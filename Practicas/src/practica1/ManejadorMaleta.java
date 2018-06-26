/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import javax.swing.JTextArea;

/**
 *
 * @author 22437
 */
public class ManejadorMaleta extends Lista {
    public ManejadorMaleta (){
        super();
    }
    public void setMaleta(int maleta){
        insertarCircular(maleta);
    
    }
    public int inicio(){
        if (inicio != null){
            return (int) inicio.getObj();
        }else{
            return  0;
        }
    }
    public int fin(){
        return (int) fin.getObj();
    
    }
    public  void eliminar (int maleta){
        while (maleta !=0){
            
            elimiarCircular(1);
            
            maleta --;
        }
    
    }
    public void imprimir(JTextArea area) {
		Nodo aux = inicio;
		if(inicio!=null) {
			area.append("\nINICIO: " + inicio());
			area.append("\nFIN: " + fin()) ;
		do {
			area.append("\nMALETA: " + aux.getObj());			
			aux = aux.sig;
		}
		while(aux!=inicio);
		}	
	}
    
}
