package Estructuras;

public  abstract class Lista {

	public Nodo inicio;
	public Nodo fin;
	int size;
	
	public Lista() {
		inicio = null;
		fin = null;
		size = 0;
	}	
	
	public Nodo getInicioNodo() {
		return inicio;
	}
	
	public void agregarFinal(Object o) {
		if(estaVacia()) {
			inicio = new Nodo(o);
			fin =inicio;
		}
		else {
			fin = fin.siguiente = new Nodo(o);
		}
		size++;
	}
	
	public Object quitarInicio() {
		Object aux = inicio.getObjeto();
		inicio = inicio.siguiente;
		if(inicio==null) {
			fin=null;
		}		
		size--;
		return aux;
	}
	
	public void listar() {
		Nodo temp = inicio;
		while(temp!=null) {
			System.out.println(temp.getObjeto());
			temp = temp.siguiente;
		}
	}
		
	public Object getIni() {
		return inicio.getObjeto();
	}
	
	public boolean estaVacia() {
		if(inicio ==null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public int getSize() {
		return size;
	}
	public abstract void display();
}
