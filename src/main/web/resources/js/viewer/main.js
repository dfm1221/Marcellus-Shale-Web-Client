dojo.require("dojo.on");

var ejs = (function () {
    
	this.ERROR_TAG_POSTFIX = "_error";
	this.DEFAULT_ERROR_CONTAINER_ID = "pageErrorsContainer";
	
    // constructor
    var ejs = function () {
		
	};

    // ajaxifies the form - takes in successCallback(data) and errorDisplayHandler(data)
	// errorDisplayHandler - (optional) if specified, this method will bypass the default error display mechanism and invoke this method instead.
    ejs.addAjaxForm = function (formId, successCallback, errorDisplayHandler) {
		
		var handleAjaxFailure = function(error) {
			console.error("ajax unsuccessful: " + error);
		};

		var form = dojo.byId(formId);		
		dojo.on(form, "submit", function(event){
			
			// Clear out any pre-existing errors
			ejs.clearServerErrors();
			
			// Stop the submit event since we want to control form submission.
			dojo.stopEvent(event);
			
			// Perform Validation
			var isValid = dijit.byId(formId).validate();
			if (!isValid) {
				return;
			}
			// The parameters to pass to xhrPost, the form, how to handle it, and the callbacks.
			// Note that there isn't a url passed.  xhrPost will extract the url to call from the form's
			//'action' attribute.  You could also leave off the action attribute and set the url of the xhrPost object
			// either should work.
			var xhrArgs = {
			  form: formId,
			  handleAs: "json",
			  load: function(data) {
				  ejs.handleAjaxResult(data, undefined, successCallback, errorDisplayHandler)
			  },
			  error: handleAjaxFailure
			};
			var deferred = dojo.xhrPost(xhrArgs);
	  });
    };
    
    /**
     * Handles data of type FormResult. It will invoke successCallback if no errors were returned from the server. If there are server side validation errors, it will either invoke errorDisplayHandler
     * if one is specified, otherwise it will handle the rendering of errors.
     * 
     * @param data object of type FormResult
     * @param properties (optional) defines optional configuration properties that this handler will use
     * 			- errorsContainerId: Alternate error container id. By default one is defined in the main template. However if this Ajax call is called from a pop-up, the error messages will be rendered into a dom node specified by this id
     * 								 (This is done so that the errors will render in the pop-up and not in the parent (background) window.
     * @param successCallback (optional) callback handler if no errors were returned from server
     * @param errorDisplayHandler (optional) callback handler if errors were returned from server
     */
    ejs.handleAjaxResult = function(data, properties, successCallback, errorDisplayHandler) {
    	if (data.errors.length == 0) {
			if (successCallback) {
				successCallback(data);
			}
		} else {
			if (errorDisplayHandler) {
				errorDisplayHandler(data);
			} else {
				ejs.renderErrors(data, properties);
			}
		}	 
    };
    
    ejs.renderErrors = function(data, properties) {
    	ejs.clearServerErrors();
    	dojo.forEach(data.errors, function(entry, i){
		  renderErrorMessage(entry, properties);
		});
    };

	var renderErrorMessage = function(error, properties) {
		
		// if the error message is associated with an input field on the page, render the error next to it
		if (error.inputName) {
			var pathErrorId = error.inputName + ERROR_TAG_POSTFIX;
			if (!dojo.byId(pathErrorId)) {
				console.error("Unable to render error message because element with id='" + pathErrorId + "' does not exist");
			} else {
				dojo.byId(pathErrorId).innerHTML = error.errorMessage;
			}
		} 
		
		// otherwise render the error on the top of the page
		else  {
			
			require(["dojo/dom-construct"], function(domConstruct){
				var errorsList = dojo.byId("errors_ul");
				if (!errorsList) {
					// determine the error container, either use the default in the template or user specified one
					var containerId = DEFAULT_ERROR_CONTAINER_ID;
					if (properties && properties.errorsContainerId) {
						containerId = properties.errorsContainerId;
					}
					errorsList = domConstruct.create("ul", {id:"errors_ul"}, containerId, "first");
				} 

				domConstruct.create("li", { innerHTML: error.errorMessage }, errorsList);
			});
		}
	};
	
	// prevents form submit if dojo inputs are invalid
	// inputs: successCallback(event), errorCallback(event)
	ejs.addValidationForm = function (formId, successCallback, errorCallback) {
		dojo.connect(dojo.byId(formId), "onsubmit", function(event){
			if (dijit.byId(formId).validate()) {
				if (successCallback) {
					successCallback(event);
				}
			} else {
				if (errorCallback) {
					errorCallback(event);
				}
				dojo.stopEvent(event);
			}
		});
	};

	ejs.clearServerErrors = function() {
		// clear any form input errors
		dojo.query(".formerrors").forEach(function(elem, i) {
		    dojo.empty(elem);
		});
		
		// clear any existing page errors
    	require(["dojo/dom-construct"], function(domConstruct){
    	
	    	var errorsList = dojo.byId("errors_ul");
	    	if (errorsList) {
	    		domConstruct.destroy(errorsList);
	    	}
    	
    	});
	};
	
	/**
	 * Refer to dojo doc for format patterns: http://dojotoolkit.org/reference-guide/1.7/dojo/date/locale/format.html
	 * Returns a String
	 */
	ejs.formatDate = function(date, pattern) {
		dojo.require("dojo.date.locale");
		return dojo.date.locale.format(date,  {selector:"date", datePattern: pattern } );
	};
	
	ejs.refreshJsonRestGrid = function(url, grid) {
		
		if (!url || !grid) {
			return;
		}
		
		require([ "dojo/store/JsonRest", "dojo/data/ObjectStore" ], function(JsonRest, ObjectStore){
			var restStore = new JsonRest({ target : url });
			var objectStore  = new ObjectStore({objectStore: restStore});
			grid.setStore(objectStore);
		});
	};
	
    return ejs;
})();

function addSpringElementDecoration(elementId, widgetName, widgeAttrs) {
	Spring.addDecoration(new Spring.ElementDecoration({
        elementId: elementId,
        widgetType: widgetName,
        widgetAttrs: widgeAttrs}));
}

function asyncGet(url, handleAs, callbackHandler, errorHandler) {

	if (errorHandler == null) {
		errorHandler = function(error) {
			console
					.warn("An error has occurred during the AJAX call: "
							+ error);
		};
	}

	require([ "dojo/_base/lang", "dojo/_base/xhr" ], dojo.xhrGet({
		url : url,
		handleAs : handleAs,
		load : callbackHandler,
		error : errorHandler
	}));
}

/**
 * Makes an AJAX Get Request to the server for Json data.
 * 
 * @param url
 *            URL for the Get Request
 * @param callbackHandler
 *            Callback method to handle the returned data
 * @param errorHandler
 *            OPTIONAL error handler method to handle errors
 */
function asyncGetJson(url, callbackHandler, errorHandler) {
	asyncGet(url, "json", callbackHandler, errorHandler);
}

/**
 * Makes an AJAX Get Request to the server for Text data.
 * 
 * @param url
 *            URL for the Get Request
 * @param callbackHandler
 *            Callback method to handle the returned data
 * @param errorHandler
 *            OPTIONAL error handler method to handle errors
 */
function asyncGetText(url, callbackHandler, errorHandler) {
	asyncGet(url, "text", callbackHandler, errorHandler);
}

function getSelectedRadio(dojoQuerySelector) {
	var radioBtns=dojo.query(dojoQuerySelector);
	dojo.forEach(radioBtns, function(radio, i){
		if (radio.checked) {
			return radio;
		}
	});
}

/**
 * Disables a single field by id.
 * 
 * @param id
 * @param disabled - boolean
 */
function disableField(id, disabled) {
	if (dijit.byId(id)) {
		dijit.byId(id).set("disabled", disabled);
	} else if (dojo.byId(id)) {
		dojo.byId(id).disabled = disabled;
	}
}

function summaryFormatter(value, rowIdx, cell, sing, plur){
	var str;
	if(rowIdx >= 0){
		return value;
	}
	if(rowIdx == -1){
		str = "Total ${displayName}: ${numItems}";
	}else{
		str = "${numItems} ${displayName}";
	}
	return dojo.string.substitute(str, {numItems: value, 
				displayName: (value == 1) ? sing : plur});			
}