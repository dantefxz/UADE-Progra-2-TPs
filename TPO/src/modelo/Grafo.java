package modelo;

import java.util.*;

public class Grafo<T> {
    private Map<T, Nodo<T>> nodos;

    public Grafo() {
        nodos = new HashMap<>();
    }

    public void agregarNodo(T valor) {
        nodos.putIfAbsent(valor, new Nodo<>(valor));
    }

    public void agregarArista(T origen, T destino, int peso) {
        Nodo<T> n1 = nodos.get(origen);
        Nodo<T> n2 = nodos.get(destino);
        if (n1 != null && n2 != null) {
            n1.agregarVecino(n2, peso);
        }
    }

    public Map<T, Nodo<T>> getNodos() {
        return nodos;
    }
}