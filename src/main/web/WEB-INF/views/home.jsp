<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div id="generalicons" class="qs_container">
  <div class="leftSide">

  	<sec:authorize url="/projects">
  		<spring:eval expression="userType == T(viewer.UserTypes).ADMIN" var="isAdmin" />
    	<c:choose>
    		<c:when test="${isAdmin}">
    			<c:set var="projectLinkDisplayName" value="All Projects" />
    			<c:set var="projectLinkDescription" value="Create and edit your projects. Projects are used as containers to manage all your campaigns and the data unique to those campaigns." />
    		</c:when>
    		<c:otherwise>
    			<c:set var="projectLinkDisplayName" value="My Projects" />
    			<c:set var="projectLinkDescription" value="View the projects you are assigned to. Projects are used as containers to manage all your campaigns and the data unique to those campaigns." />
    		</c:otherwise>
    	</c:choose>

	    <div id="qs_my_projects" class="leftColumn qs_iconProjects">
	      <h2> <a href="projects">${projectLinkDisplayName}</a> </h2>
	      <p> <span class="qs_GrayTxt">${projectLinkDescription}</span> </p>
	    </div>
	</sec:authorize>

  </div>
  <!-- end left column div -->


  <div class="rightSide">
    <!-- BEGIN RIGHT COLUMN DIVS -->

	<sec:authorize access="hasRole('ROLE_QUESTIONNAIRE_ASSIGNEE')">
	    <div id="qs_my_questionnaires" class="leftColumn qs_iconQuestionnaires">
	      <h2><a href="questionnaires">My Questionnaires</a></h2>
	      <p> <span class="qs_GrayTxt">View and answer your assigned questionnaires. </span> </p>
	    </div>
	</sec:authorize>
  </div>
  <!-- end right column div -->

</div>
<!-- end container div -->

<sec:authorize url="/administration">
	<div id="adminicons" class="qs_container">
	<hr id="adminiconshr" class="qs_hr"/>
	  <div class="leftSide">
	    <div id="qs_administration" class="leftColumn qs_iconAdmin">
	      <h2> <a href="administration">Administration Tools</a></h2>
	      <p> <span class="qs_GrayTxt">Tools used by application administrators to create user
	        accounts, create projects, assign users, configure application
	        settings, and more. </span> </p>
	    </div>
	  </div>
	  <!-- end leftside div -->
	</div>
</sec:authorize>
<!-- end container div -->


