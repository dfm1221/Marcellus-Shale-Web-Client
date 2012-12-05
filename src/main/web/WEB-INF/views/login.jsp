<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <script type="text/javascript" src="<c:url value="/resources/js/dojo/dojo.js"/>" > </script>
    <link type="text/css" rel="stylesheet" href="<c:url value="/sjs/dijit/themes/claro/claro.css" />" />

    <script type="text/javascript">

        dojo.require("dojo.on");
        dojo.require("dojo.parser");
        dojo.require("dijit.form.ValidationTextBox");
        dojo.require("dijit.form.Form");

        dojo.ready(function() {
            dojo.parser.parse();
            dojo.on(dijit.byId("loginForm"), "submit", function(event) {
                if (!dijit.byId("loginForm").validate()) {
                    return false;
                }
            });
        });

    </script>

    <title>Marcellus Shale Web Client Login</title>
    <link href="<c:url value="/resources/styles/login.css" />" rel="stylesheet" type="text/css">

</head>
<body class="login_body claro" leftmargin="0" topmargin="0" marginheight="0" marginwidth="0">
<div class="wrapper">

    <spring:url var="authUrl" value="/j_spring_security_check" />
    <form method="post" action="${authUrl}" id="loginForm" data-dojo-type="dijit.form.Form">
        <div id="content">
            <div class="login_container">
                <div class="login_xiamflux_logo" style="height:80px;padding-left: 130px;">
                    <img src="<c:url value="/resources/img/login/login_mswc_logo.png" />" alt="Marcellus Shale Web Client" title="Marcellus Shale Web Client" width="282" height="70"/>
                </div>
                <div class="login_controls">
                    <c:if test="${not empty loginError}">
                        <div class="errorblock">
                                ${loginError}
                        </div>
                    </c:if>

                    <table id="mainLoginForm" style="border-collapse: collapse;" cellpadding="0" cellspacing="0">
                        <tbody>
                        <tr><td>
                            <table class="login_controls_table" border="0" cellpadding="0" cellspacing="0">
                                <tbody><tr>
                                    <td>
                                        <label for="username">
                                            User Name:</label>
                                    </td>
                                    <td>
                                        <label for="password">
                                            Password:</label>
                                    </td><td>
                                </td>
                                </tr>
                                <tr>
                                    <td>
                                        <input id="username" name="j_username" type="text" required="true" data-dojo-type="dijit.form.ValidationTextBox" missingMessage="Please enter a username.">
                                    </td>
                                    <td>
                                        <input id="password" name="j_password" type="password" required="true" data-dojo-type="dijit.form.ValidationTextBox" missingMessage="Please enter a password.">
                                    </td>
                                    <td>
                                        <input name="loginButton" value="Log In" id="loginButton" class="centerButton" style="height: 23px; width: 50px;" type="submit">
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="2">
                                        New User?
                                        <a href="home">Request Account</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td id="login_errortext_TD" colspan="3">
                                        <!-- login error message goes in this table cell -->

                                    </td>
                                </tr>
                                </tbody></table>
                        </td></tr>
                        </tbody></table>
                </div>
                <textarea name="tbLoginBanner" rows="2" cols="20" readonly="readonly" id="tbLoginBanner" class="login_warning" style="background-color: transparent;"><c:out value="${banner}"/></textarea>
                <!-- END login warning message container DIV -->
                <!--- ****** START  FOOTER ****** -->
                <div class="login_copyrightText" valign="top">
                    Copyright � 2012 Marcellus Shale</div>
                <!--- ****** END  FOOTER ****** -->
            </div>
        </div>
    </form>
    <div class="push"></div><!-- required to push bottom security marking flush with bottom of page -->
</div><!-- end wrapper div -->

</body></html>