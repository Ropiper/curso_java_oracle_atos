<%-- 
    Document   : 05_sesiones
    Created on : 20-feb-2019, 14:03:35
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestión de sesiones JSP</title>
    </head>
    <body>
        <%@include file="cabecera.jsp" %>
        <%= dameTitulo("Gestión de sesiones JSP") %>
        <%!
            int totalPeticiones = 0;
        %>
        <h2>Cálculo de un factorial</h2>
        <form action="05_sesiones.jsp" method="get">
            <p>Número: <input type="number" id="numero" name="numero"/></p>
            <input type="submit" value="Calcular factorial"/>
        </form>
        
        <%
            String numeroGet = request.getParameter("numero");
            if(numeroGet != null){
                int numero = 0;
                double factorial = 1;
                boolean error = false;
              try{
                  numero = Integer.valueOf(numeroGet);
                  if(numero < 1){
                      error = true;
                  }else{ // Correcto, calcular factorial
                      for(int i = numero; i > 1; i--){
                          factorial *= i;
                      }
                  }
              }catch(NumberFormatException e){
                  error = true;
              }
              if(error){ //MAL, inclumos vista en lógica de negocio
                  out.println("<p style='color: red'>Indicar número entero mayor que 0</p>");
              }else{
                  out.println("<p>Resultado: " + numero + "! = " + factorial + "</p>");
              }
            }  
            //if(session.isNew()){
                session.setMaxInactiveInterval(300);
            //}
            Integer contador = (Integer) session.getAttribute("contadorVisitas");
            if(contador != null){
                contador = Integer.valueOf(contador);
            }else{
                contador = 0;
            }
            if(contador != 0){
                %> <p>Ejecuciones de este JSP en esta sesión: <%= contador %></p> <%
            }
            contador++;
            session.setAttribute("contadorVisitas", contador);
            totalPeticiones++;
        %>
        <p>Ejecuciones totales de este JSP: <%= totalPeticiones %> </p>
    </body>
</html>
