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
public abstract class ListaGeneral {
    public Nodo inicio, fin;
    public int conta;
    
    public ListaGeneral(){
        inicio = null;
        fin = null;
        conta = 0;
    }
    public abstract void display();
    public boolean estaVacio(){
        if(inicio ==null) {
			return true;
		}
		else {
			return false;
		}
    }
    
    public void agregarAlFinal(Object obj){
        if(estaVacio()){
            inicio = new Nodo(obj);
            fin = inicio;
        }else{
            fin = fin.sig = new Nodo(obj);
        }
        conta++;
    
    }
    public Object quitarAlInicio(){
        Object a = inicio.getObj();
        inicio = inicio.sig;
        if (inicio == null){
            fin = null;
        }
        conta --;
        return a;
    
    }
    public void mostrar(){
        Nodo aux = inicio;
        while (aux != null){
            System.out.println(aux.getObj());
            aux = aux.sig;
        }
    
    }
    public int tamanio(){
        return conta;
    }
    
    
    
}
