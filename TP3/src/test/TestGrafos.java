package test;
import module.*;
import interfaces.*;

public class TestGrafos {
    public static void main(String[] args){
        Grafo<Persona> grafo = new Grafo<>(true);
        Persona p1 = new Persona(465468,"Lauty");
        Persona p2 = new Persona(213136,"Gonza");
        Persona p3 = new Persona(978764,"Dante");
        Persona p4 = new Persona(156446,"Octa");

        // Crear nodos
        grafo.agregarNodo(p1);
        grafo.agregarNodo(p2);
        grafo.agregarNodo(p3);
        grafo.agregarNodo(p4);

        // Crear conexiones (aristas)
        grafo.agregarArista(p1, p2);
        grafo.agregarArista(p1, p3);
        grafo.agregarArista(p1, p4);
        grafo.agregarArista(p1, p1);
        grafo.agregarArista(p3, p2);
        grafo.agregarArista(p2, p3);
        grafo.agregarArista(p3, p2);
        grafo.agregarArista(p3, p3);
        grafo.agregarArista(p4, p2);
        grafo.agregarArista(p4, p1);
        grafo.agregarArista(p2, p2);

        // Mostrar lista de adyacencia
        System.out.println("Lista de adyacencia:");
        grafo.mostrarListaAdyacencia();

        // Mostrar matriz de adyacencia
        System.out.println("\nMatriz de adyacencia:");
        grafo.mostrarMatrizAdyacencia();

        // Recorridos
        System.out.println("\nRecorrido BFS");//Desde Lauty
        grafo.bfs(p1);

        System.out.println("\nRecorrido DFS"); //Desde Lauty
        grafo.dfs(p1);

    }
}
