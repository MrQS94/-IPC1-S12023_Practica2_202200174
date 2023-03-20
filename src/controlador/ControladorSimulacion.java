/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.Timer;
import modelo.ModeloSimulacion;
import vista.Simulacion;

/**
 *
 * @author queza
 */
public class ControladorSimulacion implements ActionListener {

    Simulacion simulacion;
    List<ModeloSimulacion> list;
    ModeloSimulacion[] mod = new ModeloSimulacion[30];
    private int minutos;
    private int segundos;
    private Timer timer;
    JPanel panel;

    public ControladorSimulacion(Simulacion simulacion, List<ModeloSimulacion> list) {
        this.simulacion = simulacion;
        this.list = list;
        this.simulacion.show();
        Hilo();
        timer = new Timer(1000, this);
        timer.start();
    }

    private void Cronometro() {
        segundos++;
        if (segundos == 60) {
            segundos = 0;
            minutos++;
        }
        if (minutos == 60) {
            minutos = 0;
        }
    }

    private void Hilo() {
        MiHilo miHilo1 = new MiHilo(list, simulacion);
        miHilo1.start();
       /* MiHilo miHilo2 = new MiHilo(list, simulacion);
        miHilo2.run("3");*/
    }

    private void ActualizarTiempo() {
        simulacion.jLabelTimer.setText(String.format("%02d:%02d", minutos, segundos));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == timer) {
            Cronometro();
            ActualizarTiempo();
        }
    }

}
