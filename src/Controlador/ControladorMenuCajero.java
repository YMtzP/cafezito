/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Egreso;
import Modelo.Empleado;
import Modelo.Login;
import Vista.PantallaMenuCajero;
import Vista.PantallaCobrarOrden;
import Vista.PantallaCorteDeCaja;
import Modelo.TomarOrden;
import Vista.PantallaLogin;
import Vista.PantallaMenuGerente;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Jose_Morales
 */
public class ControladorMenuCajero {

    PantallaMenuCajero pantallaMenuCajero;
    TomarOrden orden;
    boolean cerrar;

    public ControladorMenuCajero(PantallaMenuCajero menuCajero) {
        this.pantallaMenuCajero = menuCajero;
        orden = new TomarOrden();
        
        this.pantallaMenuCajero.btnOpcioncobrarOrden.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                menuCajero.dispose();
                PantallaCobrarOrden pantallaOrden = new PantallaCobrarOrden();
                ControladorCobrarOrden cCobrarORden = new ControladorCobrarOrden(pantallaOrden, orden);
                pantallaOrden.setLocationRelativeTo(null);
                pantallaOrden.setVisible(true);
            }
        });

        this.pantallaMenuCajero.btnOpcionCorteCaja.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                menuCajero.dispose();
                Egreso egreso = new Egreso();
                PantallaCorteDeCaja pantallaCorteCaja = new PantallaCorteDeCaja();
                ControladorCorteDeCaja c = new ControladorCorteDeCaja(pantallaCorteCaja, egreso, orden);
                pantallaCorteCaja.setLocationRelativeTo(null);
                pantallaCorteCaja.setVisible(true);
            }
        });

        this.pantallaMenuCajero.btnCerrarSesion.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pantallaMenuCajero.DialogoPregunta.setVisible(true);
            }
        });

        pantallaMenuCajero.BtnActualizarsi.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pantallaMenuCajero.dispose();
                pantallaMenuCajero.DialogoPregunta.setVisible(false);
                PantallaLogin pantallaLogin = new PantallaLogin();
                Login login = new Login();
                ControladorLogin controladorLogin = new ControladorLogin(pantallaLogin, login);
                pantallaLogin.setLocationRelativeTo(null);
                pantallaLogin.setVisible(true);

            }
        });

        pantallaMenuCajero.BtnActualizarno.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pantallaMenuCajero.DialogoPregunta.setVisible(false);
                if (cerrar) {
                    PantallaMenuCajero p = new PantallaMenuCajero();
                    ControladorMenuCajero menu = new ControladorMenuCajero(p);
                    p.setVisible(true);
                }
            }
        });

        pantallaMenuCajero.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                cerrar = true;
                pantallaMenuCajero.DialogoPregunta.setVisible(true);
            }
        });

    }

}
