/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modpruebas;

import java.util.ArrayList;
import modelo.Usuario;
import modelo.logica.ServicioUsuarios;

/**
 *
 * @author USUARIO
 */
public class Main {
    
    static void mostrarResultado(ServicioUsuarios.Resultado res, String nombre){
        System.out.print(" - Prueba " + nombre + ": ");
        switch(res){
            case CamposMal:
                System.out.println("Campos Mal");
                break;
            case ErrorDB:
                System.out.println("Error DB");
                break;
            case NoLogin:
                System.out.println("Error no Login");
                break;
            case Ok:
                System.out.println("PRUEBA CORRECTA");
                break;
        }
    }
    
    static void listar(){
        ArrayList<Usuario> todos = ServicioUsuarios.getInstancia().obtenerTodos();
        
        System.out.println("ServicioUSuarios-getInstancia().obtenerTodos():");
        todos.stream().forEach((u) -> {
            System.out.println("  - " + u.getId()
                + ", " + u.getNombre()
                + ", " + u.getEdad()
                + ", " + u.getEmail()
                + ", " + u.getPassword());
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Probando módulo modelo:");
        System.out.println("DATOS NO VÁLIDOS:");
        mostrarResultado(ServicioUsuarios.getInstancia().add("Paco Perez", "22", "", ""), "Usuario no válido");
        mostrarResultado(ServicioUsuarios.getInstancia().add("Paco Perez", "22", "xx@xx", ""), "Usuario no válido");
        mostrarResultado(ServicioUsuarios.getInstancia().add("Paco Perez", "22", "aaaa@aaa.com", ""), "Usuario no válido");
        System.out.println("DATOS VÁLIDOS:");
        mostrarResultado(ServicioUsuarios.getInstancia().add("Paco Perez", "22", "aaaa@aaa.com", "aaa"), "Usuario válido");
        mostrarResultado(ServicioUsuarios.getInstancia().add("Pepe Perez", "23", "bbbb@aaa.com", "bbbb"), "Usuario válido");
        mostrarResultado(ServicioUsuarios.getInstancia().add("Cccc Perez", "41", "cccc@aaa.com", "cccc"), "Usuario válido");
        mostrarResultado(ServicioUsuarios.getInstancia().add("Paco Perez", "22", "aaaa@aaa.com", "aaa"), "Usuario REPETIDO");
        Usuario usu = ServicioUsuarios.getInstancia().obtenerUno("aaaa@aaa.com");
        mostrarResultado(ServicioUsuarios.getInstancia().modificar(usu.getId(), "PacoJuan Perez", "55", "aaaa@aaa.com", "aaa"), "Usuario REPETIDO");
        mostrarResultado(ServicioUsuarios.getInstancia().eliminar("bbbb@aaa.com"), "eliminar bbb");
        mostrarResultado(ServicioUsuarios.getInstancia().validarLoginUsuario("bbbb@aaa.com", "bbb"), "Validar Login bbbb");
        mostrarResultado(ServicioUsuarios.getInstancia().eliminar("aaaa@aaa.com"), "eliminar aaa");
        mostrarResultado(ServicioUsuarios.getInstancia().eliminar("cccc@aaa.com"), "eliminar ccc");
    }
    
}
