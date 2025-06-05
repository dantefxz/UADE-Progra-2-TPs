package test;

import module.Arbol;
import module.Persona;
import interfaces.IPersona;
import java.util.Comparator;

public class Tp2 {
    public static void main(String[] args) {
        Comparator<IPersona> porDni = Comparator.comparingInt(IPersona::getDni);
        Comparator<IPersona> porNombre = Comparator.comparing(IPersona::getNombre);

        Arbol arbol = new Arbol(porDni);

        arbol.insertar(new Persona(46952312, "Gonza"));
        arbol.insertar(new Persona(11122233, "Latis"));
        arbol.insertar(new Persona(15978554, "Dante"));
        arbol.insertar(new Persona(15615164, "Cami"));
        arbol.insertar(new Persona(47895656, "Abru"));
        arbol.insertar(new Persona(78984564, "Tincho"));
        arbol.insertar(new Persona(78789514, "Fran"));
        arbol.insertar(new Persona(31316878, "Juan"));
        arbol.insertar(new Persona(62624994, "Carlos"));
        arbol.insertar(new Persona(13165489, "Hernesto"));
        arbol.insertar(new Persona(78985313, "Martin"));
        arbol.insertar(new Persona(87489741, "Leo"));
        arbol.insertar(new Persona(79875435, "Emma"));
        arbol.insertar(new Persona(15318496, "Mike"));
        arbol.insertar(new Persona(87976831, "Jose"));

        System.out.println("\nInorden:");
        arbol.recorridoInorden();
        System.out.println("Preorden:");
        arbol.recorridoPreorden();
        System.out.println("Postorden:");
        arbol.recorridoPostorden();

        // Buscar por DNI
        IPersona buscadaPorDni = new Persona(15978554, "");
        System.out.println("\nBuscando por DNI 15978554: " + (arbol.buscar(buscadaPorDni) ? "Encontrado" : "No encontrado"));

        // Eliminar por DNI
        IPersona aEliminar = new Persona(13165489, "");
        System.out.println("\nEliminando a DNI 13165489: " + (arbol.eliminar(aEliminar) ? "Eliminado" : "No eliminado"));

        System.out.println("\nInorden:");
        arbol.recorridoInorden();
        System.out.println("Preorden:");
        arbol.recorridoPreorden();
        System.out.println("Postorden:");
        arbol.recorridoPostorden();

        // Cambiar comparador a nombre
        arbol.setComparador(porNombre);

        // Buscar por nombre
        IPersona buscadaPorNombre = new Persona(0, "Carlos");
        System.out.println("\nBuscando por nombre 'Carlos': " + (arbol.buscar(buscadaPorNombre) ? "Encontrado" : "No encontrado"));

        // Eliminar por nombre
        IPersona eliminarPorNombre = new Persona(0, "Fran");
        System.out.println("\nEliminando por nombre 'Fran': " + (arbol.eliminar(eliminarPorNombre) ? "Eliminado" : "No eliminado"));

        System.out.println("\nInorden:");
        arbol.recorridoInorden();
        System.out.println("Preorden:");
        arbol.recorridoPreorden();
        System.out.println("Postorden:");
        arbol.recorridoPostorden();
    }
}
