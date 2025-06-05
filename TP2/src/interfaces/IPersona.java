package interfaces;

public interface IPersona {
    int getDni();
    String getNombre();
    void setDni(int dni);
    void setNombre(String nombre);

    @Override
    String toString();
}