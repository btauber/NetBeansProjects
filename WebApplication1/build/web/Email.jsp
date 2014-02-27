<%-- 
    Document   : Email
    Created on : Feb 20, 2014, 6:41:48 PM
    Author     : benjamintauber
--%>

<%@page import="java.io.IOException"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@page import ="javaClasses.*"  %>
        <%  
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String emailAddress = request.getParameter("emailAddress");
            
            ServletContext sc = getServletContext();
            String path = sc.getRealPath("WEB-INF/Email.txt");
            String err="";
            User user = new User(firstName,lastName,emailAddress);
            try{
            UserIO.add(user, path);
            }catch(IOException e){err = ""+e;}
        %>
        
        
        <h1>Thank for joining our Email list.</h1>
        <p>Here is the information you entered. </p>
        
        <table cellsapcing="5" cellpadding="5" border="1">
            <tr>
                <td align="right">First name</td>
                <td><%= firstName%></td>
            </tr>
            <tr>
                <td align="right">Last name</td>
                <td><%= lastName %></td>
            </tr>
            <tr>
                <td align="right">Email address</td>
                <td><%= emailAddress %></td>
            </tr>
            
        </table>
            <p><%=path%></p>
    </body>
</html>
