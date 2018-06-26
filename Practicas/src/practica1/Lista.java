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
public class Lista extends ListaGeneral{
    public void display(){
        System.out.println("Lista");
    }
    
    public Lista(){
        super();
    }
    public void insertarInicioSimple (Object obj){
        Nodo nodo = new Nodo(obj, inicio);
        inicio = nodo;
        if (fin==null){
            fin = inicio;
        }
        conta ++;
    }
    
    public void insertarInicioDoble(Object obj){
        if(inicio == null){
            inicio = new Nodo(obj, null, null);
            fin = inicio;
        }else{
            Nodo nuevo = new Nodo(obj,null,inicio);
            inicio.setAnt(nuevo);
            inicio = nuevo;
        
        }
        conta++;
    
    }
    public void insertarFinDoble(Object obj){
        if(inicio == null){
            inicio = new Nodo( obj, null, null);
            fin = inicio;
        }else{
            Nodo nuevo = new Nodo(obj, fin, null);
            fin.setSig(nuevo);
            fin = nuevo;
        
        }
        conta++;
    
    }
    public void insertarCircular(Object obj){
        Nodo nuevo = new Nodo(obj);
        if (inicio ==null){
            inicio = nuevo;
            inicio.sig = inicio;
            nuevo.ant  = fin;
            fin = nuevo;
        
        }else{
            fin.sig = nuevo;
            nuevo.sig = inicio;
            nuevo.ant = fin  ;
            fin = nuevo;
            inicio.ant=fin;
        }
    
    }
    public Object recorrerSimple(int contador){
        contador = conta - contador -1;
        int buscar = 0;
        Nodo aux = inicio;
        
        while(buscar < contador){
            aux = aux.getSig();
            buscar++;
        }
        return aux.getObj();
    }
    public Object recorrerDoble(int contador){
        contador = conta - contador -1;
        int buscar = 0;
        Nodo aux = inicio;
        
        while(buscar < contador){
            aux = aux.getSig();
            buscar++;
        }
        return aux.getObj();
    }
    public void recorrerCircular(){
        Nodo aux = inicio;
        do{
            System.out.println(aux.getObj());
            aux = aux.sig;
        }
        while (aux != inicio);
        
        
        
    }
    public void r(){
        Nodo aux = inicio;
        while(aux != inicio){
            System.out.println(aux.getObj());
            aux = aux.sig;       
        }
    }
   
    public void eliminarSimple(int contador){
        contador = conta - contador -1;
        if(contador == 0){
            inicio = inicio.sig;
            
        }else{
            int a = 0;
            Nodo aux = inicio;
            while (a < contador-1){
                aux = aux.sig;
                a++;
            }
            aux.setSig(aux.sig.sig);
            
            
        }
        conta--;
    
    }
    public void eliminarDoble(int contador){
        contador = conta - contador -1;
        if(contador == 0){
            inicio = inicio.getSig();
            
        }else{
            int a = 0;
            Nodo aux = inicio;
            while (a < contador-1){
                aux = aux.getSig();
                a++;
            }
            aux.setSig(aux.getSig());
            
            
        }
        conta--;
    
    }
    public void elimiarCircular(int contador){
        if(inicio!=null){
            if(contador >0){
                int a = 1;
                Nodo aux = inicio;
                while ((aux.getSig()!=inicio)&& (a<contador)){
                    a ++;
                    aux = aux.getSig();
                }
                if(a ==1){
                    if(aux.getSig() == inicio){
                        inicio = null;    
                    }else{
                        Nodo ant =aux.getAnt();
                        ant.setSig(aux.getSig());
                        aux = aux.getSig();
                        aux.setAnt(ant);
                        inicio = aux;
                    }
                }else{
                    Nodo ant = aux.getAnt();
                    ant.setAnt(null);
                    ant.setSig(aux.getSig());
                    aux=aux.getSig();
                    aux.setAnt(ant);
                }
            }
        }
    }
    
}
