<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title><spring:message code="inscription.page.titre"></spring:message></title>
</head>
    <body>
        <div class="absolute-center is-Responsive">
            <div id="contentBloc">
                <h1><spring:message code="inscription.page.titre"></spring:message></h1>
                <form:form method="POST" modelAttribute="userForm" action="${registerSubmitUrl}">
                    <div class="customRow">
                        <label class="pull-left" for="inputUsername"><spring:message code="inscription.username.label"></spring:message></label>
                        <form:input cssClass="pull-right" path="username" id="inputUsername" autocomplete="false"/>
                        <form:errors cssClass="error" path="username"/>
                    </div>
                    <br>
                    <div class="customRow">
                        <label class="pull-left" for="inputPassword"><spring:message code="inscription.username.password"></spring:message></label>
                        <form:password cssClass="pull-right" path="password" id="inputPassword"/>
                        <form:errors cssClass="error" path="password"/>
                    </div>
                    <br>
                    <div class="customRow">
                        <label class="pull-left" for="inputMatchingPassword"><spring:message code="inscription.username.repassword"></spring:message></label>
                        <form:password cssClass="pull-right" path="matchingPassword" id="inputMatchingPassword"/>
                        <form:errors cssClass="error" path="matchingPassword"/>
                    </div>
                    <br>
                    <div class="customRow">
                        <div class="pull-right">
                        <button id="accepter" class="btn btn-sm btn-success"><spring:message code="main.accepter"></spring:message></button>
                        <a id="annuler" class="btn btn-sm btn-danger" href="${cancelUrl}"><spring:message code="main.annuler"></spring:message></a>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </body>
</html>
