package module;
import interfaces.*;

public class Arbol implements IArbol {
    private INodo raiz;

    public Arbol() {
        this.raiz = null;
    }

    @Override
    public void insertar(Persona persona) {
        raiz = insertarRec(raiz, persona);
    }

    private INodo insertarRec(INodo nodo, Persona persona) {
        if (nodo == null) {
            return new Nodo(persona);
        }

        if (persona.getDni() < nodo.getDato()) {
            nodo.setIzquierdo(insertarRec(nodo.getIzquierdo(), persona));
        } else if (persona.getDni() > nodo.getDato()) {
            nodo.setDerecho(insertarRec(nodo.getDerecho(), persona));
        }

        return nodo;
    }


    @Override
    public INodo buscar(int DNI) {
        return buscarRec(raiz, DNI);
    }

    private INodo buscarRec(INodo nodo, int DNI) {
        if (nodo == null || nodo.getDato() == DNI) {
            return nodo;
        }
        if (DNI < nodo.getDato()) {
            return buscarRec(nodo.getIzquierdo(), DNI);
        } else {
            return buscarRec(nodo.getDerecho(), DNI);
        }
    }

    @Override
    public void recorridoInorden() {
        inordenRec(raiz);
    }

    private void inordenRec(INodo nodo) {
        if (nodo != null) {
            inordenRec(nodo.getIzquierdo());
            System.out.print(nodo.getPersona() + " ");
            inordenRec(nodo.getDerecho());
        }
    }

    @Override
    public void recorridoPreorden() {
        preordenRec(raiz);
    }

    private void preordenRec(INodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.getPersona() + " ");
            preordenRec(nodo.getIzquierdo());
            preordenRec(nodo.getDerecho());
        }
    }

    @Override
    public void recorridoPostorden() {
        postordenRec(raiz);
    }

    private void postordenRec(INodo nodo) {
        if (nodo != null) {
            postordenRec(nodo.getIzquierdo());
            postordenRec(nodo.getDerecho());
            System.out.print(nodo.getPersona() + " ");
        }
    }

}