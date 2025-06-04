package interfaces;

public interface IVehiculo {
    String getPatente();
    void setPatente(String patente);

    String getModelo();
    void setModelo(String modelo);

    @Override
    String toString();
}


    
