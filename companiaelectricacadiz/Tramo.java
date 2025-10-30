package ud9_utilizacion_avanzada_clases.companiaelectricacadiz;

public enum Tramo {
    TRAMO1(5, 0.00138) {
        @Override
        public boolean esAplicable(double potenciaContratada) {
            return potenciaContratada < 3.4;
        }
    },
    TRAMO2(7, 0.00276) {
        @Override
        public boolean esAplicable(double potenciaContratada) {
            return (potenciaContratada >= 3.4 && potenciaContratada <= 6.4);
        }
    }, 
    TRAMO3(9, 0.01104) {
        @Override
        public boolean esAplicable(double potenciaContratada) {
            return potenciaContratada > 6.4;
        }
    };

    private int terminoFijo;
    private double costeKWh;


    public int getTerminoFijo() {
        return terminoFijo;
    }
    public double getCosteKWh() {
        return costeKWh;
    }

    private Tramo(int terminoFijo, double costeKWh) {
        this.terminoFijo = terminoFijo;
        this.costeKWh = costeKWh;
    }

    public abstract boolean esAplicable(double potenciaContratada);
}