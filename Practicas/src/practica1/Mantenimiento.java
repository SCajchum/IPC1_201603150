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
public class Mantenimiento {
    private Avion avion;
    private boolean estado;

    public Mantenimiento(Avion avion, boolean estado) {
        setAvion(avion);
        setEstado(estado);
    }
  
    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    public String estado() {   
		if(isEstado()) {
			return "Disponible";
		}
		else {
			return "Ocupado";
		}
	}
    
    
    
    
    
}
