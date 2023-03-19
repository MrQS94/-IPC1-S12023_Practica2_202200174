/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author queza
 */
public class Bolitas {

    public Bolitas(Graphics g, int x, int y, String nombre, Color color) {
        g.setColor(color);
        g.fillOval(x, y, 25, 25);
        g.setColor(Color.BLACK);
        g.drawOval(x, y, 25, 25);
        g.drawString(nombre, x, y);
    }

}
