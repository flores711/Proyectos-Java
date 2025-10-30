package ud9_utilizacion_avanzada_clases.supermercado_chicharron;

public class Cliente {
    private String numTarjeta;
    private String nombre;
    private double saldo;
    private float porcentajeBonificacion;

    
    public Cliente (float porcentajeBonificacion, String nombre, String numTarjeta) {
        this.porcentajeBonificacion = porcentajeBonificacion;
        this.nombre = nombre;
        this.numTarjeta = numTarjeta;
        this.saldo = 0;
    }


    public void resetSaldoAcumulado() {
        saldo = 0;
    }
    public void incSaldoAcumulado(double compra) {
        saldo += compra*porcentajeBonificacion/100;
    }


    public String getNumTarjeta() {
        return numTarjeta;
    }
    public String getNombre() {
        return nombre;
    }
    public double getSaldo() {
        return saldo;
    }
    public float getPorcentajeBonificacion() {
        return porcentajeBonificacion;
    }


    @Override
    public String toString() {
        return "Cliente [numTarjeta=" + numTarjeta + ", nombre=" + nombre + ", saldo=" + saldo + ", porcentajeBonificacion="
                + porcentajeBonificacion + "]";
    }
}
