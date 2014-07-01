package edu.oscar.ejercicio.prueba;

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import org.hsqldb.Statement;

public class PersonaDAOHSQL implements PersonaDAO{
	public PersonaDAOHSQL(Connection myconn)
    {
        conn = myconn;
    }

	public boolean crear(Persona pp) throws SQLException {
		String query = "INSERT INTO Personas (dni , nombre ,apellido) VALUES(?,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setInt(1, pp.getDni());
        pstmt.setString(2, pp.getNombre());
        pstmt.setString(3, pp.getApellido());
        return pstmt.executeUpdate() > 0;
	}

	public boolean borrar(Persona pp) throws SQLException {
		String query = "DELETE from Personas WHERE dni =?";
        PreparedStatement pstst = conn.prepareStatement(query);
        pstst.setInt(1, pp.getDni());
        return pstst.executeUpdate() == 1;
	}

	public boolean guardar(Persona pp) throws SQLException {
		String query = "UPDATE Personas SET nombre=?  , apellido=? WHERE DNI=?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, pp.getNombre());
        pstmt.setString(2, pp.getApellido());
        pstmt.setInt(3, pp.getDni());
        return pstmt.executeUpdate() == 1;
	}

	public Collection listar() throws SQLException {
		List listaDePersonas = new ArrayList();
        String query = "SELECT * FROM Personas";
        Statement stst = conn.createStatement();
        Persona nPersona;
        for(ResultSet rst1 = stst.executeQuery(query); rst1.next(); listaDePersonas.add(nPersona))
        {
            nPersona = new Persona();
            nPersona.setNombre(rst1.getString("nombre"));
            nPersona.setApellido(rst1.getString("apellido"));
            nPersona.setDni(rst1.getInt("dni"));
        }

        return listaDePersonas;

	}
	public volatile Collection listar()
	        throws SQLException
	    {
	        return listar();
	    }

    Connection conn;
}
