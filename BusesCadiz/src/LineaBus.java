import java.util.List;
import java.util.ArrayList;

public class LineaBus implements Comparable<LineaBus>{
    private String nombre;
    private List<Parada> paradas;
    
    
    public LineaBus(String nombre) {
        this.nombre = nombre;
        this.paradas = new ArrayList<>();
    }


    public String getNombre() {
        return nombre;
    }
    public List<Parada> getParadas() {
        return paradas;
    }
    

    public void agregar(Parada parada) {
        paradas.add(parada);
    }    
    
    public boolean pasaPor(String nombreParada) {
        boolean pasa = false;
        for (Parada parada : paradas) {
            if (parada.getNombre().equals(nombreParada)) {
                pasa = true;
                break;
            }
        }
        return pasa;
    }

    public Parada inicio() {
        Parada parada = null;
        if (!paradas.isEmpty())
            parada = paradas.get(0);
        return parada;
    }
    public Parada fin() {
        Parada parada = null;
        if (!paradas.isEmpty())
            parada = paradas.get(paradas.size()-1);
        return parada;
    }
    

    public double distanciaLinea() {
        Parada parada1;
        Parada parada2;
        double sumaDistancia = 0;
        if (!paradas.isEmpty()) {
            for (int i=0; i<paradas.size()-1; i++) {
                parada1 = paradas.get(i);
                parada2 = paradas.get(i+1);
                sumaDistancia += parada1.distancia(parada2);
            }            
        }
        return sumaDistancia;
    }


    @Override
    public int compareTo(LineaBus otraLinea) {
        return this.nombre.compareTo(otraLinea.nombre);
    }


    @Override
    public String toString() {
        return String.format("%s[%s]", nombre, paradas);
    }


    
}
