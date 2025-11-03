package ud10_excepciones_y_ficheros.albergues;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class AlberguesFileDAO {
    private String ruta1;
    private String ruta2;

    public AlberguesFileDAO (String ruta1, String ruta2) {
        this.ruta1 = ruta1;
        this.ruta2 = ruta2;
    }

    public Map<String, Albergue> getAlbergues() throws DAOException{
        // Hacemos mapa porque luego cuando leamos todo capacidad.csv, vamos a tener que buscar en la colección de albergues cuál corresponde con el mismo nombre y municipio. Y es mucho más óptimo así con mapas, donde la clave sea el nombre y el municipio concatenados, que ir recorriendo uno a uno e ir pidiendo getNombre() y getMunicipio() en cada uno.
        Map<String, Albergue> mapaAlbergues = new HashMap<>();

        /* RECIBIR RUTAS DE GESTIONALBERGUE */
        try (BufferedReader inAlbergues = new BufferedReader(new FileReader(ruta1));
        BufferedReader inCapacidades = new BufferedReader(new FileReader(ruta2));) {

            String linea;
            String[] partes;
            String provincia;
            LocalDate fechaApertura;
            String nombre;
            String municipio;
            boolean web;
            Albergue albergue;
            while ((linea = inAlbergues.readLine()) != null) {
                partes = linea.split(";");
                if (partes.length != 5)
                    throw new DAOException("La línea debe tener 5 argumentos");
                /* LANZAR FORMATOFICHEROEXCEPTION SI NO TIENE 5 ARGUMENTOS */

                provincia = partes[0];
                // Se puede parsear la fecha directamente si está en orden YYYY-MM-DD
                fechaApertura = LocalDate.parse(partes[1]);
                nombre = partes[2];
                municipio = partes[3];
                web = (partes[4].equals("SI")) ? true : false;

                albergue = new Albergue(provincia, fechaApertura, nombre, municipio, web);
                mapaAlbergues.put(nombre+municipio, albergue);
            }

            int plazas;
            String nombreYMunicipio;
            while ((linea = inCapacidades.readLine()) != null) {
                partes = linea.split(";");

                nombreYMunicipio = partes[0] + partes[1];
                // Esto no nos hace falta de momento (el problema no pide que hagamos nada con esto)
                //unidadesAlojamiento = Integer.parseInt(partes[2]);
                //habitaciones = Integer.parseInt(partes[3]);
                plazas = Integer.parseInt(partes[4]);

                // Hacemos get directamente, no hace falta recorrerlo entero
                mapaAlbergues.get(nombreYMunicipio).setPlazas(plazas);
            }

        } catch (FileNotFoundException ex) {
            System.out.println("No se encuentra");
        }
        catch (IOException e) {
            System.out.println("Error en E/S");
        }

        return mapaAlbergues;

    }   
}
