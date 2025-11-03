import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DireccionTraficoApp {
    private IDireccionTraficoDAO dao;


    public DireccionTraficoApp(IDireccionTraficoDAO dao) {
        this.dao = dao;
    }

    public void procesaTest() throws RuntimeException {
        Map<String, String[]> mapaSoluciones;
        List<Candidato> candidatosTest;

        try {
            mapaSoluciones = dao.cargarSoluciones();
        
            for (String idTest : mapaSoluciones.keySet()) {
                candidatosTest = new ArrayList<>();
                try {
                    candidatosTest.addAll(dao.cargarCandidatos(idTest));
                
                    for (Candidato candidato : candidatosTest) {
                        int puntaje = CalculadoraPuntajes.calcularPuntaje(mapaSoluciones.get(idTest), candidato.getRespuestas());
                        candidato.setPuntaje(puntaje);
                    }
                    try {
                        dao.guardarPuntajes(candidatosTest); 
                    } catch (DAOException e) {
                        throw new RuntimeException(e.getMessage());
                    }
                } catch (DAOException e) {
                    System.out.println("No hay candidatos para el test " + idTest);
                    continue;
                }
            }
        } catch (DAOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }


    public static void main(String[] args) {
        try {
            IDireccionTraficoDAO dao = new DireccionTraficoDAO();
            DireccionTraficoApp app = new DireccionTraficoApp(dao);
            app.procesaTest();
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }
    }

}
