package modelo;

import interfaces.INodo;

public class Nodo implements INodo  {
	private Vehiculo dato;
    private INodo siguiente;
    private INodo anterior;

    public Nodo(Vehiculo dato, INodo siguiente, INodo anterior) {
        super();
        this.dato = dato;
        this.anterior = anterior;
        this.siguiente = siguiente;
    }
    
    public Nodo (Vehiculo dato){
        super();
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
    }


    @Override
    public Vehiculo getDato() {
        return dato;
    }

    @Override
    public void setDato(Vehiculo dato) {
        this.dato = dato;
    }

    @Override
    public INodo getSiguiente() {
        return siguiente;
    }

    @Override
    public void setSiguiente(INodo siguiente) {
        this.siguiente = siguiente;
    }
    
    @Override
    public INodo getAnterior() {
        return anterior;
    }

    @Override
    public void setAnterior(INodo anterior) {
        this.anterior = anterior;
    }

}