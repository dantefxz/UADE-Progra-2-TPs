package interfaces;

import module.Persona;

public interface IArbol {

    void insertar(Persona persona);
    INodo buscar(int DNI);
    void recorridoPreorden();
    void recorridoInorden();
    void recorridoPostorden();
}