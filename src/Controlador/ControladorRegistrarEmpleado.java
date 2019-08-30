/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Empleado;
import Modelo.Login;
import Vista.PantallaMenuGerente;
import Vista.PantallaRegistrarEmpleado;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author YareMtz
 */
public class ControladorRegistrarEmpleado {

    PantallaRegistrarEmpleado pantalla_RegistrarEmpleado;
    Empleado empleado = new Empleado();

    public ControladorRegistrarEmpleado(PantallaMenuGerente pantallaPrincipal, PantallaRegistrarEmpleado pantalla_RegistraEmpleado, Empleado empleado) {
        this.pantalla_RegistrarEmpleado = pantalla_RegistraEmpleado;
        this.empleado = empleado;
        
        pantalla_RegistrarEmpleado.TxtNombreEmpleado.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    pantalla_RegistrarEmpleado.TxtApellidoPaternoEmpleado.requestFocus();
                }
            }
        });
        
        pantalla_RegistrarEmpleado.TxtApellidoPaternoEmpleado.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    pantalla_RegistrarEmpleado.TxtApellidoMaternoEmpleado.requestFocus();
                }
            }
        });
        
        pantalla_RegistrarEmpleado.TxtApellidoMaternoEmpleado.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    pantalla_RegistrarEmpleado.TxtTelefonoEmpleado.requestFocus();
                }
            }
        });
        
        pantalla_RegistrarEmpleado.TxtTelefonoEmpleado.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    pantalla_RegistrarEmpleado.TxtCelularEmplado.requestFocus();
                }
            }
        });
        
        pantalla_RegistrarEmpleado.TxtCelularEmplado.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    pantalla_RegistrarEmpleado.TxtCalleEmpleado.requestFocus();
                }
            }
        });
        
        pantalla_RegistrarEmpleado.TxtCalleEmpleado.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    pantalla_RegistrarEmpleado.TxtColoniaEmpleado.requestFocus();
                }
            }
        });

        pantalla_RegistrarEmpleado.TxtColoniaEmpleado.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    pantalla_RegistrarEmpleado.TxtNumeroEmpleado.requestFocus();
                }
            }
        });
        
        pantalla_RegistrarEmpleado.TxtNumeroEmpleado.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    pantalla_RegistrarEmpleado.TxtCpDireccionEmpleado.requestFocus();
                }
            }
        });
        
        pantalla_RegistrarEmpleado.TxtCpDireccionEmpleado.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    pantalla_RegistrarEmpleado.TxtSueldoEmpleado.requestFocus();
                }
            }
        });
        
        pantalla_RegistrarEmpleado.TxtSueldoEmpleado.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    pantalla_RegistrarEmpleado.TxtUsuarioEmpleado.requestFocus();
                }
            }
        });
        
        pantalla_RegistrarEmpleado.TxtUsuarioEmpleado.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    pantalla_RegistrarEmpleado.txtContraseñaRegistrar.requestFocus();
                }
            }
        });
        
        pantalla_RegistrarEmpleado.txtContraseñaRegistrar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    pantalla_RegistrarEmpleado.TxtContraseñaRepRegistrar.requestFocus();
                }
            }
        });
        
        this.pantalla_RegistrarEmpleado.BtnAceptarErroresMenu.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    pantalla_RegistrarEmpleado.DialogoErroresRegistroEmpleado.dispose();
                }
            }
        });
        
        this.pantalla_RegistrarEmpleado.BtnAceptarMensajeErrores.addKeyListener(new KeyAdapter() {
           
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                pantalla_RegistrarEmpleado.DialogoMensajeError.dispose();}
            }
            
        });
        
        this.pantalla_RegistrarEmpleado.BtnAceptarMensajeExito.addKeyListener(new KeyAdapter() {
           
            public void keyPressed(KeyEvent e) {
             if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                 pantalla_RegistrarEmpleado.DialogoMensajeExito.dispose();
             }
            }
            
        });
        
        this.pantalla_RegistrarEmpleado.si.addKeyListener(new KeyAdapter() {
           
            public void keyPressed(KeyEvent e) {
                Empleado empleado = new Empleado();
                Login login_empleado = new Login();
                try {
                    String fecha;
                    //Campos obligatorios
                    String nombre = pantalla_RegistrarEmpleado.TxtNombreEmpleado.getText();
                    String ap_pat = pantalla_RegistrarEmpleado.TxtApellidoPaternoEmpleado.getText();
                    String ap_mat = pantalla_RegistrarEmpleado.TxtApellidoMaternoEmpleado.getText();
                    String celular = pantalla_RegistrarEmpleado.TxtCelularEmplado.getText();
                    String puesto = pantalla_RegistrarEmpleado.CbxPuestoEmpleado.getSelectedItem().toString();
                    double salario = Double.parseDouble(pantalla_RegistrarEmpleado.TxtSueldoEmpleado.getText());
                    String status = "activo";

                    //Obtener fecha
                    int mes = pantalla_RegistrarEmpleado.CbxMesNacimientoEmpleado.getSelectedIndex() + 1;
                    if (pantalla_RegistrarEmpleado.CbxMesNacimientoEmpleado.getSelectedIndex() + 1 < 9) {
                        fecha = pantalla_RegistrarEmpleado.CbxAñoEmpleado.getSelectedItem().toString() + "-0" + mes + "-" + pantalla_RegistrarEmpleado.CbxDiaNacimientoEmpleado.getSelectedItem().toString();
                    } else {
                        fecha = pantalla_RegistrarEmpleado.CbxAñoEmpleado.getSelectedItem().toString() + "-" + mes + "-" + pantalla_RegistrarEmpleado.CbxDiaNacimientoEmpleado.getSelectedItem().toString();
                    }

                    //Campos no obligatorios
                    String telefono = pantalla_RegistrarEmpleado.TxtTelefonoEmpleado.getText();
                    String calle = pantalla_RegistrarEmpleado.TxtCalleEmpleado.getText();
                    String colonia = pantalla_RegistrarEmpleado.TxtColoniaEmpleado.getText();
                    String numero = pantalla_RegistrarEmpleado.TxtNumeroEmpleado.getText();
                    String cp = pantalla_RegistrarEmpleado.TxtCpDireccionEmpleado.getText();

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

                    String contraseña = pantalla_RegistraEmpleado.txtContraseñaRegistrar.getText();
                    login_empleado.setUsuario(pantalla_RegistraEmpleado.TxtUsuarioEmpleado.getText());
                    login_empleado.setContraseña(contraseña);
                   
                    

                    verificaCamposNoObligatorios();
                    empleado.registrarEmpleado();
                    login_empleado.setId_empleado(empleado.id_login());
                    System.out.println("cod= "+empleado.id_login());

                    if (!pantalla_RegistraEmpleado.TxtUsuarioEmpleado.getText().isEmpty()) {
                        login_empleado.guardarLogin();
                    }
                    pantalla_RegistraEmpleado.MensajeConfirmacionRegistro.setVisible(false);
                    pantalla_RegistraEmpleado.MensajeConfirmacionRegistro.dispose();
                    pantalla_RegistraEmpleado.DialogoMensajeExito.setLocationRelativeTo(null);
                    pantalla_RegistraEmpleado.DialogoMensajeExito.setVisible(true);
                } catch (Exception ex) {
                    pantalla_RegistraEmpleado.LbllMensajeError.setText(ex.getMessage());
                    pantalla_RegistraEmpleado.DialogoMensajeError.setLocationRelativeTo(null);
                    pantalla_RegistraEmpleado.DialogoMensajeError.setVisible(true);
                }
            }
            
        });
        
        
        
        
        this.pantalla_RegistrarEmpleado.CbxMesNacimientoEmpleado.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                pantalla_RegistrarEmpleado.CbxDiaNacimientoEmpleado.removeAllItems();
                if (pantalla_RegistrarEmpleado.CbxMesNacimientoEmpleado.getSelectedIndex() == 3 || pantalla_RegistrarEmpleado.CbxMesNacimientoEmpleado.getSelectedIndex() == 5 || pantalla_RegistrarEmpleado.CbxMesNacimientoEmpleado.getSelectedIndex() == 8 || pantalla_RegistrarEmpleado.CbxMesNacimientoEmpleado.getSelectedIndex() == 10) {
                    for (int i = 0; i < 30; i++) {
                        pantalla_RegistrarEmpleado.CbxDiaNacimientoEmpleado.insertItemAt(i + 1 + "", i);
                    }
                } else if (pantalla_RegistrarEmpleado.CbxMesNacimientoEmpleado.getSelectedIndex() == 0 || pantalla_RegistrarEmpleado.CbxMesNacimientoEmpleado.getSelectedIndex() == 2 || pantalla_RegistrarEmpleado.CbxMesNacimientoEmpleado.getSelectedIndex() == 4 || pantalla_RegistrarEmpleado.CbxMesNacimientoEmpleado.getSelectedIndex() == 6 || pantalla_RegistrarEmpleado.CbxMesNacimientoEmpleado.getSelectedIndex() == 7 || pantalla_RegistrarEmpleado.CbxMesNacimientoEmpleado.getSelectedIndex() == 9 || pantalla_RegistrarEmpleado.CbxMesNacimientoEmpleado.getSelectedIndex() == 11) {
                    for (int i = 0; i < 31; i++) {
                        pantalla_RegistrarEmpleado.CbxDiaNacimientoEmpleado.insertItemAt(i + 1 + "", i);
                    }
                } else {
                    for (int i = 0; i < 29; i++) {
                        pantalla_RegistrarEmpleado.CbxDiaNacimientoEmpleado.insertItemAt(i + 1 + "", i);
                    }
                }
                pantalla_RegistrarEmpleado.CbxDiaNacimientoEmpleado.setSelectedIndex(0);
            }
        });

        this.pantalla_RegistrarEmpleado.BtnRegresarRegistroEmpleado.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //pantalla_RegistrarEmpleado.setVisible(false);
                pantalla_RegistrarEmpleado.dispose();
                //System.out.println("Regresar");
                pantallaPrincipal.setVisible(true);
            }
        });

        this.pantalla_RegistrarEmpleado.BtnRegistrarEmpleado.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Empleado empleado = new Empleado();
                Login login_empleado = new Login();
                try {
                    String fecha;
                    //Campos obligatorios
                    String nombre = pantalla_RegistrarEmpleado.TxtNombreEmpleado.getText();
                    String ap_pat = pantalla_RegistrarEmpleado.TxtApellidoPaternoEmpleado.getText();
                    String ap_mat = pantalla_RegistrarEmpleado.TxtApellidoMaternoEmpleado.getText();
                    String celular = pantalla_RegistrarEmpleado.TxtCelularEmplado.getText();
                    String puesto = pantalla_RegistrarEmpleado.CbxPuestoEmpleado.getSelectedItem().toString();
                    double salario = Double.parseDouble(pantalla_RegistrarEmpleado.TxtSueldoEmpleado.getText());
                    String status = "activo";

                    //Obtener fecha
                    int mes = pantalla_RegistrarEmpleado.CbxMesNacimientoEmpleado.getSelectedIndex() + 1;
                    if (pantalla_RegistrarEmpleado.CbxMesNacimientoEmpleado.getSelectedIndex() + 1 < 9) {
                        fecha = pantalla_RegistrarEmpleado.CbxAñoEmpleado.getSelectedItem().toString() + "-0" + mes + "-" + pantalla_RegistrarEmpleado.CbxDiaNacimientoEmpleado.getSelectedItem().toString();
                    } else {
                        fecha = pantalla_RegistrarEmpleado.CbxAñoEmpleado.getSelectedItem().toString() + "-" + mes + "-" + pantalla_RegistrarEmpleado.CbxDiaNacimientoEmpleado.getSelectedItem().toString();
                    }

                    //Campos no obligatorios
                    String telefono = pantalla_RegistrarEmpleado.TxtTelefonoEmpleado.getText();
                    String calle = pantalla_RegistrarEmpleado.TxtCalleEmpleado.getText();
                    String colonia = pantalla_RegistrarEmpleado.TxtColoniaEmpleado.getText();
                    String numero = pantalla_RegistrarEmpleado.TxtNumeroEmpleado.getText();
                    String cp = pantalla_RegistrarEmpleado.TxtCpDireccionEmpleado.getText();

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

                    verificaCamposNoObligatorios();

                    if (empleado.validarDatosRegistro(pantalla_RegistraEmpleado) == true) {
                        if (pantalla_RegistraEmpleado.BtnRegistrarEmpleado.isEnabled()) {
                            if (puesto.equals("Gerente") || puesto.equals("Cajero") || puesto.equals("Mesero")) {
                                String usuario = pantalla_RegistraEmpleado.TxtUsuarioEmpleado.getText();
                                if (pantalla_RegistraEmpleado.txtContraseñaRegistrar.getText().equals(pantalla_RegistraEmpleado.TxtContraseñaRepRegistrar.getText())) {
                                    pantalla_RegistraEmpleado.TxtUsuarioEmpleado.setEnabled(true);
                                    pantalla_RegistraEmpleado.TxtContraseñaRepRegistrar.setEnabled(true);
                                    pantalla_RegistraEmpleado.txtContraseñaRegistrar.setEnabled(true);

                                    String contraseña = pantalla_RegistraEmpleado.txtContraseñaRegistrar.getText();

                                    login_empleado.setUsuario(usuario);
                                    login_empleado.setContraseña(contraseña);
                                    login_empleado.setId_empleado(empleado.getId_empleado());

                                    if (login_empleado.verificaNombreUsuario(usuario, login_empleado.listaUsuarios())) {

                                        pantalla_RegistraEmpleado.LbllMensajeError.setText("Error: El usuario ya existe");
                                        pantalla_RegistraEmpleado.DialogoMensajeError.setLocationRelativeTo(null);
                                        pantalla_RegistraEmpleado.DialogoMensajeError.setVisible(true);
                                        pantalla_RegistraEmpleado.TxtUsuarioEmpleado.setText("");
                                        pantalla_RegistraEmpleado.TxtContraseñaRepRegistrar.setText("");
                                        pantalla_RegistraEmpleado.txtContraseñaRegistrar.setText("");
                                    } else {
                                        pantalla_RegistraEmpleado.MensajeConfirmacionRegistro.setLocationRelativeTo(null);
                                        pantalla_RegistraEmpleado.MensajeConfirmacionRegistro.setVisible(true);
                                    }
                                } else {

                                    pantalla_RegistraEmpleado.LbllMensajeError.setText("Error: Las contraseñas no coinciden");
                                    pantalla_RegistraEmpleado.DialogoMensajeError.setLocationRelativeTo(null);
                                    pantalla_RegistraEmpleado.DialogoMensajeError.setVisible(true);
                                    pantalla_RegistraEmpleado.txtContraseñaRegistrar.setText("");
                                    pantalla_RegistraEmpleado.TxtContraseñaRepRegistrar.setText("");
                                    pantalla_RegistraEmpleado.BtnRegistrarEmpleado.setEnabled(false);
                                }
                            } else {

                                pantalla_RegistraEmpleado.MensajeConfirmacionRegistro.setLocationRelativeTo(null);
                                pantalla_RegistraEmpleado.MensajeConfirmacionRegistro.setVisible(true);

                            }
                        }
                    }
                } catch (Exception ex) {
                    pantalla_RegistraEmpleado.LbllMensajeError.setText("Error: Campos vacíos");
                    pantalla_RegistraEmpleado.DialogoMensajeError.setLocationRelativeTo(null);
                    pantalla_RegistraEmpleado.DialogoMensajeError.setVisible(true);
                }
            }
        });

        this.pantalla_RegistrarEmpleado.no.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pantalla_RegistraEmpleado.MensajeConfirmacionRegistro.dispose();
            }

        });

        this.pantalla_RegistrarEmpleado.si.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Empleado empleado = new Empleado();
                Login login_empleado = new Login();
                try {
                    String fecha;
                    //Campos obligatorios
                    String nombre = pantalla_RegistrarEmpleado.TxtNombreEmpleado.getText();
                    String ap_pat = pantalla_RegistrarEmpleado.TxtApellidoPaternoEmpleado.getText();
                    String ap_mat = pantalla_RegistrarEmpleado.TxtApellidoMaternoEmpleado.getText();
                    String celular = pantalla_RegistrarEmpleado.TxtCelularEmplado.getText();
                    String puesto = pantalla_RegistrarEmpleado.CbxPuestoEmpleado.getSelectedItem().toString();
                    double salario = Double.parseDouble(pantalla_RegistrarEmpleado.TxtSueldoEmpleado.getText());
                    String status = "activo";

                    //Obtener fecha
                    int mes = pantalla_RegistrarEmpleado.CbxMesNacimientoEmpleado.getSelectedIndex() + 1;
                    if (pantalla_RegistrarEmpleado.CbxMesNacimientoEmpleado.getSelectedIndex() + 1 < 9) {
                        fecha = pantalla_RegistrarEmpleado.CbxAñoEmpleado.getSelectedItem().toString() + "-0" + mes + "-" + pantalla_RegistrarEmpleado.CbxDiaNacimientoEmpleado.getSelectedItem().toString();
                    } else {
                        fecha = pantalla_RegistrarEmpleado.CbxAñoEmpleado.getSelectedItem().toString() + "-" + mes + "-" + pantalla_RegistrarEmpleado.CbxDiaNacimientoEmpleado.getSelectedItem().toString();
                    }

                    //Campos no obligatorios
                    String telefono = pantalla_RegistrarEmpleado.TxtTelefonoEmpleado.getText();
                    String calle = pantalla_RegistrarEmpleado.TxtCalleEmpleado.getText();
                    String colonia = pantalla_RegistrarEmpleado.TxtColoniaEmpleado.getText();
                    String numero = pantalla_RegistrarEmpleado.TxtNumeroEmpleado.getText();
                    String cp = pantalla_RegistrarEmpleado.TxtCpDireccionEmpleado.getText();

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

                    String contraseña = pantalla_RegistraEmpleado.txtContraseñaRegistrar.getText();
                    login_empleado.setUsuario(pantalla_RegistraEmpleado.TxtUsuarioEmpleado.getText());
                    login_empleado.setContraseña(contraseña);
                   
                    

                    verificaCamposNoObligatorios();
                    empleado.registrarEmpleado();
                    login_empleado.setId_empleado(empleado.id_login());
                    System.out.println("cod= "+empleado.id_login());

                    if (!pantalla_RegistraEmpleado.TxtUsuarioEmpleado.getText().isEmpty()) {
                        login_empleado.guardarLogin();
                    }
                    pantalla_RegistraEmpleado.MensajeConfirmacionRegistro.setVisible(false);
                    pantalla_RegistraEmpleado.MensajeConfirmacionRegistro.dispose();
                    pantalla_RegistraEmpleado.DialogoMensajeExito.setLocationRelativeTo(null);
                    pantalla_RegistraEmpleado.DialogoMensajeExito.setVisible(true);
                } catch (Exception ex) {
                    pantalla_RegistraEmpleado.LbllMensajeError.setText(ex.getMessage());
                    pantalla_RegistraEmpleado.DialogoMensajeError.setLocationRelativeTo(null);
                    pantalla_RegistraEmpleado.DialogoMensajeError.setVisible(true);
                }
            }
        });

        this.pantalla_RegistrarEmpleado.BtnAceptarMensajeExito.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pantalla_RegistraEmpleado.setVisible(false);
                pantalla_RegistraEmpleado.dispose();
                PantallaMenuGerente pantallaGerente = new PantallaMenuGerente();
                Empleado empleado = new Empleado();
                ControladorMenuGerente controladorMenuGerente = new ControladorMenuGerente(pantallaGerente, empleado);
                pantallaGerente.setLocationRelativeTo(null);
                pantallaGerente.setVisible(true);
            }

        });
        
        this.pantalla_RegistrarEmpleado.BtnAceptarMensajeExito.addKeyListener(new KeyAdapter() {
            
            public void keyPressed(KeyEvent e) {
             if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                pantalla_RegistraEmpleado.setVisible(false);
                pantalla_RegistraEmpleado.dispose();
                PantallaMenuGerente pantallaGerente = new PantallaMenuGerente();
                Empleado empleado = new Empleado();
                ControladorMenuGerente controladorMenuGerente = new ControladorMenuGerente(pantallaGerente, empleado);
                pantallaGerente.setLocationRelativeTo(null);
                pantallaGerente.setVisible(true);
            }}

        });
        
        

        this.pantalla_RegistrarEmpleado.TxtNombreEmpleado.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (pantalla_RegistraEmpleado.CbxPuestoEmpleado.getSelectedItem().toString().equals("Gerente") | pantalla_RegistraEmpleado.CbxPuestoEmpleado.getSelectedItem().toString().equals("Mesero") | pantalla_RegistraEmpleado.CbxPuestoEmpleado.getSelectedItem().toString().equals("Cajero")) {
                    pantalla_RegistraEmpleado.BtnRegistrarEmpleado.setEnabled(validacionEmpleadoLogin());
                } else {
                    pantalla_RegistraEmpleado.BtnRegistrarEmpleado.setEnabled(validacionEmpleadoLogin());
                    pantalla_RegistraEmpleado.BtnRegistrarEmpleado.setEnabled(validacionEmpleado());
                }
            }
        });

        this.pantalla_RegistrarEmpleado.TxtApellidoPaternoEmpleado.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (pantalla_RegistraEmpleado.CbxPuestoEmpleado.getSelectedItem().toString().equals("Gerente") | pantalla_RegistraEmpleado.CbxPuestoEmpleado.getSelectedItem().toString().equals("Mesero") | pantalla_RegistraEmpleado.CbxPuestoEmpleado.getSelectedItem().toString().equals("Cajero")) {
                    pantalla_RegistraEmpleado.BtnRegistrarEmpleado.setEnabled(validacionEmpleadoLogin());
                } else {
                    pantalla_RegistraEmpleado.BtnRegistrarEmpleado.setEnabled(validacionEmpleadoLogin());
                    pantalla_RegistraEmpleado.BtnRegistrarEmpleado.setEnabled(validacionEmpleado());
                }
            }
        });

        this.pantalla_RegistrarEmpleado.TxtApellidoMaternoEmpleado.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (pantalla_RegistraEmpleado.CbxPuestoEmpleado.getSelectedItem().toString().equals("Gerente") | pantalla_RegistraEmpleado.CbxPuestoEmpleado.getSelectedItem().toString().equals("Mesero") | pantalla_RegistraEmpleado.CbxPuestoEmpleado.getSelectedItem().toString().equals("Cajero")) {
                    pantalla_RegistraEmpleado.BtnRegistrarEmpleado.setEnabled(validacionEmpleadoLogin());
                } else {
                    pantalla_RegistraEmpleado.BtnRegistrarEmpleado.setEnabled(validacionEmpleadoLogin());
                    pantalla_RegistraEmpleado.BtnRegistrarEmpleado.setEnabled(validacionEmpleado());
                }
            }

        });

        this.pantalla_RegistrarEmpleado.TxtCelularEmplado.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (pantalla_RegistraEmpleado.CbxPuestoEmpleado.getSelectedItem().toString().equals("Gerente") | pantalla_RegistraEmpleado.CbxPuestoEmpleado.getSelectedItem().toString().equals("Mesero") | pantalla_RegistraEmpleado.CbxPuestoEmpleado.getSelectedItem().toString().equals("Cajero")) {
                    pantalla_RegistraEmpleado.BtnRegistrarEmpleado.setEnabled(validacionEmpleadoLogin());
                } else {
                    pantalla_RegistraEmpleado.BtnRegistrarEmpleado.setEnabled(validacionEmpleadoLogin());
                    pantalla_RegistraEmpleado.BtnRegistrarEmpleado.setEnabled(validacionEmpleado());
                }
            }
        });

        this.pantalla_RegistrarEmpleado.CbxPuestoEmpleado.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

                if (pantalla_RegistraEmpleado.CbxPuestoEmpleado.getSelectedItem().toString().equals("Gerente")
                        | pantalla_RegistraEmpleado.CbxPuestoEmpleado.getSelectedItem().toString().equals("Mesero")
                        | pantalla_RegistraEmpleado.CbxPuestoEmpleado.getSelectedItem().toString().equals("Cajero")) {

                    validarBotonRegistrarLogin();
                    pantalla_RegistraEmpleado.BtnRegistrarEmpleado.setEnabled(validacionEmpleadoLogin());
                } else if (pantalla_RegistraEmpleado.CbxPuestoEmpleado.getSelectedItem().toString().equals("Cocinero")
                        | pantalla_RegistraEmpleado.CbxPuestoEmpleado.getSelectedItem().toString().equals("Contador")) {
                    pantalla_RegistraEmpleado.txtContraseñaRegistrar.setText("");
                    pantalla_RegistraEmpleado.txtContraseñaRegistrar.setEnabled(false);
                    pantalla_RegistraEmpleado.TxtContraseñaRepRegistrar.setText("");
                    pantalla_RegistraEmpleado.TxtContraseñaRepRegistrar.setEnabled(false);
                    pantalla_RegistraEmpleado.TxtUsuarioEmpleado.setText("");
                    pantalla_RegistraEmpleado.TxtUsuarioEmpleado.setEnabled(false);
                    validarBotonRegistrar();
                    pantalla_RegistraEmpleado.BtnRegistrarEmpleado.setEnabled(validacionEmpleado());
                }

            }
        });

        this.pantalla_RegistrarEmpleado.TxtSueldoEmpleado.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (pantalla_RegistraEmpleado.CbxPuestoEmpleado.getSelectedItem().toString().equals("Gerente") | pantalla_RegistraEmpleado.CbxPuestoEmpleado.getSelectedItem().toString().equals("Mesero") | pantalla_RegistraEmpleado.CbxPuestoEmpleado.getSelectedItem().toString().equals("Cajero")) {
                    pantalla_RegistraEmpleado.BtnRegistrarEmpleado.setEnabled(validacionEmpleadoLogin());
                } else {
                    pantalla_RegistraEmpleado.BtnRegistrarEmpleado.setEnabled(validacionEmpleadoLogin());
                    pantalla_RegistraEmpleado.BtnRegistrarEmpleado.setEnabled(validacionEmpleado());
                }
            }
        });

        this.pantalla_RegistrarEmpleado.TxtUsuarioEmpleado.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (pantalla_RegistraEmpleado.CbxPuestoEmpleado.getSelectedItem().toString().equals("Gerente") | pantalla_RegistraEmpleado.CbxPuestoEmpleado.getSelectedItem().toString().equals("Mesero") | pantalla_RegistraEmpleado.CbxPuestoEmpleado.getSelectedItem().toString().equals("Cajero")) {
                    pantalla_RegistraEmpleado.BtnRegistrarEmpleado.setEnabled(validacionEmpleadoLogin());
                } else {
                    pantalla_RegistraEmpleado.BtnRegistrarEmpleado.setEnabled(validacionEmpleadoLogin());
                    pantalla_RegistraEmpleado.BtnRegistrarEmpleado.setEnabled(validacionEmpleado());
                }
            }

        });

        this.pantalla_RegistrarEmpleado.txtContraseñaRegistrar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (pantalla_RegistraEmpleado.CbxPuestoEmpleado.getSelectedItem().toString().equals("Gerente") | pantalla_RegistraEmpleado.CbxPuestoEmpleado.getSelectedItem().toString().equals("Mesero") | pantalla_RegistraEmpleado.CbxPuestoEmpleado.getSelectedItem().toString().equals("Cajero")) {
                    pantalla_RegistraEmpleado.BtnRegistrarEmpleado.setEnabled(validacionEmpleadoLogin());
                } else {
                    pantalla_RegistraEmpleado.BtnRegistrarEmpleado.setEnabled(validacionEmpleadoLogin());
                    pantalla_RegistraEmpleado.BtnRegistrarEmpleado.setEnabled(validacionEmpleado());
                }
            }
        });

        this.pantalla_RegistrarEmpleado.TxtContraseñaRepRegistrar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (pantalla_RegistraEmpleado.CbxPuestoEmpleado.getSelectedItem().toString().equals("Gerente") | pantalla_RegistraEmpleado.CbxPuestoEmpleado.getSelectedItem().toString().equals("Mesero") | pantalla_RegistraEmpleado.CbxPuestoEmpleado.getSelectedItem().toString().equals("Cajero")) {
                    pantalla_RegistraEmpleado.BtnRegistrarEmpleado.setEnabled(validacionEmpleadoLogin());
                } else {
                    pantalla_RegistraEmpleado.BtnRegistrarEmpleado.setEnabled(validacionEmpleadoLogin());
                    pantalla_RegistraEmpleado.BtnRegistrarEmpleado.setEnabled(validacionEmpleado());
                }
            }
        });
        
        this.pantalla_RegistrarEmpleado.BtnAceptarMensajeErrores.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pantalla_RegistrarEmpleado.DialogoMensajeError.dispose();
            } 
        });
        
        this.pantalla_RegistrarEmpleado.BtnAceptarMensajeErrores.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    pantalla_RegistraEmpleado.DialogoMensajeError.setVisible(false);
                }
            }
        });
        
        this.pantalla_RegistrarEmpleado.BtnAceptarErroresMenu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pantalla_RegistrarEmpleado.DialogoErroresRegistroEmpleado.dispose();
            }
            
        });
        
        this.pantalla_RegistrarEmpleado.BtnAceptarErroresMenu.addKeyListener(new KeyAdapter() {
            
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    pantalla_RegistraEmpleado.DialogoErroresRegistroEmpleado.setVisible(false);
                }
            }
        });
        
        pantalla_RegistrarEmpleado.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                pantalla_RegistrarEmpleado.dispose();
                pantallaPrincipal.setVisible(true);
            }
        });
        
        
        
        

    }

    public void validarBotonRegistrar() {
        pantalla_RegistrarEmpleado.TxtContraseñaRepRegistrar.setEnabled(false);
        if (pantalla_RegistrarEmpleado.TxtApellidoMaternoEmpleado.getText().isEmpty()
                & pantalla_RegistrarEmpleado.TxtApellidoPaternoEmpleado.getText().isEmpty()
                & pantalla_RegistrarEmpleado.TxtCelularEmplado.getText().isEmpty()
                & pantalla_RegistrarEmpleado.TxtNombreEmpleado.getText().isEmpty()
                & pantalla_RegistrarEmpleado.TxtSueldoEmpleado.getText().isEmpty()) {
            pantalla_RegistrarEmpleado.BtnRegistrarEmpleado.setEnabled(false);
        } else {
            pantalla_RegistrarEmpleado.BtnRegistrarEmpleado.setEnabled(true);
        }

    }

    public void validarBotonRegistrarLogin() {
        pantalla_RegistrarEmpleado.TxtContraseñaRepRegistrar.setEnabled(false);
        if (pantalla_RegistrarEmpleado.CbxPuestoEmpleado.getSelectedIndex() == 0
                | pantalla_RegistrarEmpleado.CbxPuestoEmpleado.getSelectedIndex() == 1
                | pantalla_RegistrarEmpleado.CbxPuestoEmpleado.getSelectedIndex() == 2) {
            pantalla_RegistrarEmpleado.TxtUsuarioEmpleado.setEnabled(true);
            pantalla_RegistrarEmpleado.txtContraseñaRegistrar.setEnabled(true);
            pantalla_RegistrarEmpleado.TxtContraseñaRepRegistrar.setEnabled(true);
        } else {
            pantalla_RegistrarEmpleado.TxtUsuarioEmpleado.setEnabled(false);
            pantalla_RegistrarEmpleado.txtContraseñaRegistrar.setEnabled(false);
            pantalla_RegistrarEmpleado.TxtContraseñaRepRegistrar.setEnabled(false);
        }
    }

    //Metodo que verifica que los campos no obligatorios no esten vacios
    public void verificaCamposNoObligatorios() {
        if (pantalla_RegistrarEmpleado.TxtTelefonoEmpleado.getText().isEmpty()) {
            empleado.setTelefono(null);
        }
        if (pantalla_RegistrarEmpleado.TxtCalleEmpleado.getText().isEmpty()) {
            empleado.setCalle_Direccion(null);
        }
        if (pantalla_RegistrarEmpleado.TxtColoniaEmpleado.getText().isEmpty()) {
            empleado.setColonia_Direccion(null);
        }
        if (pantalla_RegistrarEmpleado.TxtNumeroEmpleado.getText().isEmpty()) {
            empleado.setNumero_Direccion(null);
        }
        if (pantalla_RegistrarEmpleado.TxtCpDireccionEmpleado.getText().isEmpty()) {
            empleado.setCp(null);
        }
    }

    public boolean validacionEmpleadoLogin() {
        if (!pantalla_RegistrarEmpleado.TxtCelularEmplado.getText().isEmpty()
                & !pantalla_RegistrarEmpleado.TxtSueldoEmpleado.getText().isEmpty()
                & !pantalla_RegistrarEmpleado.TxtUsuarioEmpleado.getText().isEmpty()
                & !pantalla_RegistrarEmpleado.txtContraseñaRegistrar.getText().isEmpty()
                & !pantalla_RegistrarEmpleado.TxtApellidoPaternoEmpleado.getText().isEmpty()
                & !pantalla_RegistrarEmpleado.TxtNombreEmpleado.getText().isEmpty()
                & !pantalla_RegistrarEmpleado.TxtContraseñaRepRegistrar.getText().isEmpty()
                & !pantalla_RegistrarEmpleado.TxtApellidoMaternoEmpleado.getText().isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean validacionEmpleado() {
        if (!pantalla_RegistrarEmpleado.TxtCelularEmplado.getText().isEmpty()
                & !pantalla_RegistrarEmpleado.TxtSueldoEmpleado.getText().isEmpty()
                & !pantalla_RegistrarEmpleado.TxtApellidoPaternoEmpleado.getText().isEmpty()
                & !pantalla_RegistrarEmpleado.TxtNombreEmpleado.getText().isEmpty()
                & !pantalla_RegistrarEmpleado.TxtApellidoMaternoEmpleado.getText().isEmpty()) {
            return true;
        }
        return false;
    }
}
