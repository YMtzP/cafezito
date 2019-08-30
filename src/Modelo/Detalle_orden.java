/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Alexis Salvador
 */
public class Detalle_orden {
    private String codigo_menu;
    private int numero_orden;
    private int cantidad;
    private double subtotal;

    public Detalle_orden(String codigo_menu, int numero_orden, int cantidad, double subtotal) {
        this.codigo_menu = codigo_menu;
        this.numero_orden = numero_orden;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }   

    public String getCodigo_menu() {
        return codigo_menu;
    }

    public void setCodigo_menu(String codigo_menu) {
        this.codigo_menu = codigo_menu;
    }

    public int getNumero_orden() {
        return numero_orden;
    }

    public void setNumero_orden(int numero_orden) {
        this.numero_orden = numero_orden;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
    
    
    
    
}
