<%-- 
    Document   : template_top
    Created on : 15 oct. 2019, 10:10:54
    Author     : Eddy
--%>

<%
    if(session.getAttribute("role") == null
            && !request.getRequestURI().equals( "/JEE_PROJECT_V1/WEB-INF/login.jsp" ) )
    {
        // rediriger vers le Login
        response.sendRedirect("login");
    }
%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title><%
            try
            {
                out.print(JSP_TEMPLATE_TITLE);
            }
            catch(NullPointerException e)
            {
                out.print("Default");
            }
        %></title>
    </head>
    <body>
        
<%@include file="navbar.jsp" %>
