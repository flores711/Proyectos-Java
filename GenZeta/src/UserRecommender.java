import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class UserRecommender {

    /**
	 * Método masAmigosMujer
	 * 
	 * Devuelve el usuario que tiene más amigos mujer
	 * En caso de empate, devuelve el usuario cuya fecha de registro es más antigua.
	 * En el caso de que sigan empatando, devuelve el usuario cuyo
	 * nombre completo está antes alfabéticamente ---> USAR COMPARETO QUE ESTÁ HECHO CON ESTO
	 * Si no existe tal usuario, devuelve null
	 */

	public static Usuario masAmigosMujer (Set<Usuario> usuarios) {
		Map<Usuario, Integer> usuariosAmigosM = new HashMap<>();
		char genero = 'm';
		for (Usuario usuario : usuarios) {
			Set<Usuario> amigosMujer = usuario.amigosDeGenero(genero);
			usuariosAmigosM.put(usuario, amigosMujer.size());
		}

		List<Usuario> usuariosOrdenados = new ArrayList<>();
		usuariosOrdenados.addAll(usuariosAmigosM.keySet());
		Collections.sort(usuariosOrdenados, new Comparator<Usuario>() {
			@Override
			public int compare(Usuario u1, Usuario u2) {
				int resultado;
				resultado = usuariosAmigosM.get(u1) - usuariosAmigosM.get(u2);
				if (resultado == 0)
					resultado = u2.getFechaRegistro().compareTo(u1.getFechaRegistro());
				if (resultado == 0)
					resultado = u1.compareTo(u2);	// Orden natural hecho en la clase Usuario
				return resultado;
			}
		});
		Usuario usuarioElegido = usuariosOrdenados.get(usuariosOrdenados.size()-1);
		if (usuariosAmigosM.get(usuarioElegido) == 0)
			usuarioElegido = null;
		return usuarioElegido;
	}
    


    /**
	 * Método puntuacionAmistad
	 * 
	 * Devuelve un entero que es la puntuación de amistad entre los dos 
	 * usuarios pasados como parámetro.
	 * La puntuación de amistad entre dos usuarios está basada
	 * en la cantidad de amigos en comun que tienen dichos usuarios.
	 * La puntuación de amistad de un usuario consigo mismo es 0
	 */

	public static int puntuacionAmistad (Usuario u1, Usuario u2) {
		int puntuacion = 0;
		if(u1 != u2) {
			for (Usuario amigo : u1.getAmigos()) {
				if (u2.esAmigo(amigo))
					puntuacion++;
			}
		}
		return puntuacion;
	}



    /**
	 * Método puntuaciónGrupos
	 * 
	 * Devuelve un entero que es la puntuación de grupos entre los dos 
	 * usuarios pasados como parámetro.
	 * La puntuación de grupos entre dos usuarios está basada
	 * en la cantidad de grupos en comun que tienen dichos usuarios.
	 * La puntuación de grupos de un usuario consigo mismo es 0
	 */

    
	public static int puntuacionGrupos(Usuario u1, Usuario u2) {
		int puntuacion = 0;
		if(u1 != u2) {
			for (Grupo grupo : u1.getGrupos()) {
				if (u2.getGrupos().contains(grupo))
					puntuacion++;
			}
		}
		return puntuacion;
	}



    /**
    * Método recomendarMasAmigosComun
    * 
    * Recomendar un amigo del conjunto de usuarios pasado
    * como parámetro, al usuario pasado como parámetro.
    * Se recomendará como amigo a aquel usuario con el que se 
    * tenga la mayor cantidad de amigos en comun + mayor cantidad de grupos en comun.
    * En caso de empate en la cantidad de amigos en comun y grupos en comun, 
    * se recomendará a aquel usuario con la fecha de registro más antigua.
    * Por supuesto, el usuario a recomendar no puede ser amigo ya, 
    * ni puede ser el usuario al cual se le está recomendando un amigo.
    */


	public static Usuario recomendarAmigo(Usuario u, Set<Usuario> usuarios) {
		int puntuacionAmistad;
		int puntuacionGrupos;
		int puntuacionTotal;
		Map<Usuario, Integer> usuarioPuntuacion = new HashMap<>();
		for (Usuario usuario2 : usuarios) {
			if (!(u.getAmigos().contains(usuario2)) && (u != usuario2)) {
				puntuacionAmistad = puntuacionAmistad(u, usuario2);
				puntuacionGrupos = puntuacionGrupos(u, usuario2);
				puntuacionTotal = puntuacionAmistad + puntuacionGrupos;

				usuarioPuntuacion.put(usuario2, puntuacionTotal);
			}
		}

		List<Usuario> usuariosOrdenados = new ArrayList<>();
		usuariosOrdenados.addAll(usuarioPuntuacion.keySet());
		Collections.sort(usuariosOrdenados, new Comparator<Usuario>() {
			@Override
			public int compare(Usuario u1, Usuario u2) {
				int resultado;
				resultado = usuarioPuntuacion.get(u1) - usuarioPuntuacion.get(u2);
				if (resultado == 0)
					resultado = u2.getFechaRegistro().compareTo(u1.getFechaRegistro());
				return resultado;
			}
		});

		return usuariosOrdenados.get(usuariosOrdenados.size()-1);
	}
}