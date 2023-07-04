package com.dao;
import com.conexion.Conexion;
import com.modelo.Proveedor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Kevin Uribe
 * @version 1.0
 */
public class ProveedorDAO extends Conexion{
    
    // Desarrollo de codigo para insercion de registros a la BD
    public int insertarProveedor(Proveedor p){
        int res = 0;
        try {
            this.conectar();
            String sql = "INSERT INTO proveedor(nombreProveedor, direccion, telefono) VALUES(?,?,?)";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1, p.getNombre());
            pre.setString(2, p.getDireccion());
            pre.setString(3, p.getTelefono());
            res = pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al agregar registro "+e.getMessage());
        }
        return res;
    }
    
    // Funcion para mostrar registros en BD
    public ArrayList<Proveedor> mostrarProveedor(){
        ArrayList<Proveedor> listProveedores = new ArrayList<>();
        try {
            this.conectar();
            String sql = "SELECT * FROM proveedor";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {                
                Proveedor p = new Proveedor();
                p.setCodigo(rs.getInt(1));
                p.setNombre(rs.getString("nombreProveedor"));
                p.setDireccion(rs.getString("direccion"));
                p.setTelefono(rs.getString("telefono"));
                listProveedores.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Error al extraer los registros "+e.getMessage());
        }
        return listProveedores;
    }
    
    // Funcion para actualizar registros
    public int modificarProveedor(Proveedor p){
        int res = 0;
        try {
            this.conectar();
            String sql = "UPDATE proveedor SET nombreProveedor=?, direccion=?, telefono=? WHERE codigoProveedor=?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1, p.getNombre());
            pre.setString(2, p.getDireccion());
            pre.setString(3, p.getTelefono());
            pre.setInt(4, p.getCodigo());
            res = pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al modificar "+e.getMessage());
        }
        return res;
    }
    
    // Funcion para eliminar registros
    public int eliminarRegistros(Proveedor p){
        int res = 0;
        try {
            this.conectar();
            String sql = "DELETE FROM proveedor WHERE codigoProveedor=?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setInt(1, p.getCodigo());
            res = pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al eliminar el registro "+e.getMessage());
        }
        return res;
    }
        
}
