/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

/**
 *
 * @author Gerardo
 */
public class UsuarioLista {
    private Usuario inicio;
    
    public UsuarioLista() {
        this.inicio = null;
    }
    
    public void agregar(String nombre){
        Usuario nuevoNodo = new Usuario(nombre);
        
        if(inicio == null){
            inicio = nuevoNodo;
        }else{
            Usuario temporal = inicio;
            while(temporal.getSiguiente() != null){
                temporal = temporal.getSiguiente();
            }
            temporal.setSiguiente(nuevoNodo);
        }
    }
    
    public void mostrarTodo(){
        Usuario temp = inicio;
        
        while(temp != null){
            System.out.println("El nombre del usuario es:" + temp.getNombre());
            temp = temp.getSiguiente();
        }
    }
    
    public boolean existe(String nombre){
        Usuario temp = inicio;
        
        while(temp != null){
            if(temp.getNombre().equals(nombre)) {
                return true;
            }else{
                temp = temp.getSiguiente();
            }
        }
        return false;
    }
    
    
    
    
}

