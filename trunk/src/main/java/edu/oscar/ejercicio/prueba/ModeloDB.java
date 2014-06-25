package edu.oscar.ejercicio.prueba;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;



public class ModeloDB {
   
	public ModeloDB()
    {
    }

    public boolean createModel(Connection conn)
        throws SQLException
    {
        Statement stmt = conn.createStatement();
        stmt.executeUpdate("CREATE TABLE Personas(DNI int, NOMBRE varchar(100), APE varchar(100))");
        return true;
    }

  
}
