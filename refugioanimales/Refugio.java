package ud9_utilizacion_avanzada_clases.refugioanimales;

import java.time.LocalDate;
import java.util.Deque;
import java.util.LinkedList;

public class Refugio {
    Deque<Perro> colaPerros; // LinkedList ambas
    Deque<Gato> colaGatos;

    // Esta deque no es necesario
    Deque<Animal> animalesAdoptados;

    // tener las dos colas de perros y gatos y luego una lista para animales como registro general del refugio de todos los animales

    // poner numeroRegistro = 0 para empezar las id de animales, en addanimal le añadiremos 1 supongo
    public Refugio () {
        colaPerros = new LinkedList<>();
        colaGatos = new LinkedList<>();
    }


    public void addAnimal(Animal animal) {
        // setId
        // numeroRegistro++;
        // estos ifs estan bien
        if (animal instanceof Perro)
            colaPerros.offer((Perro) animal);
            //vacunas = VacunaPerro.values()
        else
            colaGatos.offer((Gato) animal);
            //vacunas = VacunaGato.values()

        //vacunacionInicial(animal, vacunas);
        //animales.add(animal);
    }


    public Animal adoptaAnimal() {
        // fecha1.compareTo(fecha2) devuelve -x si fecha1 es más antigua que fecha2 y positivo si viceversa, 0 si iguales
        Animal animal;
        if (getAnimalMasAntiguo() instanceof Perro)
            animal = adoptaPerro();
        else
            animal = adoptaGato();
        
        return animal;
    }

    public Perro adoptaPerro() {
        Animal perro = colaPerros.poll();
        animalesAdoptados.offer(perro);
        return (Perro) perro;
    }

    public Gato adoptaGato() {
        Animal gato = colaGatos.poll();
        animalesAdoptados.offer(gato);
        return (Gato) gato;
    }


    public Animal getAnimalMasAntiguo() {
        Animal animal;
        Animal perro = colaPerros.peek();
        Animal gato = colaGatos.peek();
        if ((perro.getFechaRegistro().compareTo(gato.getFechaRegistro())) <= 0)
            animal = perro;
        else
            animal = gato;

        return animal;
    }

    public Perro getPerroMasAntiguo() {
        return colaPerros.peek();
    }

    public Gato getGatoMasAntiguo() {
        return colaGatos.peek();
    }


    public void suministrarDosisAnimal(Animal animal, Vacuna vacuna) {
        // AQUÍ es donde crea dosis con fecha que le pasamos
        animal.ponerVacuna(vacuna);
    }
    // Y aquí creamos otro método suministrarDosisAHORA, que sí se le pone now() (creamos dosis con fecha now)



    public void listarPasoRefugio() {

    }

    public void listarAdoptados() {
        
    }




    public static void main(String[] args) {
        

        Animal gJuana = new Gato("Juana", 'h', LocalDate.of(2024, 4, 12), "1");
        Animal pMarco = new Perro("Marco", 'm', LocalDate.of(2023, 2, 9), "2");
        Animal pLassie = new Perro("Lassie", 'h', LocalDate.of(2020, 3, 9), "3");
        Animal gCarlos = new Gato("Carlos", 'm', LocalDate.of(2021, 5, 23), "4");
        Animal gLola = new Gato("Lola", 'h', LocalDate.of(2020, 10, 12), "5");
        Animal pCanela = new Perro("Canela", 'h', LocalDate.of(2019, 2, 19), "6");
        Animal pSnoopy = new Perro("Snoopy", 'm', LocalDate.of(2022, 8, 12), "7");
        Animal gFelix = new Gato("Felix", 'm', LocalDate.of(2018, 9, 19), "8");

        addAnimal(gJuana);
        addAnimal(pMarco);
        add
    }
}
