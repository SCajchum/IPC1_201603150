/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medievil2;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author 22437
 */
public class PersonajeVisual {
    public int posicionPersonaje=0;
    public ImageIcon imgPersonaje;
    
    public ImageIcon obtenerImagen(int tamx){
        ImageIcon personaje = new ImageIcon(getClass().getResource("/Imagenes/bomba.JPG"));
        Image personaje1 = personaje.getImage();
        Image imgTamanio = personaje1.getScaledInstance(tamx, 150, Image.SCALE_SMOOTH);
        personaje = new ImageIcon(imgTamanio);
        return personaje;
    }
    
}
