package unir.grupo6.pecoVerduras.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import jakarta.transaction.Transactional;
import unir.grupo6.pecoVerduras.modeloEntity.ProductoPedido;


/**
 * Creo la clase ProductoRepository que coge todos los metodos que tiene JPA
 * de esta manera esta clase se encargara de hacer todas las operaciones
 * necesarias con sus metodos propios
 * 
 * @author Gerard Perujo
 *
 */
public interface ProductoPedidoRepository extends JpaRepository<ProductoPedido, Integer>{
	
	
	/**
	 * Creo un metodo pasandole una query para buscar todos los productos pedidos segun el
	 * pedido
	 * 
	 *  @author Gerard Perujo
	 *  
	 * @param idPedido parametro que hacer referencia al pedido que queremos buscar
	 * 
	 * @return nos devuelve una lista de todos los productos pedido segun el pedido que le
	 * pasemos
	 */
	@Query
	("select p from ProductoPedido p where p.pedido.idPedido = ?1")
	List<ProductoPedido> findMostrarProductosPedido(int idPedido);
	
	
	/**
	 * Creo un metodo pasandole una query para buscar todos los productos pedidos segun el 
	 * producto
	 * 
	 * @author Noelia Villahermosa
	 *  
	 * @param idProducto parametro que hace referencia al id del producto que queremos buscar
	 * 
	 * @return nos devuelve el producto segun el id del producto que queramos buscar
	 */
	@Query
	("select p from ProductoPedido p where p.producto.idProductos = ?1")
	ProductoPedido findProductoPedidoPorProducto(int idProducto);
	
	
	/**
	 * Creo un metodo pasandole una query para eliminar los productos pedido segun el 
	 * pedido que pasemos, agregamos la anotacion modifying y transacional para que los
	 * cambios se apliquen en la BBDD
	 * 
	 * @author Gerard Perujo
	 *  
	 * @param idPedido parametro que hacer referencia al pedido que queremos eliminar
	 * 
	 * Este metodo no devuelve nada hace la accion de eliminar directamente a la BBDD
	 */
	@Modifying
	@Transactional
	@Query
	("delete from ProductoPedido p where p.pedido.idPedido = ?1")
	void deleteTodosProductosPorPedido(int idPedido);
	


}
