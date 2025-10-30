import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Usuario implements Comparable<Usuario> {
    private String username;
    private String nombreCompleto;
    private LocalDate fechaRegistro;
    private char genero;
    private Set<Usuario> amigos;
    private Set<Grupo> grupos;

    
    public Usuario (String username, String nombreCompleto, LocalDate fechaRegistro, char genero) {
        this.username = username;
        this.nombreCompleto = nombreCompleto;
        this.fechaRegistro = fechaRegistro;
        this.genero = genero;
        this.amigos = new HashSet<>();
        this.grupos = new HashSet<>();
    }

    public Usuario (String username, String nombreCompleto) {
        this(username, nombreCompleto, LocalDate.of(2004, 2, 4), 'o');
    }


    public String getUsername() {
        return username;
    }
    public String getNombreCompleto() {
        return nombreCompleto;
    }
    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }
    public char getGenero() {
        return genero;
    }
    public Set<Usuario> getAmigos() {
        return amigos;
    }
    public Set<Grupo> getGrupos() {
        return grupos;
    }


    public void anadirGrupo (Grupo grupo) {
        this.grupos.add(grupo);
    }

    public void anadirAmigo (Usuario amigo) {
        this.amigos.add(amigo);
    }


    public boolean esAmigo(Usuario u) {
        boolean amigo = false;
        if (this.amigos.contains(u))
            amigo = true;
        return amigo;
    }


    public Set<Usuario> amigosDeGenero(char genero) {
        Set<Usuario> amigosGenero = new HashSet<>();
        for (Usuario amigo : this.amigos) {
            if (amigo.genero == genero)
                amigosGenero.add(amigo);
        }
        return amigosGenero;
    }



    @Override
    public int compareTo(Usuario otroUsuario) {
        return this.nombreCompleto.compareTo(otroUsuario.nombreCompleto);
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((username == null) ? 0 : username.hashCode());
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Usuario other = (Usuario) obj;
        if (username == null) {
            if (other.username != null)
                return false;
        } else if (!username.equals(other.username))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return String.format("%s (%s - %c)", username, nombreCompleto, genero);
    }
}
