<%-- 
    Document   : index
    Created on : Feb 20, 2014, 12:09:46 AM
    Author     : benjamintauber
--%>
<%! int count = 0;%>
<!DOCTYPE html>

<html>
    <head>
        <title>MY FIRST JSP</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width">
    </head>
    <body>
        <h1>Join our Email list</h1>
        <p>To join our email list. enter your name and email address below.<br>
        Then click on the submit butoon.</p>
        
        <form action="Email.jsp" method="get">
            <table cellspacing ="5" border ="0">
                <tr>
                    <td align="right">First name<?php echo "hhg"?></td>
                    <td><input type="text" name="firstName"></td>
                </tr>
                <tr>
                    <td align="right">Last name</td>
                    <td><input type="text" name="lastName"></td>
                </tr>
                <tr>
                    <td align="right">Email address</td>
                    <td><input type="text" name="emailAddress"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Submit"></td>
                </tr>
            </table>
        </form>
        <p><%++count;%></p>
        <div></div>
    </body>
</html>
