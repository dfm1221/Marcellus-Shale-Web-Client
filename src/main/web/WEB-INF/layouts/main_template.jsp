<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Marcellus Shale Web Client</title>
	<link type="text/css" rel="stylesheet" href="<c:url value="/sjs/dijit/themes/claro/claro.css" />" />
	<link type="text/css" rel="stylesheet" href="<c:url value="/resources/js/dojox/grid/resources/claroGrid.css" />" />
	<link type="text/css" rel="stylesheet" href="<c:url value="/resources/js/dojox/form/resources/FileInput.css" />" />
	<link type="text/css" rel="stylesheet" href="<c:url value="/resources/styles/core.css" />" />
	<link type="text/css" rel="stylesheet" href="<c:url value="/resources/js/dojox/grid/enhanced/resources/claro/EnhancedGrid.css" />" />
	<link type="text/css" rel="stylesheet" href="<c:url value="/resources/js/dojox/grid/enhanced/resources/EnhancedGrid_rtl.css" />" />
	<link type="text/css" rel="stylesheet" href="<c:url value="/resources/js/dojox/widget/Wizard/Wizard.css "/>"/>
	
	<style type="text/css">
		html, body {
		    height: 100%;
		    margin: 0;
		    overflow: hidden;
		    padding: 0;
		}	
	</style>

	<script>
		var dojoConfig = {
		 packages: [
			{
			  name: "ext",
			  location: "../viewer/ext"
			}
		]
		};
	</script>
	<script type="text/javascript" src="<c:url value="/resources/js/dojo/dojo.js"/>"> </script>
	<script type="text/javascript" src="<c:url value="/sjs/spring/Spring.js" />"> </script>
	<script type="text/javascript" src="<c:url value="/sjs/spring/Spring-Dojo.js" />"> </script>
	<script type="text/javascript" src="<c:url value="/resources/js/viewer/main.js"/>"> </script>

	<script type="text/javascript">
	 
		//Menu Items
	    dojo.require("dijit.Menu");
	    dojo.require("dijit.MenuBar");
	    dojo.require("dijit.DropDownMenu");
	    dojo.require("dijit.PopupMenuBarItem");
	    dojo.require("dijit.MenuItem");
	    dojo.require("dijit.form.Button");
	    dojo.require("dijit.Dialog");
	    dojo.require("dijit.form.Form");
	    dojo.require("dojox.form.FileInput");
	
	</script>
	

</head>
<body class="claro">
	<div id="wrapper" style="width:100%; height:100%; /* min-height:100%; */  overflow:scroll; margin: 0 auto -15px;">
		<div id=header style="width:100%; display:<c:out value="${classificationDisplay}"/>; color:#<c:out value="${classificationTextColor}"/>; background-color:#<c:out value="${classificationBGColor}"/>;"><c:out value="${classificationMessage}"/></div>
		<tiles:insertAttribute name="topMenu"/>
		<div id="main">
		
			<div id="sidebar" style="width:15%; float:left;">
				<tiles:insertAttribute name="sideMenu" ignore="true"/>
			</div>
			<div id="maincontent" style="float:left; width:85%; clear:right;">
				<div id="pageErrorsContainer" class="formerrors"></div>
				<tiles:insertAttribute name="body"/>
			</div>
		</div>
 			<div id=push style="height:15px;"></div>
	</div>
	<div id=footer style="width:100%; height:15px; position:absolute; text-align:right; display:<c:out value="${classificationDisplay}"/>; color:#<c:out value="${classificationTextColor}"/>; background-color:#<c:out value="${classificationBGColor}"/>; "><c:out value="${classificationMessage}"/></div>

</body>
</html>