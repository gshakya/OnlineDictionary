<%-- 
    Document   : OnlineDict
    Created on : Mar 14, 2016, 10:56:12 PM
    Author     : grsky
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="get" action="getJSON" >
            <input type="text" name ="word">
            <input type="submit" value="Find">
        </form>
        <br>
        <br>
        <span> ${definitions}</span>
    </body>
</html>
