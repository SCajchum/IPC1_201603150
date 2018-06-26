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
public class ManejadorPasajero extends Cola{
    public ManejadorPasajero (){
        super();
    }
    public void setPasajero(int pasajeros, int maletas, int docs){
        Pasajero pasajero = new Pasajero(pasajeros, maletas, docs);
        insertarFinal(pasajero);
        
    }
    public void setPasajero (Pasajero pasajero){
        insertarFinal(pasajero);
        
    }
    public void eliminarPasajero(){
        quitarFrente();
    }
    public int cantidadMaletas(){
        if(tam() !=0){
            Pasajero pasajero = (Pasajero)recorrer(tam() - 1);
            return pasajero.getMaletas();
        }
        return  0;
    
    }
    public void imprimir (JTextArea area){
        for (int i = tam()-1; i >= 0; i--) {
			Pasajero pasajero = (Pasajero)recorrer(i);
			area.append("\nPASAJERO: " + pasajero.getPasajeros() +  "\n");
			area.append("Cantidad Maletas: " + pasajero.getMaletas()+"\n"); 
                        area.append("Cantidad de Documantos: "+ pasajero.getDocs() + "\n");
		}
    
    }
}
