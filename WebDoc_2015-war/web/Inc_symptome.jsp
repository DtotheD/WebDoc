<%-- 
    Document   : Inc_symptome
    Created on : 11.03.2015, 14:39:36
    Author     : DEKREDAV
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- Bootstrap Core CSS -->
        <link href="css/bootstrap.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="css/bootstrap-theme.css" rel="stylesheet" type="text/css"/>
        <link href="css/simple-sidebar.css" rel="stylesheet">

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <p style="font-size: x-large; color: #737373">Krankheitssymptome</p>
        <hr style="color:dimgray"></hr>
        <div style="height:20px"></div>

        <p style="font-size: medium">Bitte geben Sie Ihre entsprechenden Krankheitssymptome ein:</p>

        <div style="height:40px"></div>
        <ul style="list-style-type:square"> 
            <c:forEach var="symptom" items="${context_patient_symptome}">             
                <form method ="post" action="/WebDoc_2015-war/main?p_action=del_symptom&p_del_symptom=${symptom.getIv_name()}">
                    <li> ${symptom.getIv_name()} &nbsp
                        <input type="image" src="Images/Minus-rot.jpg" style="width:30px;height:30px" alt="-">
                    </li>
                </form>
            </c:forEach>
        </ul>

        <div style="height:20px"></div>

        <c:if test="${context_patient_symptome.size() < 10}" >

            <form method = "post" action="/WebDoc_2015-war/main?p_action=add_symptom">
                <input type=text list=symptome name="input_symptom" >            
                <datalist id=symptome >
                    <c:forEach var="symptom" items="${context_alle_symptome}" >
                        <option class="combobox" style="height: 50px"> ${symptom.getIv_name()}</option>
                    </c:forEach>
                </datalist>
                <input type="submit" class="btn btn-default" style="font-size: small" value="add">
            </form>

        </c:if>

        <div style="height:100px"></div>

        <form method = "post" action="/WebDoc_2015-war/main?p_action=suche_krankheiten">

            <input type ="submit" class="btn btn-default" value ="weiter">

        </form>

    </body>
</html>

