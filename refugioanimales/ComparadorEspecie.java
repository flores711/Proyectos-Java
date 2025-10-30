package ud9_utilizacion_avanzada_clases.refugioanimales;

import java.util.Comparator;

public class ComparadorEspecie implements Comparator<Animal> {
    @Override
    public int compare(Animal a1, Animal a2) {
        int resultado;
        // Esto se puede hacer pero lo de abajo es mejor porque funcionaría aunque se metieran más tipos de animales en el refugio, los seguiría ordenando alfabéticamente y ya
        if (a1 instanceof Gato && a2 instanceof Perro)
            resultado = -1;
        else if (a1 instanceof Perro && a2 instanceof Gato)
            resultado = 1;
        else
            resultado = 0;

        return resultado;
    }
    
}

if (animal1.getClass().getName().compareTo(animal2.getClass().getName()));
if 0, 
    a1.sexo - a2.sexo;
else
    return lo de arriba