package modelo;

import interfaces.IVehiculo;

public class Vehiculo implements IVehiculo {

	private String patente;
	private String modelo;
	
	@Override
	public String getPatente() {
		return patente;
	}

	@Override
	public void setPatente(String patente) {
		this.patente = patente;
	}

	@Override
	public String getModelo() {
		return modelo;
	}

	@Override
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	@Override
	public String toString() {
		return "Vehiculo [patente= " + patente + ", modelo= " + modelo + "]";
	}

	public Vehiculo(String patente, String modelo) {
		super();
		this.patente = patente;
		this.modelo = modelo;
	}
	
	
}
