/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medievil2;
import java.awt.Color;
import java.util.Vector;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.LineBorder;
import medievil2.Jugador;
import sun.swing.ImageIconUIResource;

//import static medievil1.MenuJuego.vectorPersonaje;
//import static medievil1.MenuJuego.vectorJugador;
/**
 *
 * @author 22437
 */
public class Tablero extends javax.swing.JFrame {
    public static String Mina = "Mina";
    public static String Vida = "Vida";
    public static String Princesa = "Princesa";
    public static String Mago = "Mago";
    public static String Guerrero = "Guerrero";
    public static String J1 = "Jugador1";
    public static String J11 = "Jugador11";
    public static String J12 = "Jugador12";
    public static String J13 = "Jugador13";
    public static String J2 = "Jugador2";
    public static String Arr = "Arriba";
    public static String Aba = "Abajo";
    public static String Izq = "Izquierda";
    public static String Der = "Derecha";
    private Jugador jugador;
    private String [][] matrizLogica;
    private JButton [][] matrizCasillas;
    private int tam, vJ1=5, vJ2=5 ,turno;    
    private Integer fond, posX, posY, repe = 0;
    private ImageIcon image11, image12, image13, image21, image22, image23, iconoFondo, imageJ1, imageJ2, imageGuerreroJ1, imageGuerreroJ2, imagePrincesaJ1, imagePrincesaJ2, 
            imageMagoJ1, imageMagoJ2;
    private Vector <Vector<JLabel>> listaVidas = new Vector<>();
    private Vector<JLabel> vidaJ1 = new Vector<>(), vidaJ2 = new Vector<>();
    private Tiempo tiempo;
    private String j1, j2, j11, j12, j13, j21, j22, j23;
    
    private String dirGuerreroJ1 = "src/Imagenes/guerr1.png";
    private String dirGuerreroJ2 = "src/Imagenes/guerr2.png";
    private String dirPrincesaJ1 = "src/Imagenes/prin1.png";
    private String dirPrincesaJ2 = "src/Imagenes/prin2.png";
    private String dirMagoJ1 = "src/Imagenes/mago1.png";
    private String dirMagoJ2 = "src/Imagenes/mago2.png";
    private boolean dado= true, dadoTirado = false;
    

    /**
     * Creates new form Tablero
     */
    public Tablero(int dimensiones, Jugador jugador) {
        initComponents();
        tiempo = new Tiempo(lblTiempo, this);
        tiempo.start();
        lblTiempo = tiempo.getJLabelTiempo();
        this.tam = dimensiones;
        this.jugador = jugador;
        
    
        imageGuerreroJ1 = new ImageIcon(dirGuerreroJ1);
        imageGuerreroJ2 = new ImageIcon(dirGuerreroJ2);
        imagePrincesaJ1 = new ImageIcon(dirPrincesaJ1);
        imagePrincesaJ2 = new ImageIcon(dirPrincesaJ2);
        imageMagoJ1 = new ImageIcon(dirMagoJ1);
        imageMagoJ2 = new ImageIcon(dirMagoJ2);
        turno = 1;
        colocarFondo();
        datos();
        crearTablero();
        vidasMinas();
        colocarPersonajes();
    }
    public void datos(){
        String q = ""+jugador.getVidaJ1();
        String w = ""+jugador.getVidaJ2();
        System.out.println(jugador.getVidaJ1());
        lblNombreJ1.setText("Nombre: "+ jugador.getNombreJugador1() );
        vidaJ1.add(j1v1);
        vidaJ1.add(j1v2);
        vidaJ1.add(j1v3);
        vidaJ1.add(j1v4);
        vidaJ1.add(j1v5);
        vidaJ2.add(j2v1);
        vidaJ2.add(j2v2);
        vidaJ2.add(j2v3);
        vidaJ2.add(j2v4);
        vidaJ2.add(j2v5);
        listaVidas.add(vidaJ1);
        listaVidas.add(vidaJ2);
        
        lblPersonaje1J1.setText("Primero "+ jugador.getListaJ1().get(0).getPersonaje() );
        lblPersonaje2J1.setText("Segundo "+jugador.getListaJ1().get(1).getPersonaje());
        lblPersonaje3J1.setText("Tercero "+jugador.getListaJ1().get(2).getPersonaje());
        lblNombreJ2.setText("Nombre: "+ jugador.getNombreJugador2());
        System.out.println(jugador.getNombreJugador2());
        
        lblPersonaje1J2.setText("Primero "+jugador.getListaJ2().get(0).getPersonaje());
        lblPersonaje2J2.setText("Segundo "+jugador.getListaJ2().get(1).getPersonaje());
        lblPersonaje3J2.setText("Tercero "+jugador.getListaJ2().get(2).getPersonaje());
    
    }
    
    
    public void crearTablero(){
        
        System.out.println("dim " + tam);
        matrizCasillas = new JButton[tam][tam];
        matrizLogica = new String[tam][tam];
        JPanel panel = new JPanel(new GridLayout(tam, tam));
        panel.setBorder(new LineBorder(Color.BLACK));
        panel.setOpaque(false);
        int colum = 0;
        int fila = 0;
        
        for (int i=0; i<(tam*tam); i++){
            JButton b = new JButton();
            b.setToolTipText(""+i);
            b.setPreferredSize(new java.awt.Dimension(25,25));
            b.setToolTipText(""+fila+"-"+colum);
            b.setContentAreaFilled(false);
            b.setBorder(new LineBorder(Color.BLACK));
            matrizCasillas[fila][colum]= b;
            matrizLogica[fila][colum]="";
            if (colum == (tam-1)){
                colum = 0;
                fila++;
            }else{ 
                colum++;                     
            }
        }
        for (int j = 0; j<tam; j++){
                for (int k = 0; k<tam; k++){
                    panel.add(matrizCasillas[j][k]);        
                }
            }
            panelTablero.add(panel);
            panelTablero.setOpaque(false);
    }
    public void colocarFondo(){
        iconoFondo = new ImageIcon("src/Imagenes/fondo.jpg");
        lblFondo.setIcon(iconoFondo);
    }
    public void vidasMinas(){
        ImageIcon mina = new ImageIcon("src/Imagenes/bomba.png");
        ImageIcon vida = new ImageIcon("src/Imagenes/vida.png");
        vida.getIconHeight();
        vida.getIconWidth();
        int minas = (int) Math.round(((float)tam*tam)*(0.1));
        int vidas = (int) Math.round(((float)tam*tam)*(0.05));        
        int min =0, vid = 0;
        while (min<minas){
            posX = ThreadLocalRandom.current().nextInt(0, (tam-2)+1);
            posY = ThreadLocalRandom.current().nextInt(0, (tam-2)+1);
            matrizLogica [posX][posY] = Mina;
            matrizCasillas [posX][posY].setIcon(mina);
            min++;
        }
        while (vid < vidas){
            posX = ThreadLocalRandom.current().nextInt(0, (tam-2)+1);
            posY = ThreadLocalRandom.current().nextInt(0, (tam-2)+1);
            matrizLogica [posX][posY] = Vida;
            matrizCasillas [posX][posY].setIcon(vida);
            vid++;
        }
    }
    public void colocarPersonajes(){
        /*
        if(jugador.getListaJ1().get(0).getPersonaje().equals(Guerrero)){
            imageJ1 = imageGuerreroJ1;
            j1 = Guerrero;
            imageJ1 = imagePrincesaJ1;
            j1 = Princesa;
            imageJ1 = imageMagoJ1;
            j1 = Mago;
        } else if (jugador.getListaJ1().get(0).getPersonaje().equals(Princesa)){
            imageJ1 = imageGuerreroJ1;
            j1 = Guerrero;
            imageJ1 = imagePrincesaJ1;
            j1 = Princesa;
            imageJ1 = imageMagoJ1;
            j1 = Mago;
        }else{
            imageJ1 = imageGuerreroJ1;
            j1 = Guerrero;
            imageJ1 = imagePrincesaJ1;
            j1 = Princesa;
            imageJ1 = imageMagoJ1;
            j1 = Mago;
        }
        if(jugador.getListaJ2().get(0).getPersonaje().equals(Guerrero)){
            imageJ2 = imageGuerreroJ2;
            j2 = Guerrero;
            imageJ2 = imagePrincesaJ2;
            j2 = Princesa;
            imageJ2 = imageMagoJ2;
            j2 = Mago;
        } else if (jugador.getListaJ2().get(0).getPersonaje().equals(Princesa)){
            imageJ2 = imageGuerreroJ2;
            j2 = Guerrero;
            imageJ2 = imagePrincesaJ2;
            j2 = Princesa;
            imageJ2 = imageMagoJ2;
            j2 = Mago;
        }else{
            imageJ2 = imageGuerreroJ2;
            j2 = Guerrero;
            imageJ2 = imagePrincesaJ2;
            j2 = Princesa;
            imageJ2 = imageMagoJ2;
            j2 = Mago;
        }
        */
        if(jugador.getListaJ1().get(0).getPersonaje().equals(Guerrero) && 
                jugador.getListaJ1().get(1).getPersonaje().equals(Princesa) && 
                jugador.getListaJ1().get(2).getPersonaje().equals(Mago)){
            image11 = imageGuerreroJ1;
            image12 = imagePrincesaJ1;
            image13 = imageMagoJ1;/*
            j11 = Guerrero;
            j12 = Princesa;
            j13 = Mago;*/
            j1 = Guerrero;
            
        } else if (jugador.getListaJ1().get(0).getPersonaje().equals(Guerrero) && 
                jugador.getListaJ1().get(1).getPersonaje().equals(Mago) && 
                jugador.getListaJ1().get(2).getPersonaje().equals(Princesa)){
            image11 = imageGuerreroJ1;
            image13 = imagePrincesaJ1;
            image12 = imageMagoJ1;
            /*j11 = Guerrero;
            j13 = Princesa;
            j12 = Mago;*/
            j1 = Guerrero;
        }else if(jugador.getListaJ1().get(0).getPersonaje().equals(Mago) && 
                jugador.getListaJ1().get(1).getPersonaje().equals(Guerrero) && 
                jugador.getListaJ1().get(2).getPersonaje().equals(Princesa)){
            image11 = imageMagoJ1;
            image13 = imagePrincesaJ1;
            image12 = imageGuerreroJ1;
            /*j12 = Guerrero;
            j13 = Princesa;
            j11 = Mago;*/
            j1 = Mago;
        }else if(jugador.getListaJ1().get(0).getPersonaje().equals(Mago) && 
                jugador.getListaJ1().get(1).getPersonaje().equals(Princesa) && 
                jugador.getListaJ1().get(2).getPersonaje().equals(Guerrero)){
            image11 = imageMagoJ1;
            image13 = imageGuerreroJ1;
            image12 = imagePrincesaJ1;
            /*j13 = Guerrero;
            j12 = Princesa;
            j11 = Mago;*/
            j1 = Mago;
        }
        else if(jugador.getListaJ1().get(0).getPersonaje().equals(Princesa) && 
                jugador.getListaJ1().get(1).getPersonaje().equals(Mago) && 
                jugador.getListaJ1().get(2).getPersonaje().equals(Guerrero)){
            image12 = imageMagoJ1;
            image13 = imageGuerreroJ1;
            image11 = imagePrincesaJ1;
            /*j13 = Guerrero;
            j11 = Princesa;
            j12 = Mago;*/
            j1 = Princesa;
        }else if(jugador.getListaJ1().get(0).getPersonaje().equals(Princesa) && 
                jugador.getListaJ1().get(1).getPersonaje().equals(Guerrero) && 
                jugador.getListaJ1().get(2).getPersonaje().equals(Mago)){
            image13 = imageMagoJ1;
            image12 = imageGuerreroJ1;
            image11 = imagePrincesaJ1;
            /*j12 = Guerrero;
            j11 = Princesa;
            j13 = Mago;*/
            j1 = Princesa;
        }
        
        /*if(jugador.getListaJ2().get(0).getPersonaje().equals(Guerrero)){
            imageJ2 = imageGuerreroJ2;
            j2 = Guerrero;
            imageJ2 = imagePrincesaJ2;
            j2 = Princesa;
            imageJ2 = imageMagoJ2;
            j2 = Mago;
        } else if (jugador.getListaJ2().get(0).getPersonaje().equals(Princesa)){
            imageJ2 = imageGuerreroJ2;
            j2 = Guerrero;
            imageJ2 = imagePrincesaJ2;
            j2 = Princesa;
            imageJ2 = imageMagoJ2;
            j2 = Mago;
        }else{
            imageJ2 = imageGuerreroJ2;
            j2 = Guerrero;
            imageJ2 = imagePrincesaJ2;
            j2 = Princesa;
            imageJ2 = imageMagoJ2;
            j2 = Mago;
        }*/
        if(jugador.getListaJ2().get(0).getPersonaje().equals(Guerrero) && 
                jugador.getListaJ2().get(1).getPersonaje().equals(Princesa) && 
                jugador.getListaJ2().get(2).getPersonaje().equals(Mago)){
            image21 = imageGuerreroJ2;
            image22 = imagePrincesaJ2;
            image23 = imageMagoJ2;
            /*j21 = Guerrero;
            j22 = Princesa;
            j23 = Mago;*/
            j2 = Guerrero;
            
        }else if (jugador.getListaJ2().get(0).getPersonaje().equals(Guerrero) && 
                jugador.getListaJ2().get(1).getPersonaje().equals(Mago) && 
                jugador.getListaJ2().get(2).getPersonaje().equals(Princesa)){
            image21 = imageGuerreroJ2;
            image23 = imagePrincesaJ2;
            image22 = imageMagoJ2;
            /*j21 = Guerrero;
            j23 = Princesa;
            j22 = Mago;*/
            j2 = Guerrero;
        }else if(jugador.getListaJ2().get(0).getPersonaje().equals(Mago) && 
                jugador.getListaJ2().get(1).getPersonaje().equals(Guerrero) && 
                jugador.getListaJ2().get(2).getPersonaje().equals(Princesa)){
            image21 = imageMagoJ2;
            image23 = imagePrincesaJ2;
            image22 = imageGuerreroJ2;
            /*j22 = Guerrero;
            j23 = Princesa;
            j21 = Mago;*/
            j2 = Mago;
        }else if(jugador.getListaJ2().get(0).getPersonaje().equals(Mago) && 
                jugador.getListaJ2().get(1).getPersonaje().equals(Princesa) && 
                jugador.getListaJ2().get(2).getPersonaje().equals(Guerrero)){
            image21 = imageMagoJ2;
            image23 = imageGuerreroJ2;
            image22 = imagePrincesaJ2;
            j2 = Mago;
            /*j23 = Guerrero;
            j22 = Princesa;
            j21 = Mago;*/
        }
        else if(jugador.getListaJ2().get(0).getPersonaje().equals(Princesa) && 
                jugador.getListaJ2().get(1).getPersonaje().equals(Mago) && 
                jugador.getListaJ2().get(2).getPersonaje().equals(Guerrero)){
            image22 = imageMagoJ2;
            image23 = imageGuerreroJ2;
            image21 = imagePrincesaJ2;
            j2 = Princesa;
            /*
            j23 = Guerrero;
            j21 = Princesa;
            j22 = Mago;*/
        }else if(jugador.getListaJ2().get(0).getPersonaje().equals(Princesa) && 
                jugador.getListaJ2().get(1).getPersonaje().equals(Guerrero) && 
                jugador.getListaJ2().get(2).getPersonaje().equals(Mago)){
            image23 = imageMagoJ2;
            image22 = imageGuerreroJ2;
            image21 = imagePrincesaJ2;
            j2 = Princesa;
            /*j22 = Guerrero;
            j21 = Princesa;
            j23 = Mago;*/
        }
        
        posX = ThreadLocalRandom.current().nextInt(0, (tam-2)+1);
        posY = ThreadLocalRandom.current().nextInt(0, (tam-2)+1);
        boolean posicionJ1= false, posicionJ2 = false;
        while(!posicionJ1 || !posicionJ2){
            if(matrizLogica[posX][posY].equals("")){
                if(!posicionJ1){
                    matrizLogica[posX][posY] = J1;
                    matrizCasillas[posX][posY].setIcon(image11);
                    posicionJ1 = true;
                }else{
                    matrizLogica[posX][posY] = J2;
                    matrizCasillas[posX][posY].setIcon(image21);
                    posicionJ2 = true;
                }
            }else{
                posX = ThreadLocalRandom.current().nextInt(0, (tam-2) + 1);
                posY = ThreadLocalRandom.current().nextInt(0, (tam-2) + 1);
            }
            
        }
        posicionJ1 = false;
            posicionJ2 = false;
        while(!posicionJ1 || !posicionJ2){
            if(matrizLogica[posX][posY].equals("")){
                if(!posicionJ1){
                    matrizLogica[posX][posY] = J1;
                    matrizCasillas[posX][posY].setIcon(image12);
                    posicionJ1 = true;
                }else{
                    matrizLogica[posX][posY] = J2;
                    matrizCasillas[posX][posY].setIcon(image22);
                    posicionJ2 = true;
                }
            }else{
                posX = ThreadLocalRandom.current().nextInt(0, (tam-2) + 1);
                posY = ThreadLocalRandom.current().nextInt(0, (tam-2) + 1);
            }
        }
        posicionJ1 = false;
            posicionJ2 = false;
        while(!posicionJ1 || !posicionJ2){
            if(matrizLogica[posX][posY].equals("")){
                if(!posicionJ1){
                    matrizLogica[posX][posY] = J1;
                    matrizCasillas[posX][posY].setIcon(image13);
                    posicionJ1 = true;
                }else{
                    matrizLogica[posX][posY] = J2;
                    matrizCasillas[posX][posY].setIcon(image23);
                    posicionJ2 = true;
                }
            }else{
                posX = ThreadLocalRandom.current().nextInt(0, (tam-2) + 1);
                posY = ThreadLocalRandom.current().nextInt(0, (tam-2) + 1);
            }
        }
        
        
            
    }
    
    public void movimientoPersonaje(String moverse){
        String moverPer;
        if(dado){
            JOptionPane.showMessageDialog(null, "Debe tirar el dado para moverse", "No permitido", JOptionPane.DEFAULT_OPTION);
        }else {
            if(moverse.equals(Der)){
                if(turno==1){
                    moverPer = J1;
                }else{
                    moverPer = J2;
                }
                //public MoverIzqDer(String[][] matrizLogica, JButton[][] matrizCasillas, 
                  //      Jugador jugador, Vector<Vector<JLabel>> listaVidas, 
            //String movimiento, String jugadorActual, int cantidadMov, int tam) {
            MoverIzqDer movDerecha = new MoverIzqDer(matrizLogica, matrizCasillas, jugador,listaVidas,
                     moverse,  moverPer, Integer.parseInt(lblNumObtenido.getToolTipText()), tam);
            movDerecha.start();
            this.listaVidas = movDerecha.getListaVidas();
            this.jugador = movDerecha.getJugador();
            this.matrizCasillas = movDerecha.getMatrizCasillas();
            this.matrizLogica = movDerecha.getMatrizLogica();
            
            }
            if (moverse.equals(Izq)){
                if (turno == 1){
                    moverPer = J1;
                }else{
                    moverPer = J2;
                }
            MoverIzqDer movIzq = new MoverIzqDer(matrizLogica, matrizCasillas, jugador,listaVidas,
                     moverse,  moverPer, Integer.parseInt(lblNumObtenido.getToolTipText()),  tam);
            movIzq.start();
            this.listaVidas = movIzq.getListaVidas();
            this.jugador = movIzq.getJugador();
            this.matrizCasillas = movIzq.getMatrizCasillas();
            this.matrizLogica = movIzq.getMatrizLogica();
            }
            if (moverse.equals(Arr)){
                if (turno == 1){
                    moverPer = J1;
                }else{
                    moverPer = J2;
                }
            MoverIzqDer movArriba = new MoverIzqDer(matrizLogica, matrizCasillas, jugador,listaVidas,
                     Arr,  moverPer, Integer.parseInt(lblNumObtenido.getToolTipText()),  tam);
            movArriba.start();
            this.listaVidas = movArriba.getListaVidas();
            this.jugador = movArriba.getJugador();
            this.matrizCasillas = movArriba.getMatrizCasillas();
            this.matrizLogica = movArriba.getMatrizLogica();
            }
            if (moverse.equals(Aba)){
                if (turno == 1){
                    moverPer = J1;
                }else{
                    moverPer = J2;
                }
            MoverIzqDer movArriba = new MoverIzqDer(matrizLogica, matrizCasillas, jugador,listaVidas,
                     Aba,  moverPer, Integer.parseInt(lblNumObtenido.getToolTipText()),  tam);
            movArriba.start();
            this.listaVidas = movArriba.getListaVidas();
            this.jugador = movArriba.getJugador();
            this.matrizCasillas = movArriba.getMatrizCasillas();
            this.matrizLogica = movArriba.getMatrizLogica();
            }
            
        }
        
        
        }
    
    public void turnos(){
        boolean cambioPersonaje = false;
        int sig;
        
        if(turno ==1){
            lblNombreJ1.setForeground(null);
            turno = 2;
            lblNombreJ2.setForeground(Color.red);
            cambioPersonaje = false;
            while(!cambioPersonaje){
                for (int i = 0; i<3; i++){
                    if (jugador.getListaJ1().get(i).getPersonaje().equals(j1)&& !cambioPersonaje){
                        sig = (i==2)? 0: i+1;
                        for(int xx = 0; xx< tam; xx++){
                            if(!cambioPersonaje){
                                for(int yy = 0; yy<tam; yy++){
                                    if(matrizLogica[xx][yy].equals(J1)){
                                        if(jugador.getListaJ1().get(sig).getPersonaje().equals(Guerrero)){
                                            
               //                             imageJ1 = imageGuerreroJ1;
                                            j1 = Guerrero;
                                        }else if(jugador.getListaJ1().get(sig).getPersonaje().equals(Princesa)){
                 //                           imageJ1 = imagePrincesaJ1;
                                            j1 = Princesa;
                                        }else{
                   //                         imageJ1 = imageMagoJ1;
                                            j1 = Mago;
                                        }
                                    //matrizCasillas [xx][yy].setIcon(imageJ1);
                                    cambioPersonaje = true;
                                    break;
                                    }
                                
                                }
                            
                            
                            }
                        
                        }
                    }
                
                }
            
            
            
            }
        
        }else{
            lblNombreJ2.setForeground(null);
            turno = 1;
            lblNombreJ1.setForeground(Color.red);
            cambioPersonaje = false;
            while(!cambioPersonaje){
                for (int i = 0; i<3; i++){
                    if (jugador.getListaJ2().get(i).getPersonaje().equals(j2)&& !cambioPersonaje){
                        sig = (i==2)? 0: i+1;
                        for(int x = 0; x< tam; x++){
                            if(!cambioPersonaje){
                                for(int y = 0; y<tam; y++){
                                    if(matrizLogica[x][y].equals(J2)){
                                        if(jugador.getListaJ2().get(sig).getPersonaje().equals(Guerrero)){
                                      //      imageJ2 = imageGuerreroJ2;
                                            j2 = Guerrero;
                                        }else if(jugador.getListaJ2().get(sig).getPersonaje().equals(Princesa)){
                                        //    imageJ2 = imagePrincesaJ2;
                                            j2 = Princesa;
                                        }else{
                                          //  imageJ2 = imageMagoJ2;
                                            j2 = Mago;
                                        }
                                    //matrizCasillas [x][y].setIcon(imageJ2);
                                    cambioPersonaje = true;
                                    break;
                                    }
                                
                                }
                            
                            
                            }
                        
                        }
                    }
                
                }
            
            
            
            }
        }
    
    dadoTirado = false;
    
    }
        
      
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelFondo = new javax.swing.JPanel();
        panelTablero = new javax.swing.JPanel();
        lblFondo = new javax.swing.JLabel();
        panelJ1 = new javax.swing.JPanel();
        lblJ1 = new javax.swing.JLabel();
        lblNombreJ1 = new javax.swing.JLabel();
        lblCantidadVidas = new javax.swing.JLabel();
        lblPersonajes = new javax.swing.JLabel();
        lblPersonaje1J1 = new javax.swing.JLabel();
        lblPersonaje2J1 = new javax.swing.JLabel();
        lblPersonaje3J1 = new javax.swing.JLabel();
        j1v1 = new javax.swing.JLabel();
        j1v2 = new javax.swing.JLabel();
        j1v3 = new javax.swing.JLabel();
        j1v4 = new javax.swing.JLabel();
        j1v5 = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        lblTiempo = new javax.swing.JLabel();
        panelMov = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        panelDado = new javax.swing.JPanel();
        lblTituloDado = new javax.swing.JLabel();
        btnTirar = new javax.swing.JButton();
        lblNumObtenido = new javax.swing.JLabel();
        btnTurno = new javax.swing.JButton();
        panelJ2 = new javax.swing.JPanel();
        lblJ2 = new javax.swing.JLabel();
        lblNombreJ2 = new javax.swing.JLabel();
        lblCantidadVidas2 = new javax.swing.JLabel();
        lblPersonajes2 = new javax.swing.JLabel();
        lblPersonaje1J2 = new javax.swing.JLabel();
        lblPersonaje2J2 = new javax.swing.JLabel();
        lblPersonaje3J2 = new javax.swing.JLabel();
        j2v5 = new javax.swing.JLabel();
        j2v1 = new javax.swing.JLabel();
        j2v2 = new javax.swing.JLabel();
        j2v3 = new javax.swing.JLabel();
        j2v4 = new javax.swing.JLabel();
        panelAtaque = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelFondo.setPreferredSize(new java.awt.Dimension(750, 450));
        panelFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelTablero.setPreferredSize(new java.awt.Dimension(730, 430));
        panelTablero.setLayout(new java.awt.BorderLayout());
        panelFondo.add(panelTablero, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 670, 290));

        lblFondo.setPreferredSize(new java.awt.Dimension(760, 440));
        panelFondo.add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 330));

        lblJ1.setText("JUGADOR 1");

        lblCantidadVidas.setText("VIDAS: ");

        lblPersonajes.setText("PERSONAJES: ");

        lblPersonaje2J1.setText("            ");

        lblPersonaje3J1.setText("         ");

        j1v1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/vida.png"))); // NOI18N

        j1v2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/vida.png"))); // NOI18N

        j1v3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/vida.png"))); // NOI18N

        j1v4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/vida.png"))); // NOI18N

        j1v5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/vida.png"))); // NOI18N

        javax.swing.GroupLayout panelJ1Layout = new javax.swing.GroupLayout(panelJ1);
        panelJ1.setLayout(panelJ1Layout);
        panelJ1Layout.setHorizontalGroup(
            panelJ1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelJ1Layout.createSequentialGroup()
                .addGroup(panelJ1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelJ1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(lblJ1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelJ1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelJ1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCantidadVidas)
                            .addGroup(panelJ1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(panelJ1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(j1v2)
                                    .addComponent(j1v1)
                                    .addComponent(j1v5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelJ1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(j1v3)
                                    .addComponent(j1v4))))
                        .addGap(18, 18, 18)
                        .addGroup(panelJ1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelJ1Layout.createSequentialGroup()
                                .addGap(0, 19, Short.MAX_VALUE)
                                .addComponent(lblPersonajes))
                            .addComponent(lblPersonaje1J1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panelJ1Layout.createSequentialGroup()
                                .addComponent(lblPersonaje2J1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(12, 12, 12))
                            .addComponent(lblPersonaje3J1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelJ1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblNombreJ1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        panelJ1Layout.setVerticalGroup(
            panelJ1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelJ1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblJ1)
                .addGap(10, 10, 10)
                .addComponent(lblNombreJ1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelJ1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCantidadVidas)
                    .addComponent(lblPersonajes))
                .addGap(11, 11, 11)
                .addGroup(panelJ1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelJ1Layout.createSequentialGroup()
                        .addComponent(j1v1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(j1v2))
                    .addGroup(panelJ1Layout.createSequentialGroup()
                        .addGroup(panelJ1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelJ1Layout.createSequentialGroup()
                                .addComponent(lblPersonaje1J1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblPersonaje2J1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblPersonaje3J1))
                            .addGroup(panelJ1Layout.createSequentialGroup()
                                .addComponent(j1v3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(j1v4)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(j1v5)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        lblTime.setText("TIEMPO:");

        jLabel1.setText("MOVIMIENTO");

        jButton1.setText("UP");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("LEFT");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("RIGTH");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("DOWN");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        lblTituloDado.setText("TIRAR DADO");

        btnTirar.setText("Tirar");
        btnTirar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTirarActionPerformed(evt);
            }
        });

        btnTurno.setText("FinTurno");
        btnTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTurnoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelDadoLayout = new javax.swing.GroupLayout(panelDado);
        panelDado.setLayout(panelDadoLayout);
        panelDadoLayout.setHorizontalGroup(
            panelDadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDadoLayout.createSequentialGroup()
                .addGroup(panelDadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDadoLayout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(lblTituloDado)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelDadoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnTirar)
                        .addGap(41, 41, 41)
                        .addComponent(lblNumObtenido, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnTurno)))
                .addContainerGap())
        );
        panelDadoLayout.setVerticalGroup(
            panelDadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDadoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTituloDado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDadoLayout.createSequentialGroup()
                        .addComponent(btnTirar)
                        .addContainerGap(35, Short.MAX_VALUE))
                    .addComponent(lblNumObtenido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelDadoLayout.createSequentialGroup()
                        .addComponent(btnTurno)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout panelMovLayout = new javax.swing.GroupLayout(panelMov);
        panelMov.setLayout(panelMovLayout);
        panelMovLayout.setHorizontalGroup(
            panelMovLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMovLayout.createSequentialGroup()
                .addGroup(panelMovLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMovLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3))
                    .addGroup(panelMovLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(panelMovLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jButton1)))
                    .addComponent(panelDado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelMovLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jButton4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelMovLayout.setVerticalGroup(
            panelMovLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMovLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMovLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addGap(18, 18, 18)
                .addComponent(panelDado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblJ2.setText("JUGADOR 2");

        lblCantidadVidas2.setText("VIDAS: ");

        lblPersonajes2.setText("PERSONAJES: ");

        lblPersonaje2J2.setText("            ");

        lblPersonaje3J2.setText("         ");

        j2v5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/vida.png"))); // NOI18N

        j2v1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/vida.png"))); // NOI18N

        j2v2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/vida.png"))); // NOI18N

        j2v3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/vida.png"))); // NOI18N

        j2v4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/vida.png"))); // NOI18N

        javax.swing.GroupLayout panelJ2Layout = new javax.swing.GroupLayout(panelJ2);
        panelJ2.setLayout(panelJ2Layout);
        panelJ2Layout.setHorizontalGroup(
            panelJ2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelJ2Layout.createSequentialGroup()
                .addGroup(panelJ2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelJ2Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(lblJ2))
                    .addGroup(panelJ2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelJ2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCantidadVidas2)
                            .addGroup(panelJ2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(panelJ2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(j2v1)
                                    .addComponent(j2v2)
                                    .addComponent(j2v5))
                                .addGap(18, 18, 18)
                                .addGroup(panelJ2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(j2v3)
                                    .addComponent(j2v4))))
                        .addGap(42, 42, 42)
                        .addGroup(panelJ2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPersonajes2)
                            .addGroup(panelJ2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(panelJ2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblPersonaje1J2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblPersonaje2J2, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                                    .addComponent(lblPersonaje3J2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(panelJ2Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(lblNombreJ2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        panelJ2Layout.setVerticalGroup(
            panelJ2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelJ2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblJ2)
                .addGap(2, 2, 2)
                .addComponent(lblNombreJ2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelJ2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelJ2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblCantidadVidas2)
                        .addGap(18, 18, 18)
                        .addComponent(j2v1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(j2v2))
                    .addGroup(panelJ2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(panelJ2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(j2v3)
                            .addGroup(panelJ2Layout.createSequentialGroup()
                                .addComponent(lblPersonajes2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblPersonaje1J2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblPersonaje2J2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblPersonaje3J2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(j2v4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(j2v5)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        jLabel2.setText("ATAQUE");

        jButton5.setText("UP");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("LEFT");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("RIGTH");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("DOWN");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelAtaqueLayout = new javax.swing.GroupLayout(panelAtaque);
        panelAtaque.setLayout(panelAtaqueLayout);
        panelAtaqueLayout.setHorizontalGroup(
            panelAtaqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAtaqueLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jButton7)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAtaqueLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelAtaqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAtaqueLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(82, 82, 82))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAtaqueLayout.createSequentialGroup()
                        .addComponent(jButton5)
                        .addGap(65, 65, 65))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAtaqueLayout.createSequentialGroup()
                        .addComponent(jButton8)
                        .addGap(62, 62, 62))))
        );
        panelAtaqueLayout.setVerticalGroup(
            panelAtaqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAtaqueLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelAtaqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(jButton7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton8)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 705, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(lblTime)
                        .addGap(18, 18, 18)
                        .addComponent(lblTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelMov, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelJ1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(panelJ2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(panelAtaque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(194, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTime)
                            .addComponent(lblTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(panelJ1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panelMov, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(panelJ2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panelAtaque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(369, Short.MAX_VALUE)
                        .addComponent(panelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    public void lanzarDado(){
        Dado d = new Dado (lblNumObtenido);
        d.start();
        lblNumObtenido = d.getLblDado();
    }
    
    private void btnTirarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTirarActionPerformed
        String perTurnoActual;
        
        if (dado){
            lanzarDado();
            dado = false;
        
        }else {
            if(!dadoTirado){
                lanzarDado();
                dadoTirado = true;
                if (turno ==1 ){
                    perTurnoActual =  j1;
                }else{
                    perTurnoActual = j2;
                }
                if (perTurnoActual.equals(Princesa) && repe==0 ){
                    dadoTirado = false;
                    repe++;
                }else{
                    dadoTirado = true;
                    repe=0;
                    
                }
                
            }
        
        }
        /*Random dado = new Random();
                int numAle = 1 + dado.nextInt(6);
                String val = "" + numAle;
                lblNumObtenido.setText(val);*/
            

    }//GEN-LAST:event_btnTirarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        movimientoPersonaje(Arr);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        movimientoPersonaje(Izq);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        movimientoPersonaje(Der);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        movimientoPersonaje(Aba);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "No aplica saldra en la proxima version", null, JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void btnTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTurnoActionPerformed
        // TODO add your handling code here:
        turnos();
    }//GEN-LAST:event_btnTurnoActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        JOptionPane.showMessageDialog(null, "No aplica saldra en la proxima version", null, JOptionPane.WARNING_MESSAGE);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "No aplica saldra en la proxima version", null, JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "No aplica saldra en la proxima version", null, JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_jButton8ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
 
        
//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tablero(0, null).setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTirar;
    private javax.swing.JButton btnTurno;
    private javax.swing.JLabel j1v1;
    private javax.swing.JLabel j1v2;
    private javax.swing.JLabel j1v3;
    private javax.swing.JLabel j1v4;
    private javax.swing.JLabel j1v5;
    private javax.swing.JLabel j2v1;
    private javax.swing.JLabel j2v2;
    private javax.swing.JLabel j2v3;
    private javax.swing.JLabel j2v4;
    private javax.swing.JLabel j2v5;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblCantidadVidas;
    private javax.swing.JLabel lblCantidadVidas2;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblJ1;
    private javax.swing.JLabel lblJ2;
    private javax.swing.JLabel lblNombreJ1;
    private javax.swing.JLabel lblNombreJ2;
    private javax.swing.JLabel lblNumObtenido;
    private javax.swing.JLabel lblPersonaje1J1;
    private javax.swing.JLabel lblPersonaje1J2;
    private javax.swing.JLabel lblPersonaje2J1;
    private javax.swing.JLabel lblPersonaje2J2;
    private javax.swing.JLabel lblPersonaje3J1;
    private javax.swing.JLabel lblPersonaje3J2;
    private javax.swing.JLabel lblPersonajes;
    private javax.swing.JLabel lblPersonajes2;
    private javax.swing.JLabel lblTiempo;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lblTituloDado;
    private javax.swing.JPanel panelAtaque;
    private javax.swing.JPanel panelDado;
    private javax.swing.JPanel panelFondo;
    private javax.swing.JPanel panelJ1;
    private javax.swing.JPanel panelJ2;
    private javax.swing.JPanel panelMov;
    private javax.swing.JPanel panelTablero;
    // End of variables declaration//GEN-END:variables
    
    
    
}

