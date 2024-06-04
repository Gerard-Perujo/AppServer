package unir.grupo6.pecoVerduras.modeloDao;

import java.util.List;

import unir.grupo6.pecoVerduras.modeloEntity.Categoria;


/**
 *  Interface de Categoria donde tendremos nuestros metodos que utilizaremos para
 * sacar la informacion
 * 
 * @author Maria Isabel
 *
 */
public interface CategoriaDao {
	
	Categoria buscarUnaCategoria(int idCategoria);
	Categoria modificarCategoria(Categoria categoria);
	Categoria agregarCategoria(Categoria categoria);
	int eliminarCategoria(int idCategoria);
	List<Categoria> mostrarTodasCategorias();

}
