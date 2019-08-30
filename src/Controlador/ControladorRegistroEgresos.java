/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Egreso;
import Vista.PantallaMenuGerente;
import Vista.PantallaRegistroEgreso;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 *
 * @author Jose_Morales
 */
public class ControladorRegistroEgresos {

    PantallaRegistroEgreso pantallaEgreso;
    Egreso egreso;
    //Hacemos uso de la clase Calendar
    Calendar c = Calendar.getInstance();
    //Extraemos la fecha actual
    String diaActual = Integer.toString(c.get(Calendar.DATE));
    String mesActual = Integer.toString(c.get(Calendar.MONTH) + 1);
    String añoActual = Integer.toString(c.get(Calendar.YEAR));
    String tipo;
    String descripcion;
    String fecha;
    String sustento;
    String total;

    public ControladorRegistroEgresos(PantallaMenuGerente pantallaPrincipal, PantallaRegistroEgreso pantallaEgreso, Egreso egreso) {
        this.pantallaEgreso = pantallaEgreso;
        this.egreso = egreso;

        llenarCombos();
        //pantallaEgreso.BtnRegistraEgreso.setEnabled(false);
        pantallaEgreso.TxtDescripción.setEnabled(false);

        this.pantallaEgreso.BtnRegistraEgreso.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tipo = pantallaEgreso.CbxTipoEgreso.getSelectedItem().toString();
                descripcion = pantallaEgreso.TxtDescripción.getText();
                fecha = pantallaEgreso.CbxAñoEgreso.getSelectedItem().toString() + "-" + pantallaEgreso.CbxMesEgreso.getSelectedItem().toString() + "-" + pantallaEgreso.CbxDiaEgreso.getSelectedItem().toString();
                sustento = pantallaEgreso.CbxSustentoEgreso.getSelectedItem().toString();
                total = pantallaEgreso.TxtTotalEgreso.getText();

                if (validarDatos(tipo, descripcion, fecha, total)) {
                    pantallaEgreso.Dialogo.setVisible(true);
                    pantallaEgreso.Dialogo.setLocationRelativeTo(null);
                }
            }
        });

        this.pantallaEgreso.CbxTipoEgreso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (pantallaEgreso.CbxTipoEgreso.getSelectedItem().toString().equals("Otro")) {
                    pantallaEgreso.TxtDescripción.setEnabled(true);
                } else {
                    pantallaEgreso.TxtDescripción.setText("");
                    pantallaEgreso.TxtDescripción.setEnabled(false);
                }
            }
        });

        this.pantallaEgreso.btnConfirmacionRegistroEgreso.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pantallaEgreso.DialogMensajeEgreso.setVisible(false);
                registra();
                limpiarCapos();
                pantallaEgreso.lblMensajeEgreso.setText("\n        ¡Egreso Registrado exitosamente!");
                pantallaEgreso.Dialogo.setVisible(false);
                pantallaEgreso.DialogMensajeEgreso.setVisible(true);
                pantallaEgreso.DialogMensajeEgreso.setLocationRelativeTo(null);

            }
        });

        this.pantallaEgreso.btnNoConfirmaciónRegistroEgreso.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pantallaEgreso.Dialogo.setVisible(false);
            }
        });

        this.pantallaEgreso.BtnRegresarEgreso.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pantallaEgreso.dispose();
                pantallaPrincipal.setVisible(true);
            }
        });

        this.pantallaEgreso.btnAceptarEgeso.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pantallaEgreso.DialogMensajeEgreso.setVisible(false);
            }
        });
        this.pantallaEgreso.btnAceptarEgeso1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pantallaEgreso.DialogMensajeEgresoErrores.setVisible(false);
            }
        });

        this.pantallaEgreso.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                pantallaEgreso.dispose();
                pantallaPrincipal.setVisible(true);
            }
        });
    }

    private void registra() {
        egreso = new Egreso(tipo, descripcion, fecha, sustento, Double.parseDouble(total));
        egreso.registrarEgreso();
    }

    private void limpiarCapos() {
        pantallaEgreso.TxtDescripción.setText("");
        pantallaEgreso.TxtTotalEgreso.setText("");
        pantallaEgreso.CbxTipoEgreso.setSelectedIndex(0);
        pantallaEgreso.CbxSustentoEgreso.setSelectedIndex(0);
        pantallaEgreso.TxtDescripción.setEnabled(false);
        llenarCombos();
    }

    private void llenarCombos() {
        //Removemos contenido de los items
        pantallaEgreso.CbxDiaEgreso.removeAllItems();
        pantallaEgreso.CbxMesEgreso.removeAllItems();
        pantallaEgreso.CbxAñoEgreso.removeAllItems();

        //Obtenemos núemro maximo de días del mes actual
        int dias = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        //llenamos los combos de acuerdo al núemro de dias del mes actual
        for (int i = 1; i <= dias; i++) {
            if (i <= 12) {//Para llenar el combo mes solo hasta 12
                pantallaEgreso.CbxMesEgreso.addItem(String.valueOf(i));
            }
            pantallaEgreso.CbxDiaEgreso.addItem(String.valueOf(i));
        }
        //Ponemos los combos en el item por defecto correspondiente a la fecha actual
        pantallaEgreso.CbxDiaEgreso.setSelectedIndex(Integer.parseInt(diaActual) - 1);
        pantallaEgreso.CbxMesEgreso.setSelectedIndex(Integer.parseInt(mesActual) - 1);
        pantallaEgreso.CbxAñoEgreso.addItem(añoActual);

    }

    public boolean validarDatos(String tipo, String descripcion, String fecha, String total) {
        String txtErrores = "  Verficar datos del Egreso\n";
        boolean errores = false;

        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        formatoFecha.setLenient(false);

        if (tipo.equals("Otro")) {
            if (!(descripcion.length() <= 45)) {
                txtErrores += "    -Verificar descripción [45] caracteres\n";
                errores = true;
            }
            if (!descripcion.matches("[a-zA-Z]+([ ]*[a-zA-Z]+)+")) {
                txtErrores += "    -Descripción invalida\n";
                errores = true;
            }
        }

        try {
            formatoFecha.parse(fecha);
        } catch (ParseException ex) {
            txtErrores += "    -Fecha invalida\n";
            errores = true;
        }

        if (!(total.equals("0.0"))) {
            if (!total.matches("([1-9])[0-9]+(([.])([0-9]{1,2})?)?")) {
                txtErrores += "    -Monto total invalido";
                errores = true;
            }
        }

        if (errores) {
            pantallaEgreso.lblMensajeErrorEgreso.setText(txtErrores);
            pantallaEgreso.DialogMensajeEgresoErrores.setVisible(true);
            pantallaEgreso.DialogMensajeEgresoErrores.setLocationRelativeTo(null);
            return false;

        }
        return true;
    }

}
