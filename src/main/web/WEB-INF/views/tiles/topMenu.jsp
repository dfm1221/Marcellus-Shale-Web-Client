<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<script type="text/javascript">

	dojo.ready(function(){
   		dojo.require("dojo.parser");
	 	dojo.parser.parse();
	});
	
	
	<%--var helpPopup= function(){--%>
		<%--var url = '<c:url value="/PageHelp/default.htm"/>';--%>
		<%--//alert('popup');--%>
		<%--popupWindow = window.open(--%>
			<%--url,'popUpWindow','width=800,height=600,left=10,top=10,location=0,resizable=yes,scrollbars=yes,titlebar=no,toolbar=no,menubar=no,location=no,directories=no,status=no')--%>
	<%--};--%>
	
</script>    

<div style="width:100%">

<div class="north">
  <div class="eocil_banner" style="border: none;">
   <img alt="Marcellus Shale Web Client" title="Marcellus Shale Web Client" border="0" width="390" height="40" src="<c:url value="/resources/img/eocil_banner_bg.jpg" />" style="float:left;"/>

    <div class="eocil_banner_text">
		<span>
			<a href="JavaScript:helpPopup();"><img src="<c:url value="/resources/img/help2.png" />" alt="Help" width="16" height="16" border="0" align="absmiddle" title="Help" style="margin-right:4px;"/>Help</a>&nbsp;&nbsp;|&nbsp;&nbsp;
			<img src="<c:url value="/resources/img/user1.png" />" alt="" width="16" height="16" align="absmiddle" style="margin-right:4px;"/>Logged in as: <sec:authentication property="principal.username" /> (${userType.label})&nbsp;&nbsp;|&nbsp;&nbsp;
			<a href="<c:url value="/j_spring_security_logout" />">Logoff</a></span><br />
      	<span style="font-size:11px;">Version 1.0</span> 
	</div>
<!-- end eocil_banner_text div -->

  </div>
	<!-- end eocil_banner div -->




</div>
	<!-- end north div -->




<div id="EOCIL_primnav_tabs"> 
<div data-dojo-type="dijit.MenuBar" id="navMenu">

	<sec:authorize url="/home">
		<div data-dojo-type="dijit.MenuBarItem" 
			data-dojo-props="onClick:function(){window.location.href = '<c:url value="/home"/>';}">
			Quick Start
		</div>
	</sec:authorize>
	
	<%--<sec:authorize url="/projects">--%>
		<%--<div data-dojo-type="dijit.MenuBarItem" --%>
			<%--data-dojo-props="onClick:function(){window.location.href = '<c:url value="/projects"/>';}">--%>
			<%--Projects--%>
		<%--</div>--%>
	<%--</sec:authorize>--%>
    <%----%>
    <%--<sec:authorize url="/administration">--%>
		<%--<div data-dojo-type="dijit.MenuBarItem"--%>
			<%--data-dojo-props="onClick:function(){window.location.href = '<c:url value="/administration"/>';}">--%>
			<%--Administration--%>
		<%--</div>--%>
	<%--</sec:authorize>--%>
</div>
</div>
</div><!-- end EOCIL_primnav_tabs div -->