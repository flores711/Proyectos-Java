public class GeoUtils {
    public static boolean esCoordenadaValida(double latitud, double longitud){
        boolean valida = false;
        if (latitud >= -90 && latitud <= 90 && longitud >= -180 && longitud <= 180)
            valida = true;
        return valida;
    }
}
