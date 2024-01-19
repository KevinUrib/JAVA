
package modelo;

import java.sql.*;

/**
 *
 * @author Kevin Uribe
 */
public class Conexion {

    Connection con;
    String url = "jdbc:mysql://localhost/db_ventas?useSSL=false&serverTimezone=UTC";
    String user = "root";
    String pass = "Cisco123!!";
    
    public Connection conectar(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            System.out.println("Error al conectar hacia la base de datos "+e.getMessage());
        }
        return con;
    }
    
}
