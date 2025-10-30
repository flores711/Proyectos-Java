package ud9_utilizacion_avanzada_clases.companiaelectricacadiz;

public class PruebaElectrica {
    public static void main(String[] args) {
        Electrica electrica = new Electrica();

        Cliente c = new Cliente("22222222A", 2.4);
        Cliente cp = new ClientePaneles("33333333B", 5.2);
        Cliente cs = new ClienteSmart("44444444C", 8.3, 15);

        electrica.agregaCliente(c);
        electrica.agregaCliente(cp);
        electrica.agregaCliente(cs);

        System.out.println(electrica.getCantidadClientesPaneles());
        System.out.println(electrica.getFacturacionTotal());
    }
}
