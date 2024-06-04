package unir.grupo6.pecoVerduras.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import unir.grupo6.pecoVerduras.modeloEntity.Comentario;
import unir.grupo6.pecoVerduras.modeloEntity.Producto;

/**
 * Creo la clase Comentariorepository que coge todos los metodos que tiene JPA
 * de esta manera esta clase se encargara de hacer todas las operaciones
 * necesarias con sus metodos propios
 * 
 * @author Gerard Perujo
 *
 */
public interface ComentarioRepository extends JpaRepository<Comentario, Integer>{
	
	/**
	 * Creo un metodo pasandole una query para buscar todos los comentarios segun su estado
	 * 
	 * @author Gerard Perujo
	 * 
	 * @param estado parametro que hace referencia al estado que se encuentra el comentario
	 * 
	 * @return nos devuelve una lista con todos los comentarios segun el estado que le 
	 * pasemos
	 */
	@Query
	("select c from Comentario c where c.estado = ?1")
    List<Comentario> findCommentsByStatus(String estado);
	
	
	/**
	 * Creo un metodo pasandole una query para buscar todos los comentarios segun el
	 * producto y su estado
	 * 
	 * @author Maria Isabel
	 * 
	 * @param idProducto el id del producto que queremos sacar los comentarios
	 * 
	 * @param estado parametro que hace referencia al estado que se encuentra el comentario
	 * 
	 * @return nos devuelve una lista con todos los comentarios que tiene ese producto segun su 
	 * estado
	 */
	@Query
	("select c from Comentario c where c.producto.idProductos = ?1 AND c.estado = ?2")
    List<Comentario> findCommentsByProductAndStatus(int idProducto, String estado);
	
	
	
	/**
	 * Creo un metodo pasandole una query para buscar todos los comentarios que tiene un usuario
	 * 
	 * @author Noelia Villahermosa
	 * 
	 * @param usuario usuario del cual queremos sacar los comentarios
	 * 
	 * @return nos devuelve una lista con todos los comentarios que tiene el usuario
	 */
	@Query
	("select u from Comentario u where u.usuario.username = ?1")
	public List<Comentario> findComentariosUsuario(String usuario); 


}
