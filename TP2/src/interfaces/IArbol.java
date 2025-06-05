package interfaces;

import java.util.Comparator;

public interface IArbol {
    void insertar(IPersona persona);
    boolean buscar(IPersona persona);
    boolean eliminar(IPersona persona);
    void recorridoInorden();
    void recorridoPreorden();
    void recorridoPostorden();
    void setComparador(Comparator<IPersona> comparador);
}
