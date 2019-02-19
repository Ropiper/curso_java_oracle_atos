/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webservlet;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public class UsuarioDB {
    
    private static UsuarioDB instancia;
    private final ArrayList<Usuario> userList;
    
    private UsuarioDB() {
        this.userList = new ArrayList<Usuario>();
    }
    
    public boolean addUser(String nombre, int edad, String email, String password){
        Usuario nuevoUsu = new Usuario(nombre, edad, email, password);
        this.userList.add(nuevoUsu);
        return true;
    }
    
    public boolean validPassword(String email, String password){
        for(Usuario usuario : userList){
            if(usuario.getPassword().equals(password) && usuario.getEmail().equals(email)){
                return true;
            }
        }
        return false;
    }
    
    public static UsuarioDB getInstancia(){
        if (instancia == null) instancia = new UsuarioDB();
        return instancia;
    }
}
