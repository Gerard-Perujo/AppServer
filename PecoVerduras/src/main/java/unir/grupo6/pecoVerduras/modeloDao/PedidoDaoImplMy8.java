package unir.grupo6.pecoVerduras.modeloDao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import unir.grupo6.pecoVerduras.modeloEntity.Pedido;
import unir.grupo6.pecoVerduras.modeloEntity.Usuario;
import unir.grupo6.pecoVerduras.repository.PedidoRepository;


/**
 * Clase que implementa la interface PedidoDao para poder utilizar sus metodos
 * 
 * @author Gerard Perujo
 *
 */
@Repository
public class PedidoDaoImplMy8 implements PedidoDao{
	
	
	/**
	 * Importamos la clase PedidoRepository para poder utilizar los metodos de JPA
	 */
	@Autowired
	private PedidoRepository pedidoRepository;

	
	/**
	 * Metodo que usarremos para buscar un pedido pasandole su id
	 * 
	 * @author Gerard Perujo
	 * 
	 */
	@Override
	public Pedido buscarUnPedido(int idPedido) {

		return pedidoRepository.findById(idPedido).orElse(null);
	}

	
	/**
	 * Metodo que utilizaremos para modificar un pedido pasandole 
	 * todo el objeto
	 * 
	 * @author Gerard Perujo
	 * 
	 */
	@Override
	public Pedido modificarPedido(Pedido pedido) {
		try {
			if(buscarUnPedido(pedido.getIdPedido()) != null) {//en caso de que no sea nulo procederemos a modificar el pedido
				return pedidoRepository.save(pedido);
			}else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	/**
	 * Metodo que usaremos para agregar un pedido pasandole
	 * todo el objeto
	 * 
	 * @author Gerard Perujo
	 * 
	 */
	@Override
	public Pedido insertarPedido(Pedido pedido) {
		try {
			if(buscarUnPedido(pedido.getIdPedido()) == null) {//en caso de que sea nulo procederemos agregar el pedido
				return pedidoRepository.save(pedido);
			}else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	/**
	 * Metodo que usaremos para eliminar el pedido pasandole
	 * el id
	 * 
	 * @author Gerard Perujo
	 * 
	 */
	@Override
	public int eliminarPedido(int idPedido) {
		Pedido pedi = buscarUnPedido(idPedido);
		
		if(pedi != null) {//se comprueba que el pedido exista y procedemos a eliminarla
			pedidoRepository.delete(pedi);
			return 1;
		}else {
			return 0;
		}
		
	}

	
	/**
	 * Metodo que utilizaremos para sacar una lista con todos los pedidos
	 * 
	 * @author Gerard Perujo
	 * 
	 */
	@Override
	public List<Pedido> mostrarTodosPedidos() {
		return pedidoRepository.findAll();
	}

	
	/**
	 * Metodo que utilizaremos para buscar un pedido pasandole un usuario y el
	 * estado del pedido
	 * 
	 * @author Gerard Perujo
	 * 
	 */
	@Override
	public Pedido buscarPedidoPorUsuarioEstado(Usuario usuario, String estado) {
		String user = usuario.getUsername();
		return pedidoRepository.findPedidoUsuarioEstado(user, estado);
	}

	
	/**
	 * Metodo que utilizaremos para sacar una lista de pedidos segun el usuario
	 * que pasemos
	 * 
	 * @author Gerard Perujo
	 * 
	 */
	@Override
	public List<Pedido> findPedidosUsuario(String username) {
		return pedidoRepository.mostrarPedidosUsuario(username);
	}

	
	/**
	 * Metodo que usaremos para sacar una lista de pedidos segun el usuario que
	 * pasemos
	 * 
	 * @author Gerard Perujo
	 */
	@Override
	public List<Pedido> mostrarPedidosUsuario(Usuario usuario) {
		String user = usuario.getUsername();
		return pedidoRepository.findPedidosUsuario(user);

	}

	
	/**
	 * Metodo que usaremos para sacar una lista de pedidos segun el usuario que pasemos
	 * y el estado del pedido
	 * 
	 * @author Gerard Perujo
	 * 
	 */
	@Override
	public List<Pedido> mostrarPuntosPorUsuarioEstado(Usuario usuario, String estado) {
		String user = usuario.getUsername();
		
		return pedidoRepository.findPuntosPorUsuarioEstado(user, estado);
	}

	
	/**
	 * Metodo que usaremos para sacar una lista de pedido segun e usuario que pasemos 
	 * y el estado del pedido
	 * 
	 * @author Gerard Perujo
	 * 
	 */
	@Override
	public List<Pedido> mostrarPrecioDeUnPedido(Usuario usuario, String estado) {
		String user = usuario.getUsername();
		return pedidoRepository.findPuntosPorUsuarioEstado(user, estado);
	}

}
