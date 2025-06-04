package interfaces;

import modelo.Lista;
import modelo.Vehiculo;

public interface IPersona{
    int getDni();
    void setDni(int dni);
    String getNombre();
    void setNombre(String nombre);
    void mostrarPersona();
    boolean eliminarVehiculo(String patente);
    Vehiculo buscarVehiculo(String patente);
    Lista getListaVehiculos();
    void setListaVehiculos(Lista listaVehiculos);

}