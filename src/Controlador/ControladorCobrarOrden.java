/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.PantallaMenuCajero;
import Vista.PantallaCobrarOrden;
import Modelo.TomarOrden;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jose_Morales
 */
public final class ControladorCobrarOrden {

    PantallaCobrarOrden pantallaCobrarOrden;
    ArrayList<Object> listaOrden = null;
    TomarOrden orden;
    String numero_mesa;
    String numero_orden;
    double total = 0;

    public ControladorCobrarOrden(PantallaCobrarOrden pantallaCobrarOrden, TomarOrden orden) {
        this.pantallaCobrarOrden = pantallaCobrarOrden;
        this.orden = orden;

        this.pantallaCobrarOrden.RbtnNumeroMesaCobrar.setSelected(true);
        this.cargarMesasDisponibles(this.pantallaCobrarOrden.CbxNumeroMesaOrden);
        this.pantallaCobrarOrden.TxtCobrarNumeroOrden.setEnabled(false);
        //this.pantallaCobrarOrden.BtnCobrar.setEnabled(false);

        this.pantallaCobrarOrden.btnAceptarOrdenCobrada.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    pantallaCobrarOrden.DialogMsjCobrarOrden.dispose();
                }
            }

        });
        
        this.pantallaCobrarOrden.RbtnNumeroMesaCobrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validaBusqueda();
            }
        });

        this.pantallaCobrarOrden.RbtnNumeroOrdenCobrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validaBusqueda();
            }
        });

        this.pantallaCobrarOrden.BtnCobrarBuscarOrden.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pantallaCobrarOrden.txtRecibidoCobrar.setText("");
                if (validarNumeroOrden(pantallaCobrarOrden.TxtCobrarNumeroOrden.getText())) {
                    if (pantallaCobrarOrden.RbtnNumeroOrdenCobrar.isSelected() && orden.existNumeroOrden(pantallaCobrarOrden.TxtCobrarNumeroOrden.getText())) {
                        llenarTabla(pantallaCobrarOrden.TblCobrar, pantallaCobrarOrden.TxtCobrarNumeroOrden.getText());
                        numero_orden = pantallaCobrarOrden.TxtCobrarNumeroOrden.getText();
                    } else if (pantallaCobrarOrden.RbtnNumeroMesaCobrar.isSelected()) {
                        numero_mesa = pantallaCobrarOrden.CbxNumeroMesaOrden.getSelectedItem().toString();
                        llenarTabla(pantallaCobrarOrden.TblCobrar, numero_mesa);
                    } else {
                        mostrarMensaje("¡El número de la orden No existe!");
                        limpiarTabla(pantallaCobrarOrden.TblCobrar);
                    }

                }
            }
        });

        this.pantallaCobrarOrden.BtnCobrar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if (pantallaCobrarOrden.TblCobrar.getRowCount() >= 1) {
                    String importe = pantallaCobrarOrden.txtRecibidoCobrar.getText();
                    if (importe.matches("([1-9])[0-9]+(([.])([0-9]{1,2})?)?")) {
                        double cambio = calcularCambio(redondeo(total), Double.parseDouble(importe));
                        if (cambio >= 0) {
                            pantallaCobrarOrden.LblCambioCobrar.setText("Cambio: $" + redondeo(cambio));
                            orden.cambiarStatusDeMesaDisponible(Integer.parseInt(numero_mesa));
                            orden.cambiarStatusOrden(Integer.parseInt(numero_orden));
                            mostrarMensaje("Se ha cobrado la orden con éxito");
                            validaBusqueda();
                            
                            ControladorTicket ticket = new ControladorTicket(pantallaCobrarOrden, listaOrden, numero_orden, total, importe, redondeo(cambio));
                            limpiarTabla(pantallaCobrarOrden.TblCobrar);
                            pantallaCobrarOrden.TxtCobrarNumeroOrden.setText("");
                            pantallaCobrarOrden.txtRecibidoCobrar.setText("");
                                                       
                        } else {
                            mostrarMensaje("Importe insuficiente");
                        }
                    } else {
                        mostrarMensaje("Importe no válido");
                    }
                } else {
                    mostrarMensaje("Sin datos de orden");
                    limpiarTabla(pantallaCobrarOrden.TblCobrar);
                }

            }
        });

        this.pantallaCobrarOrden.BtnRegresarCobrar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cerrarPantalla();
            }
        });
      
        this.pantallaCobrarOrden.btnAceptarOrdenCobrada.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pantallaCobrarOrden.DialogMsjCobrarOrden.setVisible(false);
            }
        });
        
        this.pantallaCobrarOrden.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                cerrarPantalla();
            }
        });

    }

    public void cerrarPantalla() {
        pantallaCobrarOrden.setVisible(false);
        pantallaCobrarOrden.dispose();
        PantallaMenuCajero menu = new PantallaMenuCajero();
        ControladorMenuCajero c = new ControladorMenuCajero(menu);
        menu.setVisible(true);
    }

    public void validaBusqueda() {
        if (pantallaCobrarOrden.RbtnNumeroMesaCobrar.isSelected()) {//Busqueda por número de mesa
            cargarMesasDisponibles(pantallaCobrarOrden.CbxNumeroMesaOrden);
            pantallaCobrarOrden.CbxNumeroMesaOrden.setEnabled(true);
            pantallaCobrarOrden.TxtCobrarNumeroOrden.setEnabled(false);
            pantallaCobrarOrden.TxtCobrarNumeroOrden.setText("");
        } else if (pantallaCobrarOrden.RbtnNumeroOrdenCobrar.isSelected()) { //Busqueda por número de orden
            pantallaCobrarOrden.TxtCobrarNumeroOrden.setEnabled(true);
            pantallaCobrarOrden.CbxNumeroMesaOrden.removeAllItems();
            pantallaCobrarOrden.CbxNumeroMesaOrden.setEnabled(false);
        }
    }

    public void cargarMesasDisponibles(JComboBox cbxMesa) {
        cbxMesa.removeAllItems();
        ArrayList listaMesas = new ArrayList();
        listaMesas = orden.obtenerListaMesasDispobinles("Ocupada");
        for (Object listaMesa : listaMesas) {
            cbxMesa.addItem(listaMesa);
        }
    }

    public boolean validarNumeroOrden(String numero) {
        String txtErrores = "  Verficar datos del Egreso\n";
        boolean errores = false;
        if ((pantallaCobrarOrden.RbtnNumeroOrdenCobrar.isSelected())) {
            if (!numero.matches("([1-9])+")) {
                txtErrores = "¡Número de orden no válido!";
                errores = true;
            }
        }

        if (errores) {
            mostrarMensaje(txtErrores);
            return false;
        }
        return true;
    }

    public void mostrarMensaje(String mensaje) {
        pantallaCobrarOrden.lblMensajeCobrarOrden.setText(mensaje);
        pantallaCobrarOrden.DialogMsjCobrarOrden.setVisible(true);
        pantallaCobrarOrden.DialogMsjCobrarOrden.setLocationRelativeTo(null);
        pantallaCobrarOrden.TxtCobrarNumeroOrden.setText("");
    }

    public void llenarTabla(JTable tabla, String numOrden) {

        if (pantallaCobrarOrden.RbtnNumeroMesaCobrar.isSelected()) {//Busqueda por número de mesa
            listaOrden = orden.consltarOrdenPorMesa(numOrden);
        } else if (pantallaCobrarOrden.RbtnNumeroOrdenCobrar.isSelected()) { //Busqueda por número de orden
            listaOrden = orden.consltarOrdenPorNumero(numOrden);
        }
        total = 0;
        Iterator itr = listaOrden.iterator();
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tabla.removeAll();
        model.addColumn("Nombre");
        model.addColumn("Cantidad");
        model.addColumn("Precio Unitario");
        model.addColumn("Subtotal");
        Object[] egr = new Object[4];
        Object[] obj;
        while (itr.hasNext()) {
            obj = (Object[]) itr.next();
            // System.out.println(Arrays.deepToString(obj));
            egr[0] = obj[0];
            egr[1] = obj[1];
            egr[2] = obj[2];
            egr[3] = obj[3];
            if (pantallaCobrarOrden.RbtnNumeroOrdenCobrar.isSelected()) {
                numero_mesa = String.valueOf(obj[4]);
            } else {
                numero_orden = String.valueOf(obj[4]);
            }

            total += Double.parseDouble(String.valueOf(obj[3]));
            model.addRow(egr);
        }

        tabla.setModel(model);
        pantallaCobrarOrden.LblTotalCobrar.setText("Total: $" + redondeo(total));
        System.out.println("Num de mesa = " + numero_mesa);
        System.out.println("Número de orden = " + numero_orden);
    }

    private void limpiarTabla(JTable tabla) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        for (int i = 0; i < tabla.getRowCount(); i++) {
            modelo.removeRow(i);
            i -= 1;
        }
    }

    public double calcularCambio(double total, double efectivo) {
        double cambio = 0;
        if (total == efectivo) {
            cambio = 0;
        } else {
            cambio = efectivo - total;
        }
        return cambio;
    }

    public double redondeo(double cantidad) {
        //Redondeamos la cantidad a dos digitos
        return Math.rint(cantidad * 100) / 100;
    }

}
