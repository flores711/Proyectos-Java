import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;


public class GenZeta {
    public Map<String, Grupo> mapaGrupos;   // Nombre y Grupo
    public Map<String, Usuario> mapaUsuarios;   // Nombre y Usuario


    public GenZeta() {
        this.mapaGrupos = new HashMap<>();
        this.mapaUsuarios = new HashMap<>();

        cargaUsuariosGrupos();
        cargaRelacionesAmistad();
    }


    private void cargaUsuariosGrupos() {
        Scanner sc = new Scanner(System.in);

        String username;
        String nombreCompleto;

        while (true) {
            String[] linea = sc.nextLine().split(";");
            if (linea[0].equals("FIN"))
                break;

            username = linea[0];
            nombreCompleto = linea[1];

            // Cargar grupos desde índice 2 hasta que terminen
            List<String> nombresGrupos = new ArrayList<>();
            for (int i=2; i<(linea.length-4); i++) {
                nombresGrupos.add(linea[i]);
            }

            int j = linea.length-4; // Nuevo indice después de grupos
            char genero = linea[j].charAt(0);
            int anio = Integer.parseInt(linea[j+1]);
            int mes = Integer.parseInt(linea[j+2]);
            int dia = Integer.parseInt(linea[j+3]);
            LocalDate fechaRegistro = LocalDate.of(anio, mes, dia);

            Usuario usuario = new Usuario(username, nombreCompleto, fechaRegistro, genero);
            mapaUsuarios.put(username, usuario);

            for (String nombreGrupo : nombresGrupos) {
                Grupo grupo;
                if (!mapaGrupos.containsKey(nombreGrupo)) {
                    grupo = new Grupo(nombreGrupo);
                    mapaGrupos.put(nombreGrupo, grupo);
                } else {
                    grupo = mapaGrupos.get(nombreGrupo);
                }
                usuario.anadirGrupo(grupo);
            }
        }
    }

    private void cargaRelacionesAmistad() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String[] linea = sc.nextLine().split(":");
            if (linea[0].equals("FIN"))
                break;

            String username = linea[0];
            String[] nombreAmigos = linea[1].split(";");

            Usuario usuario = mapaUsuarios.get(username);
            for (String nombreAmigo : nombreAmigos) {
                Usuario amigo = mapaUsuarios.get(nombreAmigo);
                usuario.anadirAmigo(amigo);
            }
        }
    }


    private LocalDate getFecha(String anio, String mes, String dia) {
        return LocalDate.of(Integer.parseInt(anio),Integer.parseInt(mes),Integer.parseInt(dia));
    }

    public Usuario buscaUsuario(String nombreUsuario) {
        return mapaUsuarios.get(nombreUsuario);
    }

    public Grupo buscaGrupo(String nombreGrupo) {
        return mapaGrupos.get(nombreGrupo);
    }

    public Usuario agregaUsuario(Usuario unUsuario) {
        mapaUsuarios.put(unUsuario.getUsername(), unUsuario);
        return unUsuario;
    }

    public Grupo agregaGrupo(Grupo unGrupo) {
        mapaGrupos.put(unGrupo.getNombre(), unGrupo);
        return unGrupo;
    }

    public Set<Usuario> getUsuarios() {
        Set<Usuario> setUsuarios = new HashSet<>();
        setUsuarios.addAll(mapaUsuarios.values());
        return setUsuarios;
    }

    public Set<Grupo> getGrupos() {
        Set<Grupo> setGrupos = new HashSet<>();
        setGrupos.addAll(mapaGrupos.values());
        return setGrupos;
    }





    public static void main(String[] args) {        
        // Tu código aquí
        GenZeta red = new GenZeta();
        

        // 1. Usuario con más amigas mujeres
        Usuario usuario = UserRecommender.masAmigosMujer(red.getUsuarios());
        if (usuario == null) {
            System.out.println("Ningún usuario tiene amigos mujer");
        } else {
            System.out.println("Usuario que tiene más amigos mujer: " + usuario);
            System.out.println();

            // 2. Amigos de Nico
            Usuario usuarioTest = red.mapaUsuarios.get("nico");
            System.out.println("Amigos de " + usuarioTest.getUsername() + ":");
            for (Usuario amigo : usuarioTest.getAmigos()) {
                System.out.println(amigo.getUsername());
            }
            System.out.println();

            // 3. Puntuaciones de amigos y grupos en común entre Nico y otros usuarios
            System.out.println("Amigos en común entre " + usuarioTest.getUsername() + " y:");
            for (Usuario usuario2 : red.getUsuarios()) {
                System.out.printf("- %s: %d\n", usuario2.getUsername(), UserRecommender.puntuacionAmistad(usuarioTest, usuario2));
            }
            System.out.println();


            System.out.println("Grupos en común entre " + usuarioTest.getUsername() + " y:");
            for (Usuario usuario2 : red.getUsuarios()) {
                System.out.printf("- %s: %d\n", usuario2.getUsername(), UserRecommender.puntuacionGrupos(usuarioTest, usuario2));
            }
            System.out.println();

            // 4. Recomendación de amigo para Nico
            System.out.printf("Amigo recomendado a %s: %s\n", usuarioTest.getUsername(), UserRecommender.recomendarAmigo(usuarioTest, red.getUsuarios()));
        }

    }
}
