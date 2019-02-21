<%-- 
    Document   : registro
    Created on : 20-feb-2019, 17:49:20
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro</title>
    </head>
    <body>
        <h1>Registro</h1>
        <form action="procesar.do" method="get">
            <p>Nombre: </p><input type="text" id="nombre" name="nombre"/>
            <p>Edad: </p><input type="number" id="edad" name="edad"/>
            <p>Email: </p><input type="email" id="email" name="email"/>
            <p>Contraseña: </p><input type="password" id="pwd" name="pwd"/>
            <input type="submit" value="Registrarse"/>
        </form>  
    </body>
</html>
