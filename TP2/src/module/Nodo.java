package module;

import interfaces.INodo;
import interfaces.IPersona;

public class Nodo implements INodo {
    private IPersona persona;
    private INodo izquierdo;
    private INodo derecho;

    public Nodo(IPersona persona) {
        this.persona = persona;
        this.izquierdo = null;
        this.derecho = null;
    }

    @Override
    public IPersona getPersona() {
        return persona;
    }

    @Override
    public void setPersona(IPersona persona) {
        this.persona = persona;
    }

    @Override
    public INodo getIzquierdo() {
        return izquierdo;
    }

    @Override
    public void setIzquierdo(INodo izquierdo) {
        this.izquierdo = izquierdo;
    }

    @Override
    public INodo getDerecho() {
        return derecho;
    }

    @Override
    public void setDerecho(INodo derecho) {
        this.derecho = derecho;
    }
}
