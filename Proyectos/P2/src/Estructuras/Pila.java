package Estructuras;
public class Pila extends Lista{
	private int tam;
	
	public Pila() {
		super();
		tam = 0;
	}
	
	public void display() {
		
	}
	
	public int getTam() {
		return tam;
	}
	
	public void insertar(Object o) {
		Nodo nuevo = new Nodo(o);
		if(estaVacia()) {
			inicio = nuevo;			
		}
		else {
			nuevo.setSiguiente(inicio);
			inicio = nuevo;
		}
		tam++;
	}
	
	public void eliminar() {
		if(!estaVacia()) {
			inicio = inicio.getSiguiente();
			tam--;
		}
	}
}
