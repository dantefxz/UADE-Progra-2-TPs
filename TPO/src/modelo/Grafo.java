package modelo;

import java.util.*;

public class Grafo {
    private Map<Integer, Nodo> nodos;

    public Grafo() {
        nodos = new HashMap<>();
    }

    public void agregarNodo(int valor) {
        nodos.putIfAbsent(valor, new Nodo(valor));
    }

    public void agregarArista(int origen, int destino, int peso) {
        Nodo n1 = nodos.get(origen);
        Nodo n2 = nodos.get(destino);
        if (n1 != null && n2 != null) {
            n1.agregarVecino(n2, peso);
        }
    }

    public Map<Integer, Nodo> getNodos() {
        return nodos;
    }
}