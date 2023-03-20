/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import controlador.ControladorMenu;
import java.util.ArrayList;
import java.util.List;
import modelo.ModeloSimulacion;
import vista.MenuInicial;

/**
 *
 * @author queza
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MenuInicial menu = new MenuInicial();
        List<ModeloSimulacion> list = new ArrayList();
        ControladorMenu control = new ControladorMenu(menu, list);
    }

}
