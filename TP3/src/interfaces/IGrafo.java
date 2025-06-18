package interfaces;

import java.util.Map;

public interface IGrafo<T> {
    void agregarNodo(T valor);

    void agregarArista(T origen, T destino);

    void mostrarListaAdyacencia();

    void mostrarMatrizAdyacencia();

    void bfs(T inicio);

    void dfs(T inicio);

    void setDirigido(boolean valor);
    
    Map<T, INodo<T>> getNodos();
}