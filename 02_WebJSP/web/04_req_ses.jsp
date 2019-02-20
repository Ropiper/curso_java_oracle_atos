<%-- 
    Document   : 04_req_ses
    Created on : 20-feb-2019, 9:26:03
    Author     : Rodrigo Pinar Pérez
--%>

<%@page import="java.io.IOException"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.io.FileWriter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <!-- Latest compiled and minified CSS 
        Viene de https://getbootstrap.com/docs/3.3/getting-started/ -->
        <title>Gestión de peticiones y respuestas JSP</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

        <!-- Optional theme
        Viene de https://getbootstrap.com/docs/3.3/getting-started/  -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    </head>
    
    <body class="container">
        <%@include file="cabecera.jsp" %>
        <%= dameTitulo("Gestión de peticiones y respuestas JSP") %>
        <%
            String nombre = request.getParameter("nombre");
            String desc = request.getParameter("descripcion");
            String email = request.getParameter("email");
            
            if(nombre == null || desc == null || email == null){
        %>
         
        <div class="col-lg-2"></div>
        <div class="col-lg-8">
            <script>
                function preguntarSiEnviar(){
                    if(document.getElementById("nombre").value != "" && document.getElementById("nombre").value.length >1){
                        let siQuiereEnviar = window.confirm("¿Seguro que quiere enviar?");
                        return siQuiereEnviar;
                    }else{
                        alert("El nombre debe ser más largo de un caracter");
                        return false;
                    }
                }
            </script>
            <form action="04_req_ses.jsp" method="get" class="form-inline" onsubmit="return preguntarSiEnviar()">
            <p>Nombre y apellidos:</p>
            <p><input id="nombre" type="text" name="nombre" autocomplete="on" size="100" maxlength="100" required="true" placeholder="Nombre y apellidos" class="form-control"/></p>
            <p>Descripción:</p>
            <p><textarea id="descripcion" name="descripcion" required="true" cols="100" rows="10" placeholder="Introduzca una descripción detallada" class="form-control"></textarea></p>
            <p>Email:</p>
            <p><input id="email" type="email" name="email" autocomplete="on" size="100" maxlength="100" required="true" placeholder="Email" class="form-control"/></p>
            <input  type="submit" value="Enviar" class="btn btn-default"/>
        </form>
        </div>
        <div class="col-lg-2"></div>
        
        <% }// Fin de mostrar formulario
                
            else{ // Cuando ningún parámetro es NULL
                if(nombre != "" && desc != "" && email != ""){
                // Lógica de validación
                    if(nombre.length() > 1){
                        if(desc.length() > 5){
                            // Validación de mail
                            
                            if(email.matches("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,4})$")){
                                out.println("<h3>Todo correcto, crack</h3>");
                            }else{
                                out.println("<h3>Pon un email válido</h3>");
                            }
                            
                        }else{
                            out.println("<h3>Pon una descripción</h3>");
                        }
                    }else{
                        %> <h3>Pon un nombre</h3> <%     
                    }
                } 
                try{
                    FileWriter fileWriter = new FileWriter("C:/Users/USUARIO/Desktop/solicitudes.txt");
                    PrintWriter printWriter = new PrintWriter(fileWriter);
                    printWriter.printf("Nombre='%s'\r\nDescripción='%s'\r\nEmail='%s'", nombre, desc, email);
                    printWriter.close();
                }catch(IOException e){
                    %> <h2 style="color: red">Fallo en el fichero</h2> <%
            }
            }
        %> 
        
        <!-- Latest compiled and minified JavaScript
        Viene de https://getbootstrap.com/docs/3.3/getting-started/  -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    </body>
</html>
