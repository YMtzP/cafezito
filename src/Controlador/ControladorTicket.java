/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.text.SimpleDateFormat;
import java.util.Date;
import Vista.PantallaCobrarOrden;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 *
 * @author Jose_Morales
 */
public class ControladorTicket {

    Date date = new Date();
    SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat hora = new SimpleDateFormat("hh:mm:ss aa");
    PantallaCobrarOrden pantalla;

    public ControladorTicket(PantallaCobrarOrden pantalla, ArrayList<Object> listaProductos, String numTicket, double total, String importe, double cambio) {
        this.pantalla = pantalla;
        JTextArea ticket = pantalla.hojaTicket;
        
        ticket.setText("");
        Font font = new Font("Verdana", Font.BOLD, 13);
        ticket.setFont(font);
        ticket.setLineWrap(true);
        ticket.setWrapStyleWord(true);
        ticket.append("\n\tCAFE-ZITO\n\n");
        ticket.append("AV. LIC. BENITO JUÁREZ NO. 1-D ESQ. CON MORELOS"
                + " COL. CENTRO C.P. 39000 CHILPANCINGO DE LOS BRAVO,"
                + " GUERRERO, MÉXICO. ");
        ticket.append("TEL: 4726313\n");
        ticket.append("  R.F.C.: PUGJ670323H42\n\n");
        ticket.append("\tTICKET NO.: " + numTicket + "\n\n");
        ticket.append("FECHA: " + fecha.format(date) + "    HORA: " + hora.format(date) + "\n\n");
        ticket.append("\nDESCRIPCIÓN \t  CATIDAD \t P.UNITARIO");
        Object[] obj;
        for (Iterator<Object> iterator = listaProductos.iterator(); iterator.hasNext();) {
            obj = (Object[]) iterator.next();
            String descripcion = (String) obj[0];
            for (int i = descripcion.length(); i <= 24; i++) {
                descripcion += " ";
            }
            ticket.append("\n" + descripcion + " " + obj[1] + "             " + obj[2]);
        }
        ticket.append("\n");
        ticket.append("\n\tTOTAL: $" + total);
        ticket.append("\n\tRECIBIDO: $" + importe);
        ticket.append("\n\tCAMBIO: $" + cambio);

        ticket.append("\n\n       ¡GRACIAS POR SU PREFERENCIA!");
        try {
            ticket.print();
        } catch (PrinterException ex) {
            Logger.getLogger(ControladorTicket.class.getName()).log(Level.SEVERE, null, ex);
        }
        pantalla.vistaTicket.pack();
        pantalla.vistaTicket.setLocationRelativeTo(null);
        pantalla.vistaTicket.setVisible(true);

    }

}
