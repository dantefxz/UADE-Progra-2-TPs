package module;

import interfaces.*;

import java.util.*;

public class Grafo<T> implements IGrafo<T> {
    private Map<T, INodo<T>> nodos;
    private boolean dirigido;

    public Grafo(boolean dirigido) {
        this.dirigido = dirigido;
        this.nodos = new HashMap<>();
    }

    @Override
    public void setDirigido(boolean valor){
        dirigido = valor;
    }
    
    @Override
    public void agregarNodo(T valor) {
        nodos.putIfAbsent(valor, new Nodo<>(valor));
    }

    @Override
    public void agregarArista(T origen, T destino) {
        if (nodos.containsKey(origen) && nodos.containsKey(destino)) {
            nodos.get(origen).agregarVecino(nodos.get(destino));
            if (!dirigido) {
                nodos.get(destino).agregarVecino(nodos.get(origen));
            }
        }
    }

    @Override
    public void mostrarListaAdyacencia() {
        for (T clave : nodos.keySet()) {
            System.out.print(clave + ": ");
            for (INodo<T> vecino : nodos.get(clave).getVecinos()) {
                System.out.print(vecino.getValor() + " ");
            }
            System.out.println();
        }
    }

    @Override
    public void mostrarMatrizAdyacencia() {
        List<T> claves = new ArrayList<>(nodos.keySet());

        for (T col : claves) System.out.print("\n"+col + " ");

        System.out.print("\n\n");
        for (T fila : claves) {
            System.out.print(fila + ": ");
            for (T col : claves) {
                if (nodos.get(fila).getVecinos().contains(nodos.get(col))) {
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }

    @Override
    public void bfs(T inicio) {
        if (!nodos.containsKey(inicio)) return;

        Set<T> visitados = new HashSet<>();
        Queue<INodo<T>> cola = new LinkedList<>();

        cola.add(nodos.get(inicio));
        visitados.add(inicio);

        while (!cola.isEmpty()) {
            INodo<T> actual = cola.poll();
            System.out.print(actual.getValor() + " ");

            for (INodo<T> vecino : actual.getVecinos()) {
                if (!visitados.contains(vecino.getValor())) {
                    visitados.add(vecino.getValor());
                    cola.add(vecino);
                }
            }
        }
        System.out.println();
    }

    @Override
    public void dfs(T inicio) {
        if (!nodos.containsKey(inicio)) return;

        Set<T> visitados = new HashSet<>();
        dfsRec(nodos.get(inicio), visitados);
        System.out.println();
    }

    private void dfsRec(INodo<T> actual, Set<T> visitados) {
        visitados.add(actual.getValor());
        System.out.print(actual.getValor() + " ");

        for (INodo<T> vecino : actual.getVecinos()) {
            if (!visitados.contains(vecino.getValor())) {
                dfsRec(vecino, visitados);
            }
        }
    }

    @Override
    public Map<T, INodo<T>> getNodos() {
        return nodos;
    }
}
