package unir.grupo6.pecoVerduras.modeloDao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import unir.grupo6.pecoVerduras.modeloEntity.ProductoFavorito;
import unir.grupo6.pecoVerduras.repository.ProductoFavoritoRepository;



/**
 * Clase que implementa la interface ProductoFavorito para poder utilizar sus metodos
 * 
 * @author Noelia Villahermosa
 *
 */
@Repository
public class ProductoFavoritoDaoImplMy8 implements ProductoFavoritoDao{
	
	
	/**
	 * Importamos la clase ProductoFavoritoRepository para poder utilizar los metodos de JPA
	 */
	@Autowired
	private ProductoFavoritoRepository productoFavoritoRepository;

	
	/**
	 * Metodo que utilizaremos para buscar un productofavorito pasandole su id
	 * 
	 * @author Noelia Villahermosa
	 */
	@Override
	public ProductoFavorito buscarUnFavorito(int idFavorito) {
	
		return productoFavoritoRepository.findById(idFavorito).orElse(null);
	}

	
	/**
	 * Metodo que utilizaremos para modificar un producto favaorito pasandole
	 * todo el objeto
	 * 
	 * @author Noelia Villahermosa
	 * 
	 */
	@Override
	public ProductoFavorito modificarFAvorito(ProductoFavorito productoFavorito) {
		try {
			if(buscarUnFavorito(productoFavorito.getIdFavorito()) != null) {//en caso de que no sea nulo procederemos a modificar el producto favorito
				return productoFavoritoRepository.save(productoFavorito);
			}else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	/**
	 * Metodo que utilizaremos para agregar un producto favorito pasandole
	 * todo el objeto
	 * 
	 * @author Noelia Villahermosa
	 * 
	 */
	@Override
	public ProductoFavorito insertarFavorito(ProductoFavorito productoFavorito) {
		try {
			if(buscarUnFavorito(productoFavorito.getIdFavorito()) == null) {//en caso de que sea nulo procederemos agregar el producto favorito
				return productoFavoritoRepository.save(productoFavorito);
			}else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	/**
	 * Metodo que utilizaremos para eliminar un producto favorito
	 * pasandole su id
	 * 
	 * @author Noelia Villahermosa
	 * 
	 */
	@Override
	public int eliminarFavorito(int idFavorito) {
		ProductoFavorito favorito = buscarUnFavorito(idFavorito);
		
		if(favorito != null) {
			productoFavoritoRepository.delete(favorito);
			return 1;
		}else {
			return 0;
		}
		
	}

	
	/**
	 * Metodo que sacaremos una lista de todos los productos favoritos
	 * 
	 * @author Noelia Villahermosa
	 * 
	 */
	@Override
	public List<ProductoFavorito> mostrarTodosFavoritos() {
		
		return productoFavoritoRepository.findAll();
	}

	
	/**
	 * Metodo que sacaremos una lista de todos los productos favoritos del usuario
	 * que pasemos segun el estado de los productos favoritos
	 * 
	 * @author Noelia Villahermosa
	 * 
	 */
	@Override

	public List<ProductoFavorito> mostrarTodosFavPorUsuario(String username, String estado) {
		
		return productoFavoritoRepository.findProductosFavUsuario(username, estado);
	}
	
	
	/**
	 * Metodo que usaremos para buscar un producto favorito pasando un usuario y el id del
	 * producto que queremos buscar
	 * 
	 * @author Noelia Villahermosa
	 * 
	 */
	@Override
	public ProductoFavorito buscarProductoFavoritoPorUsuarioYProducto(String usuario, int idProductos) {
		return productoFavoritoRepository.findFavProductByUserAndProduct(usuario, idProductos);

	}

}
