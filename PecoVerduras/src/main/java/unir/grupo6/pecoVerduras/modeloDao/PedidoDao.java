package unir.grupo6.pecoVerduras.modeloDao;

import java.util.List;

import unir.grupo6.pecoVerduras.modeloEntity.Pedido;
import unir.grupo6.pecoVerduras.modeloEntity.Usuario;



/**
 *  Interface de Pedido donde tendremos nuestros metodos que utilizaremos para
 * sacar la informacion
 * 
 * @author Gerard Perujo
 *
 */
public interface PedidoDao {
	
	Pedido buscarUnPedido(int idPedido);
	Pedido modificarPedido(Pedido pedido);
	Pedido insertarPedido(Pedido pedido);
	int eliminarPedido(int idPedido);
	List<Pedido> mostrarTodosPedidos();
	

	Pedido buscarPedidoPorUsuarioEstado(Usuario usuario, String estado);
	List<Pedido> mostrarPuntosPorUsuarioEstado(Usuario usuario, String estado);////
	List<Pedido> mostrarPrecioDeUnPedido(Usuario usuario, String estado);////
	List<Pedido> mostrarPedidosUsuario(Usuario usuario);
	
	List<Pedido> findPedidosUsuario(String username); 
	
	


}
