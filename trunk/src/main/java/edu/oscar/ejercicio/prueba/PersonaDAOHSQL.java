package edu.oscar.ejercicio.prueba;

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class PersonaDAOHSQL implements PersonaDAO{
	private static final Logger log = LogManager.getLogger(PersonaDAOHSQL.class 
	        .getName());




	public PersonaDAOHSQL(Connection myconn)
    {
        conn = myconn;
        }

	public boolean crear(Persona pp) throws SQLException {
		String query = "INSERT INTO Personas (dni , nombre ,apellido) VALUES(?,?,?)";
		log.debug("Se va a ejecutar la query: "+query);

		PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setInt(1, pp.getDni());
        pstmt.setString(2, pp.getNombre());
        pstmt.setString(3, pp.getApellido());
        int resultado = pstmt.executeUpdate();
		log.debug("Queda ejecutada correctamente: "+query);

        return  resultado > 0;
	}

	public boolean borrar(Persona pp) throws SQLException {
		String query = "DELETE from Personas WHERE dni =?";
		log.debug("Se va a ejecutar la query: "+query);

        PreparedStatement pstst = conn.prepareStatement(query);
        pstst.setInt(1, pp.getDni());
        int resultado = pstst.executeUpdate();
		log.debug("Queda ejecutada correctamente: "+query);

        return  resultado > 0;
	}

	public boolean guardar(Persona pp) throws SQLException {
		String query = "UPDATE Personas SET nombre=?  , apellido=? WHERE DNI=?";
		log.debug("Se va a ejecutar la query: "+query);

        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, pp.getNombre());
        pstmt.setString(2, pp.getApellido());
        pstmt.setInt(3, pp.getDni());
        int resultado = pstmt.executeUpdate();
		log.debug("Queda ejecutada correctamente: "+query);        
        return  resultado == 1;
	}

	public ArrayList listar() throws SQLException {
		ArrayList listaDePersonas = new ArrayList();
        String query = "SELECT * FROM Personas";
		log.debug("Se va a ejecutar la query: "+query);

        Statement stst = conn.createStatement();
        Persona nPersona;
        for(ResultSet rst1 = stst.executeQuery(query); rst1.next(); listaDePersonas.add(nPersona))
        {
            nPersona = new Persona();
            nPersona.setNombre(rst1.getString("nombre"));
            nPersona.setApellido(rst1.getString("apellido"));
            nPersona.setDni(rst1.getInt("dni"));
        }
		log.debug("Queda ejecutada correctamente: "+query);

        return listaDePersonas;

	}
    Connection conn;
}
