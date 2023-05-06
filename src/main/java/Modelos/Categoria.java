/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;



/**
 *
 * @author Gerardo
 */
public class Categoria {
    private String usuario;
    private String nombre;
    private String ruta;
    private Categoria siguiente;
    private Categoria anterior;

    public Categoria() {
    }

    public Categoria(String usuario, String nombre, String ruta) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.ruta = ruta;
        this.siguiente = null;
        this.anterior = null;
    }
    
    /**
     *
     * @param usuario
     * @param nombre
     */
    public Categoria(String usuario, String nombre) {
        this.usuario = usuario;
        this.nombre = nombre;
    }
    

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public Categoria getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Categoria siguiente) {
        this.siguiente = siguiente;
    }

    public Categoria getAnterior() {
        return anterior;
    }

    public void setAnterior(Categoria anterior) {
        this.anterior = anterior;
    }

 
     
}
