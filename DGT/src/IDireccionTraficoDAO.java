import java.util.List;
import java.util.Map;

public interface IDireccionTraficoDAO {
    
    Map<String, String[]> cargarSoluciones() throws DAOException;
    List<Candidato> cargarCandidatos(String idTest) throws DAOException;
    void guardarPuntajes(List<Candidato> candidatos) throws DAOException;


}
