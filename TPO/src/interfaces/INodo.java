package interfaces;

import java.util.List;

public interface INodo {
    int getValor();
    List<INodo> getVecinos();
    List<Integer> getPesos();
    void agregarVecino(INodo vecino, int peso);
}
