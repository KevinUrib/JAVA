package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kevin Uribe
 */
public class VendedorDao implements CRUD {

    PreparedStatement ps;
    ResultSet rs;
    Conexion con = new Conexion();
    Connection acceso;
    int r = 0;

    public Vendedor validarVendedor(String dni, String user) {
        Vendedor v = new Vendedor();
        String sql = "select * from vendedor where dni=? and user_2=?";
        try {
            acceso = con.conectar();
            ps = acceso.prepareStatement(sql);
            ps.setString(1, dni);
            ps.setString(2, user);
            rs = ps.executeQuery();
            while (rs.next()) {
                v.setId(rs.getInt(1));
                v.setDni(rs.getString(2));
                v.setNom(rs.getString(3));
                v.setTel(rs.getString(4));
                v.setEstado(rs.getString(5));
                v.setUser(rs.getString(6));
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar usuario: " + e.getMessage());
        }
        return v;
    }

    // Inicio de metodos para modulo mantenimiento en formulario vendedor
    @Override
    public List listar() {
        List<Vendedor> lista = new ArrayList<>();
        String sql = "select * from vendedor";
        try {
            acceso = con.conectar();
            ps = acceso.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Vendedor vendor = new Vendedor();
                vendor.setId(rs.getInt(1));
                vendor.setDni(rs.getString(2));
                vendor.setNom(rs.getString(3));
                vendor.setTel(rs.getString(4));
                vendor.setEstado(rs.getString(5));
                vendor.setUser(rs.getString(6));
                lista.add(vendor);
            }
        } catch (SQLException e) {
            System.out.println("Error al extraer usuarios: " + e.getMessage());
        }

        return lista;
    }

    @Override
    public int add(Object[] o) {
        String sql = "insert into vendedor(dni, nombres, telefono, estado, user_2) values(?,?,?,?,?)";
        try {
            acceso = con.conectar();
            ps = acceso.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            ps.setObject(5, o[4]);
            r = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al insetar registro: " + e.getMessage());
        }
        return r;
    }

    @Override
    public int actualizar(Object[] o) {
        String sql = "update vendedor set dni=?, nombres=?, telefono=?, estado=?, user_2=? where idVendedor=?";
        try {
            acceso = con.conectar();
            ps = acceso.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            ps.setObject(5, o[4]);
            ps.setObject(6, o[5]);
            r = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al insetar registro: " + e.getMessage());
        }
        return r;
    }

    @Override
    public void eliminar(int id) {
        String sql = "delete from vendedor where idVendedor=?";
        try {
            acceso = con.conectar();
            ps = acceso.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al insetar registro: " + e.getMessage());
        }
    }

}
