package ud10_excepciones_y_ficheros.albergues;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class GestionAlbergue {
    private AlberguesFileDAO dao;
    private Map<String, Albergue> mapaAlbergues;

    public GestionAlbergue(AlberguesFileDAO dao) throws DAOException {
        this.dao = dao;
        this.mapaAlbergues = dao.getAlbergues();
    }


    public void mostrarAlbergues() {
        Set<Albergue> alberguesOrdenados = new TreeSet<>();
        alberguesOrdenados.addAll(mapaAlbergues.values());

        for (Albergue albergue : alberguesOrdenados) {
            System.out.printf("%d\t%s\t%s\n", albergue.getAnio(), albergue.getNombre(), albergue.getProvincia());
        }
    }


    public void mostrarPlazasProvincia() {
        Set<Albergue> albergues = new TreeSet<>();
        albergues.addAll(mapaAlbergues.values());

        Map<String, Integer> provinciaPlazas = new HashMap<>();

        String nombreProvincia;
        for (Albergue albergue : albergues) {
            nombreProvincia = albergue.getProvincia();
            if (!provinciaPlazas.containsKey(nombreProvincia))
                provinciaPlazas.put(nombreProvincia, 0);
            provinciaPlazas.put(nombreProvincia, provinciaPlazas.get(nombreProvincia)+albergue.getPlazas());
        }

        for (String provincia : provinciaPlazas.keySet()) {
            System.out.println(provincia + "\t" + provinciaPlazas.get(provincia));
        }
    }


    public static void main(String[] args) {
        try {
            AlberguesFileDAO dao = new AlberguesFileDAO(args[0], args[1]);
            GestionAlbergue gestion = new GestionAlbergue(dao);
            gestion.mostrarAlbergues();
            System.out.println();
            gestion.mostrarPlazasProvincia();
        } catch (DAOException e) {
            System.out.println(e.getMessage());
        }

    }
}
