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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:if test="${not empty context_genauere_krankheit}">
            <h1>${context_genauere_krankheit.getIo_krankheit().getName()}</h1>
            
            <div>
                ${context_genauere_krankheit.getIo_krankheit().getIv_beschreibung()}
            </div>
            
            <div>
               ${context_genauere_krankheit.getIo_krankheit().getEmpfehlung().getText()}
            </div>
        </c:if>
    </body>
</html>

