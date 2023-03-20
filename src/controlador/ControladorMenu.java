/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.ModeloSimulacion;
import vista.MenuInicial;
import vista.Simulacion;

/**
 *
 * @author queza
 */
public class ControladorMenu implements ActionListener, KeyListener {

    List<ModeloSimulacion> list;
    MenuInicial menu;

    public ControladorMenu(MenuInicial menu, List<ModeloSimulacion> list) {
        this.menu = menu;
        list = new ArrayList();
        this.list = list;
        this.menu.jTextFieldInventarioTiempo.addKeyListener(this);
        this.menu.jTextFieldIntentarioCosto.addKeyListener(this);
        this.menu.jTextFieldProduccionTiempo.addKeyListener(this);
        this.menu.jTextFieldProduccionCosto.addKeyListener(this);
        this.menu.jTextFieldEmpaquetadoTiempo.addKeyListener(this);
        this.menu.jTextFieldEmpaquetadoCosto.addKeyListener(this);
        this.menu.jTextFieldSalidaTiempo.addKeyListener(this);
        this.menu.jTextFieldSalidaCosto.addKeyListener(this);
        this.menu.jButtonSimulacion.addActionListener(this);
        this.menu.show();
    }

    private boolean ComprobarCamposVacios() {
        return !(menu.jTextFieldInventarioTiempo.getText().isBlank()
                || menu.jTextFieldIntentarioCosto.getText().isBlank()
                || menu.jTextFieldProduccionTiempo.getText().isBlank()
                || menu.jTextFieldProduccionCosto.getText().isBlank()
                || menu.jTextFieldEmpaquetadoTiempo.getText().isBlank()
                || menu.jTextFieldEmpaquetadoCosto.getText().isBlank()
                || menu.jTextFieldSalidaTiempo.getText().isBlank()
                || menu.jTextFieldSalidaCosto.getText().isBlank());
    }

    private void VaciarJText() {
        menu.jTextFieldInventarioTiempo.requestFocus();
        menu.jTextFieldInventarioTiempo.setText("");
        menu.jTextFieldIntentarioCosto.setText("");
        menu.jTextFieldProduccionTiempo.setText("");
        menu.jTextFieldProduccionCosto.setText("");
        menu.jTextFieldEmpaquetadoTiempo.setText("");
        menu.jTextFieldEmpaquetadoCosto.setText("");
        menu.jTextFieldSalidaTiempo.setText("");
        menu.jTextFieldSalidaCosto.setText("");
        menu.jButtonSimulacion.setEnabled(false);
    }

    private void GuardarSimulacion() {
        int inventarioTiempo = Integer.parseInt(menu.jTextFieldInventarioTiempo.getText());
        int inventarioCosto = Integer.parseInt(menu.jTextFieldIntentarioCosto.getText());
        int produccionTiempo = Integer.parseInt(menu.jTextFieldProduccionTiempo.getText());
        int produccionCosto = Integer.parseInt(menu.jTextFieldProduccionCosto.getText());
        int empaquetadoTiempo = Integer.parseInt(menu.jTextFieldEmpaquetadoTiempo.getText());
        int empaquetadoCosto = Integer.parseInt(menu.jTextFieldEmpaquetadoCosto.getText());
        int salidaTiempo = Integer.parseInt(menu.jTextFieldSalidaTiempo.getText());
        int salidaCosto = Integer.parseInt(menu.jTextFieldSalidaCosto.getText());

        inventarioTiempo *= 1000;
        produccionTiempo *= 1000;
        empaquetadoTiempo *= 1000;
        salidaTiempo *= 1000;

        ModeloSimulacion modInventario = new ModeloSimulacion(inventarioTiempo, inventarioCosto);
        ModeloSimulacion modProduccion = new ModeloSimulacion(produccionTiempo, produccionCosto);
        ModeloSimulacion modEmpaquetado = new ModeloSimulacion(empaquetadoTiempo, empaquetadoCosto);
        ModeloSimulacion modSalida = new ModeloSimulacion(salidaTiempo, salidaCosto);

        list.add(modInventario);
        list.add(modProduccion);
        list.add(modEmpaquetado);
        list.add(modSalida);

        JOptionPane.showMessageDialog(null, "Los datos han sido guardados correctamente.", "INFORMATION!!", JOptionPane.INFORMATION_MESSAGE);
        VaciarJText();

        menu.dispose();
        Simulacion simulacion = new Simulacion();
        ControladorSimulacion control = new ControladorSimulacion(simulacion, list, inventarioTiempo,
                produccionTiempo, empaquetadoTiempo, salidaTiempo);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == menu.jButtonSimulacion) {
            GuardarSimulacion();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();
        if (ComprobarCamposVacios()) {
            menu.jButtonSimulacion.setEnabled(true);
        } else {
            menu.jButtonSimulacion.setEnabled(false);
        }
        if (!(c >= '0' && c <= '9')) {
            e.consume();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
