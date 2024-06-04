package unir.grupo6.pecoVerduras.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import unir.grupo6.pecoVerduras.modeloEntity.Pedido;


/**
 * Creo la clase PedidoRepository que coge todos los metodos que tiene JPA
 * de esta manera esta clase se encargara de hacer todas las operaciones
 * necesarias con sus metodos propios
 * 
 * @author Gerard Perujo
 *
 */
public interface PedidoRepository extends JpaRepository<Pedido, Integer>{
	
	/**
	 * Creo un metodo pasandole una query donde le paso un usuario y un estado para
	 * sacar un pedido
	 * 
	 * @author Gerard Perujo
	 * 
	 * @param usuario usuario del cual queremos sacar las cuentas
	 * 
	 * @param estado parametro que hace referencia al estado que se encuentra el pedido
	 * 
	 * @return nos devuelve un pedido segun el usuario que pasemos y su estado
	 */
	@Query
	("select p from Pedido p where p.usuario.username = ?1 AND p.estado = ?2")
     Pedido findPedidoUsuarioEstado(String usuario, String estado);

	
	/**
	 * Creo un metodo pasandole una query para buscar los pedidos pasandole
	 * un usuario
	 * 
	 * @author Noelia Villahermosa
	 * 
	 * @param username nombre del usuario del cual queremos sacar las cuentas
	 * 
	 * @return nos devuelve una lista con todos los pedidos que tiene el usuario
	 * que hemos pasado
	 */
	@Query
	("SELECT p FROM Pedido p WHERE p.usuario.username = ?1")
	public List<Pedido> mostrarPedidosUsuario(String username);
	
	
	/**
	 * Creo un metodo pasandole una query para sacar los pedidos psandole un usuario
	 * 
	 * @author Gerard Perujo
	 * 
	 * @param usuario nombre del usuario del cual queremos sacar las cuentas
	 * 
	 * @return nos devuelve una lista con todos los pedidos que tiene el usuario
	 * que hemos pasado
	 */
	@Query
	("Select u from Pedido u where u.usuario.username = ?1")
	public List<Pedido> findPedidosUsuario (String usuario); 
	
	
	/**
	 *  Creo un metodo pasandole una query para sacar los pedidos segun el usuario
	 * y el estado
	 * 
	 * @author Gerard Perujo
	 * 
	 * @param usuario  nombre del usuario del cual queremos sacar las cuentas
	 * 
	 * @param estado parametro que hace referencia al estado que se encuentra el pedido
	 * 
	 * @return nos devuelve una lista con todos los pedidos que tiene el usuario
	 * que hemos pasado segun su estado
	 */
	@Query
	("select p from Pedido p where p.usuario.username = ?1 AND p.estado = ?2")
     List<Pedido> findPuntosPorUsuarioEstado(String usuario, String estado);
	
	
	/**
	 * Creo un metodo pasandole una query para sacar los pedidos segun el usuario
	 * y el estado
	 * 
	 * @author Noelia Villahermosa
	 * 
	 * @param usuario  nombre del usuario del cual queremos sacar las cuentas
	 * 
	 * @param estado parametro que hace referencia al estado que se encuentra el pedido
	 * 
	 * @return nos devuelve una lista con todos los pedidos que tiene el usuario
	 * que hemos pasado segun su estado
	 */
	@Query
	("select p from Pedido p where p.usuario.username = ?1 AND p.estado = ?2")
     List<Pedido> mostrarPrecioDePedido(String usuario, String estado);


}
