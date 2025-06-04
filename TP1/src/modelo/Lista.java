package modelo;

import interfaces.ILista;
import interfaces.INodo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lista implements ILista {
    private INodo primero;
    private INodo ultimo;

    public Lista() {
        this.primero = null;
        this.ultimo = null;
    }

    @Override
    public boolean esVacia(boolean mensaje) {
        if (mensaje && primero == null){
            System.out.println("La lista se encuentra vacía.");
        }
        return primero == null;
    }

    @Override
    public void insertarPrimero(Vehiculo dato) {
        INodo nuevo = new Nodo(dato);
        if (esVacia(false)) {
            this.primero = nuevo;
        } else {
            nuevo.setSiguiente(primero);
            primero.setAnterior(nuevo);
            this.primero = nuevo;
        }
    }
    
    @Override
    public void insertarUltimo(Vehiculo dato) {
        INodo nuevo = new Nodo(dato);
        if (esVacia(false)) {
            primero = nuevo;
            ultimo = nuevo;
        } else {
            INodo actual = primero;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            ultimo = nuevo;
            actual.setSiguiente(ultimo);
            nuevo.setAnterior(actual);
        }
    }
   
    @Override
    public Vehiculo obtenerPrimero() {
        if (esVacia(false)) throw new IllegalStateException("Lista vacía");
        return primero.getDato();
    }
    
    @Override
    public Vehiculo obtenerGenerico(int pos){
        if (!esVacia(false) && pos < cantidadElementos()){
            int contador = 0;
            INodo actual = this.primero;
            while(contador != pos){
                actual = actual.getSiguiente();
                contador++;
            }
            return actual.getDato();
        } else {
            System.out.println("No se puede encontrar un elemento de esta lista.");
            return null;
        }
    }
   
    @Override
    public boolean insertarGenerico(Vehiculo dato, int pos) {
        if (esVacia(true) || pos < 0 || pos > cantidadElementos()) {
            System.out.println("No se ha podido insertar un vehiculo a la lista.");
            return false;
        }

        if (pos == 0) {
            insertarPrimero(dato);
            return true;
        }

        if (pos == cantidadElementos()) {
            insertarUltimo(dato);
            return true;
        }

        INodo actual = primero;
        int contador = 0;
    
        while (actual != null && contador < pos) { // Posicionarse
            actual = actual.getSiguiente();
            contador++;
        }
        INodo nuevo = new Nodo(dato);
        nuevo.setSiguiente(actual);
        nuevo.setAnterior(actual.getAnterior()); // No es null pointer ya que pos == 0 insertar

        if (actual.getAnterior() != null) {
            INodo anterior = actual.getAnterior();
            anterior.setSiguiente(nuevo);
        }
    
        actual.setAnterior(nuevo);
    
        return true;
    }
    
    @Override
    public int cantidadElementos() {
        int contador = 0;
        INodo actual = primero;

        while (actual != null) {
            contador++;
            actual = actual.getSiguiente();
        }

        return contador;
    }
 
    @Override
    public void mostrarLista() {
        if (esVacia(true)) {
        }
        else{
            INodo actual = primero;
            while (actual != null) {
                //getDato --- Del Nodo ---- Vehiculo!!!
                System.out.print(actual.getDato() +"\n");
                actual = actual.getSiguiente();
            }
        }
    }

    @Override
    public void mostrarListaInversa() {
        if (esVacia(true)) {
        }
        else{
            INodo actual = primero;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente(); // Llega al último
            }
            while (actual != null) {
                System.out.println(actual.getDato());
                actual = actual.getAnterior();//Empieza a mostrar para atras
            }
        }
    }

    @Override
    public Vehiculo BuscarPatente(String patente){
        if (esVacia(true)) {
        }
        else{
            INodo actual = primero;
            while (actual != null) {
                Vehiculo vehiculo = actual.getDato();
                String actualPatente = vehiculo.getPatente();
                if(actualPatente.equals(patente)){
                    return vehiculo;
                }
                actual = actual.getSiguiente(); 
            }
        }
        System.out.println("No se encontró la patente: " + patente);
        return null;
    }

    @Override
    public boolean eliminarPorPatente(String patente) {
        if (esVacia(true)){
            return false;
        }
    
        INodo actual = primero;
    
        while (actual != null) {
            Vehiculo vehiculo = actual.getDato();
            String actualPatente = vehiculo.getPatente();
            if (actualPatente.equals(patente)) {
                INodo anterior = actual.getAnterior();
                INodo siguiente = actual.getSiguiente();

                if (anterior == null) {
                    primero = siguiente;
                } else {
                    anterior.setSiguiente(siguiente);
                }
    
                if (siguiente != null) {
                    siguiente.setAnterior(anterior);
                }
    
                return true;
            }
    
            actual = actual.getSiguiente();
        }
    
        return false;
    }

    @Override
    public void ordenarPorPatente(){
        if (esVacia(true)) {
        }
        else{
            INodo actual = primero;
            List<String> patentes = new ArrayList<>();
            while (actual!= null) {
                Vehiculo vehiculo = actual.getDato();
                String patente = vehiculo.getPatente();
                patentes.add(patente);
                actual = actual.getSiguiente();
            }
            Collections.sort(patentes);
            
            System.out.println(patentes);
        }
    }
}