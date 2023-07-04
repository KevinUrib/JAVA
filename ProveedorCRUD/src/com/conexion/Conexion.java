package com.conexion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 
 * @author Kevin Uribe
 * @version 1.0
 */
public class Conexion {
    private Connection con;

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
    
    public void conectar(){
        try {
            // Registro del driver SQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/inventario", "root", "Cisco123!!");
        } catch (Exception e) {
            System.out.println("Error al establecer conexion con la base de datos. "+e.getMessage());
        }
    }
    
    public void desconectar(){
        try {
            if (!con.isClosed()) {
                con.close();
            }
        } catch (Exception e) {
            System.out.println("Error al desconectar "+e.getMessage());
        }
    }
}
