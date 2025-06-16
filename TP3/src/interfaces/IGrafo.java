package interfaces;

import java.util.Map;

public interface IGrafo<T> {
    void agregarNodo(T valor);

    void agregarArista(T origen, T destino);

    void mostrarListaAdyacencia();

    void mostrarMatrizAdyacencia();

    void bfs(T inicio);

    void dfs(T inicio);

    Map<T, INodo<T>> getNodos();
}