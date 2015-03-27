<%-- 
    Document   : Inc_krankheiten
    Created on : 11.03.2015, 14:40:10
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
        <h3 style="color:dimgray">Mögliche Krankheiten</h3>

        <p style="font-size: medium">Hier finden Sie die zu Ihren Symptomen passenden Krankheiten mit <br> entsprechender Beschreibung und Wahrscheinlichkeitsangabe.</p>

        <div style="height:40px"></div>


        <div class="Ergebnisse">
                
            <div class="Ergebnisse_1">
                <c:forEach var="krankheit" items="${context_krankheiten}">
                    <div class="Ergebnisse_Box">
                        ${krankheit.getIo_krankheit().getIv_name()}
                    </div>
                </c:forEach>
            </div>
            
            <div class="Ergebnisse_2">
                <c:forEach var="krankheit" items="${context_krankheiten}">
                    <div class="Ergebnisse_Box">
                        ${krankheit.getIv_akt_wahr_string()} %
                    </div>
                </c:forEach>
            </div>
            
            <div class="Ergebnisse_3">
                <c:forEach var="krankheit" items="${context_krankheiten}">
                    <div class="Ergebnisse_Box">
                        <form method ="post" action="/WebDoc_2015-war/main?p_action=read_more&p_krankheit=${krankheit.getIo_krankheit().getIv_name()}">
                            <input type="submit" class="btn btn-default" style="font-size: xx-small; height: 20px; text-align: center" value=">" >
                        </form>
                    </div>
                </c:forEach>
            </div>
            
            <div class="Ergebnisse_4">
                <jsp:include page="Inc_view.jsp"></jsp:include>
            </div>
        </div>

        <div style="height:80px"></div>
        
        <div class="button_zurueck">
            <form method ="post" action="/WebDoc_2015-war/main?p_step=p_step_symptome">
                <input type="submit" class="btn btn-default" value ="zurück">
            </form>
        </div>

    </body>
</html>

