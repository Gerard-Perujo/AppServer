package unir.grupo6.pecoVerduras.modeloDao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import unir.grupo6.pecoVerduras.modeloEntity.Categoria;
import unir.grupo6.pecoVerduras.modeloEntity.Producto;

import unir.grupo6.pecoVerduras.repository.ProductoRepository;


/**
 * Clase que implementa la interface ProductoDao para poder utilizar sus metodos
 * 
 * @author Maria Isabel
 *
 */
@Repository
public class ProductoDaoImplMy8 implements ProductoDao{
	
	
	/**
	 * Importamos la clase ProductoRepository para poder utilizar los metodos de JPA
	 */
	@Autowired
	private ProductoRepository productoRepository;
	
	

	/**
	 * Metodo que utilizaremos para buscar un producto pasandole la id
	 * 
	 * @author Maria Isabel
	 * 
	 */
	@Override
	public Producto buscarUnProducto(int idProducto) {
		
		return productoRepository.findById(idProducto).orElse(null);

	}

	
	
	/**
	 * Metodos que utilizaremos para modificar un producto pasandole 
	 * el objeto entero
	 * 
	 * @author Maria Isabel
	 * 
	 */
	@Override
	public Producto modificarProducto(Producto producto) {
		try {
			if(buscarUnProducto(producto.getIdProductos()) != null) {//en caso de que no sea nulo procederemos a modificar el producto
				return productoRepository.save(producto);
			}else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	/**
	 * Metodo que usaremos para insertar un producto pasandole
	 * el objeto entero
	 * 
	 * @author Maria Isabel
	 * 
	 */
	@Override
	public Producto insertarProducto(Producto producto) {
		try {
			if(buscarUnProducto(producto.getIdProductos()) == null) {//en caso de que sea nulo procederemos agregar el producto
				return productoRepository.save(producto);
			}else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	/**
	 * Metodo que utilizatemos para eliminar un producto 
	 * pasandole su id
	 * 
	 * @author Maria Isabel
	 * 
	 */
	@Override
	public int eliminarProducto(int idProducto) {
		Producto producto = buscarUnProducto(idProducto);
		
		if(producto != null) {//se comprueba que el producto exista y procedemos a eliminarla
			productoRepository.delete(producto);
			return 1;
		}else{
			return 0;
		}
		
	}

	
	/**
	 * Metodo que utilizaremos para sacar una lista con todos
	 * los productos
	 * 
	 * @author Maria Isabel
	 * 
	 */
	@Override
	public List<Producto> mostrarTodosProductos() {
		
		return productoRepository.findAll();
	}



	/**
	 * Metodo que usaremos para sacar una lista de todos los productos
	 * que sean promocion segun el estado del producto
	 * 
	 * @author Maria Isabel
	 * 
	 */
	@Override
	public List<Producto> mostrarPromocionesPorEstadp(String promocion, String estado) {
		
		return productoRepository.findAllPromocionEstado(promocion, estado);
	}

	
	/**
	 * Metodo que utilizaremos para sacar una lista de todos los productos segun su categoria, si
	 * son promocion y segun el estado del producto
	 * 
	 * @author Maria Isabel
	 * 
	 */
	@Override
	public List<Producto> mostrarProductoPorCategoriaEstado(Categoria categoria, String estado, String promocion) {
		
		return productoRepository.findPorCategoriaEstado(categoria.getNombre(), estado, promocion);
	}

	
	/**
	 * Metodo que utilizaremos para sacar una lista de todos los productos segun su categoria, si
	 * son promocion y segun el estado del producto
	 * 
	 * @author Maria Isabel
	 * 
	 */
	@Override
	public List<Producto> buscarTodosPorCategoriaYEstadoActivo(Categoria categoria, String estado, String promocion){
		int cate = categoria.getIdCategoria();
		
		return productoRepository.findByCategoryAndStatusActive(cate, estado, promocion);
	}

	
	/**
	 * Metodo que utilizaremos para sacar una lista de todos los producto segun su
	 * tipoProducto y si son promocion
	 * 
	 * @author Maria Isabel
	 * 
	 */
	@Override
	public List<Producto> buscarProductoPorNombre(String tipoProducto, String promocion)
	{
		return productoRepository.findProductByName(tipoProducto, promocion);
	}

	
	/**
	 * Metodo que utilizaremos para sacar una lista de todos los productos
	 * segun el estado que pasemos
	 * 
	 * @author Maria Isabel
	 * 
	 */
	@Override
	public List<Producto> buscarProductoPorEstado(String estado) {
		
		return productoRepository.findProducoPorEstado(estado);
	}

}
