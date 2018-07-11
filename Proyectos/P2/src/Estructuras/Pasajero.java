package Estructuras;

public class Pasajero {
	private int maletas,documentos,numero,turnosRegistro;
	
	public Pasajero(int numero,int maletas, int documentos,int turnosRegistro) {
		this.numero=numero;
		this.maletas=maletas;
		this.documentos=documentos;
		this.turnosRegistro=turnosRegistro;
	}

	public int getMaletas() {
		return maletas;
	}

	public void setMaletas(int maletas) {
		this.maletas = maletas;
	}
	
	public int getNumero(){
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero=numero;
	}
	public int getDocumentos() {
		return documentos;
	}

	public void setDocumentos(int documentos) {
		this.documentos = documentos;
	}
	
	public void setTurnosRegistro(int turnosRegistro) {
		this.turnosRegistro = turnosRegistro;
	}
	
	public int getTurnosRegistro() {
		return turnosRegistro;
	}
	public String toString() {
		return " " + getNumero();				
	}
}
