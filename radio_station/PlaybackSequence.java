package ud9_utilizacion_avanzada_clases.radio_station;

public class PlaybackSequence extends AudioElement {
    private SingleAudioElement[] listaAudios; // Se inicializa en 100
    private int cantidadAudios;
    // private String nombreSecuencia; - Esto no, AudioElement ya tiene nombre
    private final int MAX_ELEMENTOS = 100;


    public PlaybackSequence(String nombreSecuencia) {
        super(nombreSecuencia);
        listaAudios = new SingleAudioElement[MAX_ELEMENTOS];
        cantidadAudios = 0;
    }

    // hacer métodos boolean full() y boolean isValid(posicion)

    public void add(SingleAudioElement audioElement) {
        // if (!full())
        listaAudios[cantidadAudios] = audioElement;
        cantidadAudios++;
    }

    public void set(int posicion, SingleAudioElement audioElement) {
        // if posicion is valid
        if (listaAudios[posicion].equals(null))
            cantidadAudios++;

        listaAudios[posicion] = audioElement;
    }

    public void remove(int posicion) {
        // if posicion is valid
        for (int i=posicion; i<cantidadAudios-1; i++) {
            listaAudios[i] = listaAudios[i+1];
        }
    }

    public void insert(int posicion, SingleAudioElement audioElement) {
        // if posicion is valid and !full
        if (posicion < cantidadAudios) { // Posiciones ocupadas y una más de la última (cantidadAudios empieza en 1 y las posiciones en 0, así que no hace falta sumar 1 para acceder a la posición siguiente a la última ocupada)
            for (int i=cantidadAudios; i>posicion; i--) {
                listaAudios[i] = listaAudios[i-1];
            }
            listaAudios[posicion] = audioElement;
        }
        // aumentar contador
    }


    @Override
    public void play() {
        for (int i=0; i<cantidadAudios; i++) {
            // lista[i].play() - Es un método suyo ya, ella ya llamará a AudioTools (polimorfismo)
            AudioTools.play(listaAudios[i].getFileName());
        }
    }

    @Override
    public int duration() {
        int suma = 0;
        for (int i=0; i<cantidadAudios; i++) {
            // lista[i].duration() - Es un método suyo ya, ella ya llamará a AudioTools (polimorfismo)
            suma += AudioTools.getDuration(listaAudios[i].getFileName());
        }
        return suma;
    }

    @Override
    public int profit() {
        int beneficio = 0;
        for (int i=0; i<cantidadAudios; i++) {
            // aquí sí lo hice bien jasjkasjaj (polimorfismo)
            beneficio += listaAudios[i].profit();
        }
        return beneficio;
    }


    @Override
    // HACER BIEN
    public String toString() {
        // Empezar con super.toString() --> El duration del super es abstracto así que igualmente coge el del hijo, el de este
        String cadena = "";
        for (int i=0; i<cantidadAudios; i++) {
            cadena += listaAudios[i] + ", ";
        }
        return String.format("%s (%d) {%s}", nombreSecuencia, duration(), cadena);
    }
}
