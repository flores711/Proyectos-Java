package ud9_utilizacion_avanzada_clases.refugioanimales;

import java.time.LocalDate;

public class Gato extends Animal {
    public Gato(String nombre, char sexo, LocalDate fechaRegistro, String id) {
        super(nombre, sexo, fechaRegistro, id);
        // Cuándo lo añado a la cola de perros del refugio?
    }


    @Override
    public String nombre() {
        return String.format("Gato: <%s>", super.nombre);
    }

    @Override
    public void ponerVacunasEsenciales() {
        for (VacunaGato vacuna : VacunaGato.values()) {
            if (vacuna.esEsencial())
                ponerVacuna(vacuna);
        }
    }

}
