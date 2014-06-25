package edu.oscar.ejercicio.prueba;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionHSQL {
	 public ConnectionHSQL()
	    {
	    }
	    public Connection createConn()
	        throws SQLException
	    {
	        ConnectionFactory mifactory = new ConnectionFactory();
	        Connection conn = mifactory.createConn("jdbc:hsqldb:mem:db");
	        return conn;
	    }
}
