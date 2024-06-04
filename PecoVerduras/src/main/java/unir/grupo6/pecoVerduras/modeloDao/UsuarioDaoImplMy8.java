package unir.grupo6.pecoVerduras.modeloDao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import unir.grupo6.pecoVerduras.modeloEntity.Usuario;
import unir.grupo6.pecoVerduras.repository.UsuarioRepository;


/**
 * Clase que implementa la interface UsuarioDao para poder utilizar sus metodos
 * 
 * @author Noelia Villahermosa
 *
 */
@Repository
public class UsuarioDaoImplMy8 implements UsuarioDao{
	
	
	/**
	 * Importamos la clase UsuarioRepository para poder utilizar los metodos de JPA
	 */
	@Autowired
	private UsuarioRepository usuarioRepository;

	
	/**
	 * Metodo que usaremos para buscar un usuario pasando el
	 * username
	 * 
	 * @author Noelia Villahermosa
	 * 
	 */
	@Override
	public Usuario buscarUnUsuario(String username) {
		
		return usuarioRepository.findById(username).orElse(null);
	}

	
	/**
	 * Metodo que usaremos para modificar un usuario pasandole
	 * el objeto entero
	 * 
	 *@author Noelia Villahermosa
	 *
	 */
	@Override
	public Usuario modificarUsuario(Usuario usuario) {
		try {
			if(buscarUnUsuario(usuario.getUsername()) != null) {//en caso de que no sea nulo procederemos a modificar el usuario
				return usuarioRepository.save(usuario);
			}else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	 

	/**
	 * Metodo que usaremos para insertar un usuario pasandole
	 * un objeto
	 * 
	 * @author Noelia Villahermosa
	 * 
	 */
	@Override
	public Usuario insertarUsuario(Usuario usuario) {
		try {
			if(buscarUnUsuario(usuario.getUsername()) == null) {//en caso de que sea nulo procederemos agregar el usuario
				return usuarioRepository.save(usuario);
			}else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	/**
	 * Metodo que usaremos para eliminar un usuario pasandole
	 * el username
	 * 
	 * @author Noelia Villahermosa
	 * 
	 */
	@Override
	public int eliminarUsuario(String username) {
		Usuario user = buscarUnUsuario(username);
		
		if(user != null) {
			usuarioRepository.delete(user);
			return 1;
		}else {
			return 0;
		}
		
	}

	
	/**
	 * Metodo que usaremos para sacar una lista de todos los 
	 * usuarios
	 * 
	 * @author Noelia Villahermosa
	 * 
	 */
	@Override
	public List<Usuario> mostrarTodosUsuario() {
		
		return usuarioRepository.findAll();
	}

}
