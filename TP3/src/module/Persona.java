package module;

import interfaces.IPersona;

public class Persona implements IPersona {
    private int dni;
    private String nombre;

    public Persona(int dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
    }
    @Override
    public int getDni() {
        return dni;
    }

    @Override
    public void setDni(int dni) {
        this.dni = dni;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre + " (" + dni + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Persona)) return false;
        Persona otra = (Persona) obj;
        return this.dni == otra.dni;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(dni);
    }

}
