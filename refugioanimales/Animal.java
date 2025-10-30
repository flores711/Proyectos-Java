package ud9_utilizacion_avanzada_clases.refugioanimales;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Animal {
    protected String nombre;
    private char sexo;
    private LocalDate fechaRegistro;
    // fecha de adopcion poner
    private String id;
    private List<Dosis> historialVacunas; // ArrayList o se puede poner Set


    public Animal(String nombre, char sexo, LocalDate fechaRegistro, String id) {
        this.nombre = nombre;
        this.sexo = sexo;
        this.fechaRegistro = fechaRegistro;
        this.id = id;
        historialVacunas = new ArrayList<>(); // poner esenciales directamente
        ponerVacunasEsenciales();
    }

    public char getSexo() {
        return sexo;
    }
    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public abstract String nombre();

    // Quien lo vacuna es el refugio, no el animal
    public abstract void ponerVacunasEsenciales(); // Un for con VacunaX.values() e ir comprobando si esEsencial();
    public void ponerVacuna(Vacuna vacuna) {
        Dosis dosis = new Dosis(vacuna);
        historialVacunas.add(dosis);
    }
}
