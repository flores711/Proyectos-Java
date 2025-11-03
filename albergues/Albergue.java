package ud10_excepciones_y_ficheros.albergues;

import java.time.LocalDate;

public class Albergue implements Comparable<Albergue> {
    private String provincia;
    private LocalDate fechaApertura;
    private String nombre;
    private String municipio;
    private boolean web;
    private int unidadesAlojamiento;
    private int habitaciones;
    private int plazas;


    public Albergue (String provincia, LocalDate fechaApertura, String nombre, String municipio, boolean web) {
        this.provincia = provincia;
        this.fechaApertura = fechaApertura;
        this.nombre = nombre;
        this.municipio = municipio;
        this.web = web;
        // Esto no nos hace falta de momento (el problema no pide que hagamos nada con esto)
        //this.unidadesAlojamiento = 0;
        //this.habitaciones = 0;
        this.plazas = 0;
    }

    
    public int getAnio() {
        return fechaApertura.getYear();
    }

    public String getNombre() {
        return nombre;
    }

    public String getProvincia() {
        return provincia;
    }

    public int getPlazas() {
        return plazas;
    }

    public void setPlazas (int plazas) {
        this.plazas = plazas;
    }



    @Override
    public int compareTo(Albergue otroAlbergue) {
        int resultado = this.fechaApertura.getYear() - otroAlbergue.fechaApertura.getYear();

        if (resultado == 0)
            resultado = this.nombre.compareTo(otroAlbergue.nombre);
        
        return resultado;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        result = prime * result + ((municipio == null) ? 0 : municipio.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Albergue other = (Albergue) obj;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        if (municipio == null) {
            if (other.municipio != null)
                return false;
        } else if (!municipio.equals(other.municipio))
            return false;
        return true;
    }
}
