package unir.grupo6.pecoVerduras.modeloDao;

import java.util.List;

import unir.grupo6.pecoVerduras.modeloEntity.Comentario;
import unir.grupo6.pecoVerduras.modeloEntity.Producto;
import unir.grupo6.pecoVerduras.modeloEntity.Usuario;



/**
 *  Interface de Comentario donde tendremos nuestros metodos que utilizaremos para
 * sacar la informacion
 * 
 * @author Noelia Villahermosa
 *
 */
public interface ComentarioDao {

	Comentario buscarUnComentario(int idComentario);
	Comentario modificarComentario(Comentario comentario);
	Comentario insertarComentario(Comentario comentario);
	int eliminarComentario(int idComentario);
	List<Comentario> mostrarTodosComentario();

	List<Comentario> mostrarComentariosUsuario(Usuario usuario); 

	
	List<Comentario> buscarComentariosPorEstado(String estado);
	List<Comentario> buscarComentariosPorProductoYEstado(Producto producto, String estado);
	

}
