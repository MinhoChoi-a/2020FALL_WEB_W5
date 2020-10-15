<%-- 
    Document   : register
    Created on : 15-Oct-2020, 9:37:10 AM
    Author     : minho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        
        <form method="post" action="">
            Username: <input type="text" name="name" value=""/>
            <input type="submit" value="Register name"/>
            <input type="hidden" name="action" value="register">
        </form>
    </body>
</html>
