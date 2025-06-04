package test;
import module.*;

public class Tp2 {
    public static void main(String[] args) {
        Arbol arbol = new Arbol();

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


        /* MEJORAR LOS PRINTS PORQUE SON HORRIBLES
        * YA AGREGE EL ELIMINAR
        * SALUDOS LAUTY/LATIS :)
        */

        System.out.println("\nInorden:");
        arbol.recorridoInorden();

        System.out.println("\nPreorden:");
        arbol.recorridoPreorden();

        System.out.println("\nPostorden:");
        arbol.recorridoPostorden();

        System.out.println("\nBuscando DNI 15978554: " + arbol.buscar(15978554).getPersona());

        System.out.println("\nEliminamos el DNI 13165489: " + arbol.eliminar(13165489));
        System.out.println("\nPreorden:");
        arbol.recorridoPreorden();
    }

}
