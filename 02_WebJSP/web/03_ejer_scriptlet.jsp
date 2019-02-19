<%-- 
    Document   : 03_ejer_scriplet
    Created on : 19-feb-2019, 17:14:26
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Tablas de multiplicar</h1>
        <%
            for(int m = 0; m <= 10; m++){
        %>
        
        <table>
            <tr>
                <th>Tabla del <%= m %></th>
            </tr>
        
        <%-- Muestra una tabla de multiplicar del 7 --%>
        <%
            for(int i = 0; i <= 10; i++){
        %>
            <tr>                
                <td><%= m %> por </td>
                <td><%= i %></td>
                <td>es <%= i*m %></td>
            </tr
        <%       
            }
        %>
        </table>
        <% } %>
    </body>
</html>
