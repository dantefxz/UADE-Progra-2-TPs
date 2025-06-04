package interfaces;

import module.Persona;

public interface INodo {

    INodo getIzquierdo();
    void setIzquierdo(INodo izquierdo);
    INodo getDerecho();
    void setDerecho(INodo derecho);
    Persona getPersona();
    String toString();
    int getDato();


}
