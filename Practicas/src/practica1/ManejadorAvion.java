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
public class ManejadorAvion extends Lista{
    
    public ManejadorAvion (){
        super();
    }
//    (String tipoAvion, int pasajero, int turnoMantenimiento, int turnoDesabordaje, int numeroAvion)
    
    public void insertarAvion(String tipoAvion, int pasajero, int turnoMantenimiento, int turnoDesabordaje, int numeroAvion){
        //Avion avion = new Avion(tipo, pasajero, turnosMantenimiento, turnosDesabordaje, numero);
        Avion avion = new Avion(tipoAvion, pasajero, turnoMantenimiento, turnoDesabordaje, numeroAvion);
        insertarInicioDoble(avion);
        
    }
    public void insertarAvion(Avion avion){
        insertarFinDoble(avion);
        
    }
    public Avion getAvion(int a){
        Avion avion = (Avion)recorrerDoble(a);
        return avion;
    }
    public void  turno(){
        for(int i=0 ; i<tamanio(); i++){
            Avion avion = (Avion)recorrerDoble(i);
            
            avion.setTurnoDesabordaje(avion.getTurnoDesabordaje()-1);
        
        }
    
    }
    public void eliminarAvion (ColaAvion cola){
        for(int i = 0; i<tamanio(); i++) {
			Avion avion = (Avion)recorrerDoble(i);
			if(avion.getTurnoDesabordaje()<=0) {
                    	    eliminarDoble(i);
                            cola.insertarAvion(avion);
                            
                            
			}
		}
    
    }
    
    
    public void imprimir(JTextArea area){
       for(int i=0 ; i<tamanio();i++) {
			Avion avion = (Avion)recorrerDoble(i);
			area.append("\nAvion: " + avion.getNumeroAvion() + " \n");
			area.append("Tipo de Avion: " + avion.getTipoAvion()+ " \n");
                        area.append("Turnos de Mantenimiento: "+avion.getTurnoMantenimiento()+" \n");
                        area.append("Turnos de desabordaje: "+avion.getTurnoDesabordaje()+" \n");
                        area.append("Cantidad de Pasajeros: "+avion.getPasajero()+" \n");
                        
                        
		} 
    
    }
    
}
