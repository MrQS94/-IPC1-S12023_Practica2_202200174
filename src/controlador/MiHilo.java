/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
        int posicionX = -80;
        int posicionY = 15;
        int posicionXhide = 0;
        int posicionYhide = 0;
        //Bolitas bolitasInventario[] = new Bolitas[31];
        Bolitas bolitasProduccion[] = new Bolitas[31];
        Bolitas bolitasEmpaquetado[] = new Bolitas[31];
        Bolitas bolitasSalida[] = new Bolitas[31];

        Bolitas bolitasInventario;

        for (int i = 0; i < 31; i++) {
            Color colorProduccionBolitas = new Color(84, 196, 94);
            Color colorInventarioBolitas = new Color(16, 113, 229);
            Color colorEmpaquetadoBolitas = new Color(224, 143, 255);
            Color colorSalidaBolitas = new Color(255, 143, 143);

            Color colorInventarioEsconder = new Color(153, 210, 242);

            posicionX += 40;
            if (posicionX >= 250) {
                posicionY += 40;
                posicionX = 0;
            }

            if (i <= 5) { //i <= 2
                simulacion.jLabelInventario.setText("" + i);
                bolitasInventario = new Bolitas(simulacion.jPanelInventario.getGraphics(),
                        posicionX, posicionY, "Hilo " + i, colorInventarioBolitas);
            } else {
                Rectangulo rect = new Rectangulo(simulacion.jPanelInventario.getGraphics(),
                        posicionXhide, posicionYhide, colorInventarioEsconder);
                posicionXhide += 40;
                posicionYhide += 0;
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
        }

    }

}/*
bolitasProduccion[i] = new Bolitas(simulacion.jPanelProduccion.getGraphics(), posicionX, posicionY, "Hilo " + i, colorProduccion);
            bolitasEmpaquetado[i] = new Bolitas(simulacion.jPanelEmpaquetado.getGraphics(), posicionX, posicionY, "Hilo " + i, colorEmpaquetado);
            bolitasSalida[i] = new Bolitas(simulacion.jPanelSalida.getGraphics(), posicionX, posicionY, "Hilo " + i, colorSalida);
 */
