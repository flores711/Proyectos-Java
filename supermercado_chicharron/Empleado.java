package ud9_utilizacion_avanzada_clases.supermercado_chicharron;

public class Empleado extends Cliente {
    private int categoria;


    public Empleado(float porcentajeBon, String nombre, String numTarjeta, int categoria) {
        super(porcentajeBon, nombre, numTarjeta);
        this.categoria = categoria;
    }


    @Override
    public void incSaldoAcumulado(double compra) {
        double compraInc = compra + compra*categoria/100;
        super.incSaldoAcumulado(compraInc);
    }
}
