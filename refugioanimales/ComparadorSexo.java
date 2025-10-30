package ud9_utilizacion_avanzada_clases.refugioanimales;

import java.util.Comparator;

public class ComparadorSexo implements Comparator<Animal> {
    @Override
    public int compare(Animal a1, Animal a2) {
        return a1.getSexo() - a2.getSexo();
    }
}
