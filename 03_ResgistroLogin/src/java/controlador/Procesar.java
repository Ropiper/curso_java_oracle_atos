/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.GestionPersona;

/**
 *
 * @author USUARIO
 */
public class Procesar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            // Comprobar que tipo de formulario se ha usado
            String metodo = request.getMethod();

            switch (metodo) {
                case "POST":
                    String nombre = request.getParameter("nombre");
                    String edad = request.getParameter("edad");
                    String email = request.getParameter("email");
                    String pwd = request.getParameter("pwd");

                    GestionPersona.TipoResultado resultado;
                    resultado = GestionPersona.getInstancia().guardarPersona(nombre, edad, email, pwd);
                    switch (resultado) {
                        case OK:
                            request.getRequestDispatcher("exito.jsp").forward(request, response);
                            break;
                        case SIN_VALORES:
                            request.getRequestDispatcher("errorcampos.jsp").forward(request, response);
                            break;
                        case EDAD_MAL:
                            request.getRequestDispatcher("errornumero.jsp").forward(request, response);
                            break;
                        case ERR_IO:
                            request.getRequestDispatcher("errorio.jsp").forward(request, response);
                            break;
                        case EMAIL_MAL:
                            request.getRequestDispatcher("errormail.jsp").forward(request, response);
                            break;
                        case MENOR_EDAD:
                            request.getRequestDispatcher("menoredad.jsp").forward(request, response);
                            break;
                    }
                    break;
                case "GET":
                    request.getRequestDispatcher("registro.jsp").forward(request, response);
                    break;
                case "PUT":
                    request.getRequestDispatcher("update.jsp").forward(request, response);
                    break;
                case "DELETE":
                    request.getRequestDispatcher("delete.jsp").forward(request, response);
                    break;
            }
        }
    }
    
    
     @Override
     protected void doGet(HttpServletRequest request, HttpServletResponse response)
     throws ServletException, IOException {
     processRequest(request, response);
     }

     @Override
     protected void doPost(HttpServletRequest request, HttpServletResponse response)
     throws ServletException, IOException {
     processRequest(request, response);
     }
 
     

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
