package ud9_utilizacion_avanzada_clases.radio_station;

import java.util.Random;

public class AudioTools {
    public static int getDuration(String fileName) {
        // De momento esto genera una duración diferente cada vez que se le llame, aunque sea la misma canción
        Random rd = new Random();
        return rd.nextInt(300)+1;
    }

    public static void play(String fileName) {
        System.out.println("Reproduciendo: " + fileName);
    }
}
