package unir.grupo6.pecoVerduras.modeloDao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import unir.grupo6.pecoVerduras.modeloEntity.Pedido;
import unir.grupo6.pecoVerduras.modeloEntity.Producto;
import unir.grupo6.pecoVerduras.modeloEntity.ProductoPedido;
import unir.grupo6.pecoVerduras.repository.ProductoPedidoRepository;


/**
 * Clase que implementa la interface ProductoPedido para poder utilizar sus metodos
 * 
 * @author Maria Isabel
 *
 */
@Repository
public class ProductoPedidoDaoImplMy8 implements ProductoPedidoDao{
	
	
	/**
	 * Importamos la clase ProductoPedidoRepository para poder utilizar los metodos de JPA
	 */
	@Autowired
	private ProductoPedidoRepository productoPedidoRepository;

	
	/**
	 * Metodo que usaremos para buscar un producto pedido pasando
	 * el id 
	 * 
	 * @author Maria Isabel
	 * 
	 */
	@Override
	public ProductoPedido buscarUnProdPedi(int idCompra) {
		
		return productoPedidoRepository.findById(idCompra).orElse(null);
	}

	
	/**
	 * Metodo que usaremos para modificar un productoPedido pasandole
	 * el objeto entero
	 * 
	 * @author Maria Isabel
	 * 
	 */
	@Override
	public ProductoPedido modificarProdPedi(ProductoPedido productoPedido) {
		try {
			if(buscarUnProdPedi(productoPedido.getIdCompra()) != null) {//en caso de que no sea nulo procederemos a modificar el producto pedido
				return productoPedidoRepository.save(productoPedido);
			}else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	/**
	 * Metodo que usaremos para insertar un productoPedido pasandole
	 * el objeto entero
	 * 
	 * @author Maria Isabel
	 * 
	 */
	@Override
	public ProductoPedido insertarProdPedi(ProductoPedido productoPedido) {
		try {
			if(buscarUnProdPedi(productoPedido.getIdCompra()) == null) {//en caso de que sea nulo procederemos agregaremos el producto pedido
				return productoPedidoRepository.save(productoPedido);
			}else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	/**
	 * Metodo que usaremos para eliminar el producto pedido pasandole
	 * su id
	 * 
	 * @author Maria Isabel
	 * 
	 */
	@Override
	public int eliminarProdPedi(int idCompra) {
		ProductoPedido prodPedi = buscarUnProdPedi(idCompra);
		
		if(prodPedi != null) {//se comprueba que el producto pedido exista y procedemos a eliminarla
			productoPedidoRepository.delete(prodPedi);
			return 1;
		}else {
			return 0;
		}
		
	}

	
	/**
	 * Metodo que usaremos para mostrar todos los productos pedidos
	 * 
	 * @author Maria Isabel
	 * 
	 */
	@Override
	public List<ProductoPedido> mostrarTodoProdPedi() {
		
		return productoPedidoRepository.findAll();
	}

	
	/**
	 * Metodo que usaremos para mostrar una lista de todos los prodcutos pedidos
	 * pasando un pedido
	 * 
	 * @author Maria Isabel
	 * 
	 */
	@Override
	public List<ProductoPedido> mostrarProductosPorPedido(Pedido pedido) {
		
		int pedi = pedido.getIdPedido();
		return productoPedidoRepository.findMostrarProductosPedido(pedi);
	}

	
	/**
	 * Metodo que usaremos para eliminar un producto pedido pasando un pedido
	 * 
	 * @author Maria Isabel
	 * 
	 */
	@Override
	public void eliminarProductosPorPedido(Pedido pedido) {
		
		int pedi = pedido.getIdPedido();
		
		productoPedidoRepository.deleteTodosProductosPorPedido(pedi);
	}

	
	/**
	 * Medodo que usaremos para buscar un producto pedido pasando un producto
	 * 
	 * @author Maria Isabel
	 * 
	 */
	@Override
	public ProductoPedido buscarProductoPedidoPorProducto(Producto producto) {
		int prod = producto.getIdProductos();
		return productoPedidoRepository.findProductoPedidoPorProducto(prod);
	}

	

}
