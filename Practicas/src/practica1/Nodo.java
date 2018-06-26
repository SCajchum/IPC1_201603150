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
public class Nodo {
    public Nodo sig, ant;
    public Object obj;

    public Nodo(Object obj,Nodo ant, Nodo sig ) {
        setAnt(ant);
        setObj(obj);
        setSig(sig);
    }
    public Nodo (Object obj, Nodo sig){
        setSig(sig);
        setObj(obj);
    }
    public Nodo (Object obj){
        setObj(obj);
        setSig(null);
    }
    

    public Nodo getSig() {
        return sig;
    }

    public void setSig(Nodo sig) {
        this.sig = sig;
    }

    public Nodo getAnt() {
        return ant;
    }

    public void setAnt(Nodo ant) {
        this.ant = ant;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
    
    
}
