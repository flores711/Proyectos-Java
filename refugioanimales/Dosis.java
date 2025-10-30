package ud9_utilizacion_avanzada_clases.refugioanimales;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Dosis {
    private Vacuna vacuna;
    private LocalDateTime fechaHora;


    public Dosis(Vacuna vacuna) {
        this.vacuna = vacuna;
        // le pasa la fecha también, no le pone now
        this.fechaHora = LocalDateTime.now();
    }
}
