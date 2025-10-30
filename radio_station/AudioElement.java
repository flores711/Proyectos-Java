package ud9_utilizacion_avanzada_clases.radio_station;

abstract public class AudioElement {
    private String name;


    public AudioElement (String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    abstract public void play();
    abstract public int duration();
    abstract public int profit();


    @Override
    public String toString() {
        return String.format("%s (%d)", name, duration());
    }
}
