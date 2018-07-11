package Estructuras;
import javax.swing.JTextArea;

public class ListaMantenimiento extends ListaSimple{
	private boolean x;
	
	public ListaMantenimiento() {
		super();
	}
		
	public void addAviones(Avion avion) {
		if(inicio!=null) {
			Nodo aux = inicio;
			while(aux!=null) {
				x = false;
				Mantenimiento m = (Mantenimiento)aux.getObjeto();
				if(m.getEstado()) {
					m.setEstado(false);
					m.setAvion(avion);
					x = true;
					aux = aux.siguiente;
					return;
				}
				else {
					x = false;
					aux = aux.siguiente;
				}			
			}
		}
	}
	
	public void iniciarLista(int numero) {
		Mantenimiento nuevo = new Mantenimiento(numero,true,null);
		insertarInicio(nuevo);
	}
	
	public void bajarTurno() {
		if(inicio!=null) {
			Nodo aux = inicio;
			while(aux!=null) {
				Mantenimiento m = (Mantenimiento)aux.getObjeto();
				if(m.getAvion()!=null)
					m.getAvion().setTurnosMantenimiento(m.getAvion().getTurnosMantenimiento()-1);
				aux = aux.siguiente;
			}
		}
	}
	
	public void terminaMantenimiento() {
		if(inicio!=null) {
			Nodo aux = inicio;
			while(aux!=null) {
				Mantenimiento m = (Mantenimiento)aux.getObjeto();
				if(m.getAvion()!=null) {
					if(m.getAvion().getTurnosMantenimiento()<=0) {
						m.setAvion(null);
						m.setEstado(true);
					}
				}
				aux= aux.siguiente;
			}
		}
	}
	
	
	public boolean getEstado() {
		return x;
	}
	
	public boolean estaVacio() {
		compruebaMantenimiento();
		return estaVacio;
	}
	boolean estaVacio=false;

	
	public void compruebaMantenimiento() {
		if(inicio!=null) {
			Nodo aux = inicio;
			while(aux!=null) {
				Mantenimiento m = (Mantenimiento)aux.getObjeto();
				if(m.getEstado()) {
					estaVacio=true;
				}
				aux = aux.siguiente;
			}
		}
	}
	
	public void printListaMantenimiento(JTextArea txt) {
		if (inicio!=null) {
			Nodo aux = inicio;
			int x=1;
			while(aux!=null) {
				Mantenimiento m = (Mantenimiento)aux.getObjeto();
				if(m.getAvion()==null) {
					txt.append("\nEstacion " + m.getNumero());
					txt.append("\nEstado: " + m.getDisponible() + "\n");
					x++;
				}
				else {
					txt.append("\nEstacion " + m.getNumero());
					txt.append("\nEstado: " + m.getDisponible() + m.getAvion());
					x++;
				}
				aux = aux.siguiente;
			}
		}
	}
	

}
