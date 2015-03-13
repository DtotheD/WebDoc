<%-- 
    Document   : Inc_pers_data
    Created on : 11.03.2015, 14:39:18
    Author     : DEKREDAV
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>pers_data</h1>

        Personenbezogene Daten können nur ausgewertet werden, wenn alle<br>
        Felder ausgefüllt sind.

        <table>
            <tr>
                <td>
                    <input type="radio" name="geschlecht" value="männlich"> männlich
                </td>
                <td>
                    <input type="radio" name="geschlecht" value="weiblich"> weiblich
                </td>
            </tr>
            <tr>
                <td>
                    Alter:
                </td>
                <td>
                    <input type="number" name="alter" value="0">
                </td>
            </tr>
            <tr>
                <td>
                    Gewicht:
                </td>
                <td>
                    <input type="number" name="gewicht" value="0">
                </td>
            </tr>
            <tr>
                <td>
                    Größe in cm:
                </td>
                <td>
                    <input type="number" name="groesse" value="0">
                </td>
            </tr>
        </table>

        <a href="main?step=symptome&from=pers_data">
            <!-- <img src="img/nav_edit.png" alt=""> -->
            weiter
        </a>

    </body>
</html>
