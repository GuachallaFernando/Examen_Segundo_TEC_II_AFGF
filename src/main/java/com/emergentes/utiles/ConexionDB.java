package com.emergentes.utiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionDB {

    static public String driver = "com.mysql.jdbc.Driver";
    static public String url = "jdbc:mysql://localhost:3333/bd_biblioteca";///my puerto es el 3333 envez del original por que tengo otro programe en ese puerto
    static public String usuario = "root";
    static public String password = "admin";

    protected Connection conn = null;

    public ConexionDB() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, usuario, password);
        } catch (ClassNotFoundException ex) {
            System.out.println("Error en el driver" + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error al conectar" + ex.getMessage());
        }
    }

    public Connection conectar() {
        return conn;
    }

    public void desconectar() {
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Error al cerrar: " + ex.getMessage());
        }
    }

}
