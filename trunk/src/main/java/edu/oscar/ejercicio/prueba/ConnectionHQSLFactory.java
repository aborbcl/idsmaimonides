package edu.oscar.ejercicio.prueba;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionHQSLFactory implements ConnectionFactory {
	public ConnectionHQSLFactory()
    {
    }

    public Connection creaConexion(String conexion)
        throws Exception
    {
        Connection connection = null;
        Class.forName("org.hsqldb.jdbcDriver");
        connection = DriverManager.getConnection(conexion);
        return connection;
    }

}
