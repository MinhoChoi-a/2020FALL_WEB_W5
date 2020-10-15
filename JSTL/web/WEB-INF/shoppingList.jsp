<%-- 
    Document   : shoppingList
    Created on : 15-Oct-2020, 9:37:24 AM
    Author     : minho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        
        <p>Hello, ${name}</p> <a href="/JSTL/shoppinglist?action=logout">Log out</a>
        
        
        <h1>List</h1>
        
         <form method="post" action="">
            Add item: <input type="text" name="add_item" value=""/>
            <input type="submit" value="Add"/>
            <input type="hidden" name="action" value="add"/>
        </form>
        
        
        <form method="post" action="">
            <table>
            <c:forEach items="${itemList}" var="item">
                <tr><td><input type="radio" name="item" value="${item}">${item}</th></td>
            </c:forEach>
            </table>
            <c:if test="${fn:length(itemList) > 0}">
            <input type="submit" value="delete"/>
            <input type="hidden" name="action" value="delete"/>
            </c:if>
        </form>
        
    </body>
</html>
