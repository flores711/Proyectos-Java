package ud9_utilizacion_avanzada_clases.supermercado_chicharron;

import java.util.Set;
import java.util.HashSet;

public class Supermercado {
    private Set<Cliente> setClientes;


    public Supermercado() {
        setClientes = new HashSet<>();
    }


    public void annadirCliente(Cliente cliente) {
        setClientes.add(cliente);
    }


    public Cliente annadirSaldo(String tarjeta, double compra) {
        Cliente clienteDevuelto = null;
        for (Cliente cliente : setClientes) {
            if (cliente.getNumTarjeta().equals(tarjeta)) {
                cliente.incSaldoAcumulado(compra);
                clienteDevuelto = cliente;
                break;
            }
        }
        return clienteDevuelto;
    }


    public double totalSaldoEmpleados() {
        double suma = 0;
        for (Cliente cliente : setClientes) {
            if (cliente instanceof Empleado)
                suma += cliente.getSaldo();
        }
        return suma;
    }


    public static void main(String[] args) {
        Cliente e1 = new Empleado(12, "Juan", "1234", 1);
        Cliente e2 = new Empleado(15, "Pepe", "4444", 3);

        Supermercado supermercado = new Supermercado();
        supermercado.annadirCliente(e1);
        supermercado.annadirCliente(e2);

        supermercado.annadirSaldo("1234", 10);
        supermercado.annadirSaldo("4444", 20);

        Cliente clienteVip = new ClienteVip(20, "Vip", "1111");
        supermercado.annadirCliente(clienteVip);


        System.out.println(supermercado.totalSaldoEmpleados());
    }
}
