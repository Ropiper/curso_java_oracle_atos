/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webservlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USUARIO
 */
public class RegistroServlet extends HttpServlet {
        
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Registro Servlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Registrate</h1>");
            out.println("<form name='form2' method='post' action='http://localhost:8084/01WebServlet/registro'>");
            out.println("<table border='1'>");
            out.println("<tr><td>Nombre:</td><td><input type='text' name='nom' id='nom' size='25' required/></td></tr>");
            out.println("<tr><td>Edad:</td><td><input type='number' name='ed' id='ed' size='25' required/></td></tr>");
            out.println("<tr><td>email:</td><td><input type='email' name='em' id='em' size='25 required'/></td></tr>");
            out.println("<tr><td>contraseña:</td><td><input type='password' name='pw' id='pw' size='25' required/></td></tr>");
            out.println("</table>");
            out.println("<input type='submit' value='Enviar'/>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            // Mayores de edad
            int edad = Integer.parseInt(request.getParameter("ed"));
            if(edad >= 18){
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Registro página muy pornosa</title>");            
                out.println("</head>");
                out.println("<body bgcolor='green'>");
                out.println("<h1>Registro correcto</h1>");
                out.println("<a href='login'>Login</a>");
                out.println("</html>");
                
                
            }else{            
                // Menores de edad
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Registro página muy pornosa</title>");            
                out.println("</head>");
                out.println("<body bgcolor='red'>");
                out.println("<h1>" + request.getParameter("nom") + ", tienes " + request.getParameter("ed") + " años y no puedes registrarte</h1>");
                out.println("</html>");
            }
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
