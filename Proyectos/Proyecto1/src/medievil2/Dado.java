/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medievil2;

import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author 22437
 */
public class Dado extends Thread{
    private Integer randomDado = ThreadLocalRandom.current().nextInt(1,5 + 1);
    private Integer randomDir  = ThreadLocalRandom.current().nextInt(1,3 + 1);
    private JLabel lblDado;
    private ImageIcon imageDado;
    int i = 1;
    boolean avanzar = true;
    
    public Dado(JLabel lblDado){
        this.lblDado = lblDado;
    }
    public void run(){
        try {
            while (avanzar){
        
                if(i ==1){
                    imageDado = new ImageIcon("src/Imagenes/d1.png");
                    lblDado.setToolTipText("1");
                }
                if(i ==2){
                    imageDado = new ImageIcon("src/Imagenes/d2.png");
                    lblDado.setToolTipText("2");
                }
                if(i ==3){
                    imageDado = new ImageIcon("src/Imagenes/d3.png");
                    lblDado.setToolTipText("3");
                }
                if(i ==4){
                    imageDado = new ImageIcon("src/Imagenes/d4.png");
                    lblDado.setToolTipText("4");
                }
                if(i ==5){
                    imageDado = new ImageIcon("src/Imagenes/d5.png");
                    lblDado.setToolTipText("5");
                }
                if(i ==6){
                    imageDado = new ImageIcon("src/Imagenes/d6.png");
                    lblDado.setToolTipText("6");
                }
                lblDado.setIcon(imageDado);
                i++;
                Thread.sleep(300);
                if(i > randomDado){
                    avanzar = false;
                }
        
        
        
        }
        this.interrupt();
            } catch (InterruptedException ex) {
                Logger.getLogger(Dado.class.getName()).log(Level.SEVERE, null, ex);
            }
    
    
    }

    public JLabel getLblDado() {
        return lblDado;
    }

    public void setLblDado(JLabel lblDado) {
        this.lblDado = lblDado;
    }
    
    
}
