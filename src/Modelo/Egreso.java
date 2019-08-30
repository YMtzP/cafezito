/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Egreso {

    private String tipo;
    private String descripcion;
    private String fecha;
    private String sustento;
    private double total;
    private static Connection cn;
    public Egreso() {
    }

    public Egreso(String tipo, String descripcion, String fecha, String sustento, double total) {
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.sustento = sustento;
        this.total = total;
        Conexion con = new Conexion("localhost", "cafezito", "root", "qpmz.2404");
        cn = con.getConnection();
    }

    public Egreso(String tipo, double total) {
        this.tipo = tipo;
        this.total = total;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getSustento() {
        return sustento;
    }

    public void setSustento(String sustento) {
        this.sustento = sustento;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Egreso{" + "tipo=" + tipo + ", descripcion=" + descripcion + ", fecha=" + fecha + ", sustento=" + sustento + ", total=" + total + '}';
    }

    public void registrarEgreso() {
        try {
            PreparedStatement pps = (PreparedStatement) cn.prepareStatement("INSERT INTO egreso (tipo, descripcion, fecha, sustento, total) values (?,?,?,?,?)");
            pps.setString(1, tipo);
            pps.setString(2, descripcion);
            pps.setString(3, fecha);
            pps.setString(4, sustento);
            pps.setDouble(5, total);
            pps.executeUpdate();
            System.out.println("¡Egreso Registrado con éxito!");
        } catch (SQLException ex) {
            Logger.getLogger(Egreso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Egreso> consultarEgresos() {
        ArrayList<Egreso> egresos = new ArrayList();
        try {
            PreparedStatement pps = cn.prepareStatement("SELECT tipo, descripcion, fecha, sustento, total FROM Egreso WHERE fecha = DATE(DATE_SUB(NOW(), INTERVAL 0 DAY))");
            ResultSet rs = pps.executeQuery();
            while (rs.next()) {
                Egreso egreso = new Egreso();
                egreso.setTipo(rs.getString("tipo"));
                egreso.setDescripcion(rs.getString("descripcion"));
                egreso.setFecha(rs.getString("fecha"));
                egreso.setSustento(rs.getString("sustento"));
                egreso.setTotal(rs.getDouble("total"));
                egresos.add(egreso);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Egreso.class.getName()).log(Level.SEVERE, null, ex);
        }
        return egresos;
    }
    


}
