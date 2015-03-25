<%-- 
    Document   : JSP_Template
    Created on : 02.03.2015, 09:56:45
    Author     : DEKREDAV
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <!-- Bootstrap Core CSS -->
        <link href="css/bootstrap.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="css/bootstrap-theme.css" rel="stylesheet" type="text/css"/>
        <link href="css/simple-sidebar.css" rel="stylesheet">
        <title>WebDoc</title>
    </head>
    <body>
        <!-- Navbar -->
        <div class="bs-example">
            <nav role="navigation" class="navbar navbar-default" style="border-radius: 3px">
                <!-- Brand and toggle get grouped for better mobile display -->

                <div class="navbar-collapse collapse">
                    <ul class="nav navbar-nav navbar-left" style="padding-left: 10px; margin-top: 10px">
                        <p style="font-size: x-large">Herzlich Willkommen bei WebDoc</p>
                    </ul>

                    <ul class="nav navbar-nav navbar-right">

                    </ul>
                </div>

            </nav>
        </div>
        <div class="inhalt">
            
            <div class="inhalt_links">
                <img src="Images/wartezimmer_2_klein.jpg" alt="" style="width:90%;height:auto;opacity:0.6; border-radius: 15px"/> 
                
            </div>
            
            <div class="inhalt_rechts"><jsp:include page="${context_inhalt}"></jsp:include></div>
            
            </div>
            <div class="container_bottom">

                <div class="col-md-6" style="text-align: right; margin-top: 15px; margin-bottom: 4px; padding-right: 85px">
                <c:if test="${not empty context_message}">
                    <img src="Images/Ausrufezeichen_1.png" alt="" style="width:25px;height:25px"/>
                    ${context_message}
                </c:if>
            </div>

            <div class="col-md-6" style="text-align: right; margin-top: 5px; margin-bottom: 5px">
                <c:if test="${empty context_alle_symptome}">
                    <a href="main?p_action=create_dtb">
                        <!-- <img src="img/nav_edit.png" alt=""> -->
                        <img src="Images/datenbank-gr.png" alt="" style="width:40px;height:40px"/>
                    </a>
                </c:if>
            </div>

        </div>
    </body>
</html>
