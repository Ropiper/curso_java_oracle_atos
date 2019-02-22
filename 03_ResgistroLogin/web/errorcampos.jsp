<%-- 
    Document   : errorcampos
    Created on : 22-feb-2019, 17:27:33
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejemplo MVC</title>
    </head>
    <body>
        <h1>Complete los campos</h1>
        <a href="index.html">Volver</a>
        <% if (request.getParameter("nombre") == "") { %>
            <h2>Falta nombre</h2>
        <% } %>
        <% if (request.getParameter("edad") == "") { %>
            <h2>Falta edad</h2>
        <% } %>
        <% if (request.getParameter("email") == "") { %>
            <h2>Falta email</h2>
        <% } %>
        <% if (request.getParameter("pwd") == "") { %>
            <h2>Falta contraseña</h2>
        <% } %>
    </body>
</html>