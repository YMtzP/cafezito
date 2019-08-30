/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Alexis Salvador
 */
public class ModificarOrden {

    Connection cn;

    public ModificarOrden() {
        Conexion con = new Conexion("localhost", "cafezito", "root", "qpmz.2404");
        System.out.println("Conexion Tomar orden");
        cn = con.getConnection();
    }

    public ArrayList obtenerListaNombres(String tipo) {
        //Connection cn = con.getConnection();
        ArrayList listaNombres = new ArrayList();
        try {
            PreparedStatement ps = cn.prepareStatement("select nombre from menu where tipo=?;");
            ps.setString(1, tipo);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String nombre = rs.getString(1);
                listaNombres.add(nombre);
            }
        } catch (Exception e) {
        }
        return listaNombres;
    }

    public ArrayList obtenerListaMesasOcupadas(String status) {
        //Connection cn = con.getConnection();
        ArrayList listaMesas = new ArrayList();
        try {
            PreparedStatement ps = cn.prepareStatement("select numero_mesa from mesa where status=?;");
            ps.setString(1, status);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int numero = rs.getInt(1);
                listaMesas.add(numero);
            }
        } catch (Exception e) {

        }
        return listaMesas;
    }

    public ArrayList<DatosOrden> obtenerDatosDeOrden(int numero_orden) {
        //Connection cn = con.getConnection();
        ArrayList listaDatosOrden = new ArrayList();
        try {
            //String sql = "select detalle_orden.codigo_menu, nombre, cantidad, precio_unitario, subtotal from detalle_orden join menu on detalle_orden.codigo_menu=menu.codigo_menu where numero_orden=?;";
            String sql = "select detalle_orden.codigo_menu, nombre, cantidad, precio_unitario, subtotal from detalle_orden join menu on detalle_orden.codigo_menu=menu.codigo_menu join orden on detalle_orden.numero_orden=orden.numero_orden join mesa on orden.numero_mesa=mesa.numero_mesa where orden.numero_orden=? and mesa.status='Ocupada';";

            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, numero_orden);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String codigo_menu = rs.getString(1);
                String nombre = rs.getString(2);
                int cantidad = rs.getInt(3);
                double precio = rs.getDouble(4);
                double subtotal = rs.getDouble(5);
                DatosOrden datosOrden = new DatosOrden(codigo_menu, nombre, cantidad, precio, subtotal);
                listaDatosOrden.add(datosOrden);
            }
        } catch (Exception e) {

        }
        return listaDatosOrden;
    }

    public ArrayList<DatosOrden> obtenerDatosDeOrdenPorMesa(int numero_mesa) {
        //Connection cn = con.getConnection();
        ArrayList listaDatosOrden = new ArrayList();
        try {
            String sql = "select detalle_orden.codigo_menu, nombre, cantidad, precio_unitario, subtotal from detalle_orden join menu on detalle_orden.codigo_menu=menu.codigo_menu join orden on detalle_orden.numero_orden=orden.numero_orden join mesa on orden.numero_mesa=mesa.numero_mesa where orden.numero_mesa=? and mesa.status='Ocupada';";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, numero_mesa);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String codigo_menu = rs.getString(1);
                String nombre = rs.getString(2);
                int cantidad = rs.getInt(3);
                double precio = rs.getDouble(4);
                double subtotal = rs.getDouble(5);
                DatosOrden datosOrden = new DatosOrden(codigo_menu, nombre, cantidad, precio, subtotal);
                listaDatosOrden.add(datosOrden);
            }
        } catch (Exception e) {

        }
        return listaDatosOrden;
    }

    public Menu BuscarPorCodigo(String codigo_menu) {
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

    public Menu BuscarPorNombre(String nombre_menu) {
        //Connection cn = con.getConnection();
        String tipo = "", nombre = "", codigo_menu = "";
        Double precio_unitario = 0.0;
        try {

            PreparedStatement ps = cn.prepareStatement("Select*from menu where nombre=?;");
            ps.setString(1, nombre_menu);
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

    public int obtenerNumeroOrden(int numero_mesa) {
        int numero_orden = 0;
        try {
            PreparedStatement ps = cn.prepareStatement("select numero_orden from orden join mesa on orden.numero_mesa=mesa.numero_mesa where mesa.numero_mesa=? and orden.status=0;");
            ps.setInt(1, numero_mesa);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                numero_orden = rs.getInt(1);
            }
        } catch (Exception e) {

        }
        return numero_orden;
    }

    public void insertarDetalle_Orden(String codigo_menu, int numero_orden, int cantidad, double subtotal) {
        //Connection cn = con.getConnection();
        try {
            PreparedStatement ps = cn.prepareStatement("insert into detalle_orden(codigo_menu,numero_orden,cantidad,subtotal)values(?,?,?,?);");
            ps.setString(1, codigo_menu);
            ps.setInt(2, numero_orden);
            ps.setInt(3, cantidad);
            ps.setDouble(4, subtotal);
            ps.execute();
        } catch (Exception e) {

        }
    }

    public void modificarTotalOrden(double total, int numero_orden) {
        //Connection cn = con.getConnection();
        try {
            PreparedStatement ps = cn.prepareStatement("update orden set total=? where numero_orden=?;");
            ps.setDouble(1, total);
            ps.setInt(2, numero_orden);
            ps.execute();
        } catch (Exception e) {

        }
    }

    public void eliminarDetalleOrden(int numero_orden) {
        //Connection cn = con.getConnection();
        try {
            PreparedStatement ps = cn.prepareStatement("delete from detalle_orden where numero_orden=?;");
            ps.setInt(1, numero_orden);
            ps.execute();
        } catch (Exception e) {

        }
    }
}
