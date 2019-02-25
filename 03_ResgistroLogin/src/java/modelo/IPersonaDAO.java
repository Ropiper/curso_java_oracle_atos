/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author USUARIO
 */
public interface IPersonaDAO {
    
    boolean guardarPersona(Persona persona);
    boolean leerPersona(String email, String pwd);
    Persona editarPersona();
    Persona borrarPersona();
}
