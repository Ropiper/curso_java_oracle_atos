<%-- 
    Document   : index
    Created on : 21-feb-2019, 9:44:57
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
        <h1>Ejemplo MVC</h1>
        <form action="procesar.do" method="get">
            Nombre: <input type="text" id="nombre" name="nombre"/><br/>
            Edad: <input type="number" id="edad" name="edad"/><br/>
            <input type="submit" value="Enviar"/>
        </form>
    </body>
</html>
