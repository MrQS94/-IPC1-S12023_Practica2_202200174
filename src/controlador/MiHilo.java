/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.Color;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import modelo.ModeloSimulacion;
import vista.Simulacion;

/**
 *
 * @author queza
 */
public class MiHilo extends Thread {

    List<ModeloSimulacion> list;
    Simulacion simulacion;

    public MiHilo(List<ModeloSimulacion> list, Simulacion simulacion) {
        this.list = list;
        this.simulacion = simulacion;
    }

    public void run() {
        // Posiciones en Inventario
        int posicionXInventario = -80;
        int posicionYInventario = 15;

        // Posicion en Inventario escondidas
        int posicionXhideInventario = -40;
        int posicionYhideInventario = 0;

        //Contador Inventario
        int contadorNombreInventario = 30; // Esto se podria quitar
        int contadorInventario = -1;
        //---------------- PRODUCCION ----------------------
        // Posiciones en Produccion
        int posicionXProduccion = -40;
        int posicionYProduccion = 15;

        // Posicion en Produccion escondidas
        int posicionXhideProduccion = -40;
        int posicionYhideProduccion = 0;

        //Contador Produccion
        int contadorNombreProduccion = 30; // Esto se podria quitar
        int contadorProduccion = 0;

        Bolitas bolitasInventario;
        Bolitas bolitasProduccion;

        while (true) {
            Color colorInventarioBolitas = new Color(16, 113, 229);
            Color colorProduccionBolitas = new Color(84, 196, 94);
            Color colorEmpaquetadoBolitas = new Color(224, 143, 255);
            Color colorSalidaBolitas = new Color(255, 143, 143);

            Color colorInventarioEsconder = new Color(153, 210, 242);
            Color colorProduccionEsconder = new Color(191, 249, 191);

            //INVENTARIO
            if (posicionXInventario >= 250) {
                posicionYInventario += 40;
                posicionXInventario = 0;
            } else if (posicionXhideInventario >= 250) {
                posicionXhideInventario = 0;
                posicionYhideInventario += 40;
            }

            contadorInventario++;
            if (contadorInventario <= 3) {
                posicionXInventario += 40;
                contadorNombreInventario--;
                simulacion.jLabelInventario.setText("" + contadorInventario);
                bolitasInventario = new Bolitas(simulacion.jPanelInventario.getGraphics(),
                        posicionXInventario, posicionYInventario, "Hilo " + contadorNombreInventario, colorInventarioBolitas);
            } else {
                contadorInventario -= 2;
                if (contadorInventario >= 0) {
                    posicionXhideInventario += 40;
                    posicionYhideInventario += 0;
                    Rectangulo rect = new Rectangulo(simulacion.jPanelInventario.getGraphics(),
                            posicionXhideInventario, posicionYhideInventario, colorInventarioEsconder);
                    simulacion.jLabelInventario.setText("" + contadorInventario);

                    // PRODUCCION
                    if (posicionXProduccion >= 250) {
                        posicionYProduccion += 40;
                        posicionXProduccion = 0;
                    } else if (posicionXhideProduccion >= 250) {
                        posicionXhideProduccion = 0;
                        posicionYhideProduccion += 40;
                    }

                    contadorProduccion++;
                    if (contadorProduccion <= 3) {
                        posicionXProduccion += 40;
                        contadorNombreProduccion--;
                        simulacion.jLabelProduccion.setText("" + contadorProduccion);
                        bolitasProduccion = new Bolitas(simulacion.jPanelProduccion.getGraphics(),
                                posicionXProduccion, posicionYProduccion, "Hilo " + contadorNombreProduccion, colorProduccionBolitas);
                    } else {
                        contadorProduccion -= 2;
                        if (contadorProduccion >= 0) {
                            posicionXhideProduccion += 40;
                            posicionYhideProduccion += 0;
                            Rectangulo rect2 = new Rectangulo(simulacion.jPanelProduccion.getGraphics(),
                                    posicionXhideProduccion, posicionYhideProduccion, colorProduccionEsconder);
                            simulacion.jLabelProduccion.setText("" + contadorProduccion);
                        }
                    }
                }

            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Logger.getLogger(MiHilo.class.getName()).log(Level.SEVERE, null, e);
            }
        }

    }
}
