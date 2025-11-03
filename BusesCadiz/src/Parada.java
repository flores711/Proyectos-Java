import java.lang.Math;

public class Parada {
    private String nombre;
    private double latitud;
    private double longitud;
    private static final double RADIOTIERRA = 6371;

    public Parada(String nombre, double latitud, double longitud) {
        this.nombre = nombre;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public String getNombre() {
        return nombre;
    }
    public double getLatitud() {
        return latitud;
    }
    public double getLongitud() {
        return longitud;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    public double distancia(Parada parada) {
        return this.distancia(parada.latitud, parada.longitud);
    }

    public double distancia(double latitud, double longitud) {
        double latitud1 = Math.toRadians(this.latitud);
        double latitud2 = Math.toRadians(latitud);
        double longitud1 = Math.toRadians(this.longitud);
        double longitud2 = Math.toRadians(longitud);

        double kms = RADIOTIERRA * Math.sqrt(Math.pow((latitud1 - latitud2), 2) + Math.pow(((longitud1 - longitud2) * Math.cos((latitud1 + latitud2) / 2)), 2));
        return kms;
    }

    public static double distancia(Parada parada1, Parada parada2) {
        return parada1.distancia(parada2.latitud, parada2.longitud);
    }

    


    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        long temp;
        temp = Double.doubleToLongBits(latitud);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(longitud);
        result = prime * result + (int) (temp ^ (temp >>> 32));
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

        Parada other = (Parada) obj;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        if (Double.doubleToLongBits(latitud) != Double.doubleToLongBits(other.latitud))
            return false;
        if (Double.doubleToLongBits(longitud) != Double.doubleToLongBits(other.longitud))
            return false;
        return true;
    }
    

    @Override
    public String toString() {
        return String.format("%s (%f,%f)", nombre, latitud, longitud);
    }
}
