/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Vista.PantallaRegistrarEmpleado;
import Vista.PantallaModificarDatosEmpleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author YareMtz
 */
public class Empleado {

    private int id_empleado;
    private String nombre;
    private String apellido_Paterno;
    private String apellido_Materno;
    private String fecha_Nacimiento;
    private String telefono;
    private String celular;
    private String calle_Direccion;
    private String colonia_Direccion;
    private String numero_Direccion;
    private String cp;
    private String puesto;
    private Double sueldo;
    private String status;
    Conexion con;

    public Empleado() {
        con = new Conexion("localhost", "cafezito", "root", "qpmz.2404");
        System.out.println("Conexion Empleado");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido_Paterno() {
        return apellido_Paterno;
    }

    public void setApellido_Paterno(String apellido_Paterno) {
        this.apellido_Paterno = apellido_Paterno;
    }

    public String getApellido_Materno() {
        return apellido_Materno;
    }

    public void setApellido_Materno(String apellido_Materno) {
        this.apellido_Materno = apellido_Materno;
    }

    public String getFecha_Nacimiento() {
        return fecha_Nacimiento;
    }

    public void setFecha_Nacimiento(String fecha_Nacimiento) {
        this.fecha_Nacimiento = fecha_Nacimiento;
    }

    public String getCalle_Direccion() {
        return calle_Direccion;
    }

    public void setCalle_Direccion(String calle_Direccion) {
        this.calle_Direccion = calle_Direccion;
    }

    public String getColonia_Direccion() {
        return colonia_Direccion;
    }

    public void setColonia_Direccion(String colonia_Direccion) {
        this.colonia_Direccion = colonia_Direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getNumero_Direccion() {
        return numero_Direccion;
    }

    public void setNumero_Direccion(String numero_Direccion) {
        this.numero_Direccion = numero_Direccion;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public Double getSueldo() {
        return sueldo;
    }

    public void setSueldo(Double sueldo) {
        this.sueldo = sueldo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public void registrarEmpleado() {
        Connection cn = con.getConnection();

        try {
            PreparedStatement pps = cn.prepareStatement("INSERT INTO empleado (Nombre,Apellido_paterno,Apellido_materno,Fecha_nacimiento,Telefono,Celular,Calle_direccion, Colonia_direccion, Numero_direccion,CP,Puesto,salario, Status) values (?,?,?,?,?,?,?,?,?,?,?,?,?); ");

            pps.setString(1, getNombre());
            pps.setString(2, getApellido_Paterno());
            pps.setString(3, getApellido_Materno());
            pps.setString(4, getFecha_Nacimiento());
            pps.setString(5, getTelefono());
            pps.setString(6, getCelular());
            pps.setString(7, getCalle_Direccion());
            pps.setString(8, getColonia_Direccion());
            pps.setString(9, getNumero_Direccion());
            pps.setString(10, getCp());
            pps.setString(11, getPuesto());
            pps.setDouble(12, getSueldo());
            pps.setString(13, getStatus());
            pps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int id_login() {
        Connection cn = con.getConnection();
        int id = 0;
        try {
            PreparedStatement pps = cn.prepareStatement("Select MAX(id_empleado) from empleado;");
            ResultSet rs = pps.executeQuery();
            rs.next();
            id = rs.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    public boolean actualizarDatos(int id_empleado) {
        Connection cn = con.getConnection();
        try {
            PreparedStatement pps = cn.prepareStatement("UPDATE empleado set nombre=?,apellido_paterno=?,Apellido_materno=?,fecha_nacimiento=?,telefono=?,celular=?,calle_direccion=?,colonia_direccion=?,numero_direccion=?, cp=?, puesto=?, salario=?, Status=? where id_empleado=?;");
            pps.setString(1, getNombre());
            pps.setString(2, getApellido_Paterno());
            pps.setString(3, getApellido_Materno());
            pps.setString(4, getFecha_Nacimiento());
            pps.setString(5, getTelefono());
            pps.setString(6, getCelular());
            pps.setString(7, getCalle_Direccion());
            pps.setString(8, getColonia_Direccion());
            pps.setString(9, getNumero_Direccion());
            pps.setString(10, getCp());
            pps.setString(11, getPuesto());
            pps.setDouble(12, getSueldo());
            pps.setString(13, getStatus());
            pps.setInt(14, id_empleado);
            pps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<Empleado> listaEmpleados() {
        Connection cn = con.getConnection();
        ArrayList<Empleado> empleados = new ArrayList<>();
        try {
            PreparedStatement pps = cn.prepareStatement("SELECT * FROM empleado;");
            ResultSet rs = pps.executeQuery();
            while (rs.next()) {
                Empleado empleado = new Empleado();
                empleado.setId_empleado(rs.getInt("id_empleado"));
                empleado.setNombre(rs.getString("nombre"));
                empleado.setApellido_Paterno(rs.getString("apellido_paterno"));
                empleado.setApellido_Materno(rs.getString("apellido_materno"));
                empleado.setFecha_Nacimiento(rs.getString("fecha_nacimiento"));
                empleado.setTelefono(rs.getString("telefono"));
                empleado.setCelular(rs.getString("celular"));
                empleado.setCalle_Direccion(rs.getString("calle_direccion"));
                empleado.setColonia_Direccion(rs.getString("colonia_direccion"));
                empleado.setNumero_Direccion(rs.getString("numero_direccion"));
                empleado.setCp(rs.getString("cp"));
                empleado.setPuesto(rs.getString("puesto"));
                empleado.setSueldo(rs.getDouble("salario"));
                empleado.setStatus(rs.getString("status"));
                empleados.add(empleado);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return empleados;
    }

    public int id_EmpleadoAsistencia() {
        Connection cn = con.getConnection();
        int id = 0;
        try {
            PreparedStatement pps = cn.prepareStatement("Select id_empleado from empleado where ;");
            ResultSet rs = pps.executeQuery();
            rs.next();
            id = rs.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    public boolean validarDatosRegistro(PantallaRegistrarEmpleado frameRegistroEmpleado) {

        String txtError = "";
        Boolean errores = false;
        String sAux = getSueldo() + "";
        //Validacion de campos obligatorios
        if (!(nombre.matches("([àèìòùáéíóúa-zA-Z]+[ ]*)+"))) {
            txtError += "-Nombre invalido\n";
            errores = true;
            frameRegistroEmpleado.TxtNombreEmpleado.setText("");
            frameRegistroEmpleado.BtnRegistrarEmpleado.setEnabled(false);
        }
        if (!(apellido_Paterno.matches("([àèìòùáéíóúa-zA-Z]+[ ]*)+"))) {
            txtError += "-Apellido paterno invalido\n";
            errores = true;
            frameRegistroEmpleado.TxtApellidoPaternoEmpleado.setText("");
            frameRegistroEmpleado.BtnRegistrarEmpleado.setEnabled(false);
        }
        if (!(apellido_Materno.matches("([àèìòùáéíóúa-zA-Z]+[ ]*)+"))) {
            txtError += "-Apellido materno invalido\n";
            errores = true;
            frameRegistroEmpleado.TxtApellidoMaternoEmpleado.setText("");
            frameRegistroEmpleado.BtnRegistrarEmpleado.setEnabled(false);
        }

        if (!(celular.matches("[1-9]{1}[0-9]{9}"))) {
            txtError += "-Celular invalido\n";
            errores = true;
            frameRegistroEmpleado.TxtCelularEmplado.setText("");
            frameRegistroEmpleado.BtnRegistrarEmpleado.setEnabled(false);
        }
        if (!sAux.matches("([1-9])[0-9]+(([.])([0-9]{1,2})?)?")) {
            txtError += "-Salario invalido\n";
            errores = true;
            frameRegistroEmpleado.TxtSueldoEmpleado.setText("");
            frameRegistroEmpleado.BtnRegistrarEmpleado.setEnabled(false);
        }

        //Campos no obligatorios
        if (!calle_Direccion.isEmpty()) {
            if (!calle_Direccion.matches("([1-9]{1,}\\s)*([áéíóúa-zA-Z.]+[0-9]*\\s*)+")) {
                txtError += "-Verificar la calle de la direccion\n";
                errores = true;
                frameRegistroEmpleado.TxtCalleEmpleado.setText("");
                //frameRegistroEmpleado.BtnRegistrarEmpleado.setEnabled(false);
            }
        }
        if (!colonia_Direccion.isEmpty()) {
            if (!(colonia_Direccion.matches("([1-9]{1,}\\s)*([áéíóúa-zA-Z.]+[0-9]*\\s*)+"))) {
                txtError += "-Verificar la colonia de la direccion\n";
                errores = true;
                frameRegistroEmpleado.TxtColoniaEmpleado.setText("");
                //frameRegistroEmpleado.BtnRegistrarEmpleado.setEnabled(false);
            }
        }

        if (!numero_Direccion.isEmpty()) {
            if (!numero_Direccion.matches("([#]*[\\s]*([0-9]+(\\s|[-])*[áéíóúa-zA-Z]+)|([áéíóúa-zA-Z]+\\s[0-9]+)|([0-9]+))")) {
                txtError += "-Verificar el número de la direccion\n";
                errores = true;
                frameRegistroEmpleado.TxtNumeroEmpleado.setText("");
                //frameRegistroEmpleado.BtnRegistrarEmpleado.setEnabled(false);
            }
        }

        if (!cp.isEmpty()) {
            if (!cp.matches("[0]{1}[1-9]{4}|[1-9]{1}[0-9]{4}")) {
                txtError += "-Código Postal invalido\n";
                errores = true;
                frameRegistroEmpleado.TxtCpDireccionEmpleado.setText("");
                //frameRegistroEmpleado.BtnRegistrarEmpleado.setEnabled(false);
            }
        }

        if (!telefono.isEmpty()) {
            if (!(telefono.matches("[1-9]{1}[0-9]{6}"))) {
                txtError += "-Telefono invalido\n";
                errores = true;
                frameRegistroEmpleado.TxtTelefonoEmpleado.setText("");
                //frameRegistroEmpleado.BtnRegistrarEmpleado.setEnabled(false);
            }
        }

        if (errores) {
            txtError += "No se permiten campos vacíos";
            frameRegistroEmpleado.jLblErroresMenu.setText(txtError);
            frameRegistroEmpleado.jLblErroresMenu.setText(txtError);
            frameRegistroEmpleado.DialogoErroresRegistroEmpleado.setLocationRelativeTo(null);
            frameRegistroEmpleado.DialogoErroresRegistroEmpleado.setVisible(true);
            //OptionPane.showMessageDialog(frameRegistroEmpleado, txtError, "Validacion de datos de usuarios", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }

//    public boolean validarDatosRegistroModificar(PantallaModificarDatosEmpleado frameRegistroModificarEmpleado) {
//
//        String txtError = "";
//        Boolean errores = false;
//        String sAux = getSueldo() + "";
//        //Validacion de campos obligatorios
//        if (!(nombre.matches("([àèìòùáéíóúa-zA-Z]+[ ]*)+"))) {
//            txtError += "-Nombre invalido\n";
//            errores = true;
//            frameRegistroModificarEmpleado.TxtNombreEmpleado.setText("");
//            frameRegistroModificarEmpleado.BtnActualizarEmpleado.setEnabled(false);
//        }
//        if (!(apellido_Paterno.matches("([àèìòùáéíóúa-zA-Z]+[ ]*)+"))) {
//            txtError += "-Apellido paterno invalido\n";
//            errores = true;
//            frameRegistroModificarEmpleado.TxtApellidoPaternoEmpleado.setText("");
//            frameRegistroModificarEmpleado.BtnActualizarEmpleado.setEnabled(false);
//        }
//        if (!(apellido_Materno.matches("([àèìòùáéíóúa-zA-Z]+[ ]*)+"))) {
//            txtError += "-Apellido materno invalido\n";
//            errores = true;
//            frameRegistroModificarEmpleado.TxtApellidoMaternoEmpleado.setText("");
//            frameRegistroModificarEmpleado.BtnActualizarEmpleado.setEnabled(false);
//        }
//
//        if (!(celular.matches("[1-9]{1}[0-9]{9}"))) {
//            txtError += "-Celular invalido\n";
//            errores = true;
//            frameRegistroModificarEmpleado.TxtCelularEmplado.setText("");
//            frameRegistroModificarEmpleado.BtnActualizarEmpleado.setEnabled(false);
//        }
//        if (!sAux.matches("([1-9])[0-9]+(([.])([0-9]{1,2})?)?")) {
//            txtError += "-Salario invalido\n";
//            errores = true;
//            frameRegistroModificarEmpleado.TxtSueldoEmpleado.setText("");
//            frameRegistroModificarEmpleado.BtnActualizarEmpleado.setEnabled(false);
//        }
//
//        //Campos no obligatorios
//        if (!calle_Direccion.isEmpty()) {
//            if (!calle_Direccion.matches("([1-9]{1,}\\s)*([áéíóúa-zA-Z]+[0-9]*\\s*)+")) {
//                txtError += "-Verificar la calle de la direccion\n";
//                errores = true;
//                frameRegistroModificarEmpleado.TxtCalleEmpleado.setText("");
//                frameRegistroModificarEmpleado.BtnActualizarEmpleado.setEnabled(false);
//            }
//        }
//        if (!colonia_Direccion.isEmpty()) {
//            if (!(colonia_Direccion.matches("([1-9]{1,}\\s)*([áéíóúa-zA-Z]+[0-9]*\\s*)+"))) {
//                txtError += "-Verificar la colonia de la direccion\n";
//                errores = true;
//                frameRegistroModificarEmpleado.TxtColoniaEmpleado.setText("");
//                frameRegistroModificarEmpleado.BtnActualizarEmpleado.setEnabled(false);
//            }
//        }
//
//        if (!numero_Direccion.isEmpty()) {
//            if (!numero_Direccion.matches("(([0-9]+(\\s|[-])*[áéíóúa-zA-Z]+)|([áéíóúa-zA-Z]+\\s[0-9]+)|([0-9]+))")) {
//                txtError += "-Verificar el número de la direccion\n";
//                errores = true;
//                frameRegistroModificarEmpleado.TxtNumeroEmpleado.setText("");
//                frameRegistroModificarEmpleado.BtnActualizarEmpleado.setEnabled(false);
//            }
//        }
//
//        if (!cp.isEmpty()) {
//            if (!cp.matches("[0]{1}[1-9]{4}|[1-9]{1}[0-9]{4}")) {
//                txtError += "-Código Postal invalido\n";
//                errores = true;
//                frameRegistroModificarEmpleado.TxtCpDireccionEmpleado.setText("");
//                frameRegistroModificarEmpleado.BtnActualizarEmpleado.setEnabled(false);
//            }
//        }
//
//        if (!telefono.isEmpty()) {
//            if (!(telefono.matches("[1-9]{1}[0-9]{6}"))) {
//                txtError += "-Telefono invalido\n";
//                errores = true;
//                frameRegistroModificarEmpleado.TxtTelefonoEmpleado.setText("");
//                frameRegistroModificarEmpleado.BtnActualizarEmpleado.setEnabled(false);
//            }
//        }
//
//        if (errores) {
//            txtError += "No se permiten campos vacíos";
//            frameRegistroModificarEmpleado.jLblErroresMenu.setText(txtError);
//            frameRegistroModificarEmpleado.DialogoErrores.setLocationRelativeTo(null);
//            frameRegistroModificarEmpleado.DialogoErrores.setVisible(true);
//            //JOptionPane.showMessageDialog(frameRegistroModificarEmpleado, txtError, "Validacion de datos de usuarios", JOptionPane.WARNING_MESSAGE);
//            return false;
//        }
//        return true;
//    }

}
