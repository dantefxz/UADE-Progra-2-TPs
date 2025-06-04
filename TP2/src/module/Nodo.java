package module;

import interfaces.INodo;

public class Nodo implements INodo {

    private Persona persona;
    private INodo izquierdo;
    private INodo derecho;

    public Nodo(Persona persona) {
        this.persona = persona;
        this.izquierdo = null;
        this.derecho = null;
    }

    // Getters y setters
    public Persona getPersona() {
        return persona;
    }

    public int getDato() {
        return persona.getDni();  // usado para comparación
    }

    public INodo getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(INodo izquierdo) {
        this.izquierdo = izquierdo;
    }

    public INodo getDerecho() {
        return derecho;
    }

    public void setDerecho(INodo derecho) {
        this.derecho = derecho;
    }

    @Override
    public String toString() {
        return persona.toString();  // Por ejemplo: "Juan (12345678)"
    }
}