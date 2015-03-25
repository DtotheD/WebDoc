<%-- 
    Document   : Inc_view
    Created on : 11.03.2015, 14:40:24
    Author     : DEKREDAV
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- Bootstrap Core CSS -->
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>

        <!-- Custom CSS -->
        <link href="css/bootstrap-theme.css" rel="stylesheet" type="text/css"/>
        <link href="css/simple-sidebar.css" rel="stylesheet">

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:if test="${not empty context_genauere_krankheit}">
            <p style="font-size: x-large; color: #737373">${context_genauere_krankheit.getIo_krankheit().getIv_name()}</p>

            <div style="height:20px"></div>

            <div>                               
                <c:forEach var="beschreibung" items="${context_genauere_krankheit.getIo_krankheit().getIo_beschreibung()}">
                    ${beschreibung}
                    </br>
                </c:forEach>
            </div>

            <div style="height:10px"></div>

            <div>
                <h3> Dr. WebDoc empfiehlt:</h3>
                <ul style="list-style-type:square">
                    <c:forEach var="empfehlung" items="${context_genauere_krankheit.getIo_krankheit().getIo_empfehlungen()}">
                        <li>
                            ${empfehlung.getIv_text()}
                        </li>
                    </c:forEach>
                </ul>
            </div>

            <div style="height:10px"></div>

            <div>
                <h3>Bekannte Symptome:</h3>
                <ul style="list-style-type:square">
                    <c:forEach var="symptom" items="${context_genauere_krankheit.getIo_krankheit().getIo_symptome()}">
                        <li>
                            ${symptom.getIo_Symptom().getIv_name()}
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </c:if>
    </body>
</html>

