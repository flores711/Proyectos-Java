package ud9_utilizacion_avanzada_clases.refugioanimales;

public enum VacunaPerro implements Vacuna {
    MOQUILLO("Moquillo canino", true, 36),
    PARVOVIRUS("Parvovirus canino", true, 36),
    RABIA("Rabia", true, 12),
    ADENOVIRUS("Adenovirus canino tipo I y II", true, 36),
    CCORONAVIRUS("Coronavirus", false, 0),
    LEPTOSPIRA("Leptopirosis", false, 12);

    private String nombre;
    private boolean esencial;
    private int revacunacion;

    private VacunaPerro(String nombre, boolean esencial, int revacunacion) {
        this.nombre = nombre;
        this.esencial = esencial;
        this.revacunacion = revacunacion;
    }

    
    @Override
    public String nombre() {
        return nombre;
    }
    @Override
    public boolean esEsencial() {
        return esencial;
    }
    @Override
    public int revacunacion() {
        return revacunacion;
    }
}
