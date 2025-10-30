package ud9_utilizacion_avanzada_clases.radio_station;

abstract public class SingleAudioElement extends AudioElement {
    private String fileName;   // Nombre del ARCHIVO (cancion.mp3), no de la canción
    private int duration;
    private int profit;

    public SingleAudioElement(String name, String fileName, int profit) {
        super(name);
        this.fileName = fileName;
        this.profit = profit;
        this.duration = AudioTools.getDuration(fileName);
    }

    public String getFileName() {
        return fileName;
    }

    //Hace falta poner el Override?
    @Override
    public void play() {
        AudioTools.play(fileName);
    }

    @Override
    public int duration() {
        return duration;
    }

    @Override
    public int profit() {
        return profit;
    }
    
    @Override
    public String toString() {
        return String.format(super.toString());
    }
}
