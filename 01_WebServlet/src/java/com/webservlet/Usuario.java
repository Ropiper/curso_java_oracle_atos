/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webservlet;

import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public class Usuario {
    
    private static String nombre;
    private static int edad;
    private static String email;
    private static String password;
    // se necesita una clase usuario para generar el tipo de objeto y otra a mayores con el array para añadir ese tipo de objeto

    public Usuario(String nombre, int edad, String email, String password) {
        this.nombre = nombre;
        this.edad = edad;
        this.email = email;
        this.password = password;
    }

    public static String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public static String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
