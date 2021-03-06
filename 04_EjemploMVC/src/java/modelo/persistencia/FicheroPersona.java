/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.persistencia;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import modelo.Persona;
import modelo.logica.IPersonaDAO;

/**
 *
 * @author USUARIO
 */
public class FicheroPersona implements IPersonaDAO{
    public static final String FICH = "C:\\Users\\USUARIO\\Documents\\NetBeansProjects\\curso_java_oracle_atos.git\\04_EjemploMVC";
    
    private static final FicheroPersona instancia = new FicheroPersona();
    private FicheroPersona(){}
    public static FicheroPersona getInstancia(){
        return instancia;
    }
    @Override
    public boolean guardarPersona(Persona persona){
        try{
            ObjectOutputStream escribiendoFichero = new ObjectOutputStream(
                new FileOutputStream(FICH + "\\persona.dat"));
            escribiendoFichero.writeObject(persona);
            escribiendoFichero.close();
            return true;
        }catch(IOException e){
            return false;
        }
    }
    
    @Override
    public Persona leerPersona(){
        try{
            ObjectInputStream leyendoFichero = new ObjectInputStream(
                new FileInputStream(FICH + "\\persona.dat"));
            Persona p = (Persona) leyendoFichero.readObject();
            leyendoFichero.close();
            return p;
        }catch(Exception e){
            return null;
        }
    }
}
