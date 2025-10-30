package ud9_utilizacion_avanzada_clases.radio_station;

public class RadioStation {
    public static void main(String[] args) {
        PlaybackSequence list40 = new PlaybackSequence("List 40");
        PlaybackSequence salsa = new PlaybackSequence("Salsa");
        PlaybackSequence program = new PlaybackSequence("Program");

        list40.add(new Song("Despacito", "despacito.mp3", 10));
        list40.add(new Commercial("Movistar", "movistar.mp3", 30));
        list40.add(new Song("Black summer", "black_summer.mp3", 8));
        list40.add(new Commercial("Camporrio", "camporrio.mp3", 100));
        list40.add(new Song("De perreo", "de_perreo.mp3", 7));
        list40.add(new OwnAudio("Noticia local", "noticia_local001.mp3"));
        
        salsa.add(new Song("Gitana", "gitana.mp3", 5));
        salsa.add(new Commercial("Telepizza", "telepizza.mp3", 100));
        salsa.add(new OwnAudio("Noticia internacional", "noticia_internacional001.mp3"));
        salsa.add(new Song("Amores como el nuestro", "amores_como_el_nuestro.mp3", 5));
        
        program.add(list40);
        program.add(new Commercial("Coca Cola", "coca_cola.mp3", 120));
        program.add(salsa);

        System.out.println(program);
        program.play();
        System.out.println("Ganancia: " + program.profit());
    }
}
