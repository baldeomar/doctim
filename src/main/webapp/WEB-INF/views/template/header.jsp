<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div id="wrapper">
    <div class="row">
        <div class="container">
            <div>
                <a href="/login/pre">
                    <div class="loginPanel pull-right"><spring:message code="main.login"></spring:message></div>
                </a>
                <a href="/register/pre">
                    <div class="loginPanel pull-right"><spring:message code="main.register"></spring:message></div>
                </a>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="container">
            <div>
                <div class="topMenuPanel">
                    <a href="/home">
                        <div class="logo pull-left">
                            <img src="/resources/images/logo_doctim.png" />
                        </div>
                    </a>
                    <div class="mainMenu">
                        <div class="menuText pull-left"><span><spring:message code="menu.text.calendar"></spring:message></span></div>
                        <div class="menuText pull-left"><span><spring:message code="menu.text.alimentation"></spring:message></span></div>
                        <div class="menuText pull-left"><spring:message code="menu.text.preparation.naissance"></spring:message></div>
                        <div class="menuText pull-left"><spring:message code="menu.text.bons.plans"></spring:message></div>
                        <div class="menuText pull-left"><spring:message code="menu.text.dico.grossesse"></spring:message></div>
                        <div class="menuText pull-left"><span><spring:message code="menu.text.souvenir"></spring:message></span></div>
                        <div class="menuText pull-left"><span><spring:message code="menu.text.blog"></spring:message></span></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
