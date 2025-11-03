import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;


public class DireccionTraficoDAO implements IDireccionTraficoDAO {
    private File fileSoluciones;
    private File filePuntajes;
    private static final String SOLUCIONES = "dgt/soluciones.txt";
    private static final String PUNTAJES = "dgt/puntajes.txt";

    
    public DireccionTraficoDAO() throws IllegalArgumentException {
        this.fileSoluciones = new File(SOLUCIONES);
        if (!fileSoluciones.exists())
            throw new IllegalArgumentException("No se puede construir el objeto de acceso a datos porque el archivo de soluciones " + SOLUCIONES + " no existe");
        this.filePuntajes = new File(PUNTAJES);
    }


    @Override
    public Map<String, String[]> cargarSoluciones() throws DAOException {
        Map<String, String[]> mapaSoluciones = new HashMap<>();

        try (BufferedReader in = new BufferedReader(new FileReader(fileSoluciones))) {
            
            String linea;
            String[] partes;
            String idTest;
            String[] respuestas = new String[10];
            while ((linea = in.readLine()) != null) {
                partes = linea.split(";");
                
                idTest = partes[0];
                for (int i=1; i<partes.length; i++) {
                    respuestas[i-1] = partes[i];
                }

                mapaSoluciones.put(idTest, respuestas);
            }

        } catch (FileNotFoundException ex) {
            throw new DAOException("El archivo de soluciones " + SOLUCIONES + " no se encuentra");
        } catch (IOException e) {
            throw new DAOException("Error leyendo el archivo de soluciones " + SOLUCIONES);
        }

        return mapaSoluciones;
    }


    @Override
    public List<Candidato> cargarCandidatos(String idTest) throws DAOException {
        List<Candidato> listaCandidatos = new ArrayList<>();
        String nombreArchivoTest = idTest + ".txt";
        File archivoTest = new File("dgt", nombreArchivoTest);
        try (BufferedReader in = new BufferedReader(new FileReader(archivoTest))) {
            
            String linea;
            String[] partes;
            String nombreCandidato;
            while ((linea = in.readLine()) != null) {
                partes = linea.split(";");

                nombreCandidato = partes[0];
                String[] respuestas = new String[10];
                for (int i=1; i<partes.length; i++) {
                    respuestas[i-1] = partes[i];
                }
                
                Candidato candidato = new Candidato(nombreCandidato, idTest, respuestas);
                listaCandidatos.add(candidato);
            }


        } catch (FileNotFoundException ex) {
            throw new DAOException("El archivo del test " + idTest + " no se encuentra");
        } catch (IOException e) {
            throw new DAOException("Error leyendo el archivo del test " + idTest);
        }

        return listaCandidatos;
    }


    @Override
    public void guardarPuntajes(List<Candidato> candidatos) throws DAOException {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(filePuntajes, true))) {
            for (Candidato candidato : candidatos) {
                out.write(candidato + "\n");
            }
        } catch (IOException e) {
            throw new DAOException("Error escribiendo el archivo de puntajes " + PUNTAJES);
        }
    }
}
