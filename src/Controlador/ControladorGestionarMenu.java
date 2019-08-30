/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Conexion;
import Modelo.Empleado;
import Modelo.Menu;
import Vista.PantallaGestionarMenu;
import Vista.PantallaMenuGerente;
import Vista.PantallaMenuMesero;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Fer Julián
 */
public class ControladorGestionarMenu {

    PantallaGestionarMenu pantallaGestionarMenu;
    Menu gestionarMenu;

    public ControladorGestionarMenu(PantallaMenuGerente pantallaPrincipal, PantallaGestionarMenu pantallaGestionarMenu, Menu gestionarMenu) {
        this.pantallaGestionarMenu = pantallaGestionarMenu;
        this.gestionarMenu = gestionarMenu;
        
        
        
//------------------------------------------Buscar por codigo------------------------------------------
        this.pantallaGestionarMenu.BtnBuscarCodigoMenu.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    String codigo_menu = pantallaGestionarMenu.TxtCodigoMenu.getText();
                    
                    Menu menu = gestionarMenu.BuscarPorCodigoMenu(codigo_menu);
                    pantallaGestionarMenu.BtnRegistrarMenu.setEnabled(false);
                    pantallaGestionarMenu.BtnEliminarMenu.setEnabled(true);
                    pantallaGestionarMenu.BtnActualizarMenu.setEnabled(true);
                    pantallaGestionarMenu.TxtNombreMenu.setEditable(false);
                    pantallaGestionarMenu.CbxTipo.setEnabled(false);

                    if (!menu.getNombre().equals("")) {
                        visualizarDatos(menu);
                    } else if (codigo_menu.equals("")) {
                        limpiarCampos();
                        pantallaGestionarMenu.LbllMensajeError.setText("El campo del código menú esta vacio");
                        pantallaGestionarMenu.TxtNombreMenu.setEditable(true);
                        pantallaGestionarMenu.CbxTipo.setEnabled(true);
                        pantallaGestionarMenu.BtnEliminarMenu.setEnabled(false);
                        pantallaGestionarMenu.DialogoMensajeError.setLocationRelativeTo(null);
                        pantallaGestionarMenu.DialogoMensajeError.setVisible(true);

                    } else {
                        limpiarCampos();
                        pantallaGestionarMenu.TxtNombreMenu.setEditable(true);
                        pantallaGestionarMenu.CbxTipo.setEnabled(true);
                        pantallaGestionarMenu.LbllMensajeError.setText("El código del menú no fue encontrado");
                        pantallaGestionarMenu.DialogoMensajeError.setLocationRelativeTo(null);
                        pantallaGestionarMenu.DialogoMensajeError.setVisible(true);

                        pantallaGestionarMenu.BtnEliminarMenu.setEnabled(false);
                        pantallaGestionarMenu.BtnActualizarMenu.setEnabled(false);
                    }

                } catch (Exception ex) {
                    pantallaGestionarMenu.LbllMensajeError.setText("El código del menú no fue encontrado");
                    pantallaGestionarMenu.DialogoMensajeError.setLocationRelativeTo(null);
                    pantallaGestionarMenu.DialogoMensajeError.setVisible(true);

                }

            }
        });

        this.pantallaGestionarMenu.BtnAceptarMensaje1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pantallaGestionarMenu.DialogoMensajeError.dispose();
            }
        });
        
        this.pantallaGestionarMenu.BtnAceptarMensaje1.addKeyListener(new KeyAdapter() {
            
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    pantallaGestionarMenu.DialogoMensajeError.setVisible(false);
                }
            }
        });

//-------------------------------------Registrar-----------------------------------------
        this.pantallaGestionarMenu.BtnRegistrarMenu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if (pantallaGestionarMenu.BtnActualizarMenu.isEnabled() && pantallaGestionarMenu.BtnEliminarMenu.isEnabled()) {
                    pantallaGestionarMenu.DialogoErrores.dispose();
                } else {
                    String codigo_menu = pantallaGestionarMenu.TxtCodigoMenu.getText();
                    String tipo = pantallaGestionarMenu.CbxTipo.getSelectedItem().toString();
                    String nombre = pantallaGestionarMenu.TxtNombreMenu.getText();
                    String precio = (pantallaGestionarMenu.TxtPrecioMenu.getText());

                    verificarCampos();
                    if (pantallaGestionarMenu.BtnRegistrarMenu.isEnabled()) {
                        if (validarRegistroMenu(codigo_menu, tipo, nombre, precio)) {
                            pantallaGestionarMenu.DialogoRegistrar.setLocationRelativeTo(null);
                            pantallaGestionarMenu.DialogoRegistrar.setVisible(true);
                            
                        }
                    } else {
                        pantallaGestionarMenu.DialogoRegistrar.dispose();
                    }
                }
            }

        });

        this.pantallaGestionarMenu.jBtsi.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pantallaGestionarMenu.DialogoMensajeExito.setVisible(false);
                String codigo_menu = pantallaGestionarMenu.TxtCodigoMenu.getText();
                String tipo = pantallaGestionarMenu.CbxTipo.getSelectedItem().toString();
                String nombre = pantallaGestionarMenu.TxtNombreMenu.getText();
                String precio = pantallaGestionarMenu.TxtPrecioMenu.getText();
                // pantallaGestionarMenu.DialogoErrores.setLocationRelativeTo(null);
                //pantallaGestionarMenu.DialogoErrores.setVisible(true);
                int status = 1;

                gestionarMenu.insertarMenu(codigo_menu, tipo, nombre, Double.parseDouble(precio), status);
                pantallaGestionarMenu.LbllMensajeConfirmacion.setText("El producto se ha registrado con éxito");

                pantallaGestionarMenu.DialogoMensajeExito.setLocationRelativeTo(null);
                pantallaGestionarMenu.DialogoMensajeExito.setVisible(true);

                pantallaGestionarMenu.DialogoErrores.dispose();
                pantallaGestionarMenu.DialogoRegistrar.dispose();
                limpiarCampos();
                pantallaGestionarMenu.BtnRegistrarMenu.setEnabled(false);
            }
        });
        this.pantallaGestionarMenu.jBtno.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pantallaGestionarMenu.DialogoRegistrar.dispose();
            }
        });

//--------------------------------Actualizar------------------------------------------
        this.pantallaGestionarMenu.BtnActualizarMenu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                verificarCampos();
                if (pantallaGestionarMenu.BtnActualizarMenu.isEnabled()) {
                    String codigo_menu = pantallaGestionarMenu.TxtCodigoMenu.getText();
                    String tipo = pantallaGestionarMenu.CbxTipo.getSelectedItem().toString();
                    String nombre = pantallaGestionarMenu.TxtNombreMenu.getText();
                    String precio = pantallaGestionarMenu.TxtPrecioMenu.getText();

                    if (validaActualizacionMenu(codigo_menu, tipo, nombre, precio)) {
                        pantallaGestionarMenu.DialogoActualizar.setLocationRelativeTo(null);
                        pantallaGestionarMenu.DialogoActualizar.setVisible(true);

                    }
                } else {
                    pantallaGestionarMenu.DialogoActualizar.dispose();
                }
            }
        });

        this.pantallaGestionarMenu.jBtnActualizarsi.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                String codigo_menu = pantallaGestionarMenu.TxtCodigoMenu.getText();
                String tipo = pantallaGestionarMenu.CbxTipo.getSelectedItem().toString();
                String nombre = pantallaGestionarMenu.TxtNombreMenu.getText();
                String precio = pantallaGestionarMenu.TxtPrecioMenu.getText();
                //pantallaGestionarMenu.DialogoErrores.setLocationRelativeTo(null);
                //pantallaGestionarMenu.DialogoErrores.setVisible(true);
                int status = 1;

                gestionarMenu.ModificarMenu(codigo_menu, tipo, nombre, Double.parseDouble(precio), status);
                pantallaGestionarMenu.LbllMensajeConfirmacion.setText("El registro se ha actualizado con éxito");
                pantallaGestionarMenu.DialogoMensajeExito.setLocationRelativeTo(null);
                pantallaGestionarMenu.DialogoMensajeExito.setVisible(true);

                pantallaGestionarMenu.DialogoActualizar.dispose();
                pantallaGestionarMenu.DialogoErrores.dispose();
                limpiarCampos();
            }
        });

        this.pantallaGestionarMenu.jBtnActualizarno.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pantallaGestionarMenu.BtnRegistrarMenu.setEnabled(false);
                pantallaGestionarMenu.DialogoActualizar.dispose();

            }
        });
//----------------------------------ELIMINAR------------------------------------------------------
        this.pantallaGestionarMenu.BtnEliminarMenu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (pantallaGestionarMenu.BtnEliminarMenu.isEnabled()) {
                    pantallaGestionarMenu.DialogoEliminar.setLocationRelativeTo(null);
                    pantallaGestionarMenu.DialogoEliminar.setVisible(true);

                } else {
                    pantallaGestionarMenu.DialogoEliminar.dispose();
                }
            }
        });

        this.pantallaGestionarMenu.jBtnEliminarsi.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String codigo_menu = pantallaGestionarMenu.TxtCodigoMenu.getText();
                int status = 0;
                gestionarMenu.EliminarMenu(codigo_menu, status);
                limpiarCampos();

                pantallaGestionarMenu.LbllMensajeConfirmacion.setText("El registro se ha eliminado con éxito");
                pantallaGestionarMenu.DialogoMensajeExito.setLocationRelativeTo(null);
                pantallaGestionarMenu.DialogoMensajeExito.setVisible(true);

                pantallaGestionarMenu.DialogoEliminar.dispose();
            }
        });

        this.pantallaGestionarMenu.jBtnEliminarno.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pantallaGestionarMenu.DialogoEliminar.dispose();
            }
        });

        this.pantallaGestionarMenu.BtnAceptarErroresMenu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pantallaGestionarMenu.DialogoErrores.dispose();

            }
        });
        
        this.pantallaGestionarMenu.BtnAceptarErroresMenu.addKeyListener(new KeyAdapter() {
            
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    pantallaGestionarMenu.DialogoErrores.setVisible(false);
                }
            }
        });

//--------------------------otros botones-------------------------------------------------------------        
        this.pantallaGestionarMenu.BtnAceptarMensaje.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pantallaGestionarMenu.DialogoMensajeExito.dispose();
            }
        });
        
        this.pantallaGestionarMenu.BtnAceptarMensaje.addKeyListener(new KeyAdapter() {
            
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    pantallaGestionarMenu.DialogoMensajeExito.setVisible(false);
                }
            }
        });

        this.pantallaGestionarMenu.BtnRegresarMenu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pantallaGestionarMenu.dispose();
                pantallaPrincipal.setVisible(true);
            }
        });
        //-----------------------------teclas-----------------------------------------------
        this.pantallaGestionarMenu.TxtCodigoMenu.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {

                pantallaGestionarMenu.TxtNombreMenu.setText("");
                pantallaGestionarMenu.TxtPrecioMenu.setText("");
                pantallaGestionarMenu.BtnActualizarMenu.setEnabled(false);
                pantallaGestionarMenu.BtnEliminarMenu.setEnabled(false);
                pantallaGestionarMenu.BtnRegistrarMenu.setEnabled(true);
                pantallaGestionarMenu.TxtNombreMenu.setEditable(true);
                pantallaGestionarMenu.CbxTipo.setEnabled(true);
            }
        });
        this.pantallaGestionarMenu.TxtNombreMenu.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {
                pantallaGestionarMenu.BtnRegistrarMenu.setEnabled(true);
            }
        });

        this.pantallaGestionarMenu.TxtPrecioMenu.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {
                if (pantallaGestionarMenu.BtnRegistrarMenu.isEnabled()){
                pantallaGestionarMenu.BtnActualizarMenu.setEnabled(false);
                 } else {
                    pantallaGestionarMenu.BtnActualizarMenu.setEnabled(true);
                }
            }
        });
        this.pantallaGestionarMenu.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                pantallaGestionarMenu.dispose();
                pantallaPrincipal.setVisible(true);
            }
        });

    }

//----------------------------- Métodos-------------------------------------------------
    public boolean verificarCampos() {
        boolean errores = false;

        String codigo_menu = pantallaGestionarMenu.TxtCodigoMenu.getText();
        String tipo = pantallaGestionarMenu.CbxTipo.getSelectedItem().toString();
        String nombre = pantallaGestionarMenu.TxtNombreMenu.getText();
        String precio_unitario = pantallaGestionarMenu.TxtPrecioMenu.getText();

        if (codigo_menu.equals("") | tipo.equals("") | nombre.equals("") | precio_unitario.equals("")) {
            errores = true;
            pantallaGestionarMenu.BtnRegistrarMenu.setEnabled(false);
            pantallaGestionarMenu.BtnActualizarMenu.setEnabled(false);
            pantallaGestionarMenu.DialogoRegistrar.setVisible(false);
        }
//        else {
//            pantallaGestionarMenu.BtnRegistrarMenu.setEnabled(true);
////            pantallaGestionarMenu.BtnActualizarMenu.setEnabled(true);
//        }

        if (errores) {
            pantallaGestionarMenu.LbllMensajeError.setText(" Existen campos que estan vacios");
            pantallaGestionarMenu.DialogoMensajeError.setVisible(true);
            pantallaGestionarMenu.DialogoMensajeError.setLocationRelativeTo(null);
            return false;
        }
        return true;
    }

    public static boolean existeEnElMenu(String codigo_menu) {
        Connection cn;
        Conexion con = new Conexion("localhost", "cafezito", "root", "qpmz.2404");
        cn = con.getConnection();
        try {
            PreparedStatement pps = cn.prepareStatement("SELECT codigo_menu FROM menu WHERE codigo_menu = ?");
            pps.setString(1, codigo_menu);
            ResultSet rs = pps.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {

        }
        return false;
    }

    public boolean validarRegistroMenu(String codigo_menu, String tipo, String nombre, String precio_unitario) {

        String txtErrores = "";
        boolean errores = false;

        if (existeEnElMenu(codigo_menu)) {
            txtErrores += "\nEl codigo del menú ya existe";
            errores = true;
        }

        if (!codigo_menu.equals("")) {
            if (!(codigo_menu.length() <= 10)) {
                txtErrores += "\nCódigo de menú invalido [10] caracteres";
                errores = true;
            }
            if (!codigo_menu.matches("[a-zA-Z0-9]+")) {
                txtErrores += "\nCódigo invalido";
                errores = true;
            }
        }

        if (!tipo.equals("")) {
            if (!(tipo.length() <= 20)) {
                txtErrores += "\nTipo de menú invalido [20] caracteres";
                errores = true;
            }
            if (!tipo.matches("[a-zA-Z]+([ ]*[a-zA-Z]+)+")) {
                txtErrores += "\nTipo invalido";
                errores = true;
            }
        }

        if (!nombre.equals("")) {
            if (!(nombre.length() <= 20)) {
                txtErrores += "\nNombre de menú invalido [20] caracteres";
                errores = true;
            }
            if (!nombre.matches("[a-zA-Z]+([ ]*[a-zA-Z]+)+")) {
                txtErrores += "\nNombre invalido";
                errores = true;
            }
        }
        if (!(precio_unitario.equals("0.0"))) {
            if (!precio_unitario.matches("([1-9])[0-9]+(([.])([0-9]{1,2})?)?")) {
                txtErrores += "\nPrecio invalido";
                errores = true;
            }
        }

        if (errores) {

            pantallaGestionarMenu.jLblErroresMenu.setText(txtErrores);
            pantallaGestionarMenu.DialogoErrores.setVisible(true);
            pantallaGestionarMenu.DialogoErrores.setLocationRelativeTo(null);
            return false;
        }
        return true;
    }

    public boolean validaActualizacionMenu(String codigo_menu, String tipo, String nombre, String precio_unitario) {

        String txtErrores = "";
        boolean errores = false;

        if (!(precio_unitario.equals("0.0"))) {
            if (!precio_unitario.matches("([1-9])[0-9]+(([.])([0-9]{1,2})?)?")) {
                txtErrores += "\nPrecio invalido";
                errores = true;
            }
        }

        if (errores) {

            pantallaGestionarMenu.jLblErroresMenu.setText(txtErrores);
            pantallaGestionarMenu.DialogoErrores.setVisible(true);
            pantallaGestionarMenu.DialogoErrores.setLocationRelativeTo(null);
            return false;
        }
        return true;
    }

    public void visualizarDatos(Menu objMenu) {

        pantallaGestionarMenu.TxtNombreMenu.setText(objMenu.getNombre());
        pantallaGestionarMenu.TxtPrecioMenu.setText(String.valueOf(objMenu.getPrecio_unitario()));
    }

    private void limpiarCampos() {
        pantallaGestionarMenu.TxtCodigoMenu.setText("");
        pantallaGestionarMenu.TxtNombreMenu.setText("");
        pantallaGestionarMenu.TxtPrecioMenu.setText("");
    }

}
