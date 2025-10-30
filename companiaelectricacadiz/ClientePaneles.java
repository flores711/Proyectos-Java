package ud9_utilizacion_avanzada_clases.companiaelectricacadiz;

public class ClientePaneles extends Cliente {
    private double energiaInyectadaMes;
    private double contadorEnergiaInyectada;


    public ClientePaneles(String dni, double potenciaContratada) {
        super(dni, potenciaContratada);
        this.energiaInyectadaMes = 0.0;
        this.contadorEnergiaInyectada = 0.0;
    }


    public void actualizaEnergiaInyectada(double nuevaLecturaContador) {
        energiaInyectadaMes = contadorEnergiaInyectada - nuevaLecturaContador;
        contadorEnergiaInyectada = nuevaLecturaContador;
    }


    @Override
    public double importeFactura() {
        double importe = super.importeFactura() - energiaInyectadaMes*0.0034;
        return importe;
    }
}
