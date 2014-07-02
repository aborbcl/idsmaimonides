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
	        ConnectionURL mifactory = new ConnectionURL();
	        Connection conn = mifactory.connect("jdbc:hsqldb:mem:db");
	        return conn;
	    }
}
