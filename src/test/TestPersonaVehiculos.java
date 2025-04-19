package test;

import modelo.*;

///Listas simplemente enlazadas N - > sig,  ant
///Listas doblemete enlazadas (int)
///Persona que tiene una lista de Vehiculos!!!!

public class TestPersonaVehiculos {

	public static void main(String[] args) {

		Persona p = new Persona(11111, "Nico Perez");
		Vehiculo v = new Vehiculo("AH8963ER", "Fiat Uno");
		Vehiculo v2 = new Vehiculo("ARG785", "Fiat Cronos");
		Vehiculo v3 = new Vehiculo("ZE125GG", "Ford Mustang GT");
		Vehiculo v4 = new Vehiculo("FF985LL", "Peugeot 208");
		Vehiculo v5 = new Vehiculo("GRV245", "Audi A4");

		Vehiculo v10 = new Vehiculo("JJBA07", "SI");

		Lista vehiculos = p.getListaVehiculos();
		vehiculos.insertarPrimero(v);
		vehiculos.insertarPrimero(v3);
		vehiculos.insertarUltimo(v4);
		vehiculos.insertarUltimo(v2);
		vehiculos.insertarPrimero(v5);

		// Audi, Ford Mustang, Fiat Uno, Peugot, Fiat Cronos

		vehiculos.mostrarLista();

		System.out.println("*".repeat(40) + "Obtener generico (pos=1):");
		System.out.println(vehiculos.obtenerGenerico(1)); // Ford
		System.out.println("*".repeat(40) + "Ordenar por patente (A-Z, 0+):");
		p.getListaVehiculos().ordenarPorPatente(); // Hecho en .getListaVehiculos a propósito
		System.out.println("*".repeat(40) + "Lista inversa:");
		p.getListaVehiculos().mostrarListaInversa(); // De Fiat Cronos a Audi (Referencia .mostrarLista()) Hecho en .getListaVehiculos a propósito. Testeo de .getAnterior()
		System.out.println("*".repeat(40) + "Buscar Peugot:");
		Vehiculo vehiculoBuscado = p.buscarVehiculo("FF985LL"); // Peugot
		System.out.println(vehiculoBuscado);
		System.out.println("*".repeat(40) + "Eliminar Peugot:");
		p.eliminarVehiculo("FF985LL"); // Peugot
		System.out.println("Peugot eliminado.");
		Vehiculo vehiculoEliminar = p.buscarVehiculo("FF985LL");
		System.out.println(vehiculoEliminar);
		System.out.println("*".repeat(40) + "Lista sin peugot:");
		vehiculos.mostrarLista();
		System.out.println("*".repeat(40) + "Añadir ante-ultimo:");
		System.out.println(vehiculos.insertarGenerico(v10, 3));
		System.out.println("*".repeat(40) + "Full persona:");
		p.mostrarPersona();

		//Muestro la persona, y sus vehiculos concatenados
		//Atentos a cómo manejo el toString de ambos y los
		//procedimientos de mostrar.

		//p.mostrarPersona();
		
		///Notar que toda la información quedó guardada en la persona
		///
		///NOTAS: 
		///esto es una ayuda para el tp1, pero tienen muchas cosas que mejorar
		///1 - Hacer y usar una lista doblemente enlazada
		///2 - Testear más metodos, incluso algunos sofisticados como 
		///ordenar y buscar vehiculos
		///3 - El nodo tiene que tener el anterior, ojo que eso modifica los métodos
		///4 - Yo omiti las interfaces para hacer más rapido el ejemplo
		///Ustedes tienen que poner las interfaces y usarlas bien
		///Ningún items es obligatorio, pero cuanto más completo más nota. 
		/// 
		

	}

}
