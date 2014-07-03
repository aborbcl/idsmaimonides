package edu.oscar.ejercicio.prueba;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.omg.CORBA.portable.InputStream;

import com.csvreader.CsvReader;


public class PersonaMain {
	private static final Logger log = LogManager.getLogger(PersonaMain.class.getName());
	 String cargar_personas;
	 String archivo_de_personas;
	 String archivo_de_salida;
    Connection conn;
    public PersonaMain(Connection conn){
    	this.conn=conn;
    }
    public boolean cargarPropiedades() throws FileNotFoundException, IOException{
    	 Properties p = new Properties();
		   p.load(new FileInputStream("C:/Users/TOSHIBA/Desktop/OS/MAIMONIDES/IV y V Año/ISII/prueba/src/main/java/edu/oscar/ejercicio/prueba/resources/configuration.properties"));		 
		    cargar_personas = p.getProperty("cargar.personas");
		    archivo_de_personas = p.getProperty("archivo.de.personas");
		    archivo_de_salida = p.getProperty("archivo.de.salida");
		    if(cargar_personas.isEmpty() || archivo_de_personas.isEmpty() || archivo_de_salida.isEmpty())
		    	return false;
		    else return true;
    }
    public ArrayList<Persona> guardarEnDB() throws IOException, SQLException{
        PersonaDAOHSQL  guardar = new PersonaDAOHSQL(conn);
        FileWriter archivo = new FileWriter ("C:/Users/TOSHIBA/Desktop/OS/MAIMONIDES/IV y V Año/ISII/prueba/src/main/java/edu/oscar/ejercicio/prueba/resources/"+archivo_de_salida);
        PrintWriter pw = new PrintWriter(archivo);
        ArrayList<Persona> listaPersona = new ArrayList();
	  if(cargar_personas.equals("true")){
		  CsvReader usuarios_import = new CsvReader("C:/Users/TOSHIBA/Desktop/OS/MAIMONIDES/IV y V Año/ISII/prueba/src/main/java/edu/oscar/ejercicio/prueba/resources/"+archivo_de_personas);
	        usuarios_import.readHeaders();
	        while (usuarios_import.readRecord())
	        {
	        		            String nombre = usuarios_import.get(0);
	            String apellidos = usuarios_import.get(1);
	            String dni = usuarios_import.get(2);
	            Persona per = new Persona(nombre,apellidos,Integer.parseInt(dni));
	            guardar.crear(per);
	           // listaPersona.add(per);
	            log.info("Persona "+nombre+" con apellidos "+apellidos+ " y dni "+dni);
	            pw.println(nombre+","+apellidos+ ","+dni);
	        }
	        Persona per = new Persona("CG","Aguilar",58);
            //listaPersona.add(per);
	        guardar.crear(per);
	        listaPersona = guardar.listar();
	        for(int i=0;i<listaPersona.size();i++){
	        	pw.println(listaPersona.get(i).getNombre()+","+listaPersona.get(i).getApellido()+ ","+listaPersona.get(i).getDni());
	        }
	        pw.close();
	  }
	  return listaPersona; //Todo ha ido bien. No hay error ni excepciones.
	}
    public boolean svcCreado(){
    	
    	String sFichero = "C:/Users/TOSHIBA/Desktop/OS/MAIMONIDES/IV y V Año/ISII/prueba/src/main/java/edu/oscar/ejercicio/prueba/resources/"+archivo_de_salida;
    	File fichero = new File(sFichero);
    	if(fichero.length()!=0)return true;
    	else return false;
    	
    }
}
