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
public class ColaAvion extends Cola {
    public ColaAvion(){
        super();
    }
    public void insertarAvion(String tipoAvion, int pasajero, int turnoMantenimiento, int turnoDesabordaje, int numeroAvion){
        //Avion avion = new Avion(tipo, pasajeros, turnosMantenimiento, turnosDesabordaje, numero);
        Avion avion = new Avion(tipoAvion, pasajero, turnoMantenimiento, turnoDesabordaje, numeroAvion);
        insertarFinal(avion);
        
    }
    public void insertarAvion(Avion avion){
        insertarFinal(avion);
        
    }
    public void mantenimiento(ManejadorMantenimiento man){
        if (inicio()==null)
            return; 
        man.agregarAviones((Avion) inicio());
        if (man.retornarValor()){
            
            quitarAvio();
        }
        
        
    }
    public void quitarAvio(){
        quitarFrente();
    }
    
    public void imprimir(JTextArea area){
        for (int i = tam() -1 ; i >= 0 ; i-- ){
            Avion avion = (Avion)recorrer(i);
            area.append("	AVION: " + avion.getNumeroAvion() + "\n	TIPO: " + avion.getTipoAvion() + "\n 	PASAJEROS: " + avion.getPasajero()  + "\n 	TURNOS DESABORDAJE: " + avion.getTurnoDesabordaje() + "\n 	TURNOS MANTENIMIENTO " + avion.getTurnoMantenimiento() + "\n");
        
        }
    
    }
}
