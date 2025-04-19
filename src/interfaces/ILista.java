package interfaces;

import modelo.Vehiculo;

public interface ILista {
    boolean esVacia(boolean mensaje);
    void insertarPrimero(Vehiculo dato);
    void insertarUltimo(Vehiculo dato);
    boolean insertarGenerico(Vehiculo vehiculo, int posicion);
    void mostrarLista();
    void mostrarListaInversa();
    int cantidadElementos();
    Vehiculo obtenerGenerico(int pos);
    Vehiculo BuscarPatente(String patente);
    void ordenarPorPatente();
    Vehiculo obtenerPrimero();
    boolean eliminarPorPatente(String patente);
    
}
