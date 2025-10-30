package ud9_utilizacion_avanzada_clases.refugioanimales;

public enum VacunaGato implements Vacuna {
    HERPES("Herpes Felino Tipo 1", true, 36),
    CALICIVIRUS("Calicivirus Felino", true, 36),
    PANLEUCOPENIA("Panleucopenia Felina", true, 36),
    FCORONAVIRUS("Coronavirus", false, 0),
    PERITONITIS("Peritonitis Infecciosa Felina", false, 12);

    private String nombre;
    private boolean esencial;
    private int revacunacion;

    private VacunaGato(String nombre, boolean esencial, int revacunacion) {
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
