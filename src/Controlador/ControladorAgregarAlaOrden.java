/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Detalle_orden;
import Modelo.Menu;
import Modelo.ModificarOrden;
import Vista.*;
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
 * @author Alexis Salvador
 */
public class ControladorAgregarAlaOrden {

    PantallaAgregarAlaOrden pantallaAgregar;
    PantallaModificarOrden pantallaModificar;
    ModificarOrden modificarOrden;

    public ControladorAgregarAlaOrden(PantallaAgregarAlaOrden pantallaAgregarAlaOrden, PantallaModificarOrden pantallaModOrden, ModificarOrden modifOrden) {
        this.pantallaAgregar = pantallaAgregarAlaOrden;
        this.pantallaModificar = pantallaModOrden;
        this.modificarOrden = modifOrden;

        this.pantallaAgregar.BtnAgregarCodigoMenu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    String codigo_menu = pantallaAgregar.TxtCodigoMenu.getText();
                    int cantidad = Integer.parseInt(pantallaAgregar.SpinnerCantidadCodMenu.getValue().toString());
                    Menu menu = modifOrden.BuscarPorCodigo(codigo_menu);

                    if (!menu.getNombre().equals("")) {
                        agregarAlaTabla(menu, cantidad);
                        agregarAlaTablaTotal(calcularTotalColumna(pantallaModificar.TblModOrden, 4));
                        pantallaAgregar.TxtCodigoMenu.setText("");
                    } else {
                        pantallaAgregarAlaOrden.LbllMensajeError.setText("El código del menú no fue encontrado");
                        pantallaAgregarAlaOrden.DialogoMensajeError.setLocationRelativeTo(null);
                        pantallaAgregarAlaOrden.DialogoMensajeError.setVisible(true);
                    }
                } catch (Exception ex) {
                    pantallaAgregarAlaOrden.LbllMensajeError.setText("El código del menú no fue encontrado");
                    pantallaAgregarAlaOrden.DialogoMensajeError.setLocationRelativeTo(null);
                    pantallaAgregarAlaOrden.DialogoMensajeError.setVisible(true);
                    //JOptionPane.showMessageDialog(null, "El código del menú no fue encontrado\nPor favor verifique nuevamente");
                }
            }
        });

        this.pantallaAgregar.BtnAceptarMensajeErrores.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pantallaAgregarAlaOrden.DialogoMensajeError.setVisible(false);
            }

        });

        this.pantallaAgregar.BtnAceptarMensajeErrores.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    pantallaAgregarAlaOrden.DialogoMensajeError.dispose();
                }
            }
        });

        this.pantallaAgregar.BtnAgregarBebida.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                String nombre_menu = pantallaAgregar.CbxBebida.getSelectedItem().toString();
                int cantidad = Integer.parseInt(pantallaAgregar.SpinnerCantidadPostre.getValue().toString());
                Menu menu = modificarOrden.BuscarPorNombre(nombre_menu);
                agregarAlaTabla(menu, cantidad);
                agregarAlaTablaTotal(calcularTotalColumna(pantallaModificar.TblModOrden, 4));
            }
        });

        this.pantallaAgregar.BtnAgregarPlatillo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String nombre_menu = pantallaAgregar.CbxPlatillo.getSelectedItem().toString();
                int cantidad = Integer.parseInt(pantallaAgregar.SpinnerCantidadPlatillo.getValue().toString());
                Menu menu = modificarOrden.BuscarPorNombre(nombre_menu);
                agregarAlaTabla(menu, cantidad);
                agregarAlaTablaTotal(calcularTotalColumna(pantallaModificar.TblModOrden, 4));
            }
        });

        this.pantallaAgregar.BtnAgregarPostre.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String nombre_menu = pantallaAgregar.CbxPostre.getSelectedItem().toString();
                int cantidad = Integer.parseInt(pantallaAgregar.SpinnerCantidadPostre.getValue().toString());
                Menu menu = modificarOrden.BuscarPorNombre(nombre_menu);
                agregarAlaTabla(menu, cantidad);
                agregarAlaTablaTotal(calcularTotalColumna(pantallaModificar.TblModOrden, 4));
            }
        });

        this.pantallaAgregar.BtnRegresar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pantallaAgregar.dispose();
                pantallaModOrden.setVisible(true);

            }
        });

        this.pantallaAgregar.BtnAceptarMensajeExito.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pantallaAgregar.DialogoMensajeExito.setVisible(false);

            }
        });
        
        this.pantallaAgregar.BtnAceptarMensajeExito.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    pantallaAgregarAlaOrden.DialogoMensajeExito.dispose();
                }
            }
        });


        pantallaAgregar.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                pantallaAgregar.dispose();
                pantallaModOrden.setVisible(true);
            }
        });
    }

    public void agregarAlaTabla(Menu objMenu, int cantidad) {
        DefaultTableModel modelo = (DefaultTableModel) pantallaModificar.TblModOrden.getModel();
        String nombre = objMenu.getCodigo_menu();
        boolean existe = false;
        int filaExiste = 0;
        for (int i = 0; i < pantallaModificar.TblModOrden.getRowCount(); i++) {
            String comparar = String.valueOf(pantallaModificar.TblModOrden.getValueAt(i, 0));
            if (comparar.equals(nombre)) {
                existe = true;
                filaExiste = i;
            }
        }
        if (existe) {
            pantallaModificar.TblModOrden.setValueAt(cantidad, filaExiste, 2);
            pantallaModificar.TblModOrden.setValueAt((cantidad * objMenu.getPrecio_unitario()), filaExiste, 4);
            pantallaAgregar.DialogoMensajeExito.setVisible(true);
        } else {
            Object[] fila = new Object[5];
            fila[0] = objMenu.getCodigo_menu();
            //fila[1] = objMenu.getTipo();
            fila[1] = objMenu.getNombre();
            fila[2] = cantidad;
            fila[3] = objMenu.getPrecio_unitario();
            fila[4] = objMenu.getPrecio_unitario() * cantidad;
            modelo.addRow(fila);
            pantallaModificar.TblModOrden.setModel(modelo);
            pantallaAgregar.DialogoMensajeExito.setVisible(true);
        }
    }

    public void agregarAlaTablaTotal(double total) {
        DefaultTableModel modelo = (DefaultTableModel) pantallaModificar.TblModOrdenTotal.getModel();
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
        pantallaModificar.TblModOrdenTotal.setModel(modelo);
    }

    public double calcularTotalColumna(JTable tabla, int columna) {
        double total = 0;
        for (int i = 0; i < tabla.getRowCount(); i++) {
            double precioUnitario = Double.parseDouble(String.valueOf(tabla.getValueAt(i, columna)));
            total += precioUnitario;
        }
        return total;
    }

    public ArrayList<Detalle_orden> arregloDetalleOrden(JTable tabla, int numero_orden) {
        ArrayList<Detalle_orden> arreglo = new ArrayList();
        for (int i = 0; i < tabla.getRowCount(); i++) {
            String codigo_menu = String.valueOf(tabla.getValueAt(i, 0));
            int cantidad = Integer.parseInt(String.valueOf(tabla.getValueAt(i, 3)));
            double subtotal = Double.parseDouble(String.valueOf(tabla.getValueAt(i, 5)));
            Detalle_orden objeto = new Detalle_orden(codigo_menu, numero_orden, cantidad, subtotal);
            arreglo.add(objeto);
        }
        return arreglo;
    }
}
