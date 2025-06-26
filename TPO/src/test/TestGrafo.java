package test;

import modelo.Grafo;
import servicios.AStar;

import java.util.HashMap;
import java.util.Map;

public class TestGrafo {
    public static void main(String[] args) {
        Grafo<String> ciudad = new Grafo<>();

        // Agregar nodos
        ciudad.agregarNodo("Palermo");
        ciudad.agregarNodo("Recoleta");
        ciudad.agregarNodo("Belgrano");
        ciudad.agregarNodo("Retiro");
        ciudad.agregarNodo("San Telmo");

        // Agregar conexiones (peso = minutos)
        ciudad.agregarArista("Palermo", "Recoleta", 10);
        ciudad.agregarArista("Palermo", "Belgrano", 7);
        ciudad.agregarArista("Belgrano", "Retiro", 12);
        ciudad.agregarArista("Recoleta", "Retiro", 5);
        ciudad.agregarArista("Retiro", "San Telmo", 8);

        AStar<String> buscador = new AStar<>();

        // Heurística trivial (0)
        long startTime = System.nanoTime();
        buscador.ejecutar(ciudad, "Palermo", "San Telmo", (a, b) -> 0);
        long durationTrivial = System.nanoTime() - startTime;
        System.out.println("Tiempo con heurística 0 (Dijkstra): " + durationTrivial + " ns");

        // Heurística estimada
        Map<String, Integer> heuristicaSanTelmo = new HashMap<>();
        heuristicaSanTelmo.put("Palermo", 20);
        heuristicaSanTelmo.put("Recoleta", 15);
        heuristicaSanTelmo.put("Belgrano", 25);
        heuristicaSanTelmo.put("Retiro", 8);
        heuristicaSanTelmo.put("San Telmo", 0);

        startTime = System.nanoTime();
        buscador.ejecutar(ciudad, "Palermo", "San Telmo",
                (a, b) -> heuristicaSanTelmo.getOrDefault(a, 0));
        long durationHeuristica = System.nanoTime() - startTime;
        System.out.println("Tiempo con heurística estimada: " + durationHeuristica + " ns");
    }
}
