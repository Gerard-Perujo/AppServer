package unir.grupo6.pecoVerduras.modeloDao;

import java.util.List;

import unir.grupo6.pecoVerduras.modeloEntity.Pedido;
import unir.grupo6.pecoVerduras.modeloEntity.Producto;
import unir.grupo6.pecoVerduras.modeloEntity.ProductoPedido;


/**
 *  Interface de Evento donde tendremos nuestros metodos que utilizaremos para
 * sacar la informacion
 * 
 * @author Maria Isabel
 *
 */
public interface ProductoPedidoDao {
	
	ProductoPedido buscarUnProdPedi(int idCompra);
	ProductoPedido modificarProdPedi(ProductoPedido productoPedido);
	ProductoPedido insertarProdPedi(ProductoPedido productoPedido);
	int eliminarProdPedi(int idCompra);
	List<ProductoPedido> mostrarTodoProdPedi();
	
	List<ProductoPedido> mostrarProductosPorPedido(Pedido pedido);
	void eliminarProductosPorPedido(Pedido pedido);
	ProductoPedido buscarProductoPedidoPorProducto(Producto producto);
}
