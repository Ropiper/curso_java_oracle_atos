/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;

/**
 *  POJO para datos
 * @author USUARIO
 */
public class Persona implements Serializable{  
    
    private String nombre;
    private int edad;
    private String email;
    private String pwd;

    public Persona(String nombre, int edad, String email, String pwd) {
        this.nombre = nombre;
        this.edad = edad;
        this.email = email;
        this.pwd = pwd;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }   
}
