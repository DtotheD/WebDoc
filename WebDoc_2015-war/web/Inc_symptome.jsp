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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript">

        </script>

    </head>
    <body>
        <h1>symptome</h1>
        <p>
        <ul>
            <c:forEach var="symptom" items="${context_patient_symptome}">
                <li> ${symptom.getIv_name()} </li>
                </c:forEach>
        </ul>
        <form method = "post" action="/WebDoc_2015-war/main?step=symptome&action=add_symptom">
            <input type=text list=symptome name="input_symptom" >            
            <datalist id=symptome >
                <c:forEach var="symptom" items="${context_alle_symptome}" >
                    <option> ${symptom.getIv_name()}</option>
                </c:forEach>
            </datalist>
            <input type="submit" value="add">
        </form>
    </p>

    Hier steht Liste der Symptome</br>

    <!-- Liste der schon im Patienten bestehenden Symptome -->

    <a href="main?step=pers_data">
        <!-- <img src="img/nav_edit.png" alt=""> -->
        zurück
    </a>

    </br>

    <a href="main?step=krankheiten">
        <!-- <img src="img/nav_edit.png" alt=""> -->
        weiter
    </a>

</body>
</html>

