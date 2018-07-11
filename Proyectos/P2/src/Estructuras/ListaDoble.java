package Estructuras;
public class ListaDoble extends Lista{
	
	
	public ListaDoble() {
		super();
	}
	
	public void display() {
		
	}
	
	public void insertar(Object objeto) {
		if(inicio==null) {
			inicio = new Nodo(objeto,null,null);
			fin = inicio;
		}
		else {
			Nodo nuevo = new Nodo(objeto,null,inicio);
			inicio.setAnterior(nuevo);
			inicio = nuevo;
		}
		size++;
	}
	
	public void insertarFin(Object objeto) {
		Nodo nuevo = new Nodo(objeto);	
		if(inicio == null) {
			inicio = nuevo; 					
		}
		else {
			Nodo aux = inicio;
			while(aux.siguiente!=null) {
				aux = aux.siguiente;
			}
			aux.setSiguiente(nuevo);
			nuevo.setAnterior(aux);						
		}
		size++;
	}
	
	public Object getElemento(int indice) {
		indice = size - indice-1;
		int cont = 0;
		Nodo temporal = inicio;
		
		while(cont< indice) {
			temporal = temporal.getSiguiente();
			cont++;
		}
		return temporal.getObjeto();
	}	
		
	public void eliminarElemento(int indice) {
		indice = size - indice-1;
		if(indice==0) {
			inicio = inicio.siguiente;
		}
		else {
			int cont =0;
			Nodo temp = inicio;
			while(cont< indice-1) {
				temp = temp.siguiente;
				cont++;
			}
			temp.setSiguiente(temp.getSiguiente().siguiente);
			temp.setAnterior(temp.getAnterior());
			temp=null;
		}
		size--;
	}	
}
