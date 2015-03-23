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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>illness</h1>

        <table>
            <tr>
                <th>
                    Krankheiten
                </th>
                <th>
                    Genauer
                </th>
            </tr>
            <tr>
                <td>

                    <table id="krankheiten">
                        <c:forEach var="krankheit" items="${context_krankheiten}">
                            <tr>
                                <td> 
                                    ${krankheit.getIo_krankheit().getIv_name()}
                                </td>
                                <td>
                                    ${krankheit.getIv_akt_wert_string()} %
                                </td>
                                <td>
                                    <form method ="post" action="/WebDoc_2015-war/main?p_action=read_more&p_krankheit=${krankheit.getIo_krankheit().getIv_name()}">
                                        <input type="submit" value=">">  
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

        <form method ="post" action="/WebDoc_2015-war/main?p_step=p_step_symptome">
            <input type="submit" value ="zurück">
        </form>


    </body>
</html>

