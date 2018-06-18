/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medievil2;

import java.util.Vector;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;


/**
 *
 * @author 22437
 */
public class MoverUpDown extends  Thread{
    public static String Mina = "Mina";
    public static String Vida = "Vida";
    public static String Princesa = "Princesa";
    public static String Mago = "Mago";
    public static String Guerrero = "Guerrero";
    public static String J1 = "Jugador1";
    public static String J2 = "Jugador2";
    public static String Arr = "Arriba";
    public static String Aba = "Abajo";
    public static String Izq = "Izquierda";
    public static String Der = "Derecha";
    private String [][] matrizLogica;
    private JButton [][] matrizCasillas;
    private Jugador jugador;
    private Vector <Vector<JLabel>> listaVidas;
    private String movimiento, jugadorActual, jugadorEspera;
    private ImageIcon vida;
    private int cantidadMov, tam, fila, columna, aprox, a=0, b=1, dan, vi;
    private Integer posX, posY, random;
    private boolean mov = false, buscar=false;

    public MoverUpDown(String[][] matrizLogica, JButton[][] matrizCasillas, Jugador jugador, Vector<Vector<JLabel>> listaVidas, 
            String movimiento, String jugadorActual, int cantidadMov, int tam) {
        this.matrizLogica = matrizLogica;
        this.matrizCasillas = matrizCasillas;
        this.jugador = jugador;
        this.listaVidas = listaVidas;
        this.movimiento = movimiento;
        this.jugadorActual = jugadorActual;
        this.cantidadMov = cantidadMov;
        this.tam = tam;
        aprox = (int) Math.round((float)tam/2);
        vida = new ImageIcon("src/Imagenes/vida.png");
        if (jugadorActual.equals(J1)){
            this.jugadorActual = jugadorActual;
            this.jugadorEspera = J2;
        }else{
            this.jugadorActual = J2;
            this.jugadorEspera = J1;
        }
        for (int i = 0; i < tam ; i++){
            for(int j = 0; j<tam; j++){
                if(matrizLogica[j][i].equals(jugadorActual)){
                    fila = j;
                    columna = i;
                }
                    
            }
        
        }
        
    }
    
    public void run(){   
    
        try {
            

            while (a<cantidadMov){
                if (movimiento.equals(Aba)){
                    if(!matrizLogica[fila+1][columna].equals(jugadorEspera)){
                        if(matrizLogica[fila+1][columna].equals(Mina)){ mina(1); }
                            if(matrizLogica[fila+1][columna].equals(Vida) && (jugador.getVidaJ1()<5 &&
                                    jugador.getVidaJ1()>0)){ vida(); }
                            //Mueve Jugador - LOGICO
                            matrizLogica[fila+1][columna] = jugadorActual;
                            matrizLogica[fila][columna] = "";
                            //Mueve Jugador - GRAFICO
                            matrizCasillas[fila+1][columna].setIcon(matrizCasillas[fila][columna].getIcon());
                            matrizCasillas[fila][columna].setIcon(new JButton().getIcon());
                            Thread.sleep(500);
                            fila++;
                            a++;

                    }else{
                        random = ThreadLocalRandom.current().nextInt(0,0 + 1);
                        if(random ==0){
                            /*MoverUpDown upDown = new MoverUpDown(matrizLogica,  matrizCasillas, jugador,
                                listaVidas, Arr, jugadorActual,(cantidadMov-a), tam);
                            upDown.start();*/
                            MoverIzqDer derIzq = new MoverIzqDer(matrizLogica, matrizCasillas, jugador, listaVidas, 
                                    Izq, jugadorActual, (cantidadMov - a ), tam);
                            this.listaVidas = derIzq.getListaVidas();
                            this.jugador = derIzq.getJugador();
                            this.matrizCasillas = derIzq.getMatrizCasillas();
                            this.matrizLogica = derIzq.getMatrizLogica();
                            a = cantidadMov;
                        }else{
                            MoverIzqDer derIzq = new MoverIzqDer(matrizLogica, matrizCasillas, jugador, listaVidas, 
                                    Der, jugadorActual, (cantidadMov - a ), tam);
                            this.listaVidas = derIzq.getListaVidas();
                            this.jugador = derIzq.getJugador();
                            this.matrizCasillas = derIzq.getMatrizCasillas();
                            this.matrizLogica = derIzq.getMatrizLogica();
                            a = cantidadMov;
                        }
                    }
                }
                if (movimiento.equals(Arr)){
                    if(!matrizLogica[fila-1][columna].equals(jugadorEspera)){
                            //<editor-fold defaultstate="collapsed" desc="Izquierda">
                            if(matrizLogica[fila-1][columna].equals(Mina)){ mina(1); }
                            if(matrizLogica[fila-1][columna].equals(Vida) && (jugador.getVidaJ1()<5 &&
                                    jugador.getVidaJ1()>0)){ vida(); }
                            //Mueve Jugador - LOGICO
                            matrizLogica[fila-1][columna] = jugadorActual;
                            matrizLogica[fila][columna] = "";
                            //Mueve Jugador - GRAFICO
                            matrizCasillas[fila-1][columna].setIcon(matrizCasillas[fila][columna].getIcon());
                            matrizCasillas[fila][columna].setIcon(new JButton().getIcon());
                            Thread.sleep(500);
                            fila--;
                            a++;

                    }else{
                        random = ThreadLocalRandom.current().nextInt(0, 0 + 1);
                            if(random == 0 ){ 
                                
                            MoverIzqDer derIzq = new MoverIzqDer(matrizLogica, matrizCasillas, jugador, listaVidas, 
                                Izq, jugadorActual, (cantidadMov - a ), tam);
                            this.listaVidas = derIzq.getListaVidas();
                            this.jugador = derIzq.getJugador();
                            this.matrizCasillas = derIzq.getMatrizCasillas();
                            this.matrizLogica = derIzq.getMatrizLogica();
                            a = cantidadMov;
                        }else{
                            MoverIzqDer derIzq = new MoverIzqDer(matrizLogica, matrizCasillas, jugador, listaVidas, 
                                    Der, jugadorActual, (cantidadMov - a ), tam);
                            this.listaVidas = derIzq.getListaVidas();
                            this.jugador = derIzq.getJugador();
                            this.matrizCasillas = derIzq.getMatrizCasillas();
                            this.matrizLogica = derIzq.getMatrizLogica();
                            a = cantidadMov;
                            }
                    }
                }

            }
            this.interrupt();
        } catch (Exception e) {
            
        }
        
    }
    public void salirTablero(Icon icon, int fil, int colum ){
        int reubicarX = aprox, reubicarY = aprox, prueba=0;
        boolean colocarJ1 = true, colocarJ2 = true;
        if(jugadorActual.equals(J1)){
            colocarJ1 = false;
            colocarJ2 = true;
        }
        while (!colocarJ2 || !colocarJ1) {            
            if (matrizLogica[reubicarX][reubicarY].equals("")){
                if(!colocarJ1){
                    matrizLogica[fil][colum]="";
                    matrizCasillas[fil][colum].setIcon(new JButton().getIcon());
                    matrizLogica[reubicarX][reubicarY] = J1;
                    matrizCasillas[reubicarX][reubicarY].setIcon(icon);
                    colocarJ1 = true;
                }else if (!colocarJ2){
                    matrizLogica[fil][colum]="";
                    matrizCasillas[fil][colum].setIcon(new JButton().getIcon());
                    matrizLogica[reubicarX][reubicarY] = J2;
                    matrizCasillas[reubicarX][reubicarY].setIcon(icon);
                    colocarJ2 = true;
                } 
                }else{
                    if(!buscar){
                        for(int i = (aprox - b); i<= (aprox+b); i++){
                            if(!buscar ){
                                for(int j = (aprox - b); j<= (aprox+b); j++){
                                    if(matrizLogica[i][j].equals("")){
                                        reubicarX = i;
                                        reubicarY = j;
                                        prueba++;
                                        buscar = true;
                                        break;
                                        
                                        
                                    }else{
                                        prueba++;
                                    }
                                }
                            
                            }
                    }
                    if(b==1 && prueba==8){
                        b++; prueba=0; 
                    }
                    if(b==2 && prueba==16){ 
                        b++; prueba=0; 
                    }
                    if(b==3 && prueba==33){ 
                        b++; prueba=0; 
                    }
                    
                    }
                
                }
            
            }
                
            
        }
    public void mina(int danio){
        if(jugadorActual.equals(J1)){
            //Resta vida - LOGICO
            jugador.setVidaJ1(jugador.getVidaJ1()-danio);
            dan=0; vi=jugador.getVidaJ1(); 
        }else{
            //Resta vida - LOGICO
            jugador.setVidaJ2(jugador.getVidaJ2()-danio);
            dan=1; vi=jugador.getVidaJ2(); 
        }
        //Resta vida - GRAFICO
        if(vi==4){
            listaVidas.get(dan).get(4).setIcon(new JButton().getIcon());
        }
        if(vi==3){
            listaVidas.get(dan).get(4).setIcon(new JButton().getIcon());
            listaVidas.get(dan).get(3).setIcon(new JButton().getIcon());
        }
        if(vi==2){
            listaVidas.get(dan).get(4).setIcon(new JButton().getIcon());
            listaVidas.get(dan).get(3).setIcon(new JButton().getIcon());
            listaVidas.get(dan).get(2).setIcon(new JButton().getIcon());
        }
        if(vi==1){
            listaVidas.get(dan).get(4).setIcon(new JButton().getIcon());
            listaVidas.get(dan).get(3).setIcon(new JButton().getIcon());
            listaVidas.get(dan).get(2).setIcon(new JButton().getIcon());
            listaVidas.get(dan).get(1).setIcon(new JButton().getIcon());
        }
        if(vi==0 || vi<0){
            if(dan==0){
                jugador.setVidaJ1(0);
            }else{
                jugador.setVidaJ2(0);
            }
        }
    
    
    }
    public void vida(){
    if(jugadorActual.equals(J1)){
            //Resta vida - LOGICO
            jugador.setVidaJ1(jugador.getVidaJ1() + 1);
            dan=0; vi=jugador.getVidaJ1(); 
        }else{
            //Resta vida - LOGICO
            jugador.setVidaJ2(jugador.getVidaJ2() + 1);
            dan=1; vi=jugador.getVidaJ2(); 
        }
        //Resta vida - GRAFICO
        if(vi==1){
            listaVidas.get(dan).get(0).setIcon(vida);
        }
        if(vi==2){
            listaVidas.get(dan).get(1).setIcon(vida);
            listaVidas.get(dan).get(0).setIcon(vida);
        }
        if(vi==3){
            listaVidas.get(dan).get(2).setIcon(vida);
            listaVidas.get(dan).get(1).setIcon(vida);
            listaVidas.get(dan).get(0).setIcon(vida);
        }
        if(vi==4){
            listaVidas.get(dan).get(3).setIcon(vida);
            listaVidas.get(dan).get(2).setIcon(vida);
            listaVidas.get(dan).get(1).setIcon(vida);
            listaVidas.get(dan).get(0).setIcon(vida);
        }
        
    }

    public String[][] getMatrizLogica() {
        return matrizLogica;
    }

    public JButton[][] getMatrizCasillas() {
        return matrizCasillas;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public Vector<Vector<JLabel>> getListaVidas() {
        return listaVidas;
    }
    
    
    

    
    
    
}
