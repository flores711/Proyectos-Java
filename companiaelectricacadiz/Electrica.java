package ud9_utilizacion_avanzada_clases.companiaelectricacadiz;

import java.util.Set;
import java.util.HashSet;

public class Electrica {
    private Set<Cliente> clientes;


    public Electrica() {
        this.clientes = new HashSet<>();
    }


    public void agregaCliente(Cliente nuevoCliente) {
        clientes.add(nuevoCliente);
    }
    
    public int getCantidadClientesPaneles() {
        int clientesPaneles = 0;
        for (Cliente cliente : clientes) {
            if (cliente instanceof ClientePaneles)
                clientesPaneles++;
        }

        return clientesPaneles;
    }

    public double getFacturacionTotal() {
        double importeTotal = 0;
        for (Cliente cliente : clientes) {
            importeTotal += cliente.importeFactura();
        }

        return importeTotal;
    }
}
