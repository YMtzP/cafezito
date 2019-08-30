/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.DatosOrden;
import Modelo.Menu;
import Modelo.ModificarOrden;
import Vista.PantallaAgregarAlaOrden;
import Vista.PantallaMenuMesero;
import Vista.PantallaModificarOrden;
import Vista.PantallaTomarOrden;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alexis Salvador
 */
public class ControladorModificarOrden {

    PantallaModificarOrden pantallaModificarOrden;
    ModificarOrden modOrden;
    int numero_orden;

    public ControladorModificarOrden(PantallaMenuMesero pantallaPrincipal, PantallaModificarOrden pantalla_ModificaOrden, ModificarOrden modificarOrden) {
        this.pantallaModificarOrden = pantalla_ModificaOrden;
        this.modOrden = modificarOrden;

        this.pantallaModificarOrden.RbtnNumOrden.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

                if (pantallaModificarOrden.RbtnNumOrden.isSelected()) {
                    pantallaModificarOrden.TxtNumeroOrden.setEnabled(true);
                    pantallaModificarOrden.CbxNumeroMesaModOrden.setEnabled(false);
                } else {
                    pantallaModificarOrden.CbxNumeroMesaModOrden.setEnabled(true);
                    pantallaModificarOrden.TxtNumeroOrden.setEnabled(false);
                }

            }
        });

        this.pantallaModificarOrden.BtnAgregarModOrden.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (pantallaModificarOrden.BtnAgregarModOrden.isEnabled()) {
                    PantallaAgregarAlaOrden pantallaAgregarModificarOrden = new PantallaAgregarAlaOrden();
                    ArrayList bebidas = modOrden.obtenerListaNombres("Bebida");
                    ArrayList platilos = modOrden.obtenerListaNombres("Platillo");
                    ArrayList postres = modOrden.obtenerListaNombres("Postre");

                    pantallaAgregarModificarOrden.CbxBebida.removeAllItems();
                    pantallaAgregarModificarOrden.CbxPlatillo.removeAllItems();
                    pantallaAgregarModificarOrden.CbxPostre.removeAllItems();

                    for (int i = 0; i < bebidas.size(); i++) {
                        pantallaAgregarModificarOrden.CbxBebida.addItem(bebidas.get(i).toString());
                    }

                    for (int i = 0; i < postres.size(); i++) {
                        pantallaAgregarModificarOrden.CbxPostre.addItem(postres.get(i).toString());
                    }

                    for (int i = 0; i < platilos.size(); i++) {
                        pantallaAgregarModificarOrden.CbxPlatillo.addItem(platilos.get(i).toString());
                    }

                    ControladorAgregarAlaOrden controlador = new ControladorAgregarAlaOrden(pantallaAgregarModificarOrden, pantallaModificarOrden, modOrden);
                    pantallaModificarOrden.setVisible(false);
                    pantallaAgregarModificarOrden.setLocationRelativeTo(null);
                    pantallaAgregarModificarOrden.setVisible(true);

                }
            }

        });

        this.pantallaModificarOrden.BtnBuscarModOrden.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (pantallaModificarOrden.RbtnNumOrden.isSelected()) {
                    try {
                        int num_orden = Integer.parseInt(pantallaModificarOrden.TxtNumeroOrden.getText());

                        ArrayList<DatosOrden> orden = modOrden.obtenerDatosDeOrden(num_orden);
                        if (orden.isEmpty()) {
                            pantallaModificarOrden.LbllMensajeError.setText("No se encontró información");
                            pantallaModificarOrden.DialogoMensajeError.setLocationRelativeTo(null);
                            pantallaModificarOrden.DialogoMensajeError.setVisible(true);

                            pantallaModificarOrden.BtnAgregarModOrden.setEnabled(false);
                            pantallaModificarOrden.BtnGuardarModOrden.setEnabled(false);
                            pantallaModificarOrden.BtnModificarModOrden.setEnabled(false);
                            pantallaModificarOrden.BtnEliminarModOrden.setEnabled(false);

                        } else {
                            numero_orden = num_orden;
                            agregarAlaTabla(orden);
                            agregarAlaTablaTotal(calcularTotalColumna(pantallaModificarOrden.TblModOrden, 4));
                            pantallaModificarOrden.BtnAgregarModOrden.setEnabled(true);
                            pantallaModificarOrden.BtnGuardarModOrden.setEnabled(true);
                            pantallaModificarOrden.BtnModificarModOrden.setEnabled(true);
                            pantallaModificarOrden.BtnEliminarModOrden.setEnabled(true);
                        }
                    } catch (Exception ex) {
                        pantallaModificarOrden.LbllMensajeError.setText("Campo numero de orden vacío");
                        pantallaModificarOrden.DialogoMensajeError.setLocationRelativeTo(null);
                        pantallaModificarOrden.DialogoMensajeError.setVisible(true);
                    }

                } else if (pantallaModificarOrden.CbxNumeroMesaModOrden.getSelectedItem() != null) {
                    int num_mesa = Integer.parseInt(pantallaModificarOrden.CbxNumeroMesaModOrden.getSelectedItem().toString());
                    ArrayList<DatosOrden> orden = modOrden.obtenerDatosDeOrdenPorMesa(num_mesa);
                    numero_orden = modOrden.obtenerNumeroOrden(num_mesa);

                    if (orden.isEmpty()) {
                        pantallaModificarOrden.LbllMensajeError.setText("No se encontró información");
                        pantallaModificarOrden.DialogoMensajeError.setLocationRelativeTo(null);
                        pantallaModificarOrden.DialogoMensajeError.setVisible(true);

                        pantallaModificarOrden.BtnAgregarModOrden.setEnabled(false);
                        pantallaModificarOrden.BtnGuardarModOrden.setEnabled(false);
                        pantallaModificarOrden.BtnModificarModOrden.setEnabled(false);
                        pantallaModificarOrden.BtnEliminarModOrden.setEnabled(false);
                    } else {
                        agregarAlaTabla(orden);
                        agregarAlaTablaTotal(calcularTotalColumna(pantallaModificarOrden.TblModOrden, 4));
                        pantallaModificarOrden.BtnAgregarModOrden.setEnabled(true);
                        pantallaModificarOrden.BtnGuardarModOrden.setEnabled(true);
                        pantallaModificarOrden.BtnModificarModOrden.setEnabled(true);
                        pantallaModificarOrden.BtnEliminarModOrden.setEnabled(true);

                    }
                } else {
                    pantallaModificarOrden.LbllMensajeError.setText("No existen mesas con ordenes disponibles para modificar");
                    pantallaModificarOrden.DialogoMensajeError.setLocationRelativeTo(null);
                    pantallaModificarOrden.DialogoMensajeError.setVisible(true);

                }

            }
        });

        this.pantallaModificarOrden.BtnEliminarModOrden.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (pantallaModificarOrden.BtnEliminarModOrden.isEnabled()) {
                    try {
                        DefaultTableModel modelo = (DefaultTableModel) pantallaModificarOrden.TblModOrden.getModel();
                        int filaEliminar = pantallaModificarOrden.TblModOrden.getSelectedRow();
                        if (modelo.getRowCount() < 2) {
                            pantallaModificarOrden.LbllMensajeError.setText("La orden no puede quedar vacía");
                            pantallaModificarOrden.DialogoMensajeError.setLocationRelativeTo(null);
                            pantallaModificarOrden.DialogoMensajeError.setVisible(true);

                        } else {
                            modelo.removeRow(filaEliminar);
                            pantallaModificarOrden.TblModOrden.setModel(modelo);
                            agregarAlaTablaTotal(calcularTotalColumna(pantallaModificarOrden.TblModOrden, 4));
                        }
                    } catch (Exception ex) {
                        pantallaModificarOrden.LbllMensajeError.setText("No se encontró ifila para eliminar");
                        pantallaModificarOrden.DialogoMensajeError.setLocationRelativeTo(null);
                        pantallaModificarOrden.DialogoMensajeError.setVisible(true);

                    }
                }
            }
        });

        this.pantallaModificarOrden.BtnGuardarModOrden.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    if (pantallaModificarOrden.BtnGuardarModOrden.isEnabled()) {
                        modificarOrden.eliminarDetalleOrden(numero_orden);
                        insertarDatosDeTabla(pantallaModificarOrden.TblModOrden, numero_orden);
                        modOrden.modificarTotalOrden(calcularTotalColumna(pantallaModificarOrden.TblModOrden, 4), numero_orden);
                        pantalla_ModificaOrden.DialogoMensajeExito.setLocationRelativeTo(null);
                        pantallaModificarOrden.DialogoMensajeExito.setVisible(true);

                        pantallaModificarOrden.dispose();
                        pantallaPrincipal.setVisible(true);
                    }
                } catch (Exception ex) {

                }

            }
        });

        this.pantallaModificarOrden.BtnModificarModOrden.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    int fila = pantallaModificarOrden.TblModOrden.getSelectedRow();
                    String platillo = (String) pantallaModificarOrden.TblModOrden.getValueAt(fila, 1);
                    pantallaModificarOrden.LblPlatillo.setText("Nombre: " + platillo);
                    pantallaModificarOrden.PantallaModificarCantidad.setVisible(true);
                } catch (Exception ex) {
                    pantallaModificarOrden.LbllMensajeError.setText("Debe seleccionar una fila");
                    pantallaModificarOrden.DialogoMensajeError.setLocationRelativeTo(null);
                    pantallaModificarOrden.DialogoMensajeError.setVisible(true);
                }

            }
        });

        this.pantallaModificarOrden.BtnModificarAceptar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                int fila = pantallaModificarOrden.TblModOrden.getSelectedRow();
                int canti = Integer.parseInt(pantallaModificarOrden.SpinnerModificarCantidad.getValue().toString());
                pantallaModificarOrden.TblModOrden.setValueAt(canti, fila, 2);
                pantallaModificarOrden.PantallaModificarCantidad.setVisible(false);
                Menu objMenu = modOrden.BuscarPorCodigo(pantallaModificarOrden.TblModOrden.getValueAt(fila, 0).toString());
                double subtotal = canti * objMenu.getPrecio_unitario();
                pantallaModificarOrden.TblModOrden.setValueAt(subtotal, fila, 4);
                agregarAlaTablaTotal(calcularTotalColumna(pantallaModificarOrden.TblModOrden, 4));

            }
        });

        this.pantallaModificarOrden.BtnRegresarModOrden.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pantallaModificarOrden.dispose();
                pantallaPrincipal.setVisible(true);
            }
        });

        this.pantallaModificarOrden.BtnRegresar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pantallaModificarOrden.PantallaModificarCantidad.setVisible(false);
                //pantallaPrincipal.setVisible(true);
            }
        });

        pantallaModificarOrden.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                pantallaModificarOrden.dispose();
                pantallaPrincipal.setVisible(true);
            }
        });

        pantallaModificarOrden.BtnAceptarMensajeErrores.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pantalla_ModificaOrden.DialogoMensajeError.setVisible(false);
            }

        });

        this.pantallaModificarOrden.BtnAceptarMensajeErrores.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    pantallaModificarOrden.DialogoMensajeError.setVisible(false);
                }
            }
        });

        pantallaModificarOrden.BtnAceptarMensajeExito.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pantalla_ModificaOrden.DialogoMensajeExito.setVisible(false);
            }

        });

        this.pantallaModificarOrden.BtnAceptarMensajeExito.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    pantallaModificarOrden.DialogoMensajeExito.setVisible(false);
                }
            }
        });

    }

    public void agregarAlaTabla(ArrayList<DatosOrden> datosOrden) {
        DefaultTableModel modelo = (DefaultTableModel) pantallaModificarOrden.TblModOrden.getModel();
        //System.out.println("Total de filas: " + modelo.getRowCount());
        int filasTabla = modelo.getRowCount();
        for (int i = 0; filasTabla > i; i++) {
            modelo.removeRow(0);
        }

        for (int i = 0; i < datosOrden.size(); i++) {
            DatosOrden orden = datosOrden.get(i);
            Object[] fila = new Object[5];
            fila[0] = orden.getCodigo_menu();
            fila[1] = orden.getNombre();
            fila[2] = orden.getCantidad();
            fila[3] = orden.getPrecio_unitario();
            fila[4] = orden.getSubtotal();
            modelo.addRow(fila);
        }

        pantallaModificarOrden.TblModOrden.setModel(modelo);

    }

    public double calcularTotalColumna(JTable tabla, int columna) {
        double total = 0;
        for (int i = 0; i < tabla.getRowCount(); i++) {
            double precioUnitario = Double.parseDouble(String.valueOf(tabla.getValueAt(i, columna)));
            total += precioUnitario;
        }
        return total;
    }

    public void agregarAlaTablaTotal(double total) {
        DefaultTableModel modelo = (DefaultTableModel) pantallaModificarOrden.TblModOrdenTotal.getModel();
        Object[] fila = new Object[5];
        fila[0] = "";
        fila[1] = "";
        fila[2] = "";
        fila[3] = "Total: ";
        fila[4] = total;
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
        }
        modelo.addRow(fila);
        pantallaModificarOrden.TblModOrdenTotal.setModel(modelo);
    }

    public void insertarDatosDeTabla(JTable tabla, int numero_orden) {
        for (int i = 0; i < tabla.getRowCount(); i++) {
            String codigo = (String) tabla.getValueAt(i, 0);
            int cantidad = (int) tabla.getValueAt(i, 2);
            double subtotal = (double) tabla.getValueAt(i, 4);
            modOrden.insertarDetalle_Orden(codigo, numero_orden, cantidad, subtotal);
        }
    }

}
