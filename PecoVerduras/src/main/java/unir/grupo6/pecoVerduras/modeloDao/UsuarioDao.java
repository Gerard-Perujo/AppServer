package unir.grupo6.pecoVerduras.modeloDao;

import java.util.List;

import unir.grupo6.pecoVerduras.modeloEntity.Usuario;


/**
 *  Interface de Usuario donde tendremos nuestros metodos que utilizaremos para
 * sacar la informacion
 * 
 * @author Noelia Villahermosa
 *
 */
public interface UsuarioDao {
	
	Usuario buscarUnUsuario(String username);
	Usuario modificarUsuario(Usuario usuario);
	Usuario insertarUsuario(Usuario usuario);
	int eliminarUsuario(String username);
	List<Usuario> mostrarTodosUsuario();

}
