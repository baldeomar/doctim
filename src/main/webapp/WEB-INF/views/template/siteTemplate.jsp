<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="stylesheet" href="<c:url value='/resources/css/doctim.css' />">
        <link rel="stylesheet" href="<c:url value='/resources/css/bootstrap.css' />">
        <title><spring:message code="main.title"></spring:message></title>
    </head>
    <body>
        <header id="header">
            <tiles:insertAttribute name="header" />
        </header>

        <section id="site-content">
            <tiles:insertAttribute name="body" />
        </section>

        <footer id="footer">
            <tiles:insertAttribute name="footer" />
        </footer>
    </body>
</html>
