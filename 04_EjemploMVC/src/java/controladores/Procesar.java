/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Persona;

/**
 *
 * @author USUARIO
 */
public class Procesar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String edadString = request.getParameter("edad");
        
        if(nombre.equals("")|| edadString.equals("")){
            request.getRequestDispatcher("errorcampos.jsp").forward(request, response);
        }else{
            int edad = 0;
            try{
                edad = Integer.parseInt(edadString);
            }catch(NumberFormatException e){
                request.getRequestDispatcher("errornumero.jsp").forward(request, response);
            }
            Persona p1 = new Persona(nombre, edad);
            request.getSession().setAttribute("persona1", p1);
            
            request.getRequestDispatcher("exito.jsp").forward(request, response);
        }
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
