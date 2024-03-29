/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;

import vista.Simulacion;

/**
 *
 * @author queza
 */
public class MiHilo extends Thread {

    Simulacion simulacion;
    Timer timer;

    private int inventario, produccion, empaquetado, salida;

    public MiHilo(Simulacion simulacion, int inventario,
            int produccion, int empaquetado, int salida, Timer timer) {
        this.simulacion = simulacion;
        this.inventario = inventario;
        this.produccion = produccion;
        this.empaquetado = empaquetado;
        this.salida = salida;
        this.timer = timer;
    }

    public void run() {
        //---------------- INVENTARIO ----------------------
        // Posiciones en Inventario
        int posicionXInventario = -80;
        int posicionYInventario = 15;

        // Posicion en Inventario escondidas
        int posicionXhideInventario = -40;
        int posicionYhideInventario = 0;

        //Contador Inventario
        int contadorNombreInventario = 31; // Esto se podria quitar
        int contadorInventario = -1;

        //---------------- PRODUCCION ----------------------
        // Posiciones en Produccion
        int posicionXProduccion = -40;
        int posicionYProduccion = 15;

        // Posicion en Produccion escondidas
        int posicionXhideProduccion = -40;
        int posicionYhideProduccion = 0;

        //Contador Produccion
        int contadorNombreProduccion = 31; // Esto se podria quitar
        int contadorProduccion = 0;

        //---------------- EMPAQUETADO ----------------------
        // Posiciones en Produccion
        int posicionXEmpaquetado = -40;
        int posicionYEmpaquetado = 15;

        // Posicion en Produccion escondidas
        int posicionXhideEmpaquetado = -40;
        int posicionYhideEmpaquetado = 0;

        //Contador Produccion
        int contadorNombreEmpaquetado = 31; // Esto se podria quitar
        int contadorEmpaquetado = 0;

        //---------------- SALIDA ----------------------
        // Posiciones en Produccion
        int posicionXSalida = -40;
        int posicionYSalida = 15;

        // Posicion en Produccion escondidas
        int posicionXhideSalida = -40;
        int posicionYhideSalida = 0;

        //Contador Produccion
        int contadorNombreSalida = 31; // Esto se podria quitar
        int contadorSalida = 0;

        int contadorFinal = 0;

        Bolitas bolitasInventario;
        Bolitas bolitasProduccion;
        Bolitas bolitasEmpaquetado;
        Bolitas bolitasSalida;
        Bolitas bolitasEntrada;
        Bolitas bolitasFinal;

        while (true) {
            Color colorInventarioBolitas = new Color(16, 113, 229);
            Color colorProduccionBolitas = new Color(84, 196, 94);
            Color colorEmpaquetadoBolitas = new Color(224, 143, 255);
            Color colorSalidaBolitas = new Color(255, 143, 143);

            Color colorInventarioEsconder = new Color(153, 210, 242);
            Color colorProduccionEsconder = new Color(191, 249, 191);
            Color colorEmpaquetadoEsconder = new Color(244, 217, 255);
            Color colorSalidaEsconder = new Color(255, 217, 217);

            //INVENTARIO
            if (posicionXInventario >= 250) {
                posicionYInventario += 40;
                posicionXInventario = 0;
            } else if (posicionXhideInventario >= 250) {
                posicionXhideInventario = 0;
                posicionYhideInventario += 40;
            }
            
            contadorInventario++;
            if (contadorInventario <= (inventario / 1000)) { // Aca cambiar el limite de las pelotitas
                if (contadorNombreInventario > 0) {
                    posicionXInventario += 40;
                    contadorNombreInventario--;
                    simulacion.jLabelInventario.setText("" + contadorInventario);
                    bolitasInventario = new Bolitas(simulacion.jPanelInventario.getGraphics(),
                            posicionXInventario, posicionYInventario, colorInventarioBolitas);
                    simulacion.jPanelInicial.repaint();
                    simulacion.jLabelInicial.setText(String.valueOf(contadorNombreInventario));
                }
            } else {
                contadorInventario -= 2;
                if (contadorInventario >= 0) {
                    posicionXhideInventario += 40;
                    posicionYhideInventario += 0;
                    Rectangulo rect = new Rectangulo(simulacion.jPanelInventario.getGraphics(),
                            posicionXhideInventario, posicionYhideInventario, colorInventarioEsconder);
                    simulacion.jLabelInventario.setText("" + contadorInventario);
                    bolitasEntrada = new Bolitas(simulacion.jPanelInicial.getGraphics(),
                            65, 65, Color.WHITE);

                    // PRODUCCION
                    if (posicionXProduccion >= 250) {
                        posicionYProduccion += 40;
                        posicionXProduccion = 0;
                    } else if (posicionXhideProduccion >= 250) {
                        posicionXhideProduccion = 0;
                        posicionYhideProduccion += 40;
                    }

                    contadorProduccion++;
                    if (contadorProduccion <= (produccion / 1000)) { // Aca cambiar el limite de las pelotitas
                        if (contadorNombreProduccion > 0) {
                            posicionXProduccion += 40;
                            contadorNombreProduccion--;
                            simulacion.jLabelProduccion.setText("" + contadorProduccion);
                            bolitasProduccion = new Bolitas(simulacion.jPanelProduccion.getGraphics(),
                                    posicionXProduccion, posicionYProduccion, colorProduccionBolitas);
                        }
                    } else {
                        contadorProduccion -= 2;
                        if (contadorProduccion >= 0) {
                            posicionXhideProduccion += 40;
                            posicionYhideProduccion += 0;
                            Rectangulo rect2 = new Rectangulo(simulacion.jPanelProduccion.getGraphics(),
                                    posicionXhideProduccion, posicionYhideProduccion, colorProduccionEsconder);
                            simulacion.jLabelProduccion.setText("" + contadorProduccion);

                            // EMPAQUETADO
                            if (posicionXEmpaquetado >= 250) {
                                posicionYEmpaquetado += 40;
                                posicionXEmpaquetado = 0;
                            } else if (posicionXhideEmpaquetado >= 250) {
                                posicionXhideEmpaquetado = 0;
                                posicionYhideEmpaquetado += 40;
                            }

                            contadorEmpaquetado++;
                            if (contadorEmpaquetado <= (empaquetado / 1000)) { // Aca cambiar el limite de las pelotitas
                                if (contadorNombreEmpaquetado > 0) {
                                    posicionXEmpaquetado += 40;
                                    contadorNombreEmpaquetado--;
                                    simulacion.jLabelEmpaquetado.setText("" + contadorEmpaquetado);
                                    bolitasEmpaquetado = new Bolitas(simulacion.jPanelEmpaquetado.getGraphics(),
                                            posicionXEmpaquetado, posicionYEmpaquetado, colorEmpaquetadoBolitas);
                                }
                            } else {
                                contadorEmpaquetado -= 2;
                                if (contadorEmpaquetado >= 0) {
                                    posicionXhideEmpaquetado += 40;
                                    posicionYhideEmpaquetado += 0;
                                    Rectangulo rect3 = new Rectangulo(simulacion.jPanelEmpaquetado.getGraphics(),
                                            posicionXhideEmpaquetado, posicionYhideEmpaquetado, colorEmpaquetadoEsconder);
                                    simulacion.jLabelEmpaquetado.setText("" + contadorEmpaquetado);

                                    // SALIDA
                                    if (posicionXSalida >= 250) {
                                        posicionYSalida += 40;
                                        posicionXSalida = 0;
                                    } else if (posicionXhideSalida >= 250) {
                                        posicionXhideSalida = 0;
                                        posicionYhideSalida += 40;
                                    }

                                    contadorSalida++;
                                    if (contadorSalida <= (salida / 1000)) { // Aca cambiar el limite de las pelotitas
                                        if (contadorNombreSalida > 0) {
                                            posicionXSalida += 40;
                                            contadorNombreSalida--;
                                            simulacion.jLabelSalida.setText("" + contadorSalida);
                                            bolitasSalida = new Bolitas(simulacion.jPanelSalida.getGraphics(),
                                                    posicionXSalida, posicionYSalida, colorSalidaBolitas);
                                            simulacion.jPanelFinal.repaint();
                                        }
                                    } else {
                                        contadorSalida -= 2;
                                        if (contadorSalida >= 0) {
                                            posicionXhideSalida += 40;
                                            posicionYhideSalida += 0;

                                            Rectangulo rect4 = new Rectangulo(simulacion.jPanelSalida.getGraphics(),
                                                    posicionXhideSalida, posicionYhideSalida, colorSalidaEsconder);
                                            simulacion.jLabelSalida.setText("" + contadorSalida);
                                            bolitasEntrada = new Bolitas(simulacion.jPanelFinal.getGraphics(),
                                                    65, 65, Color.WHITE);
                                            contadorFinal++;
                                            if (contadorFinal <= 30) {
                                                simulacion.jLabelFinal.setText(String.valueOf(contadorFinal));
                                            } else {
                                                timer.stop();
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
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
