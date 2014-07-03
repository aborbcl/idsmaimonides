package edu.oscar.ejercicio.prueba;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionURL {
    Connection conn = null;  
public ConnectionURL(){
    try {  
        // Cargamos el controlador JDBC  
        Class.forName("org.hsqldb.jdbc.JDBCDriver");  
    } catch (Exception ex){  
        System.err.println("Se pa producido un error al cargar el controlador JDBC");  
        return;  
    }  
}
public Connection connect(String URL) throws SQLException{
    conn = DriverManager.getConnection(URL);  
    return conn;

}
}
