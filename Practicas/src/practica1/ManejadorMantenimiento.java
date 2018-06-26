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
public class ManejadorMantenimiento extends Lista{
    private boolean val;
    public ManejadorMantenimiento(){
        super();
    }
    public void mantenimiento(Avion avion, boolean estado){
        Mantenimiento man = new Mantenimiento(avion, estado);
    }
    public void agregarAviones(Avion avion){
        for(int i = 0; i<tamanio(); i++){
            val = false;
            Mantenimiento man = (Mantenimiento)recorrerSimple(i);
           
            if (man.isEstado()){
                man.setEstado(false);
                man.setAvion(avion);
                val = true;
                return;
            }else{
                val = false;
            }
            
        }
    }
    public void inicio(){
        Mantenimiento man = new Mantenimiento(null, true);
        insertarInicioSimple(man);
    }
    public void turno() {
		for(int i=0 ; i<tamanio();i++) {
			Mantenimiento man = (Mantenimiento)recorrerSimple(i);
			if(man.getAvion()!=null)
			man.getAvion().setTurnoMantenimiento(man.getAvion().getTurnoMantenimiento()-1);
		}
	}
    public void pasar(){
        for(int i = 0; i<tamanio(); i++){
            Mantenimiento man = (Mantenimiento)recorrerSimple(i);
            if(man.getAvion()!=null){
                if(man.getAvion().getTurnoMantenimiento()<=0){
                man.setAvion(null);
                man.setEstado(true);
                }
            }
        }
    }
    public boolean retornarValor(){
        return val;
    }
    
    public void imprimir(JTextArea area){
        for(int i=0 ; i<tamanio();i++) {
			Mantenimiento man = (Mantenimiento)recorrerSimple(i);
			if(man.getAvion()==null) {
				area.append("\nEstacion " + (i+1));
				area.append("\nEstado: " + man.estado() + "\n");
			}
			else {
				area.append("\nEstacion " + (i+1));
				area.append("\nEstado: " + man.estado() + man.getAvion()+"\n");
			}
		}
    
    }
    
    
}
