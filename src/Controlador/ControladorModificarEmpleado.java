/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Empleado;
import Modelo.Login;
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
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author YareMtz
 */
public class ControladorModificarEmpleado {

    PantallaModificarEmpleado pantallaModificarEmpleado;

    public ControladorModificarEmpleado(PantallaMenuGerente pantallaPrincipal, PantallaModificarEmpleado pantallaModificarEmpleado) {
        this.pantallaModificarEmpleado = pantallaModificarEmpleado;

        this.pantallaModificarEmpleado.BtnRegresarModificarEmpleado.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pantallaModificarEmpleado.dispose();
                pantallaPrincipal.setLocationRelativeTo(null);
                pantallaPrincipal.setVisible(true);
            }
        });

        this.pantallaModificarEmpleado.RdBtnCodEmpleadoModificar.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (pantallaModificarEmpleado.RdBtnCodEmpleadoModificar.isSelected()) {
                    pantallaModificarEmpleado.TxtNombreEmpleadoModificar.setText("");
                    pantallaModificarEmpleado.TxtCodigoEmpleadoModificar.setEnabled(true);
                    pantallaModificarEmpleado.TxtNombreEmpleadoModificar.setEnabled(false);
                } else {
                    pantallaModificarEmpleado.TxtCodigoEmpleadoModificar.setText("");
                    pantallaModificarEmpleado.TxtNombreEmpleadoModificar.setEnabled(true);
                    pantallaModificarEmpleado.TxtCodigoEmpleadoModificar.setEnabled(false);
                }
            }
        });

        this.pantallaModificarEmpleado.TxtCodigoEmpleadoModificar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (pantallaModificarEmpleado.RdBtnCodEmpleadoModificar.isSelected() & pantallaModificarEmpleado.TxtCodigoEmpleadoModificar.getText().isEmpty()) {
                    pantallaModificarEmpleado.BtnBuscarModificar.setEnabled(false);
                } else {
                    pantallaModificarEmpleado.BtnBuscarModificar.setEnabled(true);
                }
            }
        });

        this.pantallaModificarEmpleado.TxtNombreEmpleadoModificar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (pantallaModificarEmpleado.RbBtnNomEmpleadoModificar.isSelected() & pantallaModificarEmpleado.TxtNombreEmpleadoModificar.getText().isEmpty()) {
                    pantallaModificarEmpleado.BtnBuscarModificar.setEnabled(false);
                } else {
                    pantallaModificarEmpleado.BtnBuscarModificar.setEnabled(true);
                }
            }

        });

        this.pantallaModificarEmpleado.BtnModificarEmpleado.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    if (pantallaModificarEmpleado.BtnBuscarModificar.isEnabled()) {
                        int num_fila_empleado = pantallaModificarEmpleado.TblEmpleadoModificar.getSelectedRow();
                        int id = (int) pantallaModificarEmpleado.TblEmpleadoModificar.getValueAt(num_fila_empleado, 0);
                        Empleado empleado = new Empleado();
                        PantallaModificarDatosEmpleado pantallaModDatosEmp = new PantallaModificarDatosEmpleado();

                        for (int i = 0; i < empleado.listaEmpleados().size(); i++) {
                            if (empleado.listaEmpleados().get(i).getId_empleado() == id) {
                                empleado = empleado.listaEmpleados().get(i);

                            }
                        }

                        for (int i = 0; i <= 38; i++) {
                            pantallaModDatosEmp.CbxMesAñoEmpleado.insertItemAt(1960 + i + "", i);
                        }

                        pantallaModDatosEmp.CbxPuestoEmpleado.setSelectedItem(empleado.getPuesto());

                        pantallaModDatosEmp.LblCodigoEmpleadoMod.setText(id + "");
                        pantallaModDatosEmp.TxtNombreEmpleado.setText(empleado.getNombre());

                        pantallaModDatosEmp.TxtApellidoPaternoEmpleado.setText(empleado.getApellido_Paterno());
                        pantallaModDatosEmp.TxtApellidoMaternoEmpleado.setText(empleado.getApellido_Materno());

                        String fecha[] = empleado.getFecha_Nacimiento().split("-");
                        String año = fecha[0];
                        String mes = fecha[1];
                        String dia = fecha[2];

                        pantallaModDatosEmp.CbxDiaNacimientoEmpleado.setSelectedItem(dia);
                        pantallaModDatosEmp.CbxMesAñoEmpleado.setSelectedItem(año);
                        pantallaModDatosEmp.CbxMesNacimientoEmpleado.setSelectedItem(mesLetra(mes));
                        pantallaModDatosEmp.TxtTelefonoEmpleado.setText(empleado.getTelefono());
                        pantallaModDatosEmp.TxtCelularEmplado.setText(empleado.getCelular());
                        pantallaModDatosEmp.TxtCalleEmpleado.setText(empleado.getCalle_Direccion());
                        pantallaModDatosEmp.TxtColoniaEmpleado.setText(empleado.getColonia_Direccion());
                        pantallaModDatosEmp.TxtCpDireccionEmpleado.setText(empleado.getCp() + "");
                        pantallaModDatosEmp.TxtNumeroEmpleado.setText(empleado.getNumero_Direccion());
                        pantallaModDatosEmp.TxtSueldoEmpleado.setText(empleado.getSueldo() + "");

                        Login usuario = new Login();
                        if (pantallaModDatosEmp.CbxPuestoEmpleado.getSelectedItem().equals("Gerente") | pantallaModDatosEmp.CbxPuestoEmpleado.getSelectedItem().equals("Cajero") | pantallaModDatosEmp.CbxPuestoEmpleado.getSelectedItem().equals("Mesero")) {
                            for (int i = 0; i < usuario.listaUsuarios().size(); i++) {
                                if (usuario.listaUsuarios().get(i).getId_empleado() == id) {
                                    usuario = usuario.listaUsuarios().get(i);
                                }
                            }
                            pantallaModDatosEmp.TxtUsuarioEmpleado.setEnabled(false);
                            pantallaModDatosEmp.TxtUsuarioEmpleado.setText(usuario.getUsuario());
                            pantallaModDatosEmp.txtContraseñaMod.setText(usuario.getContraseña());
                            pantallaModDatosEmp.TxtContraseñaRepMod.setText(usuario.getContraseña());
                        } else {
                            pantallaModDatosEmp.TxtUsuarioEmpleado.setEnabled(false);
                            pantallaModDatosEmp.txtContraseñaMod.setEnabled(false);
                            pantallaModDatosEmp.TxtContraseñaRepMod.setEnabled(false);
                        }

                        ControladorModificarDatosEmpleado controladorModDatosEmp = new ControladorModificarDatosEmpleado(pantallaModificarEmpleado, pantallaModDatosEmp, empleado, usuario);
                        pantallaModificarEmpleado.dispose();
                        pantallaModDatosEmp.setLocationRelativeTo(null);
                        pantallaModDatosEmp.setVisible(true);
                    }
                } catch (Exception ex) {
                    pantallaModificarEmpleado.LbllMensajeError.setText("Error, no seleccionó una fila");
                    pantallaModificarEmpleado.DialogoMensajeError.setLocationRelativeTo(null);
                    pantallaModificarEmpleado.DialogoMensajeError.setVisible(true);
                }

            }
        });

        this.pantallaModificarEmpleado.BtnBuscarModificar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (pantallaModificarEmpleado.BtnBuscarModificar.isEnabled()) {
                    limpiarTabla(pantallaModificarEmpleado.TblEmpleadoModificar);
                    boolean porNombre = pantallaModificarEmpleado.RbBtnNomEmpleadoModificar.isSelected();
                    boolean porCodigo = pantallaModificarEmpleado.RdBtnCodEmpleadoModificar.isSelected();
                    boolean encontrado = false;
                    Empleado empleado = new Empleado();
                    ArrayList<Empleado> listaEmpleado = empleado.listaEmpleados();
                    if (porNombre) {
                        if (pantallaModificarEmpleado.TxtNombreEmpleadoModificar.getText().matches("([àèìòùáéíóúa-zA-Z]+[ ]*)+")) {
                            for (int i = 0; i < listaEmpleado.size(); i++) {
                                if (pantallaModificarEmpleado.TxtNombreEmpleadoModificar.getText().toUpperCase().replace(" ", "").equals(empleado.listaEmpleados().get(i).getNombre().toUpperCase().replace(" ", ""))) {
                                    agregarAlaTabla(listaEmpleado.get(i));
                                    encontrado = true;
                                }
                            }
                            if (!encontrado) {
                                pantallaModificarEmpleado.TxtNombreEmpleadoModificar.setText("");
                                pantallaModificarEmpleado.LbllMensajeError.setText("No se encontró el empleado");
                                pantallaModificarEmpleado.DialogoMensajeError.setLocationRelativeTo(null);
                                pantallaModificarEmpleado.DialogoMensajeError.setVisible(true);
                            }
                        } else {
                            //Ventana de mensajeeee
                            pantallaModificarEmpleado.TxtNombreEmpleadoModificar.setText("");
                            pantallaModificarEmpleado.LbllMensajeError.setText("Nombre inválido");
                            pantallaModificarEmpleado.DialogoMensajeError.setLocationRelativeTo(null);
                            pantallaModificarEmpleado.DialogoMensajeError.setVisible(true);
                        }

                    }
                    if (porCodigo) {
                        //ArrayList<Empleado> listaEmpleado = empleado.listaEmpleados();
                        if (pantallaModificarEmpleado.TxtCodigoEmpleadoModificar.getText().matches("[0-9]+")) {
                            for (int i = 0; i < listaEmpleado.size(); i++) {
                                if (Integer.parseInt(pantallaModificarEmpleado.TxtCodigoEmpleadoModificar.getText()) == (empleado.listaEmpleados().get(i).getId_empleado())) {
                                    agregarAlaTabla(listaEmpleado.get(i));
                                    encontrado = true;
                                }
                            }
                            if (!encontrado) {
                                pantallaModificarEmpleado.TxtCodigoEmpleadoModificar.setText("");
                                pantallaModificarEmpleado.LbllMensajeError.setText("No se encontró el empleado");
                                pantallaModificarEmpleado.DialogoMensajeError.setLocationRelativeTo(null);
                                pantallaModificarEmpleado.DialogoMensajeError.setVisible(true);
                            }
                        } else {
                            pantallaModificarEmpleado.TxtCodigoEmpleadoModificar.setText("");
                            pantallaModificarEmpleado.LbllMensajeError.setText("Código inválido");
                            pantallaModificarEmpleado.DialogoMensajeError.setLocationRelativeTo(null);
                            pantallaModificarEmpleado.DialogoMensajeError.setVisible(true);
                        }
                    }
                    if (pantallaModificarEmpleado.TblEmpleadoModificar.getRowCount() > 0) {
                        pantallaModificarEmpleado.BtnModificarEmpleado.setEnabled(true);
                    } else {
                        pantallaModificarEmpleado.BtnModificarEmpleado.setEnabled(false);
                    }
                }
            }

        });

        this.pantallaModificarEmpleado.BtnAceptarMensajeErrores.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pantallaModificarEmpleado.DialogoMensajeError.dispose();
            }
        });
        
        this.pantallaModificarEmpleado.BtnAceptarMensajeErrores.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    pantallaModificarEmpleado.DialogoMensajeError.setVisible(false);
                }
            }
        });

        this.pantallaModificarEmpleado.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                pantallaModificarEmpleado.dispose();
                pantallaPrincipal.setVisible(true);
            }
        });

    }

    public void agregarAlaTabla(Empleado objEmpleado) {
        DefaultTableModel modelo = (DefaultTableModel) pantallaModificarEmpleado.TblEmpleadoModificar.getModel();
        Object[] fila = new Object[4];
        fila[0] = objEmpleado.getId_empleado();
        fila[1] = objEmpleado.getNombre();
        fila[2] = objEmpleado.getApellido_Paterno();
        fila[3] = objEmpleado.getApellido_Materno();
        modelo.addRow(fila);
        pantallaModificarEmpleado.TblEmpleadoModificar.setModel(modelo);
    }

    public void limpiarTabla(JTable tabla) {
        try {
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            int filas = tabla.getRowCount();
            for (int i = 0; filas > i; i++) {
                modelo.removeRow(0);
            }
        } catch (Exception e) {
            pantallaModificarEmpleado.LbllMensajeError.setText("Error al limpiar la tabla");
            pantallaModificarEmpleado.DialogoMensajeError.setLocationRelativeTo(null);
            pantallaModificarEmpleado.DialogoMensajeError.setVisible(true);

        }
    }

    public String mesLetra(String mes) {
        if (mes.equals("01")) {
            return "Enero";
        }
        if (mes.equals("02")) {
            return "Febrero";
        }
        if (mes.equals("03")) {
            return "Marzo";
        }
        if (mes.equals("04")) {
            return "Abril";
        }
        if (mes.equals("05")) {
            return "Mayo";
        }
        if (mes.equals("06")) {
            return "Junio";
        }
        if (mes.equals("07")) {
            return "Julio";
        }
        if (mes.equals("08")) {
            return "Agosto";
        }
        if (mes.equals("09")) {
            return "Septiembre";
        }
        if (mes.equals("10")) {
            return "Octubre";
        }
        if (mes.equals("11")) {
            return "Noviembre";
        }
        if (mes.equals("12")) {
            return "Diciembre";
        }
        return null;
    }

}
