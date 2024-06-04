package unir.grupo6.pecoVerduras.modeloDao;

import java.util.List;

import unir.grupo6.pecoVerduras.modeloEntity.Categoria;
import unir.grupo6.pecoVerduras.modeloEntity.Producto;


/**
 *  Interface de Producto donde tendremos nuestros metodos que utilizaremos para
 * sacar la informacion
 * 
 * @author Maria Isabel
 *
 */
public interface ProductoDao {
	
	Producto buscarUnProducto(int idProducto);
	Producto modificarProducto(Producto producto);
	Producto insertarProducto(Producto producto);
	int eliminarProducto(int idProducto);
	List<Producto> mostrarTodosProductos();
	List<Producto> mostrarPromocionesPorEstadp(String promocion, String estado);
	List<Producto> mostrarProductoPorCategoriaEstado(Categoria categoria, String estado, String promocion);
	
	
	List<Producto> buscarTodosPorCategoriaYEstadoActivo(Categoria categoria, String estado, String promocion);
	List<Producto> buscarProductoPorNombre(String tipoProducto, String promocion);
	List<Producto> buscarProductoPorEstado(String estado);
	

}
