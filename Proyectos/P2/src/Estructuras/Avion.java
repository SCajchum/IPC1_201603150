package Estructuras;

public class Avion {
	private String tipo;
	private int turnosDesabordaje,turnosMantenimiento,numero;
	private int pasajeros;
	
	public Avion(int numero, String tipo, int pasajeros, int turnosDesabordaje, int turnosMantenimiento) {
		this.numero=numero;
		this.tipo=tipo;
		this.pasajeros=pasajeros;
		this.turnosDesabordaje=turnosDesabordaje;
		this.turnosMantenimiento=turnosMantenimiento;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero=numero;
	}
	
	public int getPasajeros() {
		return pasajeros;
	}

	public void setPasajeros(int pasajeros) {
		this.pasajeros = pasajeros;
	}

	public int getTurnosDesabordaje() {
		return turnosDesabordaje;
	}

	public void setTurnosDesabordaje(int turnosDesabordaje) {
		this.turnosDesabordaje = turnosDesabordaje;
	}

	public int getTurnosMantenimiento() {
		return turnosMantenimiento;
	}

	public void setTurnosMantenimiento(int turnosMantenimiento) {
		this.turnosMantenimiento = turnosMantenimiento;
	}
	
	public String toString() {
		return "\nAvion: " + numero +"\nTipo: " + tipo + "\nPasajero: " + pasajeros  + "\nTurnos de desabordaje: " + turnosDesabordaje + "\nTurnos de Mantenimiento:" + turnosMantenimiento;
	}

}
