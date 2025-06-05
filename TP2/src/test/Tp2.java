package test;

import module.Arbol;
import module.Persona;
import interfaces.IPersona;
import java.util.Comparator;

public class Tp2 {
    public static void main(String[] args) {
        Comparator<IPersona> porDni = Comparator.comparingInt(IPersona::getDni);
        Comparator<IPersona> porNombre = Comparator.comparing(IPersona::getNombre);

        // Los comparadores es para que el árbol funcione con Nombre/DNI, tanto para su lectura como su edición (Eliminar, buscar, recorrer)
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
        IPersona personaABuscar = new Persona(15978554, ""); // Se debe hacer un new Persona ya que Arbol trabaja con IPersona
        System.out.println("\nBuscando por DNI 15978554: " + (arbol.buscar(personaABuscar) ? "Encontrado" : "No encontrado"));

        // Eliminar por DNI
        IPersona personaAEliminar = new Persona(13165489, ""); // Se debe hacer un new Persona ya que Arbol trabaja con IPersona
        System.out.println("\nEliminando a DNI 13165489: " + (arbol.eliminar(personaAEliminar) ? "Eliminado" : "No eliminado"));

        System.out.println("\nInorden:");
        arbol.recorridoInorden();
        System.out.println("Preorden:");
        arbol.recorridoPreorden();
        System.out.println("Postorden:");
        arbol.recorridoPostorden();

        // Cambiar comparador a nombre
        arbol.setComparador(porNombre);

        // Buscar por nombre
        IPersona personaABuscarN = new Persona(0, "Carlos"); // Se debe hacer un new Persona ya que Arbol trabaja con IPersona
        System.out.println("\nBuscando por nombre 'Carlos': " + (arbol.buscar(personaABuscarN) ? "Encontrado" : "No encontrado"));

        // Eliminar por nombre
        IPersona personaAEliminarN = new Persona(0, "Fran"); // Se debe hacer un new Persona ya que Arbol trabaja con IPersona
        System.out.println("\nEliminando por nombre 'Fran': " + (arbol.eliminar(personaAEliminarN) ? "Eliminado" : "No eliminado"));

        System.out.println("\nInorden:");
        arbol.recorridoInorden();
        System.out.println("Preorden:");
        arbol.recorridoPreorden();
        System.out.println("Postorden:");
        arbol.recorridoPostorden();

        // Arbol construido en base de nombre
        System.out.println("Arbol por nombre:");
        Arbol arbol2 = new Arbol(porNombre);
        arbol2.insertar(new Persona(46952312, "Gonza"));
        arbol2.insertar(new Persona(11122233, "Latis"));
        arbol2.insertar(new Persona(15978554, "Dante"));
        arbol2.insertar(new Persona(15615164, "Cami"));
        arbol2.insertar(new Persona(47895656, "Abru"));
        arbol2.insertar(new Persona(78984564, "Tincho"));
        arbol2.insertar(new Persona(78789514, "Fran"));
        arbol2.insertar(new Persona(31316878, "Juan"));
        arbol2.insertar(new Persona(62624994, "Carlos"));
        arbol2.insertar(new Persona(13165489, "Hernesto"));
        arbol2.insertar(new Persona(78985313, "Martin"));
        arbol2.insertar(new Persona(87489741, "Leo"));
        arbol2.insertar(new Persona(79875435, "Emma"));
        arbol2.insertar(new Persona(15318496, "Mike"));
        arbol2.insertar(new Persona(87976831, "Jose"));

        System.out.println("\nInorden:");
        arbol2.recorridoInorden();
        System.out.println("Preorden:");
        arbol2.recorridoPreorden();
        System.out.println("Postorden:");
        arbol2.recorridoPostorden();
    }
}
