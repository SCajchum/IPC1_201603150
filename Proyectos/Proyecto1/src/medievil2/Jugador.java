/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medievil2;

import java.io.Serializable;
import java.util.Vector;

/**
 *
 * @author 22437
 */
public class Jugador implements Serializable{
    private String nombreJugador1;
    private String nombreJugador2;
    private int vidaJ1;
    private int vidaJ2;
    private Vector<Personaje>listaJ1;
    private Vector<Personaje>listaJ2;

    
    public Jugador(){
        
    }

    public Jugador(String nombreJugador1, String nombreJugador2) {
        setNombreJugador1(nombreJugador1);
        setNombreJugador2(nombreJugador2);
        setVidaJ1(5);
        setVidaJ2(5);
        
    }

    public int getVidaJ1() {
        return vidaJ1;
    }

    public void setVidaJ1(int vidaJ1) {
        this.vidaJ1 = vidaJ1;
    }

    public int getVidaJ2() {
        return vidaJ2;
    }

    public void setVidaJ2(int vidaJ2) {
        this.vidaJ2 = vidaJ2;
    }

    public Vector<Personaje> getListaJ1() {
        return listaJ1;
    }

    public void setListaJ1(Vector<Personaje> listaJ1) {
        this.listaJ1 = listaJ1;
    }

    public Vector<Personaje> getListaJ2() {
        return listaJ2;
    }

    public void setListaJ2(Vector<Personaje> listaJ2) {
        this.listaJ2 = listaJ2;
    }
    

    public String getNombreJugador1() {
        return nombreJugador1;
    }

    public void setNombreJugador1(String nombreJugador1) {
        this.nombreJugador1 = nombreJugador1;
    }
    public String getNombreJugador2() {
        return nombreJugador2;
    }

    public void setNombreJugador2(String nombreJugador2) {
        this.nombreJugador2 = nombreJugador2;
    }
    
}
