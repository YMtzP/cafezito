/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alexis Salvador
 */
public class Login {

    Conexion con;
    private String usuario;
    private String contraseña;
    private int id_empleado;

    public Login() {
        con = new Conexion("localhost", "cafezito", "root", "%TargetHxC");
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }


    public void guardarLogin() {
        Connection cn = con.getConnection();
        try {
            PreparedStatement pps = cn.prepareStatement("INSERT INTO login (usuario,contrasena,id_empleado) values (?,?,?)");
            pps.setString(1, getUsuario());
            pps.setString(2, getContraseña());
            pps.setInt(3, getId_empleado());
            pps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Boolean verificarLogin(String usuario, String contraseña) {
        Connection cn = con.getConnection();
        boolean user = false, pass = false;
        try {
            PreparedStatement ps = cn.prepareStatement("select * from login where usuario=? and contrasena=?");
            ps.setString(1, usuario);
            ps.setString(2, contraseña);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                if (rs.getString(1).equals(usuario)) {
                    user = true;
                }
                if (rs.getString(2).equals(contraseña)) {
                    pass = true;                          
                }
            }
        } catch (Exception e) {
        }

        if (pass && user) {
            return true;
        } else {
            return false;
        }
    }

    public String tipoUsuario(String usuario) {
        Connection cn = con.getConnection();
        String tipoUsuario = "";
        try {

            PreparedStatement ps = cn.prepareStatement("select puesto from empleado join login on login.id_empleado=empleado.id_empleado where usuario=?;");
            ps.setString(1, usuario);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                tipoUsuario = rs.getString(1);
            }
            cn.close();
        } catch (Exception e) {
        }
        return tipoUsuario;
    }

    public ArrayList<Login> listaUsuarios() {
        Connection cn = con.getConnection();
        ArrayList<Login> usuarios = new ArrayList<>();
        try {
            PreparedStatement pps = cn.prepareStatement("SELECT * FROM login");
            ResultSet rs = pps.executeQuery();
            while (rs.next()) {
                Login usuario = new Login();
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setContraseña(rs.getString("contrasena"));
                usuario.setId_empleado(rs.getInt("id_empleado"));

                usuarios.add(usuario);
            }
            cn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuarios;
    }
    
    

    public boolean verificaUsuario(String usuario, String contra, ArrayList<Login> usuarios) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getUsuario().equals(usuario)&&usuarios.get(i).getContraseña().equals(contra)) {
                return true;
            }
        }
        return false;
    }
    
    
    public boolean verificaNombreUsuario(String usuario, ArrayList<Login> usuarios) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getUsuario().equals(usuario)) {
                return true;
            }
        }
        return false;
    }

    public boolean actualizarUsuario(int id_empleado, String usuario, String contraseña) {
        Connection cn = con.getConnection();
        try {
            
            PreparedStatement pps = cn.prepareStatement("UPDATE login set contrasena=? where id_empleado=?;");
            pps.setString(1, contraseña);
            pps.setInt(2, id_empleado);
            pps.executeUpdate();
            pps = cn.prepareStatement("UPDATE login set usuario=? where id_empleado=?;");
            pps.setString(1, usuario);
            pps.setInt(2, id_empleado);
            
            pps.executeUpdate();
            cn.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean borrarLogin(int id_empleado) {
        Connection cn = con.getConnection();
        try {
            PreparedStatement pps = cn.prepareStatement("delete from login where id_empleado=?;");
            pps.setInt(1, id_empleado);
            
            pps.executeUpdate();
            cn.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

}
