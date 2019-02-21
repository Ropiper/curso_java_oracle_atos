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
        <form action="registro.jsp" method="get">
            <p>Nombre: </p><input type="text" id="nombre" name="nombre"/>
            <p>Edad: </p><input type="number" id="edad" name="edad"/>
            <p>Email: </p><input type="email" id="email" name="email"/>
            <p>Contraseña: </p><input type="password" id="pwd" name="pwd"/>
            <input type="submit" value="Registrarse"/>
        </form>
        
        <%
            String nombre = request.getParameter("nombre");
            String email = request.getParameter("email");
            String pwd = request.getParameter("pwd");
            String edadString = request.getParameter("edad");
            
            if(nombre != "" && edadString != "" && email != "" && pwd != ""){
                if(nombre.length() <= 1){
                    out.println("<h2>Nombre demasiado corto</h2>");
                }
            }
        %>
    </body>
</html>
