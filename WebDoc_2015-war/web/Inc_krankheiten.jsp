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
        <p style="font-size: x-large; color: #737373">Mögliche Krankheiten</p>
        <hr style="color:dimgray">
        <div style="height:20px"></div>

        <p style="font-size: medium">Hier finden Sie die zu Ihren Symptomen passenden Krankheiten mit <br> entsprechender Beschreibung und Wahrscheinlichkeitsangabe.</p>

        <div style="height:40px"></div>

        <table>
            <tr>
                <td>

                    <table id="krankheiten" class="table">
                        <c:forEach var="krankheit" items="${context_krankheiten}">
                            <tr>
                                <td> 
                                    ${krankheit.getIo_krankheit().getIv_name()}
                                </td>
                                <td>
                                    ${krankheit.getIv_akt_wahr_string()} %
                                </td>
                                <td>
                                    <form method ="post" action="/WebDoc_2015-war/main?p_action=read_more&p_krankheit=${krankheit.getIo_krankheit().getIv_name()}">
                                        <input type="submit" class="btn btn-default" style="font-size: xx-small" value=">">
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </td>
                <td>
                    <div>
                        <jsp:include page="Inc_view.jsp"></jsp:include>
                    </div>
                </td>
            </tr>
        </table>

        <div style="height:80px"></div>

        <form method ="post" action="/WebDoc_2015-war/main?p_step=p_step_symptome">
            <input type="submit" class="btn btn-default" value ="zurück">
        </form>

    </body>
</html>

