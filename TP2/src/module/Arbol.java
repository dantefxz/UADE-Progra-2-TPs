package module;

import interfaces.*;
import java.util.Comparator;

public class Arbol implements IArbol {
    private INodo raiz;
    private Comparator<IPersona> comparador;

    public Arbol(Comparator<IPersona> comparadorInicial) {
        this.raiz = null;
        this.comparador = comparadorInicial;
    }

    @Override
    public void setComparador(Comparator<IPersona> nuevoComparador) {
        this.comparador = nuevoComparador;
    }

    @Override
    public void insertar(IPersona persona) {
        raiz = insertarRec(raiz, persona);
    }

    private INodo insertarRec(INodo nodo, IPersona persona) {
        if (nodo == null) {
            return new Nodo(persona);
        }
        if (comparador.compare(persona, nodo.getPersona()) < 0) {
            nodo.setIzquierdo(insertarRec(nodo.getIzquierdo(), persona));
        } else if (comparador.compare(persona, nodo.getPersona()) > 0) {
            nodo.setDerecho(insertarRec(nodo.getDerecho(), persona));
        }
        return nodo;
    }

    @Override
    public boolean buscar(IPersona persona) {
        return buscarRec(raiz, persona);
    }

    private boolean buscarRec(INodo nodo, IPersona persona) {
        if (nodo == null) return false;
        int comp = comparador.compare(persona, nodo.getPersona());
        if (comp == 0) return true;
        else if (comp < 0) return buscarRec(nodo.getIzquierdo(), persona);
        else return buscarRec(nodo.getDerecho(), persona);
    }

    @Override
    public void recorridoInorden() {
        inordenRec(raiz);
        System.out.println();
    }

    private void inordenRec(INodo nodo) {
        if (nodo != null) {
            inordenRec(nodo.getIzquierdo());
            System.out.print(nodo.getPersona() + " \n");
            inordenRec(nodo.getDerecho());
        }
    }

    @Override
    public void recorridoPreorden() {
        preordenRec(raiz);
        System.out.println();
    }

    private void preordenRec(INodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.getPersona() + " \n");
            preordenRec(nodo.getIzquierdo());
            preordenRec(nodo.getDerecho());
        }
    }

    @Override
    public void recorridoPostorden() {
        postordenRec(raiz);
        System.out.println();
    }

    private void postordenRec(INodo nodo) {
        if (nodo != null) {
            postordenRec(nodo.getIzquierdo());
            postordenRec(nodo.getDerecho());
            System.out.print(nodo.getPersona() + " \n");
        }
    }

    @Override
    public boolean eliminar(IPersona persona) {
        if (!buscar(persona)) return false;
        raiz = eliminarRec(raiz, persona);
        return true;
    }

    private INodo eliminarRec(INodo nodo, IPersona persona) {
        if (nodo == null) return null;

        int comp = comparador.compare(persona, nodo.getPersona());
        if (comp < 0) {
            nodo.setIzquierdo(eliminarRec(nodo.getIzquierdo(), persona));
        } else if (comp > 0) {
            nodo.setDerecho(eliminarRec(nodo.getDerecho(), persona));
        } else {
            // Nodo encontrado
            if (nodo.getIzquierdo() == null) return nodo.getDerecho();
            if (nodo.getDerecho() == null) return nodo.getIzquierdo();

            INodo sucesor = encontrarMinimo(nodo.getDerecho());
            nodo.setPersona(sucesor.getPersona());
            nodo.setDerecho(eliminarRec(nodo.getDerecho(), sucesor.getPersona()));
        }
        return nodo;
    }

    private INodo encontrarMinimo(INodo nodo) {
        while (nodo.getIzquierdo() != null) {
            nodo = nodo.getIzquierdo();
        }
        return nodo;
    }
}
