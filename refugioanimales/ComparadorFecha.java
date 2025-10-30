package ud9_utilizacion_avanzada_clases.refugioanimales;

import java.util.Comparator;

public class ComparadorFecha implements Comparator<Animal>{
    @Override
    public int compare(Animal a1, Animal a2) {
        return a1.getFechaRegistro().compareTo(a2.getFechaRegistro());
    }
}
