<%-- 
    Document   : success
    Created on : Jan 6, 2018, 11:04:53 PM
    Author     : user
--%>

<%@page import="java.io.PrintWriter"%>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            
            String n=request.getParameter("username");  
            out.print("Berjaya Akhirnya! "+n);  
          
            out.close(); 
         %>
        <h1>Hello World!</h1>
    </body>
</html>
