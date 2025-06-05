package interfaces;

public interface INodo {
    IPersona getPersona();
    void setPersona(IPersona persona);
    INodo getIzquierdo();
    void setIzquierdo(INodo izquierdo);
    INodo getDerecho();
    void setDerecho(INodo derecho);
}
