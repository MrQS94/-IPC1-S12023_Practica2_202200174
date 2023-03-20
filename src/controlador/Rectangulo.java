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
public class Rectangulo {

    public Rectangulo(Graphics g, int x, int y, Color color) {
        g.setColor(color);
        g.fillRect(x, y, 40, 45);
    }

}
