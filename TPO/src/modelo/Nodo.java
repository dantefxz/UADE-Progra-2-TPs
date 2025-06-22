package modelo;

import interfaces.INodo;
import java.util.*;

public class Nodo implements INodo {
    private int valor;
    private List<INodo> vecinos;
    private List<Integer> pesos;

    public Nodo(int valor) {
        this.valor = valor;
        this.vecinos = new ArrayList<>();
        this.pesos = new ArrayList<>();
    }

    public int getValor() {
        return valor;
    }

    public List<INodo> getVecinos() {
        return vecinos;
    }

    public List<Integer> getPesos() {
        return pesos;
    }

    public void agregarVecino(INodo vecino, int peso) {
        vecinos.add(vecino);
        pesos.add(peso);
    }

    @Override
    public String toString() {
        return "Nodo(" + valor + ")";
    }
}