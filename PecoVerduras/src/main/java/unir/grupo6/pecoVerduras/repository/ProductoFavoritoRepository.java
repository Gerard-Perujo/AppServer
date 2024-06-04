package unir.grupo6.pecoVerduras.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import unir.grupo6.pecoVerduras.modeloEntity.ProductoFavorito;


/**
 * Creo la clase ProductoFavoritoRepository que coge todos los metodos que tiene JPA
 * de esta manera esta clase se encargara de hacer todas las operaciones
 * necesarias con sus metodos propios
 * 
 * @author Gerard Perujo
 *
 */
public interface ProductoFavoritoRepository extends JpaRepository<ProductoFavorito, Integer>{
	
	
	/**
	 * Creo un metodo pasandole una query para buscar los productos favoritos pasandole
	 * el nombre del usuario y su estado
	 * 
	 * @author Noelia Villahermosa
	 * 
	 * @param username parametro que hacer referencia al username del usuario
	 * 
	 * @param estado parametro que hace referencia al estado que se encuentra el producto favorito
	 * 
	 * @return nos devuelve una lista con todos los productos favoritos segun el usuario y su estado
	 */
	@Query
	("SELECT p FROM ProductoFavorito p WHERE p.usuario.username = ?1 AND p.estado = ?2")
	public List<ProductoFavorito> findProductosFavUsuario (String username, String estado); 
	
	
	/**
	 * Creo un metodo pasandole una query para buscar los productos favoritos pasandole el nombre
	 * del usuario y el id del producto
	 * 
	 * @author Maria Isabel
	 * 
	 * @param usuario parametro que hacer referencia al username del usuario
	 * 
	 * @param idProductos parametro que hace referencia al id del producto que buscamos
	 * 
	 * @return nos devuelve un producto favorito segun el nombre de usuario que pasemos y el 
	 * id del prodcuto
	 *
	 */
	@Query
	("select p from ProductoFavorito p where p.usuario.username = ?1 AND p.producto.idProductos = ?2")
     ProductoFavorito findFavProductByUserAndProduct(String usuario, int idProductos);

}
