/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Detalle_orden;
import Modelo.Menu;
import Modelo.TomarOrden;
import Vista.PantallaMenuMesero;
import Vista.PantallaTomarOrden;
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
public class ControladorTomarOrden {

    PantallaTomarOrden pantallaTomarOrden;
    TomarOrden orden;

    public ControladorTomarOrden(PantallaMenuMesero pantallaPrincipal, PantallaTomarOrden pantalla_TomarOrden, TomarOrden orden, String usuario) {

        this.pantallaTomarOrden = pantalla_TomarOrden;
        this.orden = orden;

        this.pantallaTomarOrden.BtnAgregarPorCodigo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    String codigo_menu = pantallaTomarOrden.TxtCodigoMenu.getText();
                    int cantidad = Integer.parseInt(pantallaTomarOrden.SpinnerCantidadCodigoMenu.getValue().toString());
                    Menu menu = orden.BuscarPorCodigo(codigo_menu);

                    if (!menu.getNombre().equals("")) {
                        agregarAlaTabla(menu, cantidad);
                        agregarAlaTablaTotal(calcularTotalColumna(pantallaTomarOrden.TblOrden, 5));
                        pantallaTomarOrden.TxtCodigoMenu.setText("");
                    } else {
                        pantallaTomarOrden.LbllMensajeError.setText("Código no encontrado");
                        pantallaTomarOrden.setLocationRelativeTo(null);
                        pantallaTomarOrden.DialogoMensajeError.setVisible(true);
                    }

                } catch (Exception ex) {
                    pantallaTomarOrden.LbllMensajeError.setText("El código del menú no fue encontrado");
                        pantallaTomarOrden.setLocationRelativeTo(null);
                        pantallaTomarOrden.DialogoMensajeError.setVisible(true);
                    
                }
            }
        });

        this.pantallaTomarOrden.BtnAgregarPlatillo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //String codigo_menu = pantallaTomarOrden.TxtCodigoMenu.getText();
                String nombre_menu = pantallaTomarOrden.CbxPlatillo.getSelectedItem().toString();
                int cantidad = Integer.parseInt(pantallaTomarOrden.SpinnerCantidadPlatillo.getValue().toString());
                Menu menu = orden.BuscarPorNombre(nombre_menu);
                agregarAlaTabla(menu, cantidad);
                agregarAlaTablaTotal(calcularTotalColumna(pantallaTomarOrden.TblOrden, 5));
            }
        });

        this.pantallaTomarOrden.BtnAgregarBebida.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //String codigo_menu = pantallaTomarOrden.TxtCodigoMenu.getText();
                String nombre_menu = pantallaTomarOrden.CbxBebida.getSelectedItem().toString();
                int cantidad = Integer.parseInt(pantallaTomarOrden.SpinnerCantidadBebida.getValue().toString());
                Menu menu = orden.BuscarPorNombre(nombre_menu);
                agregarAlaTabla(menu, cantidad);
                agregarAlaTablaTotal(calcularTotalColumna(pantallaTomarOrden.TblOrden, 5));
            }
        });

        this.pantallaTomarOrden.BtnAgregarPostre.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String nombre_menu = pantallaTomarOrden.CbxPostre.getSelectedItem().toString();
                int cantidad = Integer.parseInt(pantallaTomarOrden.SpinnerCantidadPostre.getValue().toString());
                Menu menu = orden.BuscarPorNombre(nombre_menu);
                agregarAlaTabla(menu, cantidad);
                agregarAlaTablaTotal(calcularTotalColumna(pantallaTomarOrden.TblOrden, 5));
            }
        });

        this.pantallaTomarOrden.BtnRegresarOrden.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pantallaTomarOrden.dispose();
                pantallaPrincipal.setVisible(true);
            }
        });

        this.pantallaTomarOrden.BtnRegistrarOrden.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (pantallaTomarOrden.CbxNumeroDeMesa.getSelectedObjects().length > 0) {
                    System.out.println("Haber que: " + pantallaTomarOrden.CbxNumeroDeMesa.getSelectedObjects().length);
                    int numero_mesa = Integer.parseInt(pantallaTomarOrden.CbxNumeroDeMesa.getSelectedItem().toString());
                    if (pantallaTomarOrden.TblOrden.getRowCount() > 0) {
                        double total = calcularTotalColumna(pantallaTomarOrden.TblOrden, 5);
                        int numeroMesero = orden.obtenerNumeroMesero(usuario);

                        orden.insertarOrden(total, numeroMesero, numero_mesa);
                        int numeroOrden = orden.obtenerNumeroOrden();

                        ArrayList<Detalle_orden> detalle_orden = arregloDetalleOrden(pantallaTomarOrden.TblOrden, numeroOrden);
                        for (int i = 0; i < detalle_orden.size(); i++) {
                            String codigo_menu = detalle_orden.get(i).getCodigo_menu();
                            int numero_orden = detalle_orden.get(i).getNumero_orden();
                            int cantidad = detalle_orden.get(i).getCantidad();
                            double subtotal = detalle_orden.get(i).getSubtotal();
                            orden.insertarDetalle_Orden(codigo_menu, numero_orden, cantidad, subtotal);
                        }
                        orden.cambiarStatusDeMesaOcupado(numero_mesa);
                        
                        pantallaTomarOrden.DialogoPregunta.setLocationRelativeTo(null);
                        pantallaTomarOrden.DialogoPregunta.setVisible(true);

//                        JOptionPane.showMessageDialog(null, "Orden Registrada Correctamente");
//                        pantallaTomarOrden.dispose();
//                        pantallaPrincipal.setVisible(true);

                    } else {
                        JOptionPane.showMessageDialog(null, "La orden no contiene ningún elemento del menú");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No existen mesas Disponibles para Crear la Orden");
                }
            }
        });
        
        pantallaTomarOrden.jBtnActualizarsi.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                 
                 
                        pantallaTomarOrden.DialogoPregunta.dispose();
                        pantallaPrincipal.setVisible(true);
                        pantalla_TomarOrden.DialogoMensajeExito.setVisible(true);
            }
            
        });
        
        pantallaTomarOrden.jBtnActualizarno.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pantallaTomarOrden.DialogoPregunta.dispose();
            }
            
        });
        
        pantallaTomarOrden.BtnAceptarMensajeErrores.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pantallaTomarOrden.DialogoMensajeError.dispose();
            }
            
        });
        
        this.pantallaTomarOrden.BtnAceptarMensajeErrores.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    pantallaTomarOrden.DialogoMensajeError.setVisible(false);
                }
            }
        });
        
        pantallaTomarOrden.BtnAceptarMensajeExito.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pantallaTomarOrden.DialogoMensajeExito.dispose();
                pantallaTomarOrden.dispose();
                pantallaPrincipal.setVisible(true);
            }
            
        });
        
        this.pantallaTomarOrden.BtnAceptarMensajeExito.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    pantallaTomarOrden.DialogoMensajeExito.setVisible(false);
                }
            }
        });

        pantallaTomarOrden.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                pantallaTomarOrden.dispose();
                pantallaPrincipal.setVisible(true);
            }
        });
        
        

    }

    public void agregarAlaTabla(Menu objMenu, int cantidad) {
        DefaultTableModel modelo = (DefaultTableModel) pantallaTomarOrden.TblOrden.getModel();
        String nombre = objMenu.getCodigo_menu();
        boolean existe = false;
        int filaExiste = 0;
        for (int i = 0; i < pantallaTomarOrden.TblOrden.getRowCount(); i++) {
            String comparar = String.valueOf(pantallaTomarOrden.TblOrden.getValueAt(i, 0));
            if (comparar.equals(nombre)) {
                existe = true;
                filaExiste = i;
            }
        }
        if (existe) {
            pantallaTomarOrden.TblOrden.setValueAt(cantidad, filaExiste, 3);
            pantallaTomarOrden.TblOrden.setValueAt((cantidad * objMenu.getPrecio_unitario()), filaExiste, 5);
        } else {
            Object[] fila = new Object[6];
            fila[0] = objMenu.getCodigo_menu();
            fila[1] = objMenu.getTipo();
            fila[2] = objMenu.getNombre();
            fila[3] = cantidad;
            fila[4] = objMenu.getPrecio_unitario();
            fila[5] = objMenu.getPrecio_unitario() * cantidad;
            modelo.addRow(fila);
            pantallaTomarOrden.TblOrden.setModel(modelo);
        }
    }

    public void agregarAlaTablaTotal(double total) {
        DefaultTableModel modelo = (DefaultTableModel) pantallaTomarOrden.TblOrdenTotal.getModel();
        Object[] fila = new Object[6];
        fila[0] = "";
        fila[1] = "";
        fila[2] = "";
        fila[3] = "";
        fila[4] = "Total: ";
        fila[5] = total;

        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
        }
        modelo.addRow(fila);
        pantallaTomarOrden.TblOrdenTotal.setModel(modelo);
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
