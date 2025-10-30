package ud9_utilizacion_avanzada_clases.companiaelectricacadiz;

public class ClienteSmart extends Cliente {
    private double porcentajeDescuento;


    public ClienteSmart(String dni, double potenciaContratada, double porcentajeDescuento) {
        super(dni, potenciaContratada);
        this.porcentajeDescuento = porcentajeDescuento;
    }


    @Override
    public double importeFactura() {
        double importe = super.importeFactura() - super.importeFactura()*porcentajeDescuento/100;
        return importe;
    }
}
