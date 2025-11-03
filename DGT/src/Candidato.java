public class Candidato {
    private String nombre;
    private String idTest;
    private int puntaje;
    private String[] respuestas;


    public Candidato (String nombre, String idTest, String[] respuestas) {
        this.nombre = nombre;
        this.idTest = idTest;
        this.respuestas = respuestas;
        this.puntaje = 0;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public String[] getRespuestas() {
        return respuestas;
    }

    @Override
    public String toString() {
        return String.format("%s\t%d\t%s\t%s", nombre, puntaje, idTest, (puntaje >= 7) ? "" : "suspenso");
    }
}
