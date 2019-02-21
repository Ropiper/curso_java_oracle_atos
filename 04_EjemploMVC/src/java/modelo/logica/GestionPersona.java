/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.logica;

import modelo.Persona;

/**
 *
 * @author USUARIO
 */
public class GestionPersona {
    
    private Persona persona;
    
    private static GestionPersona instancia;
    private GestionPersona(){}
    GestionPersona getInstancia(){
        if(instancia == null){
            instancia = new GestionPersona();
        }
        return instancia;
    }
    public enum TipoResultado {OK, SIN_VALORES, EDAD_MAL};
    
    public TipoResultado guardarPersona(String nombre, String edadString){
        if(validarDatosPersona(nombre, edadString)){
            if(validarEdad(edadString)){    
                int edad = Integer.parseInt(edadString);
                this.persona = new Persona(nombre, edad);
                return TipoResultado.OK;
            }else{
                return TipoResultado.EDAD_MAL;
            }
        }else{
            return TipoResultado.SIN_VALORES;
        }
    }
    
    public boolean validarEdad(String edadString){
        return edadString.matches("^[0-9]+$");
    }
    
    public boolean validarDatosPersona(String nombre, String edadString){
        return nombre.equals("")|| edadString.equals("");
        
    }

    public Persona getPersona() {
        return persona;
    }
    
}
