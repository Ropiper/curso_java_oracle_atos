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
public class GestionPersona {
    
    private static GestionPersona instancia;
    private IPersonaDAO daoPersona = new JavaDBPersona();
    private GestionPersona(){}

    public static GestionPersona getInstancia() {
        if(instancia == null) instancia = new GestionPersona();
        return instancia;
    }
    
    public enum TipoResultado {OK, SIN_VALORES, MENOR_EDAD, EDAD_MAL, ERR_IO, EMAIL_MAL}
    
    private boolean ValidarPersona(String nombre, String edad, String email, String pwd){
        return !nombre.isEmpty() && !edad.isEmpty() && !email.isEmpty() && !pwd.isEmpty();
    }
    
    private boolean validarEdad(String edad){
        return edad.matches("^[1-9][0-9]*$");
    }
    
    private boolean validarEmail(String email){
        return email.matches("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,4})$");
    }
    
    public TipoResultado guardarPersona(String nombre, String edad, String email, String pwd){
        if(ValidarPersona(nombre, edad, email, pwd)){
            if(validarEdad(edad)){
                int iEdad = Integer.parseInt(edad);
                if(validarEmail(email)){
                    if(daoPersona.guardarPersona(new Persona(nombre, iEdad, email, pwd)))
                        return TipoResultado.OK;
                    else
                        return TipoResultado.ERR_IO;
                }else{
                    return TipoResultado.EMAIL_MAL;
                }
            }else{
                return TipoResultado.EDAD_MAL;
            }
        }else{
            return TipoResultado.SIN_VALORES;
        }
    }
}
