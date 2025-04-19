package modelo;
import interfaces.ILista;
import interfaces.INodo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lista implements ILista {
    private INodo primero;
    
    public Lista() {
        this.primero = null;
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
        } else {
            INodo actual = primero;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevo);
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