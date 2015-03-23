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
                <form method ="post" action="/WebDoc_2015-war/main?p_action=del_symptom&p_del_symptom=${symptom.getIv_name()}">
                    <li> ${symptom.getIv_name()}
                        <input type="image" src="minus-button.png" alt="-">
                    </li>
                </form>
            </c:forEach>

        </ul>
        <c:if test="${context_patient_symptome.size() < 10}" >

            <form method = "post" action="/WebDoc_2015-war/main?p_action=add_symptom">
                <input type=text list=symptome name="input_symptom" >            
                <datalist id=symptome >
                    <c:forEach var="symptom" items="${context_alle_symptome}" >
                        <option> ${symptom.getIv_name()}</option>
                    </c:forEach>
                </datalist>
                <input type="submit" value="add">
            </form>

        </c:if>

    </p>

    <form method = "post" action="/WebDoc_2015-war/main?p_action=suche_krankheiten">

        <input type ="submit" value ="weiter">

    </form>

</body>
</html>

