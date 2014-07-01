package edu.oscar.ejercicio.prueba;

import java.sql.Connection;

public interface ConnectionFactory{
	public abstract Connection CreaConexion(String s)
	throws Exception;
}
