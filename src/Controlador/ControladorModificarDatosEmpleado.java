/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Empleado;
import Modelo.Login;
import Vista.PantallaLogin;
import Vista.PantallaMenuGerente;
import Vista.PantallaModificarDatosEmpleado;
import Vista.PantallaModificarEmpleado;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author YareMtz
 */
public class ControladorModificarDatosEmpleado {

    PantallaModificarDatosEmpleado pantallaModificarDatosEmpleado;
    Empleado empleado;
    Login login;

    public ControladorModificarDatosEmpleado(PantallaModificarEmpleado pantallaPrincipal, PantallaModificarDatosEmpleado pantallaModificarDatosEmpleado, Empleado empleado, Login login) {
        this.pantallaModificarDatosEmpleado = pantallaModificarDatosEmpleado;
        this.empleado = empleado;
        this.login = login;
        int id = Integer.parseInt(pantallaModificarDatosEmpleado.LblCodigoEmpleadoMod.getText());

        this.pantallaModificarDatosEmpleado.CbxMesNacimientoEmpleado.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                pantallaModificarDatosEmpleado.CbxDiaNacimientoEmpleado.removeAllItems();
                if (pantallaModificarDatosEmpleado.CbxMesNacimientoEmpleado.getSelectedIndex() == 3 || pantallaModificarDatosEmpleado.CbxMesNacimientoEmpleado.getSelectedIndex() == 5 || pantallaModificarDatosEmpleado.CbxMesNacimientoEmpleado.getSelectedIndex() == 8 || pantallaModificarDatosEmpleado.CbxMesNacimientoEmpleado.getSelectedIndex() == 10) {
                    for (int i = 0; i < 30; i++) {
                        pantallaModificarDatosEmpleado.CbxDiaNacimientoEmpleado.insertItemAt(i + 1 + "", i);
                    }
                } else if (pantallaModificarDatosEmpleado.CbxMesNacimientoEmpleado.getSelectedIndex() == 0 || pantallaModificarDatosEmpleado.CbxMesNacimientoEmpleado.getSelectedIndex() == 2 || pantallaModificarDatosEmpleado.CbxMesNacimientoEmpleado.getSelectedIndex() == 4 || pantallaModificarDatosEmpleado.CbxMesNacimientoEmpleado.getSelectedIndex() == 6 || pantallaModificarDatosEmpleado.CbxMesNacimientoEmpleado.getSelectedIndex() == 7 || pantallaModificarDatosEmpleado.CbxMesNacimientoEmpleado.getSelectedIndex() == 9 || pantallaModificarDatosEmpleado.CbxMesNacimientoEmpleado.getSelectedIndex() == 11) {
                    for (int i = 0; i < 31; i++) {
                        pantallaModificarDatosEmpleado.CbxDiaNacimientoEmpleado.insertItemAt(i + 1 + "", i);
                    }
                } else {
                    for (int i = 0; i < 29; i++) {
                        pantallaModificarDatosEmpleado.CbxDiaNacimientoEmpleado.insertItemAt(i + 1 + "", i);
                    }
                }
                pantallaModificarDatosEmpleado.CbxDiaNacimientoEmpleado.setSelectedIndex(0);
            }
        });

        this.pantallaModificarDatosEmpleado.CbxStatusMod.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (pantallaModificarDatosEmpleado.CbxStatusMod.getSelectedItem().equals("Inactivo")) {
                    pantallaModificarDatosEmpleado.TxtNombreEmpleado.setEnabled(false);
                    pantallaModificarDatosEmpleado.TxtApellidoPaternoEmpleado.setEnabled(false);
                    pantallaModificarDatosEmpleado.TxtApellidoMaternoEmpleado.setEnabled(false);
                    pantallaModificarDatosEmpleado.TxtCalleEmpleado.setEnabled(false);
                    pantallaModificarDatosEmpleado.TxtCelularEmplado.setEnabled(false);
                    pantallaModificarDatosEmpleado.TxtColoniaEmpleado.setEnabled(false);
                    pantallaModificarDatosEmpleado.TxtContraseñaRepMod.setEnabled(false);
                    pantallaModificarDatosEmpleado.TxtCpDireccionEmpleado.setEnabled(false);
                    pantallaModificarDatosEmpleado.TxtNumeroEmpleado.setEnabled(false);
                    pantallaModificarDatosEmpleado.TxtSueldoEmpleado.setEnabled(false);
                    pantallaModificarDatosEmpleado.TxtTelefonoEmpleado.setEnabled(false);
                    pantallaModificarDatosEmpleado.TxtUsuarioEmpleado.setEnabled(false);
                    pantallaModificarDatosEmpleado.txtContraseñaMod.setEnabled(false);
                    pantallaModificarDatosEmpleado.CbxPuestoEmpleado.setEnabled(false);
                    pantallaModificarDatosEmpleado.CbxDiaNacimientoEmpleado.setEnabled(false);
                    pantallaModificarDatosEmpleado.CbxMesAñoEmpleado.setEnabled(false);
                    pantallaModificarDatosEmpleado.CbxMesNacimientoEmpleado.setEnabled(false);
                } else {
                    pantallaModificarDatosEmpleado.TxtNombreEmpleado.setEnabled(true);
                    pantallaModificarDatosEmpleado.TxtApellidoPaternoEmpleado.setEnabled(true);
                    pantallaModificarDatosEmpleado.TxtApellidoMaternoEmpleado.setEnabled(true);
                    pantallaModificarDatosEmpleado.TxtCalleEmpleado.setEnabled(true);
                    pantallaModificarDatosEmpleado.TxtCelularEmplado.setEnabled(true);
                    pantallaModificarDatosEmpleado.TxtColoniaEmpleado.setEnabled(true);
                    pantallaModificarDatosEmpleado.TxtContraseñaRepMod.setEnabled(true);
                    pantallaModificarDatosEmpleado.TxtCpDireccionEmpleado.setEnabled(true);
                    pantallaModificarDatosEmpleado.TxtNumeroEmpleado.setEnabled(true);
                    pantallaModificarDatosEmpleado.TxtSueldoEmpleado.setEnabled(true);
                    pantallaModificarDatosEmpleado.TxtTelefonoEmpleado.setEnabled(true);
                    pantallaModificarDatosEmpleado.TxtUsuarioEmpleado.setEnabled(true);
                    pantallaModificarDatosEmpleado.txtContraseñaMod.setEnabled(true);
                    pantallaModificarDatosEmpleado.CbxPuestoEmpleado.setEnabled(true);
                    pantallaModificarDatosEmpleado.CbxDiaNacimientoEmpleado.setEnabled(true);
                    pantallaModificarDatosEmpleado.CbxMesAñoEmpleado.setEnabled(true);
                    pantallaModificarDatosEmpleado.CbxMesNacimientoEmpleado.setEnabled(true);
                }

            }
        });

        this.pantallaModificarDatosEmpleado.CbxPuestoEmpleado.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (pantallaModificarDatosEmpleado.CbxPuestoEmpleado.getSelectedItem().toString().equals("Gerente")
                        | pantallaModificarDatosEmpleado.CbxPuestoEmpleado.getSelectedItem().toString().equals("Mesero")
                        | pantallaModificarDatosEmpleado.CbxPuestoEmpleado.getSelectedItem().toString().equals("Cajero")) {
                    pantallaModificarDatosEmpleado.TxtUsuarioEmpleado.setEnabled(true);
                    validarBotonRegistrarLogin();
                    pantallaModificarDatosEmpleado.BtnActualizarEmpleado.setEnabled(validacionEmpleadoLogin());
                } else if (pantallaModificarDatosEmpleado.CbxPuestoEmpleado.getSelectedItem().toString().equals("Cocinero")
                        | pantallaModificarDatosEmpleado.CbxPuestoEmpleado.getSelectedItem().toString().equals("Contador")) {
                    pantallaModificarDatosEmpleado.TxtContraseñaRepMod.setText("");
                    pantallaModificarDatosEmpleado.TxtContraseñaRepMod.setEnabled(false);
                    pantallaModificarDatosEmpleado.txtContraseñaMod.setText("");
                    pantallaModificarDatosEmpleado.txtContraseñaMod.setEnabled(false);
                    pantallaModificarDatosEmpleado.TxtUsuarioEmpleado.setText("");
                    pantallaModificarDatosEmpleado.TxtUsuarioEmpleado.setEnabled(false);
                    validarBotonRegistrar();
//                    pantallaModificarDatosEmpleado.BtnActualizarEmpleado.setEnabled(validacionEmpleado());
                }
            }
        });

        this.pantallaModificarDatosEmpleado.BtnActualizarEmpleado.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Empleado empleado = new Empleado();
                Login login = new Login();
                try {
                    String fecha;
                    //Campos obligatorios
                    String nombre = pantallaModificarDatosEmpleado.TxtNombreEmpleado.getText();
                    String ap_pat = pantallaModificarDatosEmpleado.TxtApellidoPaternoEmpleado.getText();
                    String ap_mat = pantallaModificarDatosEmpleado.TxtApellidoMaternoEmpleado.getText();
                    String celular = pantallaModificarDatosEmpleado.TxtCelularEmplado.getText();
                    String puesto = pantallaModificarDatosEmpleado.CbxPuestoEmpleado.getSelectedItem().toString();
                    double salario = Double.parseDouble(pantallaModificarDatosEmpleado.TxtSueldoEmpleado.getText());
                    String status = pantallaModificarDatosEmpleado.CbxStatusMod.getSelectedItem().toString();

                    //Obtener fecha
                    int mes = pantallaModificarDatosEmpleado.CbxMesNacimientoEmpleado.getSelectedIndex() + 1;
                    if (pantallaModificarDatosEmpleado.CbxMesNacimientoEmpleado.getSelectedIndex() + 1 < 9) {
                        fecha = pantallaModificarDatosEmpleado.CbxMesAñoEmpleado.getSelectedItem().toString() + "-0" + mes + "-" + pantallaModificarDatosEmpleado.CbxDiaNacimientoEmpleado.getSelectedItem().toString();
                    } else {
                        fecha = pantallaModificarDatosEmpleado.CbxMesAñoEmpleado.getSelectedItem().toString() + "-" + mes + "-" + pantallaModificarDatosEmpleado.CbxDiaNacimientoEmpleado.getSelectedItem().toString();
                    }

                    //Campos no obligatorios
                    String telefono = pantallaModificarDatosEmpleado.TxtTelefonoEmpleado.getText();
                    String calle = pantallaModificarDatosEmpleado.TxtCalleEmpleado.getText();
                    String colonia = pantallaModificarDatosEmpleado.TxtColoniaEmpleado.getText();
                    String numero = pantallaModificarDatosEmpleado.TxtNumeroEmpleado.getText();
                    String cp = pantallaModificarDatosEmpleado.TxtCpDireccionEmpleado.getText();

                    //Mandamos los campos obligatorios al objeto de tipo empleado
                    empleado.setNombre(nombre);
                    empleado.setApellido_Paterno(ap_pat);
                    empleado.setApellido_Materno(ap_mat);
                    empleado.setPuesto(puesto);
                    empleado.setSueldo(salario);
                    empleado.setStatus(status);
                    empleado.setCelular(celular);

                    //Mandamos los campos no obligatorios al objeto de tipo empleado
                    empleado.setFecha_Nacimiento(fecha);
                    empleado.setTelefono(telefono);
                    empleado.setCalle_Direccion(calle);
                    empleado.setColonia_Direccion(colonia);
                    empleado.setNumero_Direccion(numero);
                    empleado.setCp(cp);

                    String usuario = pantallaModificarDatosEmpleado.TxtUsuarioEmpleado.getText();
                    String contraseña = pantallaModificarDatosEmpleado.txtContraseñaMod.getText();

                    verificaCamposNoObligatorios();

                    if (validarDatosRegistroModificar()) {
                        if (pantallaModificarDatosEmpleado.BtnActualizarEmpleado.isEnabled()) {

                            pantallaModificarDatosEmpleado.DialogoActualizarEmpleado.setLocationRelativeTo(null);
                            pantallaModificarDatosEmpleado.DialogoActualizarEmpleado.setVisible(true);

                        }
                    } 
//                    else {
//
//                        pantallaModificarDatosEmpleado.DialogoMensajeError.setLocationRelativeTo(null);
//                        pantallaModificarDatosEmpleado.DialogoMensajeError.setVisible(true);
//
//                    }
                } catch (Exception ex) {
                    pantallaModificarDatosEmpleado.LbllMensajeError.setText("Error: " + ex.getMessage());
                    pantallaModificarDatosEmpleado.DialogoMensajeError.setLocationRelativeTo(null);
                    pantallaModificarDatosEmpleado.DialogoMensajeError.setVisible(true);

                }
            }
        });

        this.pantallaModificarDatosEmpleado.BtnAceptarMensajeErrores.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pantallaModificarDatosEmpleado.DialogoMensajeError.setVisible(false);
            }
        });
        
        this.pantallaModificarDatosEmpleado.BtnAceptarMensajeErrores.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    pantallaModificarDatosEmpleado.DialogoMensajeError.setVisible(false);
                }
            }
        });

        this.pantallaModificarDatosEmpleado.jBtnActualizarsi.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                boolean verifica=false;
                Empleado empleado = new Empleado();
                Login login = new Login();
                String fecha;
                //Campos obligatorios
                String nombre = pantallaModificarDatosEmpleado.TxtNombreEmpleado.getText();
                String ap_pat = pantallaModificarDatosEmpleado.TxtApellidoPaternoEmpleado.getText();
                String ap_mat = pantallaModificarDatosEmpleado.TxtApellidoMaternoEmpleado.getText();
                String celular = pantallaModificarDatosEmpleado.TxtCelularEmplado.getText();
                String puesto = pantallaModificarDatosEmpleado.CbxPuestoEmpleado.getSelectedItem().toString();
                double salario = Double.parseDouble(pantallaModificarDatosEmpleado.TxtSueldoEmpleado.getText());
                String status = pantallaModificarDatosEmpleado.CbxStatusMod.getSelectedItem().toString();

                //Obtener fecha
                int mes = pantallaModificarDatosEmpleado.CbxMesNacimientoEmpleado.getSelectedIndex() + 1;
                if (pantallaModificarDatosEmpleado.CbxMesNacimientoEmpleado.getSelectedIndex() + 1 < 9) {
                    fecha = pantallaModificarDatosEmpleado.CbxMesAñoEmpleado.getSelectedItem().toString() + "-0" + mes + "-" + pantallaModificarDatosEmpleado.CbxDiaNacimientoEmpleado.getSelectedItem().toString();
                } else {
                    fecha = pantallaModificarDatosEmpleado.CbxMesAñoEmpleado.getSelectedItem().toString() + "-" + mes + "-" + pantallaModificarDatosEmpleado.CbxDiaNacimientoEmpleado.getSelectedItem().toString();
                }

                //Campos no obligatorios
                String telefono = pantallaModificarDatosEmpleado.TxtTelefonoEmpleado.getText();
                String calle = pantallaModificarDatosEmpleado.TxtCalleEmpleado.getText();
                String colonia = pantallaModificarDatosEmpleado.TxtColoniaEmpleado.getText();
                String numero = pantallaModificarDatosEmpleado.TxtNumeroEmpleado.getText();
                String cp = pantallaModificarDatosEmpleado.TxtCpDireccionEmpleado.getText();

                //Mandamos los campos obligatorios al objeto de tipo empleado
                empleado.setNombre(nombre);
                empleado.setApellido_Paterno(ap_pat);
                empleado.setApellido_Materno(ap_mat);
                empleado.setPuesto(puesto);
                empleado.setSueldo(salario);
                empleado.setStatus(status);
                empleado.setCelular(celular);

                //Mandamos los campos no obligatorios al objeto de tipo empleado
                empleado.setFecha_Nacimiento(fecha);
                empleado.setTelefono(telefono);
                empleado.setCalle_Direccion(calle);
                empleado.setColonia_Direccion(colonia);
                empleado.setNumero_Direccion(numero);
                empleado.setCp(cp);

                String usuario = pantallaModificarDatosEmpleado.TxtUsuarioEmpleado.getText();
                String contraseña = pantallaModificarDatosEmpleado.txtContraseñaMod.getText();

                verificaCamposNoObligatorios();
                empleado.actualizarDatos(id);
                login.borrarLogin(id);
                puesto = pantallaModificarDatosEmpleado.CbxPuestoEmpleado.getSelectedItem().toString() + "";
                if (puesto.equals("Gerente") || puesto.equals("Cajero") || puesto.equals("Mesero")) {
                    usuario = pantallaModificarDatosEmpleado.TxtUsuarioEmpleado.getText();
                    if (pantallaModificarDatosEmpleado.txtContraseñaMod.getText().equals(pantallaModificarDatosEmpleado.TxtContraseñaRepMod.getText())) {
                        pantallaModificarDatosEmpleado.TxtUsuarioEmpleado.setEnabled(true);
                        pantallaModificarDatosEmpleado.TxtContraseñaRepMod.setEnabled(true);
                        pantallaModificarDatosEmpleado.txtContraseñaMod.setEnabled(true);
                        contraseña = pantallaModificarDatosEmpleado.txtContraseñaMod.getText();

                        login.setUsuario(usuario);
                        login.setContraseña(contraseña);
                        login.setId_empleado(Integer.parseInt(pantallaModificarDatosEmpleado.LblCodigoEmpleadoMod.getText()));

                        if (login.verificaUsuario(usuario, contraseña, login.listaUsuarios())) { //Verifica si el usuario existe 
                            pantallaModificarDatosEmpleado.LbllMensajeError.setText("El usuario ya existe. Ingrese otro");
                            //pantallaModificarDatosEmpleado.DialogoMensajeError.setLocationRelativeTo(null);
                            pantallaModificarDatosEmpleado.DialogoMensajeError.setVisible(true);
                            //pantallaModificarDatosEmpleado.TxtUsuarioEmpleado.getSelectedText();
                            pantallaModificarDatosEmpleado.TxtUsuarioEmpleado.setText("");
                            pantallaModificarDatosEmpleado.TxtContraseñaRepMod.setText("");
                            pantallaModificarDatosEmpleado.txtContraseñaMod.setText("");
                            verifica=true;
                        } else {
                            if (login.verificaUsuario(usuario, contraseña, login.listaUsuarios())) {
                                login.actualizarUsuario(Integer.parseInt(pantallaModificarDatosEmpleado.LblCodigoEmpleadoMod.getText()), usuario, contraseña);
                            } else {
                                login.guardarLogin();
                            }
                            //pantallaModificarDatosEmpleado.setVisible(false);
                            pantallaModificarDatosEmpleado.DialogoActualizarEmpleado.setVisible(false);
                             //pantallaModificarDatosEmpleado.DialogoMensajeExito.setLocationRelativeTo(null);
                            pantallaModificarDatosEmpleado.DialogoMensajeExito.setVisible(true);

                        }
                    } else {
                        pantallaModificarDatosEmpleado.LbllMensajeError.setText("Error: Las contraseñas no coinciden");
                        pantallaModificarDatosEmpleado.DialogoMensajeError.setLocationRelativeTo(null);
                        pantallaModificarDatosEmpleado.DialogoMensajeError.setVisible(true);
                        pantallaModificarDatosEmpleado.txtContraseñaMod.setText("");
                        pantallaModificarDatosEmpleado.TxtContraseñaRepMod.setText("");
                    }
                } else {
                    if(!verifica){
                        login.borrarLogin(id);
                    }
                    
                    //pantallaModificarDatosEmpleado.DialogoMensajeExito.setLocationRelativeTo(null);
                    pantallaModificarDatosEmpleado.DialogoMensajeExito.setVisible(true);
                    pantallaModificarDatosEmpleado.TxtUsuarioEmpleado.setEnabled(false);
                    pantallaModificarDatosEmpleado.TxtContraseñaRepMod.setEnabled(false);
                    pantallaModificarDatosEmpleado.txtContraseñaMod.setEnabled(false);

                }
            }

        });

        this.pantallaModificarDatosEmpleado.jBtnActualizarno.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pantallaModificarDatosEmpleado.DialogoActualizarEmpleado.dispose();
            }

        });

        this.pantallaModificarDatosEmpleado.BtnAceptarMensajeErrores.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pantallaModificarDatosEmpleado.DialogoMensajeError.dispose();
            }
        });
        
        this.pantallaModificarDatosEmpleado.BtnAceptarMensajeErrores.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    pantallaModificarDatosEmpleado.DialogoMensajeError.dispose();
                }
            }
        });

        this.pantallaModificarDatosEmpleado.BtnAceptarMensajeExito.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                //PantallaModificarEmpleado pantallaModificarEmpleado = new PantallaModificarEmpleado();
                //ControladorModificarEmpleado controladorModificarEmpleado = new ControladorModificarEmpleado(pantallaModificarEmpleado);
//                pantallaModificarDatosEmpleado.setLocationRelativeTo(null);
//                pantallaModificarDatosEmpleado.setVisible(true);
                pantallaModificarDatosEmpleado.DialogoMensajeExito.setVisible(false);
                //pantallaModificarDatosEmpleado.DialogoMensajeExito.dispose();
                //pantallaModificarDatosEmpleado.setVisible(false);
                pantallaModificarDatosEmpleado.dispose();
                pantallaPrincipal.setVisible(true);
            }

        });
        
        this.pantallaModificarDatosEmpleado.BtnAceptarMensajeExito.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    pantallaModificarDatosEmpleado.DialogoMensajeExito.setVisible(false);
                    pantallaModificarDatosEmpleado.dispose();
                pantallaPrincipal.setVisible(true);
                }
            }
        });

        this.pantallaModificarDatosEmpleado.BtnRegresarRegistrarEmpleado.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

//                PantallaMenuGerente pantallaGerente = new PantallaMenuGerente();
//                Empleado empleado = new Empleado();
//                ControladorMenuGerente controladorMenuGerente = new ControladorMenuGerente(pantallaGerente, empleado);
//                pantallaGerente.setLocationRelativeTo(null);
//                pantallaGerente.setVisible(true);
                pantallaModificarDatosEmpleado.setVisible(false);
                pantallaModificarDatosEmpleado.dispose();
                pantallaPrincipal.setVisible(true);

            }

        });

        this.pantallaModificarDatosEmpleado.CbxPuestoEmpleado.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

                if (pantallaModificarDatosEmpleado.CbxPuestoEmpleado.getSelectedItem().toString().equals("Gerente")
                        | pantallaModificarDatosEmpleado.CbxPuestoEmpleado.getSelectedItem().toString().equals("Mesero")
                        | pantallaModificarDatosEmpleado.CbxPuestoEmpleado.getSelectedItem().toString().equals("Cajero")) {

                    validarBotonRegistrarLogin();
                    pantallaModificarDatosEmpleado.BtnActualizarEmpleado.setEnabled(validacionEmpleadoLogin());
                } else if (pantallaModificarDatosEmpleado.CbxPuestoEmpleado.getSelectedItem().toString().equals("Cocinero")
                        | pantallaModificarDatosEmpleado.CbxPuestoEmpleado.getSelectedItem().toString().equals("Contador")) {
                    pantallaModificarDatosEmpleado.txtContraseñaMod.setText("");
                    pantallaModificarDatosEmpleado.txtContraseñaMod.setEnabled(false);
                    pantallaModificarDatosEmpleado.TxtContraseñaRepMod.setText("");
                    pantallaModificarDatosEmpleado.TxtContraseñaRepMod.setEnabled(false);
                    pantallaModificarDatosEmpleado.TxtUsuarioEmpleado.setText("");
                    pantallaModificarDatosEmpleado.TxtUsuarioEmpleado.setEnabled(false);
                    validarBotonRegistrar();
                    pantallaModificarDatosEmpleado.BtnActualizarEmpleado.setEnabled(validacionEmpleado());
                }
            }
        });
        
        this.pantallaModificarDatosEmpleado.BtnAceptarMensajeErrores.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pantallaModificarDatosEmpleado.DialogoMensajeError.dispose();
            }            
        });
        
        this.pantallaModificarDatosEmpleado.BtnAceptarMensajeErrores.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    pantallaModificarDatosEmpleado.DialogoMensajeError.dispose();
                }
            }
        });
        
        this.pantallaModificarDatosEmpleado.BtnAceptarErroresMenu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pantallaModificarDatosEmpleado.DialogoErrores.dispose();
            } 
        });
        
        this.pantallaModificarDatosEmpleado.BtnAceptarErroresMenu.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    pantallaModificarDatosEmpleado.DialogoErrores.dispose();
                }
            }
        });

        this.pantallaModificarDatosEmpleado.TxtNombreEmpleado.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (pantallaModificarDatosEmpleado.CbxPuestoEmpleado.getSelectedItem().toString().equals("Gerente") | pantallaModificarDatosEmpleado.CbxPuestoEmpleado.getSelectedItem().toString().equals("Mesero") | pantallaModificarDatosEmpleado.CbxPuestoEmpleado.getSelectedItem().toString().equals("Cajero")) {
                    pantallaModificarDatosEmpleado.BtnActualizarEmpleado.setEnabled(validacionEmpleadoLogin());
                } else {
//                    pantallaModificarDatosEmpleado.BtnActualizarEmpleado.setEnabled(validacionEmpleadoLogin());
                    pantallaModificarDatosEmpleado.BtnActualizarEmpleado.setEnabled(validacionEmpleado());
                }
            }
        });

        this.pantallaModificarDatosEmpleado.TxtApellidoPaternoEmpleado.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (pantallaModificarDatosEmpleado.CbxPuestoEmpleado.getSelectedItem().toString().equals("Gerente") | pantallaModificarDatosEmpleado.CbxPuestoEmpleado.getSelectedItem().toString().equals("Mesero") | pantallaModificarDatosEmpleado.CbxPuestoEmpleado.getSelectedItem().toString().equals("Cajero")) {
                    pantallaModificarDatosEmpleado.BtnActualizarEmpleado.setEnabled(validacionEmpleadoLogin());
                } else {
//                    pantallaModificarDatosEmpleado.BtnActualizarEmpleado.setEnabled(validacionEmpleadoLogin());
                    pantallaModificarDatosEmpleado.BtnActualizarEmpleado.setEnabled(validacionEmpleado());
                }
            }
        });

        this.pantallaModificarDatosEmpleado.TxtApellidoMaternoEmpleado.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (pantallaModificarDatosEmpleado.CbxPuestoEmpleado.getSelectedItem().toString().equals("Gerente") | pantallaModificarDatosEmpleado.CbxPuestoEmpleado.getSelectedItem().toString().equals("Mesero") | pantallaModificarDatosEmpleado.CbxPuestoEmpleado.getSelectedItem().toString().equals("Cajero")) {
                    pantallaModificarDatosEmpleado.BtnActualizarEmpleado.setEnabled(validacionEmpleadoLogin());
                } else {
//                    pantallaModificarDatosEmpleado.BtnActualizarEmpleado.setEnabled(validacionEmpleadoLogin());
                    pantallaModificarDatosEmpleado.BtnActualizarEmpleado.setEnabled(validacionEmpleado());
                }
            }

        });

        this.pantallaModificarDatosEmpleado.TxtCelularEmplado.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (pantallaModificarDatosEmpleado.CbxPuestoEmpleado.getSelectedItem().toString().equals("Gerente") | pantallaModificarDatosEmpleado.CbxPuestoEmpleado.getSelectedItem().toString().equals("Mesero") | pantallaModificarDatosEmpleado.CbxPuestoEmpleado.getSelectedItem().toString().equals("Cajero")) {
                    pantallaModificarDatosEmpleado.BtnActualizarEmpleado.setEnabled(validacionEmpleadoLogin());
                } else {
//                    pantallaModificarDatosEmpleado.BtnActualizarEmpleado.setEnabled(validacionEmpleadoLogin());
                    pantallaModificarDatosEmpleado.BtnActualizarEmpleado.setEnabled(validacionEmpleado());
                }
            }
        });

        this.pantallaModificarDatosEmpleado.TxtSueldoEmpleado.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (pantallaModificarDatosEmpleado.CbxPuestoEmpleado.getSelectedItem().toString().equals("Gerente") | pantallaModificarDatosEmpleado.CbxPuestoEmpleado.getSelectedItem().toString().equals("Mesero") | pantallaModificarDatosEmpleado.CbxPuestoEmpleado.getSelectedItem().toString().equals("Cajero")) {
                    pantallaModificarDatosEmpleado.BtnActualizarEmpleado.setEnabled(validacionEmpleadoLogin());
                } else {
//                    pantallaModificarDatosEmpleado.BtnActualizarEmpleado.setEnabled(validacionEmpleadoLogin());
                    pantallaModificarDatosEmpleado.BtnActualizarEmpleado.setEnabled(validacionEmpleado());
                }
            }
        });

        this.pantallaModificarDatosEmpleado.TxtUsuarioEmpleado.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (pantallaModificarDatosEmpleado.CbxPuestoEmpleado.getSelectedItem().toString().equals("Gerente") | pantallaModificarDatosEmpleado.CbxPuestoEmpleado.getSelectedItem().toString().equals("Mesero") | pantallaModificarDatosEmpleado.CbxPuestoEmpleado.getSelectedItem().toString().equals("Cajero")) {
                    pantallaModificarDatosEmpleado.BtnActualizarEmpleado.setEnabled(validacionEmpleadoLogin());
                } else {
//                    pantallaModificarDatosEmpleado.BtnActualizarEmpleado.setEnabled(validacionEmpleadoLogin());
                    pantallaModificarDatosEmpleado.BtnActualizarEmpleado.setEnabled(validacionEmpleado());
                }
            }

        });

        this.pantallaModificarDatosEmpleado.txtContraseñaMod.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (pantallaModificarDatosEmpleado.CbxPuestoEmpleado.getSelectedItem().toString().equals("Gerente") | pantallaModificarDatosEmpleado.CbxPuestoEmpleado.getSelectedItem().toString().equals("Mesero") | pantallaModificarDatosEmpleado.CbxPuestoEmpleado.getSelectedItem().toString().equals("Cajero")) {
                    pantallaModificarDatosEmpleado.BtnActualizarEmpleado.setEnabled(validacionEmpleadoLogin());
                } else {
//                    pantallaModificarDatosEmpleado.BtnActualizarEmpleado.setEnabled(validacionEmpleadoLogin());
                    pantallaModificarDatosEmpleado.BtnActualizarEmpleado.setEnabled(validacionEmpleado());
                }
            }
        });

        this.pantallaModificarDatosEmpleado.TxtContraseñaRepMod.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (pantallaModificarDatosEmpleado.CbxPuestoEmpleado.getSelectedItem().toString().equals("Gerente") | pantallaModificarDatosEmpleado.CbxPuestoEmpleado.getSelectedItem().toString().equals("Mesero") | pantallaModificarDatosEmpleado.CbxPuestoEmpleado.getSelectedItem().toString().equals("Cajero")) {
                    pantallaModificarDatosEmpleado.BtnActualizarEmpleado.setEnabled(validacionEmpleadoLogin());
                } else {
//                    pantallaModificarDatosEmpleado.BtnActualizarEmpleado.setEnabled(validacionEmpleadoLogin());
                    pantallaModificarDatosEmpleado.BtnActualizarEmpleado.setEnabled(validacionEmpleado());
                }
            }
        });

    }

    public void verificaCamposNoObligatorios() {
        if (pantallaModificarDatosEmpleado.TxtTelefonoEmpleado.getText().isEmpty()) {
            empleado.setTelefono(null);
        }
        if (pantallaModificarDatosEmpleado.TxtCalleEmpleado.getText().isEmpty()) {
            empleado.setCalle_Direccion(null);
        }
        if (pantallaModificarDatosEmpleado.TxtColoniaEmpleado.getText().isEmpty()) {
            empleado.setColonia_Direccion(null);
        }
        if (pantallaModificarDatosEmpleado.TxtNumeroEmpleado.getText().isEmpty()) {
            empleado.setNumero_Direccion(null);
        }
        if (pantallaModificarDatosEmpleado.TxtCpDireccionEmpleado.getText().isEmpty()) {
            empleado.setCp("");
        }
    }

    public boolean validacionEmpleadoLogin() {
        if (!pantallaModificarDatosEmpleado.TxtCelularEmplado.getText().isEmpty()
                & !pantallaModificarDatosEmpleado.TxtSueldoEmpleado.getText().isEmpty()
                & !pantallaModificarDatosEmpleado.TxtUsuarioEmpleado.getText().isEmpty()
                & !pantallaModificarDatosEmpleado.txtContraseñaMod.getText().isEmpty()
                & !pantallaModificarDatosEmpleado.TxtApellidoPaternoEmpleado.getText().isEmpty()
                & !pantallaModificarDatosEmpleado.TxtNombreEmpleado.getText().isEmpty()
                & !pantallaModificarDatosEmpleado.TxtContraseñaRepMod.getText().isEmpty()
                & !pantallaModificarDatosEmpleado.TxtApellidoMaternoEmpleado.getText().isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean validacionEmpleado() {
        if (!pantallaModificarDatosEmpleado.TxtCelularEmplado.getText().isEmpty()
                & !pantallaModificarDatosEmpleado.TxtSueldoEmpleado.getText().isEmpty()
                & !pantallaModificarDatosEmpleado.TxtApellidoPaternoEmpleado.getText().isEmpty()
                & !pantallaModificarDatosEmpleado.TxtNombreEmpleado.getText().isEmpty()
                & !pantallaModificarDatosEmpleado.TxtApellidoMaternoEmpleado.getText().isEmpty()) {
            return true;
        }
        return false;
    }

    public void validarBotonRegistrar() {
        pantallaModificarDatosEmpleado.txtContraseñaMod.setEnabled(false);
        if (pantallaModificarDatosEmpleado.TxtApellidoMaternoEmpleado.getText().isEmpty()
                & pantallaModificarDatosEmpleado.TxtApellidoPaternoEmpleado.getText().isEmpty()
                & pantallaModificarDatosEmpleado.TxtCelularEmplado.getText().isEmpty()
                & pantallaModificarDatosEmpleado.TxtNombreEmpleado.getText().isEmpty()
                & pantallaModificarDatosEmpleado.TxtSueldoEmpleado.getText().isEmpty()) {
            pantallaModificarDatosEmpleado.BtnActualizarEmpleado.setEnabled(false);
        } else {
            pantallaModificarDatosEmpleado.BtnActualizarEmpleado.setEnabled(true);
        }

    }

    public void validarBotonRegistrarLogin() {
        pantallaModificarDatosEmpleado.txtContraseñaMod.setEnabled(false);
        if (pantallaModificarDatosEmpleado.CbxPuestoEmpleado.getSelectedIndex() == 0
                | pantallaModificarDatosEmpleado.CbxPuestoEmpleado.getSelectedIndex() == 1
                | pantallaModificarDatosEmpleado.CbxPuestoEmpleado.getSelectedIndex() == 2) {
            pantallaModificarDatosEmpleado.TxtUsuarioEmpleado.setEnabled(true);
            pantallaModificarDatosEmpleado.txtContraseñaMod.setEnabled(true);
            pantallaModificarDatosEmpleado.TxtContraseñaRepMod.setEnabled(true);
        } else {
            pantallaModificarDatosEmpleado.TxtUsuarioEmpleado.setEnabled(false);
            pantallaModificarDatosEmpleado.txtContraseñaMod.setEnabled(false);
            pantallaModificarDatosEmpleado.TxtContraseñaRepMod.setEnabled(false);
        }
    }
    
    public boolean validarDatosRegistroModificar() {

        String txtError = "";
        Boolean errores = false;
        String sAux = pantallaModificarDatosEmpleado.TxtSueldoEmpleado.getText();
        //Validacion de campos obligatorios
        if (!(pantallaModificarDatosEmpleado.TxtNombreEmpleado.getText().matches("([àèìòùáéíóúa-zA-Z]+[ ]*)+"))) {
            txtError += "-Nombre invalido\n";
            errores = true;
            pantallaModificarDatosEmpleado.TxtNombreEmpleado.setText("");
            pantallaModificarDatosEmpleado.BtnActualizarEmpleado.setEnabled(false);
        }
        if (!(pantallaModificarDatosEmpleado.TxtApellidoPaternoEmpleado.getText().matches("([àèìòùáéíóúa-zA-Z]+[ ]*)+"))) {
            txtError += "-Apellido paterno invalido\n";
            errores = true;
            pantallaModificarDatosEmpleado.TxtApellidoPaternoEmpleado.setText("");
            pantallaModificarDatosEmpleado.BtnActualizarEmpleado.setEnabled(false);
        }
        if (!(pantallaModificarDatosEmpleado.TxtApellidoMaternoEmpleado.getText().matches("([àèìòùáéíóúa-zA-Z]+[ ]*)+"))) {
            txtError += "-Apellido materno invalido\n";
            errores = true;
            pantallaModificarDatosEmpleado.TxtApellidoMaternoEmpleado.setText("");
            pantallaModificarDatosEmpleado.BtnActualizarEmpleado.setEnabled(false);
        }

        if (!(pantallaModificarDatosEmpleado.TxtCelularEmplado.getText().matches("[1-9]{1}[0-9]{9}"))) {
            txtError += "-Celular invalido\n";
            errores = true;
            pantallaModificarDatosEmpleado.TxtCelularEmplado.setText("");
           pantallaModificarDatosEmpleado.BtnActualizarEmpleado.setEnabled(false);
        }
        if (!sAux.matches("([1-9])[0-9]+(([.])([0-9]{1,2})?)?")) {
            txtError += "-Salario invalido\n";
            errores = true;
            pantallaModificarDatosEmpleado.TxtSueldoEmpleado.setText("");
            pantallaModificarDatosEmpleado.BtnActualizarEmpleado.setEnabled(false);
        }

        //Campos no obligatorios
        if (!pantallaModificarDatosEmpleado.TxtCalleEmpleado.getText().isEmpty()) {
            if (!pantallaModificarDatosEmpleado.TxtCalleEmpleado.getText().matches("([1-9]{1,}\\s)*([áéíóúa-zA-Z]+[0-9]*\\s*)+")) {
                txtError += "-Verificar la calle de la direccion\n";
                errores = true;
                pantallaModificarDatosEmpleado.TxtCalleEmpleado.setText("");
                //pantallaModificarDatosEmpleado.BtnActualizarEmpleado.setEnabled(false);
            }
        }
        if (!pantallaModificarDatosEmpleado.TxtColoniaEmpleado.getText().isEmpty()) {
            if (!(pantallaModificarDatosEmpleado.TxtColoniaEmpleado.getText().matches("([1-9]{1,}\\s)*([áéíóúa-zA-Z]+[0-9]*\\s*)+"))) {
                txtError += "-Verificar la colonia de la direccion\n";
                errores = true;
                pantallaModificarDatosEmpleado.TxtColoniaEmpleado.setText("");
                //pantallaModificarDatosEmpleado.BtnActualizarEmpleado.setEnabled(false);
            }
        }

        if (!pantallaModificarDatosEmpleado.TxtNumeroEmpleado.getText().isEmpty()) {
            if (!pantallaModificarDatosEmpleado.TxtNumeroEmpleado.getText().matches("(([0-9]+(\\s|[-])*[áéíóúa-zA-Z]+)|([áéíóúa-zA-Z]+\\s[0-9]+)|([0-9]+))")) {
                txtError += "-Verificar el número de la direccion\n";
                errores = true;
                pantallaModificarDatosEmpleado.TxtNumeroEmpleado.setText("");
                //pantallaModificarDatosEmpleado.BtnActualizarEmpleado.setEnabled(false);
            }
        }

        if (!pantallaModificarDatosEmpleado.TxtCpDireccionEmpleado.getText().isEmpty()) {
            if (!pantallaModificarDatosEmpleado.TxtCpDireccionEmpleado.getText().matches("[0]{1}[1-9]{4}|[1-9]{1}[0-9]{4}")) {
                txtError += "-Código Postal invalido\n";
                errores = true;
                pantallaModificarDatosEmpleado.TxtCpDireccionEmpleado.setText("");
                //pantallaModificarDatosEmpleado.BtnActualizarEmpleado.setEnabled(false);
            }
        }

        if (!pantallaModificarDatosEmpleado.TxtTelefonoEmpleado.getText().isEmpty()) {
            if (!(pantallaModificarDatosEmpleado.TxtTelefonoEmpleado.getText().matches("[1-9]{1}[0-9]{6}"))) {
                txtError += "-Telefono invalido\n";
                errores = true;
                pantallaModificarDatosEmpleado.TxtTelefonoEmpleado.setText("");
                //pantallaModificarDatosEmpleado.BtnActualizarEmpleado.setEnabled(false);
            }
        }

        if (errores) {
            txtError += "No se permiten campos vacíos";
            pantallaModificarDatosEmpleado.jLblErroresMenu.setText(txtError);
            pantallaModificarDatosEmpleado.DialogoErrores.setLocationRelativeTo(null);
            pantallaModificarDatosEmpleado.DialogoErrores.setVisible(true);
            //JOptionPane.showMessageDialog(frameRegistroModificarEmpleado, txtError, "Validacion de datos de usuarios", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }

}
