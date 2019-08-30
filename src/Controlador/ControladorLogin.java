/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.*;
import Vista.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Alexis Salvador
 */
public class ControladorLogin {

    PantallaLogin pantallaLogin;
    Login login;
    //Connection con;

    public ControladorLogin(PantallaLogin pantallaLogin, Login login) {
        this.pantallaLogin = pantallaLogin;
        this.login = login;

        pantallaLogin.BtnIniciarSesion.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                inicioSesion();
            }
        });

        pantallaLogin.TxtUsuario.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    pantallaLogin.TxtContrasenia.requestFocus();
                }
            }
        });

        pantallaLogin.BtnAceptarMensaje.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    iniciaSesionComo();
                }
            }
        });

        pantallaLogin.BtnAceptarMensajeError.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pantallaLogin.DialogoMensajeError.dispose();
            }
        });
        
        pantallaLogin.BtnAceptarMensajeError.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                pantallaLogin.DialogoMensajeError.dispose();
            }
        });

        this.pantallaLogin.TxtContrasenia.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    inicioSesion();
                }
            }

        });

        pantallaLogin.BtnAceptarMensaje.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                iniciaSesionComo();
            }

        });

    }

    public void inicioSesion() {

        String user = pantallaLogin.TxtUsuario.getText();
        String pas = pantallaLogin.TxtContrasenia.getText();
        if (login.verificaNombreUsuario(user, login.listaUsuarios())) {
            if (login.verificarLogin(user, pas)) {
                pantallaLogin.LbllMensajeBienvenido.setText(pantallaLogin.LbllMensajeBienvenido.getText() + user + "!");
                pantallaLogin.DialogoMensajeExito.setLocationRelativeTo(null);
                pantallaLogin.DialogoMensajeExito.setVisible(true);
            } else {
                pantallaLogin.LbllMensajeError.setText("Contraseña incorrecta");
                pantallaLogin.DialogoMensajeError.setLocationRelativeTo(null);
                pantallaLogin.DialogoMensajeError.setVisible(true);
                pantallaLogin.TxtContrasenia.setText("");
            }
        } else {
            pantallaLogin.LbllMensajeError.setText("No se encontró el usuario");
            pantallaLogin.DialogoMensajeError.setLocationRelativeTo(null);
            pantallaLogin.DialogoMensajeError.setVisible(true);
            pantallaLogin.TxtUsuario.setText("");
            pantallaLogin.TxtContrasenia.setText("");
        }
    }

    public void iniciaSesionComo() {
        String user = pantallaLogin.TxtUsuario.getText();
        String pas = pantallaLogin.TxtContrasenia.getText();
        switch (login.tipoUsuario(user).toLowerCase()) {
            case "gerente":
                PantallaMenuGerente pantallaGerente = new PantallaMenuGerente();
                Empleado empleado = new Empleado();
                ControladorMenuGerente controladorMenuGerente = new ControladorMenuGerente(pantallaGerente, empleado);
                pantallaGerente.setLocationRelativeTo(null);
                pantallaGerente.setVisible(true);
                pantallaLogin.setVisible(false);
                pantallaLogin.dispose();
                break;
            case "mesero":
                PantallaMenuMesero pantallaMesero = new PantallaMenuMesero();
                TomarOrden orden = new TomarOrden();
                ModificarOrden modOrden = new ModificarOrden();
                ControladorMenuMesero controladorMenuMesero = new ControladorMenuMesero(pantallaMesero, orden, modOrden, user);
                pantallaMesero.setLocationRelativeTo(null);
                pantallaMesero.setVisible(true);
                pantallaLogin.setVisible(false);
                pantallaLogin.dispose();
                break;
            case "cajero":
                PantallaMenuCajero p = new PantallaMenuCajero();
                ControladorMenuCajero menu = new ControladorMenuCajero(p);
                p.setVisible(true);
                pantallaLogin.setVisible(false);
                pantallaLogin.dispose();
                break;
        }
        pantallaLogin.DialogoMensajeExito.dispose();
        pantallaLogin.LbllMensajeBienvenido.setText("¡Bienvenido ");
        pantallaLogin.setVisible(false);
        pantallaLogin.dispose();
    }

}
