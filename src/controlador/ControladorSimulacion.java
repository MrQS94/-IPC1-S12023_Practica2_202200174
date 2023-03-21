/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.Timer;
import modelo.ModeloSimulacion;
import vista.MenuInicial;
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
        this.timer = new Timer(1000, this);
        this.timer.start();
        this.inventario = inventario;
        this.produccion = produccion;
        this.empaquetado = empaquetado;
        this.salida = salida;
        this.simulacion.jButtonVolver.addActionListener(this);
        this.simulacion.jButtonReporte.addActionListener(this);
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

    private void Reporte() {
        String estructuraHTML = "";
        String tablaHTML = "";
        int total = 0;

        for (int i = 0; i < list.size(); i++) {
            total += list.get(i).getCosto() * (list.get(i).getTiempo() / 1000) * 30;
            tablaHTML
                    += "<tr>"
                    + "<td>" + String.valueOf(list.get(i).getCosto()) + "</td>"
                    + "<td>" + String.valueOf(list.get(i).getTiempo() / 1000) + "</td>"
                    + "<td> Q." + String.valueOf(list.get(i).getCosto() * (list.get(i).getTiempo() / 1000) * 30) + ".00</td>";
        }
        tablaHTML += ""
                + "<td> Q." + total + ".00</td>"
                + "</tr>";

        estructuraHTML += """
                          <!DOCTYPE html>
                                          <!-- Acá importar archivos necesarios --->
                                          <html>
                                              <head>
                                                  <title>Costos</title>
                                                  <meta charset="UTF-8">
                                                  <meta name="viewport" content="width=device-width, initial-scale=1.0">
                                                  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
                                              </head>
                                              <body>
                                                  <!-- Acá comenzar a conectar con el programa  -->
                                                  <div class="container">
                                                      <h1>Costo de materias primas - Andres Alejandro Quezada Cabrera - 202200174</h1>
                                                      <hr>
                                                      <table class="table table-bordered">
                                                          <tr>
                                                              <th class="text-center">Costo por Producto (Q/s)</th>
                                                              <th class="text-center">Tiempo de Procesamiento (s)</th>
                                                              <th class="text-center">Total de todos los sectores (Q)</th>
                                                              <th class="text-center">Total (Q)</th>
                                                             
                                                          </tr>
                                         """
                + tablaHTML + """
                                     </table>
                                  </div>
                              </body>
                          </html>
                        """;
        File file = new File("costos.html");
        try {
            file.createNewFile();
            FileWriter fw = new FileWriter("costos.html");
            fw.write(estructuraHTML);
            fw.close();
            Desktop desk = Desktop.getDesktop();
            desk.open(file);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(ControladorSimulacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

    }

    private void Regresar() {
        MenuInicial menu = new MenuInicial();
        ControladorMenu control = new ControladorMenu(menu, list);
        menu.show();
        simulacion.dispose();
    }

    private void Hilo() {
        MiHilo miHilo1 = new MiHilo(simulacion, inventario, produccion, empaquetado, salida, timer);
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
        } else if (e.getSource() == simulacion.jButtonVolver) {
            Regresar();
        } else if (e.getSource() == simulacion.jButtonReporte) {
            Reporte();
        }
    }

}
