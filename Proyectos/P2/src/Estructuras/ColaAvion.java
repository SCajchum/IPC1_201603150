package Estructuras;
import javax.swing.JTextArea;



public class ColaAvion extends Cola{

	public ColaAvion() {
		super();
	}
	
	public void setAvion(int numero, String tipo, int pasajeros, int turnosDesabordaje, int turnosMantenimiento) {
		Avion nuevo = new Avion(numero,tipo,pasajeros,turnosDesabordaje,turnosMantenimiento);		
		insertar(nuevo);
	}
	
	public void setAvion(Avion nuevo) {		
			insertar(nuevo);									
	}	
	
	public void pasarMantenimiento(ListaMantenimiento lMantenimiento) {
		if(inicioCola()==null) 
			return ;		
		lMantenimiento.addAviones((Avion) inicioCola());
		if(lMantenimiento.getEstado()) {
			quitarAvion();
		}		
	}
	
	public void quitarAvion() {
		quitar();
	}
	
	public void printColaAviones(JTextArea txt) {
		for (int i = tamCola()-1; i >= 0; i--) {
			Avion a = (Avion)getElemento(i);			
			txt.append("Avion: " + a.getNumero() + "\nTamanio: " + a.getTipo() + "\nPasajeros: " + a.getPasajeros()  + "\nTurno de Desabordaje: " + a.getTurnosDesabordaje() + "\nTurno de Mantenimiento" + a.getTurnosMantenimiento() + "\n");
		}
	}
}
