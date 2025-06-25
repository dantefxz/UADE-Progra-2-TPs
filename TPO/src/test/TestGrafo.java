package test;

import modelo.Grafo;
import servicios.AStar;

public class TestGrafo {
    public static void main(String[] args) {
        Grafo<Integer> grafo = new Grafo<>();
        for (int i = 1; i <= 5; i++) {
            grafo.agregarNodo(i);
        }

        grafo.agregarArista(1, 2, 2);
        grafo.agregarArista(1, 3, 4);
        grafo.agregarArista(2, 4, 7);
        grafo.agregarArista(3, 4, 1);
        grafo.agregarArista(4, 5, 3);

        AStar<Integer> algoritmo = new AStar<>();
        algoritmo.ejecutar(grafo, 1, 5, (a, b) -> 0); // Heurística trivial
    }
}

