public class CalculadoraPuntajes {

    public static int calcularPuntaje(String[] respuestasCorrectas, String[] respuestasCandidato) { // Recibe COLECCIÓN DE SOLUCIONES y  COLECCIÓN DE RESPUESTAS DE UN CANDIDATO
        int puntaje = 0;
       
        for (int i=0; i<respuestasCorrectas.length; i++) {
            if (respuestasCorrectas[i].equals(respuestasCandidato[i]))
                puntaje++;
        }

        return puntaje;
    }
}
