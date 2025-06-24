package modelo;

import interfaces.INodo;
import java.util.*;

public class Nodo<T> implements INodo<T> {
    private T valor;
    private List<INodo<T>> vecinos;
    private List<Integer> pesos;

    public Nodo(T valor) {
        this.valor = valor;
        this.vecinos = new ArrayList<>();
        this.pesos = new ArrayList<>();
    }

    public T getValor() {
        return valor;
    }

    public List<INodo<T>> getVecinos() {
        return vecinos;
    }

    public List<Integer> getPesos() {
        return pesos;
    }

    public void agregarVecino(INodo<T> vecino, int peso) {
        vecinos.add(vecino);
        pesos.add(peso);
    }

    @Override
    public String toString() {
        return "Nodo(" + valor + ")";
    }
}