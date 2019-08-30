/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Login;
import Modelo.ModificarOrden;
import Modelo.TomarOrden;
import Vista.PantallaLogin;
import Vista.PantallaMenuMesero;
import Vista.PantallaTomarOrden;
import Vista.PantallaModificarOrden;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

/**
 *
 * @author Alexis Salvador
 */
public class ControladorMenuMesero {

    PantallaMenuMesero pantallaMesero;
    TomarOrden tomarOrden;
    ModificarOrden modificarOrden;
    boolean cerrar;

    public ControladorMenuMesero(PantallaMenuMesero pantallaMenuMesero, TomarOrden orden, ModificarOrden modOrden, String usuario) {
        this.pantallaMesero = pantallaMenuMesero;
        this.tomarOrden = orden;
        this.modificarOrden = modOrden;

        pantallaMesero.BtnTomarOrden.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                PantallaTomarOrden pantallaTomarOrden = new PantallaTomarOrden();
                ArrayList bebidas = tomarOrden.obtenerListaNombres("Bebida");
                ArrayList platilos = tomarOrden.obtenerListaNombres("Platillo");
                ArrayList postres = tomarOrden.obtenerListaNombres("Postre");

                pantallaTomarOrden.CbxBebida.removeAllItems();
                pantallaTomarOrden.CbxPlatillo.removeAllItems();
                pantallaTomarOrden.CbxPostre.removeAllItems();

                pantallaTomarOrden.CbxNumeroDeMesa.removeAllItems();
                ArrayList listaMesas = orden.obtenerListaMesasDispobinles("Disponible");

                for (int i = 0; i < bebidas.size(); i++) {
                    pantallaTomarOrden.CbxBebida.addItem(bebidas.get(i).toString());
                }

                for (int i = 0; i < postres.size(); i++) {
                    pantallaTomarOrden.CbxPostre.addItem(postres.get(i).toString());
                }

                for (int i = 0; i < platilos.size(); i++) {
                    pantallaTomarOrden.CbxPlatillo.addItem(platilos.get(i).toString());
                }

                for (int i = 0; i < listaMesas.size(); i++) {
                    pantallaTomarOrden.CbxNumeroDeMesa.addItem(listaMesas.get(i).toString());
                }

                pantallaTomarOrden.LblNumOrden.setText("Número Orden: " + (orden.obtenerNumeroOrden() + 1));

                ControladorTomarOrden controladorTomarOrden = new ControladorTomarOrden(pantallaMesero, pantallaTomarOrden, orden, usuario);
                pantallaTomarOrden.setLocationRelativeTo(null);
                pantallaMesero.setVisible(false);
                pantallaTomarOrden.setVisible(true);
            }
        });

        pantallaMesero.BtnModificarOrden.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                PantallaModificarOrden pantallaModificarOrden = new PantallaModificarOrden();
                ControladorModificarOrden controladorModificarOrden = new ControladorModificarOrden(pantallaMesero, pantallaModificarOrden, modOrden);

                pantallaModificarOrden.CbxNumeroMesaModOrden.removeAllItems();
                ArrayList listaMesas = modOrden.obtenerListaMesasOcupadas("Ocupada");
                for (int i = 0; i < listaMesas.size(); i++) {
                    pantallaModificarOrden.CbxNumeroMesaModOrden.addItem(listaMesas.get(i).toString());
                }
                pantallaModificarOrden.setLocationRelativeTo(null);
                pantallaMesero.setVisible(false);
                pantallaModificarOrden.setVisible(true);

            }
        });

        pantallaMesero.BtnCerrarSesion.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pantallaMesero.DialogoPregunta.setVisible(true);
                
            }
        });

        pantallaMesero.BtnActualizarno.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pantallaMesero.DialogoPregunta.setVisible(false);
                if (cerrar) {
                    PantallaMenuMesero pantallaMesero = new PantallaMenuMesero();
                    TomarOrden orden = new TomarOrden();
                    ModificarOrden modOrden = new ModificarOrden();
                    ControladorMenuMesero controladorMenuMesero = new ControladorMenuMesero(pantallaMesero, orden, modOrden, usuario);
                    pantallaMesero.setLocationRelativeTo(null);
                    pantallaMesero.setVisible(true);
                }

            }
        });

        pantallaMesero.BtnActualizarsi.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pantallaMesero.dispose();
                pantallaMesero.DialogoPregunta.setVisible(false);
                PantallaLogin pantallaLogin = new PantallaLogin();
                Login login = new Login();
                ControladorLogin controladorLogin = new ControladorLogin(pantallaLogin, login);
                pantallaLogin.setLocationRelativeTo(null);
                pantallaLogin.setVisible(true);
            }
        });

        //CerrarLaVentana
        pantallaMesero.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                cerrar = true;
                pantallaMesero.DialogoPregunta.setVisible(true);
            }
        });

    }
}
