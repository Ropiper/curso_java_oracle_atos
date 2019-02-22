/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USUARIO
 */
public class JavaDBPersona implements IPersonaDAO{
    
    public JavaDBPersona() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
        } catch (Exception ex) {
            Logger.getLogger(JavaDBPersona.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean guardarPersona(Persona persona) {
        try (Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/UsuarioDB",
                "user1", "user1")) {
            String squery = "SELECT COUNT(Id) as ultId FROM usuario";
            Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery(squery);
            if (res.next()) { 
                int ultId = res.getInt("ultId");
                ultId++; // Nuestro autoincrement
                squery = "INSERT INTO usuario VALUES(" + ultId + ", '" + persona.getNombre() + "', '"
                        + persona.getEmail()+ "', " + persona.getEdad()+ ", '"  + persona.getPwd() + "')";
                stmt = con.createStatement();
                stmt.executeUpdate(squery);
                return true;
            }
            return false;
        } catch (SQLException ex) {
            return false;
        }
    }

    @Override
    public Persona leerPersona() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Persona editarPersona() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Persona borrarPersona() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
