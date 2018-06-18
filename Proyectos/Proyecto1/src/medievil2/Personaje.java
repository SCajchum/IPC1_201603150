/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medievil2;

import java.io.Serializable;

/**
 *
 * @author 22437
 */
public class Personaje implements Serializable {
    protected String personaje;
    protected int ataque;
    protected int casillas;
    protected boolean turno;

    public Personaje(String personaje, int ataque, int casillas, boolean turno) {
        this.personaje = personaje;
        this.ataque = ataque;
        this.casillas = casillas;
        this.turno = turno;
    }
    
    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getCasillas() {
        return casillas;
    }

    public void setCasillas(int casillas) {
        this.casillas = casillas;
    }

    public boolean isTurno() {
        return turno;
    }

    public void setTurno(boolean turno) {
        this.turno = turno;
    }
    
    public String getPersonaje() {
        return personaje;
    }

    public void setPersonaje(String personaje) {
        this.personaje = personaje;
    }

    
    
    
    /*private String personaje1J1;
    private String personaje2J1;
    private String personaje3J1;
    private String personaje1J2;
    private String personaje2J2;
    private String personaje3J2;
    protected boolean turno;
    
    
    
    public Personaje(){
    }

    public Personaje(String personaje1J1, String personaje2J1, String personaje3J1, String personaje1J2,
            String personaje2J2, String personaje3J2, boolean turno){
        setPersonaje1J1(personaje1J1);
        setPersonaje1J2(personaje1J2);
        setPersonaje2J1(personaje2J1);
        setPersonaje2J2(personaje2J2);
        setPersonaje3J1(personaje3J1);
        setPersonaje3J2(personaje3J2);
        setTurno(turno);
        
    }

    public boolean isTurno() {
        return turno;
    }

    public void setTurno(boolean turno) {
        this.turno = turno;
    }
    
    public String getPersonaje1J1() {
        return personaje1J1;
    }

    public void setPersonaje1J1(String personaje1J1) {
        this.personaje1J1 = personaje1J1;
    }

    public String getPersonaje2J1() {
        return personaje2J1;
    }

    public void setPersonaje2J1(String personaje2J1) {
        this.personaje2J1 = personaje2J1;
    }

    public String getPersonaje3J1() {
        return personaje3J1;
    }

    public void setPersonaje3J1(String personaje3J1) {
        this.personaje3J1 = personaje3J1;
    }

    public String getPersonaje1J2() {
        return personaje1J2;
    }

    public void setPersonaje1J2(String personaje1J2) {
        this.personaje1J2 = personaje1J2;
    }

    public String getPersonaje2J2() {
        return personaje2J2;
    }

    public void setPersonaje2J2(String personaje2J2) {
        this.personaje2J2 = personaje2J2;
    }

    public String getPersonaje3J2() {
        return personaje3J2;
    }

    public void setPersonaje3J2(String personaje3J2) {
        this.personaje3J2 = personaje3J2;
    }
    
    */

    
}
