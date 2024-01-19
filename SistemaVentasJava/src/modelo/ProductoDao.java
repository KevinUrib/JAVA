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
public class ProductoDao implements CRUD {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();
    int id = 0;
    int r = 0;

    public Producto listarID(int id){
        Producto p = new Producto();
        String sql = "select * from producto where IdProducto=?";
        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {                
                p.setId(rs.getInt(1));
                p.setNombres(rs.getString(2));
                p.setPrecio(rs.getFloat(3));
                p.setStock(rs.getInt(4));
                p.setEstado(rs.getString(5));
                
            }
        } catch (Exception e) {
            System.out.println("Error en la consulta: "+e.getMessage());
        }
        return p;
    }
    
    @Override
    public List listar() {
        List<Producto> lista = new ArrayList<>();
        String sql = "select * from producto";
        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setId(rs.getInt(1));
                producto.setNombres(rs.getString(2));
                producto.setPrecio(rs.getFloat(3));
                producto.setStock(rs.getInt(4));
                producto.setEstado(rs.getString(5));
                lista.add(producto);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return lista;
    }

    @Override
    public int add(Object[] o) {
        String sql = "insert into producto(nombres, precio, stock, estado) values(?,?,?,?)";
        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            r = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return r;
    }

    @Override
    public int actualizar(Object[] o) {
        String sql = "update producto set nombres=?, precio=?, stock=?, estado=? where idProducto=?";
        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            ps.setObject(5, o[4]);
            r = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return r;
    }

    @Override
    public void eliminar(int id) {
        String sql = "delete from producto where idProducto=?";
        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

}
