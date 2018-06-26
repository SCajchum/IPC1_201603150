/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

/**
 *
 * @author 22437
 */
public class Avion {
    private String tipoAvion;
    private int pasajero, turnoMantenimiento, turnoDesabordaje, numeroAvion;

    public Avion(String tipoAvion, int pasajero, int turnoMantenimiento, int turnoDesabordaje, int numeroAvion) {
        setNumeroAvion(numeroAvion);
        setPasajero(pasajero);
        setTipoAvion(tipoAvion);
        setTurnoDesabordaje(turnoDesabordaje);
        setTurnoMantenimiento(turnoMantenimiento);
    }
    public Avion(){}

    public String getTipoAvion() {
        return tipoAvion;
    }

    public void setTipoAvion(String tipoAvion) {
        this.tipoAvion = tipoAvion;
    }

    public int getPasajero() {
        return pasajero;
    }

    public void setPasajero(int pasajero) {
        this.pasajero = pasajero;
    }

    public int getTurnoMantenimiento() {
        return turnoMantenimiento;
    }

    public void setTurnoMantenimiento(int turnoMantenimiento) {
        this.turnoMantenimiento = turnoMantenimiento;
    }

    public int getTurnoDesabordaje() {
        return turnoDesabordaje;
    }

    public void setTurnoDesabordaje(int turnoDesabordaje) {
        this.turnoDesabordaje = turnoDesabordaje;
    }

    public int getNumeroAvion() {
        return numeroAvion;
    }

    public void setNumeroAvion(int numeroAvion) {
        this.numeroAvion = numeroAvion;
    }
    public String toString() {
		return "\nAvion: " + numeroAvion +"\nTipo: " + tipoAvion + "\nTurnos de Mantenimiento: " + turnoMantenimiento  + "\nTurnos de Desabordaje: " + turnoDesabordaje + "\nCantidad de Pasajeros" + pasajero;
	}
    
    
}
