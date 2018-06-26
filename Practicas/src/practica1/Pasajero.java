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
public class Pasajero {
    private int pasajeros, maletas, docs;

    public Pasajero(int pasajeros, int maletas, int docs) {
        setDocs(docs);
        setMaletas(maletas);
        setPasajeros(pasajeros);
    }
    

    public int getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(int pasajeros) {
        this.pasajeros = pasajeros;
    }

    public int getMaletas() {
        return maletas;
    }

    public void setMaletas(int maletas) {
        this.maletas = maletas;
    }

    public int getDocs() {
        return docs;
    }

    public void setDocs(int docs) {
        this.docs = docs;
    }
    public String toString() {
		return " " + getPasajeros();				
	}
    
    
}
