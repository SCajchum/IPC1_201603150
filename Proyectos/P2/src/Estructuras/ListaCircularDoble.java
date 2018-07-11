package Estructuras;
public class ListaCircularDoble extends Lista{	
	
	public ListaCircularDoble() {
		super();		
	}
	
	public void display() {
		
	}
	
	public Nodo ultimo() {
		return fin;
	}
	
	public void ingresar(Object objeto) {
		Nodo nuevo = new Nodo(objeto);
		
		if(inicio==null) {			
			inicio = nuevo;
			inicio.siguiente=inicio;
			nuevo.anterior=fin;
			fin = nuevo;			
		}
		else {
			fin.siguiente=nuevo;
			nuevo.siguiente=inicio;
			nuevo.anterior=fin;	
			fin = nuevo;
			inicio.anterior=fin;
		}
	}
			
	public void eliminar(int p) {
		if(inicio!=null) {
			if(p>0) {
				int cont = 1;
				Nodo aux =inicio;				
				while((aux.getSiguiente()!=inicio)&& (cont<p)){
					cont ++;
					aux = aux.getSiguiente();
				}
				if(cont==1) {
					if(aux.getSiguiente()==inicio) {
						inicio=null;
					}
					else {
						Nodo ant = aux.getAnterior();
						ant.setSiguiente(aux.getSiguiente());
						aux=aux.getSiguiente();
						aux.setAnterior(ant);
						inicio=aux;
					}
				}
				else {
					Nodo ant = aux.getAnterior();
					aux.setAnterior(null);
					ant.setSiguiente(aux.getSiguiente());
					aux=aux.getSiguiente();
					aux.setAnterior(ant);
				}
			}
		}
	}
	
	public void listar() {
		Nodo temp = inicio;		
		do {
			System.out.println(temp.getObjeto());
			temp = temp.siguiente;
		}
		while(temp!=inicio);
	}
}
