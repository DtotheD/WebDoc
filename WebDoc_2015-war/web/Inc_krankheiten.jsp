<%-- 
    Document   : Inc_krankheiten
    Created on : 11.03.2015, 14:40:10
    Author     : DEKREDAV
--%>

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
                    Hier sind die Krankheiten mit % Wahrscheinlichkeit gelistet
                </td>
                <td>
                    Hier kommt ein Template mit Genaueren Informationen zur Krankheit
                </td>
            </tr>
        </table>
        
        <a href="main?step=symptome">
            <!-- <img src="img/nav_edit.png" alt=""> -->
            zurück
        </a>
        
    </body>
</html>

