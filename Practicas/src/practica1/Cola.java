/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

/**
 *
 * @author 22437
 */
public class Cola extends ListaGeneral {
    public int a = conta; 
    
    public void display(){
        System.out.println("Cola");
    }
    public Cola(){
        super();
        a = conta;
    }
    public void insertarFinal(Object obj){
        if (estaVacio()){
            inicio = new Nodo(obj);
            fin = inicio;
        
        }else{
            fin = fin.sig = new Nodo(obj);
        }
        a++;
    
    }
    
    public Object quitarFrente(){
        if(estaVacio()){
            return null;
        }
        Object aux = inicio.getObj();
        inicio = inicio.sig;
        a--;
        return aux;
    
    }
    public  Object inicio(){
        if(inicio == null){
            return  null;
        }
        return  inicio.getObj();
    }
    public int tam(){
        return a;
    }
    
    public Object recorrer(int contador){
        contador = a-contador-1;
        int var = 0;
        Nodo aux = inicio;
        while (var<contador){
            aux = aux.getSig();
            var ++;
        
        }
        return aux.getObj();
        
    }
    
}
