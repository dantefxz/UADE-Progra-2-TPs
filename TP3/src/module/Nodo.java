package module;

import interfaces.INodo;
import java.util.*;

public class Nodo<T> implements INodo<T> {
    private T valor;
    private List<INodo<T>> vecinos;

    public Nodo(T valor) {
        this.valor = valor;
        this.vecinos = new ArrayList<>();
    }

    @Override
    public T getValor() {
        return valor;
    }

    @Override
    public void setValor(T valor) {
        this.valor = valor;
    }

    @Override
    public void agregarVecino(INodo<T> vecino) {
        if (!vecinos.contains(vecino)) {
            vecinos.add(vecino);
        }
    }

    @Override
    public List<INodo<T>> getVecinos() {
        return vecinos;
    }

    @Override
    public String toString() {
        return valor.toString();
    }
}