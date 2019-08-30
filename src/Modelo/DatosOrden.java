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
public class DatosOrden {
    
    private String codigo_menu;
    private String nombre;
    private int cantidad;
    private double precio_unitario;
    private double subtotal;

    public DatosOrden(String codigo_menu, String nombre, int cantidad, double precio_unitario, double subtotal) {
        this.codigo_menu = codigo_menu;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio_unitario = precio_unitario;
        this.subtotal = subtotal;
    }

    public String getCodigo_menu() {
        return codigo_menu;
    }

    public void setCodigo_menu(String codigo_menu) {
        this.codigo_menu = codigo_menu;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(double precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
    
    
}
