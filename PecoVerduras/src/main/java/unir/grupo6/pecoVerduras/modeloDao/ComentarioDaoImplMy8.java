package unir.grupo6.pecoVerduras.modeloDao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import unir.grupo6.pecoVerduras.modeloEntity.Comentario;
import unir.grupo6.pecoVerduras.modeloEntity.Producto;
import unir.grupo6.pecoVerduras.modeloEntity.Usuario;
import unir.grupo6.pecoVerduras.repository.ComentarioRepository;




/**
 * Clase que implementa la interface ComentarioDao para poder utilizar sus metodos
 * 
 * @author Noelia Villahermosa
 *
 */
@Repository
public class ComentarioDaoImplMy8 implements ComentarioDao {

	
	/**
	 * Importamos la clase ComentarioRepository para poder utilizar los metodos de JPA
	 */
	@Autowired
	private ComentarioRepository comentarioRepository;
	

	
	/**
	 * Metodo que utilizaremos para buscar un comentario pasandole su id
	 * 
	 * @author Noelia Villahermosa
	 */
	@Override
	public Comentario buscarUnComentario(int idComentario) {
		
		return comentarioRepository.findById(idComentario).orElse(null);
	}

	
	
	/**
	 * Metodo que utilizaremos para modificar un comentario pasandole
	 * todo el objeto
	 * 
	 * @author Noelia Villahermosa
	 */
	@Override
	public Comentario modificarComentario(Comentario comentario) {
		try {
			if(buscarUnComentario(comentario.getIdComentario()) != null) {//en caso de que no sea nulo procederemos a modificar el comentario
				return comentarioRepository.save(comentario);
			}else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	/**
	 * Metodo que utilizaremos para agregar un comentario pasandole
	 * todo el objeto
	 * 
	 * @author Noelia Villahermosa
	 */
	@Override
	public Comentario insertarComentario(Comentario comentario) {
		try {
			if(buscarUnComentario(comentario.getIdComentario()) == null) {//en caso de que sea nulo procederemos agregar el comentario
				return comentarioRepository.save(comentario);
			}else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	/**
	 * Metodo que utilizaremos para eliminar un comentario pasandole su id
	 * 
	 * @author Noelia Villahermosa
	 */
	@Override
	public int eliminarComentario(int idComentario) {
		Comentario comen = buscarUnComentario(idComentario);
		
		if(comen != null) {//se comprueba que el comentario exista y procedemos a eliminarla
			comentarioRepository.delete(comen);
			return 1;
		}else {
			return 0;
		}
		
	}


	/**
	 * Metodo que utilizaremos para sacar una lista con todos los comentarios segun
	 * su usuario
	 * 
	 * @author Noelia Villahermosa
	 */
	@Override
	public List<Comentario> mostrarComentariosUsuario(Usuario usuario) {
		String user = usuario.getUsername(); 
		return comentarioRepository.findComentariosUsuario(user);
	}

	
	
	
	/**
	 * Metodo que utilizaremos para sacar una lista con todos los comentarios
	 * que hay
	 * 
	 * @author Noelia Villahermosa
	 */
	@Override
	public List<Comentario> mostrarTodosComentario() {
		// TODO Auto-generated method stub
		return comentarioRepository.findAll();
	}

	
	
	/**
	 * Metodo que usaremos para sacar una lista de todos los comentarios
	 * segun el estado del comentario
	 * 
	 * @author Noelia Villahermosa
	 */
	@Override
	public List<Comentario> buscarComentariosPorEstado(String estado) {
		return comentarioRepository.findCommentsByStatus(estado);
	}

	
	/**
	 * Metodo que utilizatremos para sacar una lista de todos los comentarios que tiene el 
	 * producto que pasemos segun el estado del comentario
	 * 
	 * @author Noelia Villahermosa
	 */
	@Override
	public List<Comentario> buscarComentariosPorProductoYEstado(Producto producto, String estado) {
		int product = producto.getIdProductos();
		
		return comentarioRepository.findCommentsByProductAndStatus(product, estado);
	}


}
