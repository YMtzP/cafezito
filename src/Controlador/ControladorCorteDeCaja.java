/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Egreso;
import Modelo.TomarOrden;
import Vista.PantallaCorteDeCaja;
import Vista.PantallaMenuCajero;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.print.PrinterException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jose_Morales
 */
public class ControladorCorteDeCaja {

    PantallaCorteDeCaja pantallaCorteDeCaja;
    Egreso egreso;
    TomarOrden orden;
    //Hacemos uso de la clase Calendar
    Calendar c = Calendar.getInstance();
    //Extraemos la fecha actual
    String diaActual = Integer.toString(c.get(Calendar.DATE));
    String mesActual = Integer.toString(c.get(Calendar.MONTH) + 1);
    String añoActual = Integer.toString(c.get(Calendar.YEAR));
    double totalEgreso = 0;
    double totalIngreso = 0;
    String fecha = diaActual + "/" + mesActual + "/" + añoActual;

    public ControladorCorteDeCaja(PantallaCorteDeCaja pantallaCorteDeCaja, Egreso egreso, TomarOrden orden) {
        this.pantallaCorteDeCaja = pantallaCorteDeCaja;
        this.egreso = egreso;
        this.orden = orden;
        totalIngreso = orden.consultarIngreso();
        pantallaCorteDeCaja.lblFechaCorteCaja.setText("Fecha: " + fecha);
        llenarTabla(this.pantallaCorteDeCaja.tblEgresosIngresosCorteCaja);
        pantallaCorteDeCaja.lblSaldoFinal.setText("Saldo Final: $" + String.valueOf(redondeo(totalIngreso - totalEgreso)));

        //Botón Regresar
        this.pantallaCorteDeCaja.btnRegresarCorteCaja.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cerrarPantalla();
            }
        });

        //Botón imprimir reporte
        this.pantallaCorteDeCaja.btnExportarPDF.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    pantallaCorteDeCaja.tblEgresosIngresosCorteCaja.print();
                } catch (PrinterException ex) {
                    Logger.getLogger(ControladorCorteDeCaja.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        this.pantallaCorteDeCaja.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                cerrarPantalla();
            }
        });
    }

    public void cerrarPantalla() {
        pantallaCorteDeCaja.setVisible(false);
        pantallaCorteDeCaja.dispose();
        PantallaMenuCajero p = new PantallaMenuCajero();
        ControladorMenuCajero menu = new ControladorMenuCajero(p);
        p.setVisible(true);

    }

    public void llenarTabla(JTable tabla) {
        egreso = new Egreso("", "", "", "", 0);
        orden = new TomarOrden();
        ArrayList<Egreso> egresos = egreso.consultarEgresos();
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tabla.removeAll();
        model.addColumn("Concepto");
        model.addColumn("Ingresos");
        model.addColumn("Egresos");

        Object[] egr = new Object[3];
        for (Egreso egreso : egresos) {
            egr[0] = egreso.getTipo();
            egr[2] = egreso.getTotal();
            totalEgreso += egreso.getTotal();
            model.addRow(egr);
        }

        egr[0] = "Ventas";
        egr[1] = orden.consultarIngreso();
        egr[2] = "";
        model.addRow(egr);
        egr[0] = "Total";
        egr[1] = redondeo(totalIngreso);
        egr[2] = redondeo(totalEgreso);
        model.addRow(egr);

        egr[0] = "Saldo final: $";
        egr[1] = redondeo(totalIngreso - totalEgreso);
        egr[2] = "";
        model.addRow(egr);

        egr[0] = "Fecha: ";
        egr[1] = fecha;
        egr[2] = "";
        model.addRow(egr);

        tabla.setModel(model);

    }

    public double redondeo(double cantidad) {
        //Redondeamos la cantidad a dos digitos
        return Math.rint(cantidad * 100) / 100;
    }

}
