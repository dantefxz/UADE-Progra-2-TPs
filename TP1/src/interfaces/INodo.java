package interfaces;

import modelo.Vehiculo;

public interface INodo {
    public Vehiculo getDato();
    public void setDato(Vehiculo dato);
    public void setSiguiente(INodo siguiente);
    public INodo getSiguiente();
    public void setAnterior(INodo anterior);
    public INodo getAnterior();

}
