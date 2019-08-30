/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Egreso;
import Modelo.Empleado;
import Modelo.Login;
import Modelo.Menu;
import Vista.PantallaGestionarMenu;
import Vista.PantallaLogin;
import Vista.PantallaMenuGerente;
import Vista.PantallaModificarEmpleado;
import Vista.PantallaRegistrarEmpleado;
import Vista.PantallaRegistroEgreso;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author YareMtz
 */
public class ControladorMenuGerente {

    PantallaMenuGerente pantallaGerente;
    Empleado empleado;
    boolean cerrar;
    //boolean cerrar;

    public ControladorMenuGerente(PantallaMenuGerente pantallaMenuGerente, Empleado empleado) {
        this.pantallaGerente = pantallaMenuGerente;
        this.empleado = empleado;
        
        
        pantallaGerente.BtnActualizarsi.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                pantallaGerente.dispose();
                pantallaGerente.DialogoPregunta.setVisible(false);
                PantallaLogin pantallaLogin = new PantallaLogin();
                Login login = new Login();
                ControladorLogin controladorLogin = new ControladorLogin(pantallaLogin, login);
                pantallaLogin.setLocationRelativeTo(null);
                pantallaLogin.setVisible(true);
            }
        });

        pantallaGerente.BtnRegistrarEmpleado.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                PantallaRegistrarEmpleado pantallaRegistrarEmpleado = new PantallaRegistrarEmpleado();
                ControladorRegistrarEmpleado controladorRegistrarEmpleado = new ControladorRegistrarEmpleado(pantallaMenuGerente, pantallaRegistrarEmpleado, empleado);

                for (int i = 0; i <= 38; i++) {
                    pantallaRegistrarEmpleado.CbxAñoEmpleado.insertItemAt(1960 + i + "", i);
                }

                for (int i = 0; i < 31; i++) {
                    pantallaRegistrarEmpleado.CbxDiaNacimientoEmpleado.insertItemAt(i + 1 + "", i);
                }

                pantallaRegistrarEmpleado.CbxDiaNacimientoEmpleado.setSelectedIndex(0);
                pantallaRegistrarEmpleado.CbxAñoEmpleado.setSelectedIndex(0);
                pantallaRegistrarEmpleado.BtnRegistrarEmpleado.setEnabled(false);
                int id = empleado.id_login() + 1;
                pantallaRegistrarEmpleado.LblCodigoEmpleadoReg.setText(id + "");
                pantallaGerente.setVisible(false);
                pantallaRegistrarEmpleado.setLocationRelativeTo(null);
                pantallaRegistrarEmpleado.setVisible(true);
                
            }
        });

        pantallaGerente.BtnModificarEmpleado.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                PantallaModificarEmpleado pantallaModificarEmpleado = new PantallaModificarEmpleado();
                ControladorModificarEmpleado controladorModificarEmpleado = new ControladorModificarEmpleado(pantallaGerente,pantallaModificarEmpleado);
                pantallaModificarEmpleado.BtnBuscarModificar.setEnabled(false);
                pantallaModificarEmpleado.BtnModificarEmpleado.setEnabled(false);
                pantallaGerente.setVisible(false);
                pantallaModificarEmpleado.setLocationRelativeTo(null);
                pantallaModificarEmpleado.setVisible(true);
            }
        });

        pantallaGerente.BtnGestionarMenu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                PantallaGestionarMenu pantallaGestionarMenu = new PantallaGestionarMenu();
                Menu menu = new Menu();
                ControladorGestionarMenu controladorGestionarMenu = new ControladorGestionarMenu(pantallaGerente,pantallaGestionarMenu, menu);
                pantallaGerente.setVisible(false);
                pantallaGestionarMenu.setLocationRelativeTo(null);
                pantallaGestionarMenu.setVisible(true);
            }

        });

        pantallaGerente.BtnRegistroEgresos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                PantallaRegistroEgreso pantalla = new PantallaRegistroEgreso();
                Egreso egreso = new Egreso();
                ControladorRegistroEgresos controlador = new ControladorRegistroEgresos(pantallaGerente, pantalla, egreso);
                pantallaGerente.setVisible(false);
                pantalla.setLocationRelativeTo(null);
                pantalla.setVisible(true);
            }

        });

        pantallaGerente.BtnCerrarSesionGestEmpleado.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pantallaGerente.DialogoPregunta.setVisible(true);
            }

        });

        pantallaGerente.BtnActualizarsi.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pantallaGerente.dispose();
                pantallaGerente.DialogoPregunta.setVisible(false);
                PantallaLogin pantallaLogin = new PantallaLogin();
                Login login = new Login();
                ControladorLogin controladorLogin = new ControladorLogin(pantallaLogin, login);
                pantallaLogin.setLocationRelativeTo(null);
                pantallaLogin.setVisible(true);

            }
        });

        pantallaGerente.BtnActualizarno.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pantallaGerente.DialogoPregunta.setVisible(false);
                if (cerrar) {
                    PantallaMenuGerente pantallaGerente = new PantallaMenuGerente();
                    Empleado empleado = new Empleado();
                    ControladorMenuGerente controladorMenuGerente = new ControladorMenuGerente(pantallaGerente, empleado);
                    pantallaGerente.setLocationRelativeTo(null);
                    pantallaGerente.setVisible(true);
                }
            }
        });

        pantallaGerente.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                cerrar = true;
                pantallaGerente.DialogoPregunta.setVisible(true);
            }
        });

    }

    public void limpiarTabla(JTable tabla) {
        try {
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            int filas = tabla.getRowCount();
            for (int i = 0; filas > i; i++) {
                modelo.removeRow(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
        }
    }

}
