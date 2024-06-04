package unir.grupo6.pecoVerduras.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import unir.grupo6.pecoVerduras.modeloEntity.Producto;


/**
 * Creo la clase ProductoRepository que coge todos los metodos que tiene JPA
 * de esta manera esta clase se encargara de hacer todas las operaciones
 * necesarias con sus metodos propios
 * 
 * @author Gerard Perujo
 *
 */
public interface ProductoRepository extends JpaRepository<Producto, Integer>{
	
	
	/**
	 * Creo un metodo pasandole una query para buscar por promocion y estado
	 * 
	 * @author Gerard Perujo
	 * 
	 * @param promocion parametro que hace referencia al campor promocion si el producto esta en promocion o no
	 * 
	 * @param estado parametro que hace referencia al estado que se encuentra el producto
	 * 
	 * @return devuelve una lista con todos los productos segun la promocion que le pasemos y
	 * su estado
	 */
	@Query
	("select p from Producto p where p.promocion = ?1 AND p.estado = ?2")
	public List<Producto> findAllPromocionEstado(String promocion, String estado);
	
	
	/**
	 * Creo un metodo pasandole una query para buscar productos segun el nombre de su categoria, su
	 * estado y su promocion
	 * 
	 * @author Gerard Perujo
	 * 
	 * @param nombre parametro que hacer referencia al nombre de la categoria
	 * 
	 * @param estado parametro que hace referencia al estado que se encuentra el producto
	 * 
	 * @param promocion parametro que hace referencia al campor promocion si el producto esta en promocion o no
	 * 
	 * @return nos devuelve una lista con todos los productos por el nombre de la categoria que le hemos pasado
	 * el estado que hemos pasado y el campo promocion que pasemos
	 */
	@Query("select p from Producto p where p.categoria.nombre = ?1 AND p.estado = ?2 AND p.promocion = ?3")
	public List<Producto> findPorCategoriaEstado(String nombre, String estado, String promocion);
	
	
	/**
	 * Creo un metodo pasandole una query para buscar productos segun su categoria, su estado y su promocion
	 * 
	 * @author Maria Isabel
	 * 
	 * @param idCategoria parametro que hace referencia al id de la categoria que queremos buscar
	 * 
	 * @param estado parametro que hace referencia al estado que se encuentra el producto
	 * 
	 * @param promocion parametro que hace referencia al campor promocion si el producto esta en promocion o no
	 * 
	 * @return nos devuelve una lista con todos los productos por su categoria, segun el estado que le
	 * hemos pasado y segun su campo promocion
	 */
	@Query
	("select p from Producto p where p.categoria.idCategoria = ?1 AND p.estado = ?2 AND p.promocion = ?3")
	public List<Producto> findByCategoryAndStatusActive(int idCategoria, String estado,String promocion);
	
	
	/**
	 * Creo un metodo pasandole una query para buscar productos segun su tipo y su promocion
	 * 
	 * @author Maria Isabel
	 * 
	 * @param tipoProducto parametro que hace referencia al tipo de producto que queremos buscar
	 * 
	 * @param promocion parametro que hace referencia al campor promocion si el producto esta en promocion o no
	 * 
	 * @return nos devuelve una lista con todos los productos por su tipoProducto, y segun el campo
	 * promocion que pasemos
	 */
	@Query
	("select p from Producto p where p.tipoProducto = ?1 AND p.promocion = ?2")
	public List<Producto> findProductByName(String tipoProducto,String promocion);
	
	
	/**
	 * Creo un metodo con una query para sacar productos segun el estado
	 * 
	 * @author Gerard Perujo
	 * 
	 * @param estado parametro que hace referencia al estado que se encuentra el producto
	 * 
	 * @return nos devuele una lista con todos los productos segun el estado que le hemos
	 * pasado
	 */
	@Query
	("select p from Producto p where p.estado = ?1")
	public List<Producto> findProducoPorEstado(String estado);
	
	

}
