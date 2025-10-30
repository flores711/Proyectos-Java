import java.util.Objects;

public class Grupo implements Comparable<Grupo> {
    private String nombre;
    private boolean publico;
    private String descripcion;


    public Grupo(String nombre) {
        this.nombre = nombre;
        this.descripcion = "";
        this.publico = true;
    }


    public boolean isPublico() {
        return publico;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    
    @Override
    public int compareTo(Grupo otro) {
        return this.nombre.compareTo(otro.nombre);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grupo grupo = (Grupo) o;
        return Objects.equals(nombre, grupo.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

}