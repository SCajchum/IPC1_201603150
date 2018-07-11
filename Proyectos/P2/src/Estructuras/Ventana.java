/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import Estructuras.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author 22437
 */
public class Ventana extends javax.swing.JFrame {

    private ListaAviones listaAvion;
    private ColaPasajero colaPasajero;
    private ListaMaletas listaMaletas;
    private ListaEscritorio listaEscritorio;
    private ColaAvion colaAvion;
    private ListaMantenimiento listaMantenimiento;
    private int cantAviones, turno = 0, n = 1, contador, cantEstaciones, pasajeros, desabordaje, mantenimiento, maletas, documentos, turnosRegistro, cantEscritorios, validar;
    public static final String pequenio = "Pequenio", mediano = "Mediano", grande = "Grande";
    public static final int salidaPasajero = 5;
    private String tam;
    private String ruta;
    private int contadorMaletas, numeroMaleta = 1;
    boolean iniciado = false;
    Simulador sim = new Simulador();

    /**
     * Creates new form Ventana
     */
    public Ventana() {
        initComponents();
    }

    public void determinaTam() {
        int x = (int) (Math.random() * 3 + 1);
        if (x == 1) {
            tam = pequenio;
            desabordaje = 1;
            pasajeros = (int) Math.floor(Math.random() * (10 - 5 + 1) + 5);
            mantenimiento = (int) (Math.random() * 3 + 1);
        } else if (x == 2) {
            tam = mediano;
            desabordaje = 2;
            pasajeros = (int) Math.floor(Math.random() * (25 - 15 + 1) + 15);
            mantenimiento = (int) Math.floor(Math.random() * (4 - 2 + 1) + 2);
        } else if (x == 3) {
            tam = grande;
            desabordaje = 3;
            pasajeros = (int) Math.floor(Math.random() * (40 - 30 + 1) + 30);
            mantenimiento = (int) Math.floor(Math.random() * (6 - 3 + 1) + 3);
        }
    }

    public void agregarAviones() {
        if (cantAviones > 0) {
            determinaTam();
            listaAvion.setAvion(n, tam, pasajeros, desabordaje, mantenimiento);
            n++;
            cantAviones--;
            agregarPasajeros();
            agregarMaletas();
        }
    }

    public void agregarEstaciones() {
        while (cantEstaciones != 0) {
            listaMantenimiento.iniciarLista(cantEstaciones);
            cantEstaciones--;
        }
    }

    public void agregarEscritorios() {
        while (cantEscritorios != 0) {
            listaEscritorio.iniciarLista();
            cantEscritorios--;
        }
    }

    public void sacaPasajeros(int cantidad) {
        if (cantidad > 0) {
            //listaMaletas.eliminarMaleta(colaPasajero.getMaletas());
            if (listaEscritorio.determinaEspacio()) {
                listaEscritorio.agregarPasajerosCola((Pasajero) colaPasajero.quitar());
            } else {
                listaMaletas.eliminarMaleta(colaPasajero.getMaletas());
                colaPasajero.eliminarPasajero();
            }
            sacaPasajeros(cantidad - 1);
        }
    }

    public void agregarPasajeros() {
        contador += pasajeros;
        for (int i = (contador - pasajeros + 1); i < (contador + 1); i++) {
            determinarDoc();
            colaPasajero.setPasajero(i, maletas, documentos, turnosRegistro);
            contadorMaletas += maletas;
        }
    }

    public void agregarMaletas() {
        while (contadorMaletas != 0) {
            listaMaletas.setMaleta(numeroMaleta);
            numeroMaleta++;
            contadorMaletas--;
        }
    }

    public void determinarDoc() {
        maletas = (int) (Math.random() * 4 + 1);
        documentos = (int) (Math.random() * 10 + 1);
        turnosRegistro = (int) (Math.random() * 3 + 1);
    }

    public void imprimir() {

        sim.area.append("---------------- Turno " + turno + "---------------\n");
        sim.area.append("----------- Aviones -----------\n");
        listaAvion.printAviones(sim.area);
        sim.area.append("----------- Pasajero -----------\n");
        colaPasajero.printPasajero(sim.area);
        sim.area.append("---------Equipaje---------\n");
        listaMaletas.printMaletas(sim.area);
        sim.area.append("\n---------Estacion---------\n");
        listaMantenimiento.printListaMantenimiento(sim.area);
        sim.area.append("\n---------Cola---------\n");
        colaAvion.printColaAviones(sim.area);
        sim.area.append("\n-----------Escritorio---------\n");
        listaEscritorio.printListaEscritorio(sim.area);
        sim.area.append("\n----------------- Fin " + turno + "------------------\n");
    }

    public void comprobarVacio() {
        if (listaAvion.estaVacia() && colaAvion.estaVacia() && listaMaletas.estaVacia() && colaPasajero.estaVacia() && listaMantenimiento.estaVacio()) {
            JOptionPane.showMessageDialog(null, "Lista Vacia");
        }
    }

    public void imagenes() {
        ruta = "C:\\Users\\22437\\Desktop\\img\\listaAvion.png";
        ImageIcon iconoA = new ImageIcon(ruta);
        iconoA.getImage().flush();
        sim.lblAviones.setIcon(iconoA);
        this.sim.lblAviones.repaint();

        ruta = "C:\\Users\\22437\\Desktop\\img\\colaPasajero.png";
        ImageIcon iconoP = new ImageIcon(ruta);
        iconoP.getImage().flush();
        sim.lblPasajero.setIcon(iconoP);
        this.sim.lblPasajero.repaint();

        ruta = "C:\\Users\\22437\\Desktop\\img\\listaEscritorio.png";
        ImageIcon iconoE = new ImageIcon(ruta);
        iconoE.getImage().flush();
        sim.lblEscritorio.setIcon(iconoE);
        this.sim.lblEscritorio.repaint();

        ruta = "C:\\Users\\22437\\Desktop\\img\\listaMantenimiento.png";
        ImageIcon iconoMan = new ImageIcon(ruta);
        iconoMan.getImage().flush();
        sim.lblMan.setIcon(iconoMan);
        this.sim.lblMan.repaint();

        ruta = "C:\\Users\\22437\\Desktop\\img\\listaEquipaje.png";
        ImageIcon iconoMal = new ImageIcon(ruta);
        iconoMal.getImage().flush();
        sim.lblEquipaje.setIcon(iconoMal);
        this.sim.lblEquipaje.repaint();

    }

    public void graficar() {
        Graficador g = new Graficador();
        g.crearDot(listaAvion.getPrimero(), "listaDoble.dot");
        g.generarImagen("listaDoble.dot", "C:\\Users\\22437\\Desktop\\img\\listaAvion.png");

        g.crearDesabordaje(colaPasajero.getInicioNodo(), "colaPasajero.dot");
        g.generarImagen("colaPasajero.dot", "C:\\Users\\22437\\Desktop\\img\\colaPasajero.png");

        g.crearDotMantenimiento(listaMantenimiento.getInicioNodo(), "listaMantenimiento.dot", colaAvion.getInicioNodo());
        g.generarImagen("listaMantenimiento.dot", "C:\\Users\\22437\\Desktop\\img\\listaMantenimiento.png");

        g.crearDotEscritorio(listaEscritorio.getInicioNodo(), "listaEscritorio.dot");
        g.generarImagen("listaEscritorio.dot", "C:\\Users\\22437\\Desktop\\img\\listaEscritorio.png");

        g.crearDotListaMaleta(listaMaletas.getInicioNodo(), listaMaletas.getInicioNodo(), "colaMaleta");
        g.generarImagen("colaMaleta.dot", "C:\\Users\\22437\\Desktop\\img\\listaEquipaje.png");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Aviones");

        jLabel2.setText("Estaciones");

        jLabel3.setText("Escritorios");

        jLabel4.setText("Inicio");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton1.setText("Inicio");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Turno");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        validar = 2;
        turno = 0;
        n = 1;
        contador = 0;
        numeroMaleta = 1;
        sim.area.setText("");
        listaAvion = new ListaAviones();
        colaPasajero = new ColaPasajero();
        listaMaletas = new ListaMaletas();
        listaMantenimiento = new ListaMantenimiento();
        colaAvion = new ColaAvion();
        listaEscritorio = new ListaEscritorio();
        iniciado = false;
        try {
            cantAviones = Integer.parseInt(jTextField1.getText());
            cantEstaciones = Integer.parseInt(jTextField2.getText());
            cantEscritorios = Integer.parseInt(jTextField3.getText());

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Error");
        }
        agregarEstaciones();
        agregarEscritorios();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        sim.show(true);
        if (!iniciado) {
            agregarAviones();
            turno++;
            imprimir();
            iniciado = true;
            graficar();
            return;
        }
        listaAvion.bajaTurno();
        listaMantenimiento.bajarTurno();
        listaEscritorio.bajarTurno(listaMaletas);

        int x = 5;
        while (x != 0) {
            listaAvion.eliminaAvion(colaAvion);
            listaMantenimiento.terminaMantenimiento();
            colaAvion.pasarMantenimiento(listaMantenimiento);
            x--;
        }

        sacaPasajeros(salidaPasajero);
        listaEscritorio.addPasajeros();
        listaEscritorio.estaDisponible();
        agregarAviones();
        turno++;
        imprimir();
        comprobarVacio();
        graficar();
        imagenes();


    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
