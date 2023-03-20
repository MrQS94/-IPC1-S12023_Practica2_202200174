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
    private int minutos, segundos;
    private Timer timer;
    JPanel panel;

    private int inventario, produccion, empaquetado, salida;

    public ControladorSimulacion(Simulacion simulacion, List<ModeloSimulacion> list,
            int inventario, int produccion, int empaquetado, int salida) {
        this.simulacion = simulacion;
        this.list = list;
        this.simulacion.show();  
        timer = new Timer(1000, this);
        timer.start();
        this.inventario = inventario;
        this.produccion = produccion;
        this.empaquetado = empaquetado;
        this.salida = salida;
        Hilo();
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
        MiHilo miHilo1 = new MiHilo(list, simulacion, inventario, produccion, empaquetado, salida);
        miHilo1.start();
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
