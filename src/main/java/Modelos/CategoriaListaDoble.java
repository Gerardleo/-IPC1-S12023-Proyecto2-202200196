/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

/**
 *
 * @author Gerardo
 */
public class CategoriaListaDoble {
    private Categoria inicio;
    private Categoria fin;


    public CategoriaListaDoble() {
        this.inicio = null;
        this.fin = null;
    }
    
    public void agregar(String usuario, String nombre, String ruta){
        Categoria nuevoNodo = new Categoria(usuario, nombre,ruta);
        
        if(this.inicio == null){
            this.inicio = nuevoNodo;
        }else{
            Categoria temp = this.inicio;
            while(temp.getSiguiente() != null){
                temp = temp.getSiguiente();
            }
            temp.setSiguiente(nuevoNodo);
            nuevoNodo.setAnterior(temp);
            fin = nuevoNodo;
        }
    }
    
    public void mostrarNormal(){
        Categoria temp = this.inicio;
        while(temp != null){
            System.out.println("Usario: "+temp.getUsuario() + " Categoria: "+ temp.getNombre() + " ruta: "+ temp.getRuta());
            temp = temp.getSiguiente();
        }
    }
    public void mostrarReversa(){
        
        Categoria temp = this.inicio;
        while(temp.getSiguiente() != null){
                temp = temp.getSiguiente();                
        }
        
        while(temp != null){
            System.out.println("El valor del nodo es: "+temp.getRuta());            
            temp = temp.getAnterior();
        }
    
}
    public Categoria getInicio(){
        return inicio;
    }
    
    
      public Categoria getFin(){
       return fin;
    }
 
       public Categoria actual(){
            Categoria temp = this.inicio;
        while(temp.getSiguiente() != null){
                temp = temp.getSiguiente();                
        }
        return temp;
       }
      
}
