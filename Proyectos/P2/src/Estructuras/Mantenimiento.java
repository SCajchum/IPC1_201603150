package Estructuras;

public class Mantenimiento {
	private boolean estado;
	private Avion avion;
	private int numero;
	
	public Mantenimiento(int numero,boolean estado, Avion avion) {
		this.estado=estado;
		this.avion=avion;
		this.numero=numero;
	}

	public boolean getEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero=numero;
	}
	
	public Avion getAvion() {
		return avion;
	}
	
	
	public void setAvion(Avion avion) {
		this.avion = avion;
	}
	
	public String getDisponible() {
		if(getEstado()) {
			return "Disponible";
		}
		else {
			return "Ocupado";
		}
	}
}
