/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.logica;

import modelo.Persona;
import modelo.persistencia.FicheroPersona;

/**
 *
 * @author USUARIO
 */
public class GestionPersona {
    
    //private Persona persona;
    
    private static GestionPersona instancia;
    private IPersonaDAO daoPersona = FicheroPersona.getInstancia();
    private GestionPersona(){}
    
    public static GestionPersona getInstancia(){
        if(instancia == null){
            instancia = new GestionPersona();
        }
        return instancia;
    }
    public enum TipoResultado {OK, SIN_VALORES, EDAD_MAL, ERR_IO};
    
    public TipoResultado guardarPersona(String nombre, String edadString){
        if(validarDatosPersona(nombre, edadString)){
            if(validarEdad(edadString)){    
                int edad = Integer.parseInt(edadString);
                if(daoPersona.guardarPersona(new Persona(nombre, edad))){
                    return TipoResultado.OK;
                }else{
                    return TipoResultado.ERR_IO;
                }
                
            }else{
                return TipoResultado.EDAD_MAL;
            }
        }else{
            return TipoResultado.SIN_VALORES;
        }
    }
    
    private boolean validarEdad(String edadString){
        return edadString.matches("^[1-9][0-9]*$");
    }
    
    private boolean validarDatosPersona(String nombre, String edadString){
        return !nombre.isEmpty()&& !edadString.isEmpty();
        
    }

    public Persona getPersona() {
        return daoPersona.leerPersona();
    }
    
}
