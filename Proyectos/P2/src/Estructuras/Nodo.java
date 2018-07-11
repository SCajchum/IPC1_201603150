package Estructuras;
public class Nodo {
	public Nodo siguiente;
	public Nodo anterior;
	private Object objeto;
	
	public Nodo(Object objeto, Nodo anterior, Nodo siguiente) {//DOBLE
		this.siguiente=siguiente;
		this.objeto=objeto;
		this.anterior=anterior;
	}
	
	public Nodo() {
		
	}
	
	public Nodo(Object objeto) {	//COLA
		this.objeto=objeto;
		setSiguiente(null);
	}
	public Nodo(Object objeto, Nodo siguiente) { //Simple
		this.siguiente=siguiente;
		this.objeto=objeto;
	}

	public Nodo getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(Nodo siguiente) {
		this.siguiente = siguiente;
	}

	public Nodo getAnterior() {
		return anterior;
	}

	public void setAnterior(Nodo anterior) {
		this.anterior = anterior;
	}

	public Object getObjeto() {
		return objeto;
	}

	public void setObjeto(Object objeto) {
		this.objeto=objeto;
	}	
}
