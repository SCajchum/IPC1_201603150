package Estructuras;
public class ListaSimple extends Lista{
	
	
	public ListaSimple() {
		super();
	}
	
	public void display() {
		System.out.println("Lista Simple");
	}
	
	public void insertarInicio(Object objeto) {
		Nodo nodo = new Nodo(objeto,inicio);		
		inicio = nodo;
		if(fin == null) {
			fin = inicio;
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
			temp.setSiguiente(temp.siguiente.siguiente);
		}
		size--;
	}	
}
