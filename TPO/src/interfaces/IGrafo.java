package interfaces;

import modelo.Nodo;

import java.util.Map;

public interface IGrafo<T> {
    void agregarNodo(T valor);
    void agregarArista(T origen, T destino, int peso);
    Map<T, Nodo<T>> getNodos();
}
