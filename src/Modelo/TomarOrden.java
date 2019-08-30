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
import javax.swing.JOptionPane;

/**
 *
 * @author Alexis Salvador
 */
public class TomarOrden {

    //Conexion con;
    Connection cn;

    public TomarOrden() {
        Conexion con = new Conexion("localhost", "cafezito", "root", "qpmz.2404");
        cn = con.getConnection();
        System.out.println("Conexion Tomar orden");
    }

    public Menu BuscarPorCodigo(String codigo_menu) {
        String tipo = "", nombre = "";
        Double precio_unitario = 0.0;
        try {

            PreparedStatement ps = cn.prepareStatement("Select*from menu where codigo_menu=? and status=1;");
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

            PreparedStatement ps = cn.prepareStatement("Select*from menu where nombre=? and status=1;");
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

    public ArrayList obtenerListaNombres(String tipo) {
        //Connection cn = con.getConnection();
        ArrayList listaNombres = new ArrayList();
        try {
            PreparedStatement ps = cn.prepareStatement("select nombre from menu where tipo=?  and status=1;");
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

    public ArrayList obtenerListaMesasDispobinles(String status) {
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

    public int obtenerNumeroMesero(String usuario) {
        //Connection cn = con.getConnection();
        int numeroMesero = 0;
        try {
            PreparedStatement ps = cn.prepareStatement("select id_empleado from login where usuario=?;");
            ps.setString(1, usuario);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                numeroMesero = rs.getInt(1);
            }
        } catch (Exception e) {

        }
        return numeroMesero;
    }

    public void insertarOrden(Double total, int id_empleado, int numero_mesa) {
        //Connection cn = con.getConnection();
        try {
            PreparedStatement ps = cn.prepareStatement("insert into orden (total, id_empleado, numero_mesa,fecha,status) values (?,?,?,now(),0);");
            ps.setDouble(1, total);
            ps.setInt(2, id_empleado);
            ps.setInt(3, numero_mesa);
            ps.execute();
            //JOptionPane.showMessageDialog(null, "Orden Registrada Correctamente");
        } catch (Exception e) {

        }
    }

    public void insertarDetalle_Orden(String codigo_menu, int numero_orden, int cantidad, double subtotal) {
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

    public int obtenerNumeroOrden() {
        int numeroOrden = 0;
        try {
            PreparedStatement ps = cn.prepareStatement("select numero_orden from orden order by numero_orden desc limit 1;");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                numeroOrden = rs.getInt(1);
            }
        } catch (Exception e) {

        }
        return numeroOrden;
    }

    public void cambiarStatusDeMesaOcupado(int numero_mesa) {
        //Connection cn = con.getConnection();
        try {
            PreparedStatement ps = cn.prepareStatement("update mesa set status='Ocupada' where numero_mesa=?;");
            ps.setInt(1, numero_mesa);
            ps.execute();
        } catch (Exception e) {

        }
    }

    public void cambiarStatusDeMesaDisponible(int numero_mesa) {
        //Connection cn = con.getConnection();
        try {
            PreparedStatement ps = cn.prepareStatement("update mesa set status='Disponible' where numero_mesa=?;");
            ps.setInt(1, numero_mesa);
            ps.execute();
        } catch (Exception e) {

        }
    }

    public double consultarIngreso() {

        double total = 0;
        try {
            PreparedStatement ps = cn.prepareStatement("SELECT sum(total) as total_venta FROM Orden WHERE fecha = DATE(DATE_SUB(NOW(), INTERVAL 0 DAY)) and status = 1");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                total = rs.getDouble("total_venta");
            }
        } catch (Exception e) {

        }
        return total;
    }

    public boolean existNumeroOrden(String numeroOrden) {
        try {
            PreparedStatement pps = cn.prepareStatement("SELECT * FROM detalle_orden join Orden on Orden.numero_orden = Detalle_Orden.numero_orden WHERE Detalle_Orden.numero_orden = ? and Orden.status = 0");
            pps.setString(1, numeroOrden);
            ResultSet rs = pps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {

        }
        return false;
    }

    public ArrayList consltarOrdenPorNumero(String numeroOrden) {
        ArrayList listaOrden = new ArrayList();
        try {
            PreparedStatement pps = cn.prepareStatement("SELECT Menu.nombre, Detalle_Orden.cantidad, Menu.precio_unitario, (Detalle_Orden.cantidad*Menu.precio_unitario) as subtotal, Orden.numero_mesa fROM Menu join Detalle_Orden on Menu.codigo_menu=Detalle_Orden.codigo_menu join Orden on Orden.numero_orden = Detalle_Orden.numero_orden WHERE Detalle_Orden.numero_orden = ?");
            pps.setString(1, numeroOrden);
            ResultSet rs = pps.executeQuery();
            while (rs.next()) {
                Object[] temp = new Object[5];
                temp[0] = rs.getString("nombre");
                temp[1] = rs.getInt("cantidad");
                temp[2] = rs.getDouble("precio_unitario");
                temp[3] = rs.getDouble("subtotal");
                temp[4] = rs.getInt("numero_mesa");
                listaOrden.add(temp);
            }
        } catch (Exception e) {

        }
        return listaOrden;
    }

    public ArrayList consltarOrdenPorMesa(String numeroMesa) {
        ArrayList listaOrden = new ArrayList();
        try {
            PreparedStatement pps = cn.prepareStatement("SELECT Menu.nombre, Detalle_Orden.cantidad, Menu.precio_unitario, (Detalle_Orden.cantidad*Menu.precio_unitario) as subtotal, Detalle_Orden.numero_orden fROM Menu join Detalle_Orden on Menu.codigo_menu=Detalle_Orden.codigo_menu join Orden on Orden.numero_orden = Detalle_Orden.numero_orden WHERE Orden.numero_mesa = ? and Orden.status = 0");
            pps.setString(1, numeroMesa);
            ResultSet rs = pps.executeQuery();
            while (rs.next()) {
                Object[] temp = new Object[5];
                temp[0] = rs.getString("nombre");
                temp[1] = rs.getInt("cantidad");
                temp[2] = rs.getDouble("precio_unitario");
                temp[3] = rs.getDouble("subtotal");
                temp[4] = rs.getInt("numero_orden");
                listaOrden.add(temp);
            }
        } catch (Exception e) {

        }
        return listaOrden;
    }
    
    
    public void cambiarStatusOrden(int numero_orden) {
        //Connection cn = con.getConnection();
        try {
            PreparedStatement ps = cn.prepareStatement("update Orden set status=1 where numero_orden=?;");
            ps.setInt(1, numero_orden);
            ps.execute();
        } catch (Exception e) {

        }
    }

}
