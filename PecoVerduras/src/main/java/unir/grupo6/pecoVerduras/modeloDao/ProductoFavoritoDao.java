package unir.grupo6.pecoVerduras.modeloDao;

import java.util.List;

import unir.grupo6.pecoVerduras.modeloEntity.ProductoFavorito;



/**
 *  Interface de ProductoFavorito donde tendremos nuestros metodos que utilizaremos para
 * sacar la informacion
 * 
 * @author Noelia Villahermosa
 *
 */
public interface ProductoFavoritoDao {
	
	ProductoFavorito buscarUnFavorito(int idFavorito);
	ProductoFavorito modificarFAvorito(ProductoFavorito productoFavorito);
	ProductoFavorito insertarFavorito(ProductoFavorito productoFavorito);
	int eliminarFavorito(int idFavorito);
	List<ProductoFavorito> mostrarTodosFavoritos();
	

	List<ProductoFavorito> mostrarTodosFavPorUsuario(String username, String estado); 

	ProductoFavorito buscarProductoFavoritoPorUsuarioYProducto(String usuario, int idProductos);


}
