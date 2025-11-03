import java.util.Comparator;
import java.util.Map;
import java.util.HashMap;

public class ComparadorDistanciasMapa implements Comparator<Parada> {
    private Map<Parada, Double> mapa;
     
    public ComparadorDistanciasMapa (Map<Parada, Double> mapaDesordenado) {
        this.mapa = mapaDesordenado;
    }

    @Override
    public int compare(Parada parada1, Parada parada2) {
        return Double.compare(mapa.get(parada1), mapa.get(parada2));
    }
}
