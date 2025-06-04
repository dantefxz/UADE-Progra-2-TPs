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

    public INodo eliminar(int DNI) {
        raiz = eliminarRec(raiz, DNI);
        return null;
    }

    private INodo eliminarRec(INodo nodo, int DNI) {
        if (nodo == null) return null;

        if (DNI < nodo.getDato()) {
            nodo.setIzquierdo(eliminarRec(nodo.getIzquierdo(), DNI));
        } else if (DNI > nodo.getDato()) {
            nodo.setDerecho(eliminarRec(nodo.getDerecho(), DNI));
        } else {
            // Caso 1: nodo sin hijos
            if (nodo.getIzquierdo() == null && nodo.getDerecho() == null) {
                return null;
            }

            // Caso 2: un solo hijo
            if (nodo.getIzquierdo() == null) {
                return nodo.getDerecho();
            }
            if (nodo.getDerecho() == null) {
                return nodo.getIzquierdo();
            }

            // Caso 3: dos hijos
            INodo sucesor = encontrarMinimo(nodo.getDerecho());
            nodo.setPersona(((Nodo) sucesor).getPersona());
            nodo.setDerecho(eliminarRec(nodo.getDerecho(), sucesor.getDato()));
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