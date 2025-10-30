// FORMA ANTERIOR

package ud9_utilizacion_avanzada_clases.companiaelectricacadiz;

enum Potencia {
    POTENCIA_BAJA(5, 0.00138), 
    POTENCIA_MEDIA(7, 0.00276), 
    POTENCIA_ALTA(9, 0.01104);

    private int terminoFijo;
    private double costeKWh;


    public int getTerminoFijo() {
        return terminoFijo;
    }
    public double getCosteKWh() {
        return costeKWh;
    }

    private Potencia(int terminoFijo, double costeKWh) {
        this.terminoFijo = terminoFijo;
        this.costeKWh = costeKWh;
    }
}


public class Cliente {
    private String dni;
    private double contadorEnergiaConsumida;
    private double energiaConsumidaMes;
    private double potenciaContratada;

    // Poner la asignación del enum aquí directamente?
    public Cliente(String dni, double potenciaContratada) {
        this.dni = dni;
        this.potenciaContratada = potenciaContratada;
        this.energiaConsumidaMes = 0.0;
        this.contadorEnergiaConsumida = 0.0;
    }


    public void actualizaEnergiaConsumida(double nuevaLecturaContador) {
        energiaConsumidaMes = nuevaLecturaContador - contadorEnergiaConsumida;
        contadorEnergiaConsumida = nuevaLecturaContador;
    }

    public double importeFactura() {
        Potencia potencia;
        if (potenciaContratada < 3.4) {
            potencia = Potencia.POTENCIA_BAJA;
        } else if (3.4 <= potenciaContratada && potenciaContratada <= 6.4) {
            potencia = Potencia.POTENCIA_MEDIA;
        } else {
            potencia = Potencia.POTENCIA_ALTA;
        }

        double importe = potencia.getTerminoFijo() + energiaConsumidaMes * potencia.getCosteKWh();
        return importe;
    }


}
