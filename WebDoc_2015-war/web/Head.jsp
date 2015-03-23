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

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Simple Sidebar - Start Bootstrap Template</title>

        <!-- Bootstrap Core CSS -->
        <link href="css/bootstrap.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="css/bootstrap-theme.css" rel="stylesheet" type="text/css"/>
        <link href="css/simple-sidebar.css" rel="stylesheet">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

    </head>

    <body>
        <!-- Navbar -->
        <div class="bs-example">
            <nav role="navigation" class="navbar navbar-default">
                <!-- Brand and toggle get grouped for better mobile display -->

                <div class="navbar-collapse collapse">
                    <ul class="nav navbar-nav navbar-left"></ul>

                    <ul class="nav navbar-nav navbar-right">
                        <h1>WebDoc &nbsp &nbsp </h1>
                    </ul>
                </div>

            </nav>
        </div>

        ${context_message}

            <c:if test="${empty context_alle_symptome}">
                <a href="main?p_action=create_dtb">
                    <!-- <img src="img/nav_edit.png" alt=""> -->
                    create DTB
                </a>
            </c:if>

        <div class="container_left" style="width: 95%">
            <div class="col-md-4">
                <img src="Images/wartezimmer_2.jpg" alt="" style="width:100%;height:auto;opacity:0.6;"/>  
            </div>

            <div class="col-md-8"> <jsp:include page="${context_inhalt}"></jsp:include></div>

            </div>

        
    </body>
</html>
