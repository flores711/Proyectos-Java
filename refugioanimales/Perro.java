package ud9_utilizacion_avanzada_clases.refugioanimales;

import java.time.LocalDate;

public class Perro extends Animal {
    public Perro(String nombre, char sexo, LocalDate fechaRegistro, String id) {
        super(nombre, sexo, fechaRegistro, id);
        // Cuándo lo añado a la cola de perros del refugio?
        // Construir animal independiente del refugio, sólo con nombre y sexo
    }


    @Override
    public String nombre() {
        return String.format("Perro: <%s>", super.nombre);
    }
    
    @Override
    public void ponerVacunasEsenciales() {
        for (VacunaPerro vacuna : VacunaPerro.values()) {
            if (vacuna.esEsencial())
                ponerVacuna(vacuna);
        }
    }
}
