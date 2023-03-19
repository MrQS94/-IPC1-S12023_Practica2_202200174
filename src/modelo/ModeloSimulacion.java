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

    private int inventarioTiempo;
    private int inventarioCosto;
    private int produccionTiempo;
    private int produccionCosto;
    private int empaquetadoTiempo;
    private int empaquetadoCosto;
    private int salidaTiempo;
    private int salidaCosto;

    private String nombre;
    private String precio;

    public ModeloSimulacion(String nombre, String precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
    
    
    
    public ModeloSimulacion(int inventarioTiempo, int inventarioCosto, int produccionTiempo, 
            int produccionCosto, int empaquetadoTiempo, int empaquetadoCosto, int salidaTiempo, 
            int salidaCosto) {
        this.inventarioTiempo = inventarioTiempo;
        this.inventarioCosto = inventarioCosto;
        this.produccionTiempo = produccionTiempo;
        this.produccionCosto = produccionCosto;
        this.empaquetadoTiempo = empaquetadoTiempo;
        this.empaquetadoCosto = empaquetadoCosto;
        this.salidaTiempo = salidaTiempo;
        this.salidaCosto = salidaCosto;
    }

    public int getInventarioTiempo() {
        return inventarioTiempo;
    }

    public void setInventarioTiempo(int inventarioTiempo) {
        this.inventarioTiempo = inventarioTiempo;
    }

    public int getInventarioCosto() {
        return inventarioCosto;
    }

    public void setInventarioCosto(int inventarioCosto) {
        this.inventarioCosto = inventarioCosto;
    }

    public int getProduccionTiempo() {
        return produccionTiempo;
    }

    public void setProduccionTiempo(int produccionTiempo) {
        this.produccionTiempo = produccionTiempo;
    }

    public int getProduccionCosto() {
        return produccionCosto;
    }

    public void setProduccionCosto(int produccionCosto) {
        this.produccionCosto = produccionCosto;
    }

    public int getEmpaquetadoTiempo() {
        return empaquetadoTiempo;
    }

    public void setEmpaquetadoTiempo(int empaquetadoTiempo) {
        this.empaquetadoTiempo = empaquetadoTiempo;
    }

    public int getEmpaquetadoCosto() {
        return empaquetadoCosto;
    }

    public void setEmpaquetadoCosto(int empaquetadoCosto) {
        this.empaquetadoCosto = empaquetadoCosto;
    }

    public int getSalidaTiempo() {
        return salidaTiempo;
    }

    public void setSalidaTiempo(int salidaTiempo) {
        this.salidaTiempo = salidaTiempo;
    }

    public int getSalidaCosto() {
        return salidaCosto;
    }

    public void setSalidaCosto(int salidaCosto) {
        this.salidaCosto = salidaCosto;
    }

}