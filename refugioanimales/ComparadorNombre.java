package ud9_utilizacion_avanzada_clases.refugioanimales;

import java.util.Comparator;

public class ComparadorNombre implements Comparator<Animal> {
    @Override
    public int compare(Animal a1, Animal a2) {
        return a1.getNombre().compareTo(a2.getNombre());
    }
}
