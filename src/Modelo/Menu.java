/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Vista.PantallaGestionarMenu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Alexis Salvador
 */
public class Menu {

    //Conexion con;
    Connection cn;

    private String codigo_menu;
    private String tipo;
    private String nombre;
    private Double precio_unitario;
    // String precio =String.valueOf(precio_unitario);

    PantallaGestionarMenu pantallaGestionarMenu;

    public Menu(String codigo_menu, String tipo, String nombre, Double precio_unitario) {
        this.codigo_menu = codigo_menu;
        this.tipo = tipo;
        this.nombre = nombre;
        this.precio_unitario = precio_unitario;
    }

    public Menu() {
        Conexion con = new Conexion("localhost", "cafezito", "root", "qpmz.2404");
        cn = con.getConnection();
    }

    public String getCodigo_menu() {
        return codigo_menu;
    }

    public void setCodigo_menu(String codigo_menu) {
        this.codigo_menu = codigo_menu;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(Double precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    @Override
    public String toString() {
        return "Menu{" + "codigo_menu=" + codigo_menu + ", tipo=" + tipo + ", nombre=" + nombre + ", precio_unitario=" + precio_unitario + '}';
    }

    public Menu BuscarPorCodigoMenu(String codigo_menu) {
///        Connection cn = con.getConnection();
        String tipo = "", nombre = "";
        Double precio_unitario = 0.0;
        try {

            PreparedStatement ps = cn.prepareStatement("Select*from menu where codigo_menu=?;");
            ps.setString(1, codigo_menu);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                codigo_menu = rs.getString(1);
                tipo = rs.getString(2);
                nombre = rs.getString(3);
                precio_unitario = rs.getDouble(4);
            }
        } catch (Exception e) {
        }
        Menu objMenu = new Menu(codigo_menu, tipo, nombre, precio_unitario);

        return objMenu;
    }

    public void insertarMenu(String codigo_menu, String tipo, String nombre, Double precio_unitario, int status) {
//        Connection cn = con.getConnection();
        try {
            PreparedStatement ps = cn.prepareStatement("insert into menu (codigo_menu, tipo, nombre,precio_unitario, status) values (?,?,?,?,?);");
            ps.setString(1, codigo_menu);
            ps.setString(2, tipo);
            ps.setString(3, nombre);
            ps.setDouble(4, precio_unitario);
            ps.setInt(5, status);
            ps.execute();
            //JOptionPane.showMessageDialog(null, "platillo/orden/bebida  registrado en el menú");
        } catch (Exception e) {

        }
    }

    public void EliminarMenu(String codigo_menu, int status) {
//        Connection cn = con.getConnection();
        try {
            PreparedStatement ps = cn.prepareStatement("update menu set status=? where codigo_menu=?;");
            ps.setInt(1,status);
            ps.setString(2, codigo_menu);
            ps.execute();
            //JOptionPane.showMessageDialog(null, "platillo/orden/bebida  eliminado del menú");
        } catch (Exception e) {

        }
    }

    public void ModificarMenu(String codigo_menu, String tipo, String nombre, Double precio_unitario,int status) {
//        Connection cn = con.getConnection();
        try {
            PreparedStatement ps = cn.prepareStatement("update menu set tipo=?, nombre=?,precio_unitario=?,status=? where codigo_menu=?;");

            ps.setString(1, tipo);
            ps.setString(2, nombre);
            ps.setDouble(3, precio_unitario);
            ps.setInt (4,status);
            ps.setString(5, codigo_menu);
            ps.execute();
            // JOptionPane.showMessageDialog(null, "platillo/orden/bebida  modificado en el menú");
        } catch (Exception e) {

        }
    }

   

}
