<%-- 
    Document   : OnlineDict
    Created on : Mar 14, 2016, 10:56:12 PM
    Author     : grsky
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <script src="dict.js" type="text/javascript"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="dict.css" type="text/css" rel="stylesheet">
        <title>WAP Online Dictionary</title>
    </head>
    <body>
        <div class="form-wrapper cf">

            <input id ="txtWord" type="text" name ="word" placeholder="Search Word here..." required>
            <button id  ="btnFindDef"> Find </button>
            
            <div id = "Definition" >
            
            </div>
        </div> 
    </body>
</html>
