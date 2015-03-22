<%-- 
    Document   : JSP_Template
    Created on : 02.03.2015, 09:56:45
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
        <div style="color:red">
            <h1>This is the template</h1>
        </div>
        This is the error Message </br>
        ${context_message}
        <div>
            <a href="main?p_action=create_dtb">
                <!-- <img src="img/nav_edit.png" alt=""> -->
                create DTB
            </a>
        </div>
    <div>
        <jsp:include page="${context_inhalt}"></jsp:include>
    </div>
</body>
</html>
