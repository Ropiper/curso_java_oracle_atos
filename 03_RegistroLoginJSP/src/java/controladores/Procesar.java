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
        String email = request.getParameter("email");
        String pwd = request.getParameter("pwd");
        
        if(!nombre.isEmpty() && !edadString.isEmpty() && !email.isEmpty() && pwd.isEmpty()){
            if(edadString.matches("^[1-9][0-9]*$") && email.matches("^[_a-z0-9-]+(.[_a-z0-9-]+)*@[a-z0-9-]+(.[a-z0-9-]+)*(.[a-z]{2,4})$")){
                int edad = Integer.parseInt(edadString);
            }else{
                
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
