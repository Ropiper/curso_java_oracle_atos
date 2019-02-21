/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.persistencia;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Persona;
import modelo.logica.IPersonaDAO;

/**
 *
 * @author USUARIO
 */
public class JavaDBPersona implements IPersonaDAO{

    @Override
    public boolean guardarPersona(Persona persona) {
        try(Connection connect = DriverManager.getConnection("jdbc:derby://localhost:1527/PersonasDB",
                "usuario", "usuario")){
            String squery = "SELECT COUNT(";
            Statement stmt = connect.createStatement();
            ResultSet res = stmt.executeQuery(squery);
            int ultID = res.getInt("ultID");
            return true;        
        }catch(SQLException e){
            return false;
        }
    }
    @Override
    public Persona leerPersona() {
        Persona persona = null;
        try(Connection connect = DriverManager.getConnection("jdbc:derby://localhost:1527/PersonasDB]",
                "usuario", "usuario")){
            String squery = "SELECT nombre, edad FROM Persona";
            Statement stmt = connect.createStatement();
            ResultSet res = stmt.executeQuery(squery);
            if(res.next()){ // Cogemos cualquier persona (última o primera)
                String nombre = res.getString("nombre");
                int edad = res.getInt("edad");
                return new Persona(nombre, edad);
                
            }
            return null;
        }catch(SQLException e){
            return null;
        }
    }    
}
