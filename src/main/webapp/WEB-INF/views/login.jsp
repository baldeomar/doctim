<%@ page contentType="text/html; ISO-8859-1" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
    <body>
        <div id="contentBloc">
            <div class="text-center">
                <div class="row">
                    <h1>
                        <spring:message code="login.page.titre"></spring:message>
                    </h1>
                </div>
                <div class="row">
                    <div class="error hidden">
                        Login ou mot de passe incorrect
                    </div>
                </div>
                <form id="loginForm" method="POST" action="/login">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                    <div class="row">
                        <div class="form-group input-group">
                            <span class="input-group-addon">
                                <i class="glyphicon glyphicon-user"></i>
                            </span>
                            <input name="username" class="form-control" type="text" autocomplete="off" value="" placeholder="EMAIL">
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group input-group">
                            <span class="input-group-addon">
                                <i class="glyphicon glyphicon-lock"></i>
                            </span>
                            <input name="password" class="form-control" type="password" autocomplete="off" value="" placeholder="MOT DE PASSE">
                        </div>
                    </div>
                    <div class="form-group row">
                        <button type="submit" class="btn btn-sm btn-success pull-right">Se connecter</button>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>