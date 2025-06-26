package servicios;

import interfaces.INodo;
import modelo.Grafo;
import modelo.Nodo;

import java.util.*;

public class AStar<T> {

    public interface Heuristica<T> {
        int estimar(T actual, T destino);
    }

    public void ejecutar(Grafo<T> grafo, T inicio, T objetivo, Heuristica<T> heuristica) {
        Map<T, Nodo<T>> nodos = grafo.getNodos();

        Map<T, Integer> gCost = new HashMap<>();
        Map<T, Integer> fCost = new HashMap<>();
        Map<T, T> padres = new HashMap<>();
        Set<T> abiertos = new HashSet<>();
        Set<T> cerrados = new HashSet<>();

        for (T id : nodos.keySet()) {
            gCost.put(id, Integer.MAX_VALUE);
            fCost.put(id, Integer.MAX_VALUE);
        }

        gCost.put(inicio, 0);
        fCost.put(inicio, heuristica.estimar(inicio, objetivo));

        PriorityQueue<NodoCosto<T>> cola = new PriorityQueue<>();
        cola.add(new NodoCosto<>(inicio, fCost.get(inicio)));
        abiertos.add(inicio);

        while (!cola.isEmpty()) {
            NodoCosto<T> actual = cola.poll();
            T idActual = actual.id;

            if (idActual.equals(objetivo)) {
                List<T> camino = new ArrayList<>();
                while (padres.containsKey(idActual)) {
                    camino.add(idActual);
                    idActual = padres.get(idActual);
                }
                camino.add(inicio);
                Collections.reverse(camino);
                System.out.println("Camino encontrado: " + camino);
                System.out.println("Costo total: " + gCost.get(objetivo));
                return;
            }

            abiertos.remove(idActual);
            cerrados.add(idActual);

            Nodo<T> nodoActual = nodos.get(idActual);
            List<INodo<T>> vecinos = nodoActual.getVecinos();
            List<Integer> pesos = nodoActual.getPesos();

            for (int i = 0; i < vecinos.size(); i++) {
                T vecinoId = vecinos.get(i).getValor();
                if (cerrados.contains(vecinoId)) continue;

                int tentativeG = gCost.get(idActual) + pesos.get(i);
                if (tentativeG < gCost.get(vecinoId)) {
                    padres.put(vecinoId, idActual);
                    gCost.put(vecinoId, tentativeG);
                    fCost.put(vecinoId, tentativeG + heuristica.estimar(vecinoId, objetivo));

                    if (!abiertos.contains(vecinoId)) {
                        cola.add(new NodoCosto<>(vecinoId, fCost.get(vecinoId)));
                        abiertos.add(vecinoId);
                    }
                }
            }
        }

        System.out.println("No se encontró camino desde " + inicio + " hasta " + objetivo);
    }

    private static class NodoCosto<T> implements Comparable<NodoCosto<T>> {
        T id;
        int fCost;

        NodoCosto(T id, int fCost) {
            this.id = id;
            this.fCost = fCost;
        }

        public int compareTo(NodoCosto<T> otro) {
            return Integer.compare(this.fCost, otro.fCost);
        }
    }
}