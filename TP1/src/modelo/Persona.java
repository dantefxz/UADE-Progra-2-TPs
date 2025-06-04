package modelo;

import interfaces.IPersona;

public class Persona implements IPersona {
	private int dni;
	private String nombre;
	//Lo más importante del TP
	//anidado por medio de un array Vehiculo[3]
	//private List<Vehiculo> Vehiculos; // No entendimos si hacer array o no
	private Lista listaVehiculos;
	
	@Override
	public int getDni() {
		return dni;
	}

	@Override
	public void setDni(int dni) {
		this.dni = dni;
	}

	@Override
	public String getNombre() {
		return nombre;
	}

	@Override
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	//Prestar atención
	public Persona(int dni, String nombre) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.listaVehiculos = new Lista();//solo se crea la lista
		//this.Vehiculos = new ArrayList<>();
	}
	
	@Override
	public String toString() {
		return "Persona [dni= " + dni + ", nombre= " + nombre +"]";
	}
	
	@Override
	public Lista getListaVehiculos() {
		return listaVehiculos;
	}

	@Override
	public void setListaVehiculos(Lista listaVehiculos) {
		this.listaVehiculos = listaVehiculos;
	}
	
	@Override
	public void mostrarPersona() {
		System.out.println(this);
		listaVehiculos.mostrarLista();
	}

	@Override
	public boolean eliminarVehiculo(String patente) {
		return listaVehiculos.eliminarPorPatente(patente);
	}

	@Override
	public Vehiculo buscarVehiculo(String patente) {
		return listaVehiculos.BuscarPatente(patente);
	}
	
	

}
