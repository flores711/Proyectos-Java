import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Empresa {
    private String nombre;
    private List<LineaBus> lineasBuses;


    public Empresa(String nombre) {
        this.nombre = nombre;
        this.lineasBuses = new ArrayList<>();
    }


    public String getNombre() {
        return nombre;
    }
    public List<LineaBus> getLineasBuses() {
        return lineasBuses;
    }


    // Los que estén fuera de ese radio no los pongo, y los que estén dentro los pongo ordenados de más cerca a más lejos
    public Map<Parada, Double> paradasCercanas(double latitud, double longitud, double radio) {
        Map<Parada, Double> mapaDesordenado = new HashMap<>();

        for (LineaBus linea : lineasBuses) {
            for (Parada parada : linea.getParadas()) {
                double distancia = parada.distancia(latitud, longitud);
                if (distancia <= radio) {
                    mapaDesordenado.put(parada, distancia); //--> No se agrega si ya hay una parada igual como clave, y para ello lo comprueba con el equals de Parada
                }
            }
        }

        // Devolver mapa ordenado
        List<Parada> paradasOrdenadas = new ArrayList<>();
        paradasOrdenadas.addAll(mapaDesordenado.keySet());
        // Con clase Comparator aparte
        ComparadorDistanciasMapa comparador = new ComparadorDistanciasMapa(mapaDesordenado);
        Collections.sort(paradasOrdenadas, comparador);

        // Con comparador de clase anónima
        /* Collections.sort(paradasOrdenadas, new Comparator<Parada>() {
            @Override
            public int compare(Parada parada1, Parada parada2) {
                return Double.compare(mapaDesordenado.get(parada1), mapaDesordenado.get(parada2));
            }
        }); */

        Map<Parada, Double> mapaOrdenado = new LinkedHashMap<>();
        for (Parada parada : paradasOrdenadas) {
            mapaOrdenado.put(parada, mapaDesordenado.get(parada));
        }


        return mapaOrdenado;

    }


    public List<LineaBus> lineasPorParada(String nombreParada) {
        // Reutilizo método de LineaBus
        List<LineaBus> lineasParada = new ArrayList<>();
        for (LineaBus linea : lineasBuses) {
            if (linea.pasaPor(nombreParada))
                lineasParada.add(linea);
        }

        return lineasParada;
    }


    public void leerDatos() {
        Scanner sc = new Scanner(System.in);

        String[] lineaEntrada;
        LineaBus lineaBus = null;
        Parada parada;
        while (true) {
            lineaEntrada = sc.nextLine().split("; ");
            if (lineaEntrada[0].equals("FIN"))
                break;

            // Si es una LÍNEA
            if (lineaEntrada.length == 1) {
                lineaBus = new LineaBus(lineaEntrada[0]);
                lineasBuses.add(lineaBus);
            } else {    // Si es una PARADA de esa línea
                String nombreParada = lineaEntrada[0];
                double latitud = Double.parseDouble(lineaEntrada[1]);
                double longitud = Double.parseDouble(lineaEntrada[2]);

                if(GeoUtils.esCoordenadaValida(latitud, longitud)) {
                    parada = new Parada(nombreParada, latitud, longitud);
                    lineaBus.agregar(parada);
                }
            }
        }
        sc.close();
    }


    public static void main(String[] args) {
        Empresa empresa = new Empresa("Consorcio de Transportes Costa de la Luz");
        empresa.leerDatos();

        System.out.println(empresa.nombre);
        System.out.println();
        System.out.println("=== Reporte de líneas ===");
        for (LineaBus linea : empresa.lineasBuses) {
            System.out.println("Línea: " + linea.getNombre());
            System.out.println("Paradas: " + linea.getParadas().size());
            System.out.println("Inicio: " + linea.inicio());
            System.out.println("Fin: " + linea.fin());
            System.out.printf("Distancia total: %.2f km\n", linea.distanciaLinea());
            System.out.println("---------------------------------------");
        }
        System.out.println();
        String nombreParada = "Puerta Tierra";
        List<LineaBus> lineasParada = empresa.lineasPorParada(nombreParada);
        System.out.println("=== Líneas que pasan por la parada " + nombreParada + ": " + lineasParada.size());
        for (LineaBus linea : lineasParada) {
            System.out.println("Línea: " + linea.getNombre());
        }
        System.out.println();

        double latitud = 36.5295;
        double longitud = -6.2956;
        double radio = 0.5;
        System.out.println("Paradas ordenadas por distancia más cercanas a la Catedral de Cádiz (" + latitud + ", " + longitud + ") en un radio de " + radio + " km:");

        Map<Parada, Double> mapaParadaDistancia = empresa.paradasCercanas(latitud, longitud, radio);
        for (Parada parada : mapaParadaDistancia.keySet()) {
            System.out.printf("%s - %.2fkm\n", parada.getNombre(), mapaParadaDistancia.get(parada));
        }
    }
}
