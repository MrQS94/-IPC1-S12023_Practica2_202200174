/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author queza
 */
public class ModeloSimulacion {

    private int tiempo;
    private int costo;

    public ModeloSimulacion(int tiempo, int costo) {
        this.tiempo = tiempo;
        this.costo = costo;
    }

    public int getTiempo() {
        return tiempo;
    }

    public int getCosto() {
        return costo;
    }

}
