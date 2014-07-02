package edu.oscar.ejercicio.prueba;

public class Persona {
	public Persona()
    {
    }

    public Persona(String Nombre, String Apellido, int dni)
    {
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.dni = dni;
    }

    public boolean equals(Object obj)
    {
        Persona otra = (Persona)obj;
        return otra.getNombre().equals(getNombre()) && otra.getApellido().equals(getApellido()) && otra.getDni() == getDni();
    }

    public int hashCode()
    {
        return getDni();
    }

    public String getNombre()
    {
        return Nombre;
    }

    public void setNombre(String Nombre)
    {
        this.Nombre = Nombre;
    }

    public String getApellido()
    {
        return Apellido;
    }

    public void setApellido(String Apellido)
    {
        this.Apellido = Apellido;
    }

    public int getDni()
    {
        return dni;
    }

    public void setDni(int dni)
    {
        this.dni = dni;
    }

    private String Nombre;
    private String Apellido;
    private int dni;
}
