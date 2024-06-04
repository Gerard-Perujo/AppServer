package unir.grupo6.pecoVerduras.modeloDao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import unir.grupo6.pecoVerduras.modeloEntity.Categoria;
import unir.grupo6.pecoVerduras.repository.CategoriaRepository;


/**
 * Clase que implementa la interface CategoriaDao para poder utilizar sus metodos
 * 
 * @author Maria Isabel
 *
 */
@Repository
public class CategoriaDaoImplMy8 implements CategoriaDao{

	
	/**
	 * Importamos la clase CategoriaRepository para poder utilizar los metodos de JPA
	 */
	@Autowired
	private CategoriaRepository categoriaRepository;
		
	
	/**
	 * Metodo que utilizaremos para buscar una categoria pasandole su id
	 * 
	 * @author Maria Isabel
	 */
	@Override
	public Categoria buscarUnaCategoria(int idCategoria) {
		
		return categoriaRepository.findById(idCategoria).orElse(null);
	}

	
	
	/**
	 * Metodo que utilizaremos para modificar una categoria pasandole
	 * todo el objeto
	 * 
	 * @author Maria Isabel
	 */
	@Override
	public Categoria modificarCategoria(Categoria categoria) {
		try {
			if(buscarUnaCategoria(categoria.getIdCategoria()) != null) {//en caso de que no sea nulo procederemos a modificar la categoria
				return categoriaRepository.save(categoria);
			}else {
				return null;
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	
	/**
	 * Metodo que utilizaremos para agregar una categoria pasandole
	 * todo el objeto
	 * 
	 * @author Maria Isabel
	 */
	@Override
	public Categoria agregarCategoria(Categoria categoria) {
		try {
			if(buscarUnaCategoria(categoria.getIdCategoria()) == null) {//en caso de que sea nulo procederemos agregar la categoria
				return categoriaRepository.save(categoria);
			}else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return null;
	}

	
	/**
	 * Metodo que utilizaremos para eliminar una categoria pasandole su id
	 * 
	 * @author Maria Isabel
	 */
	@Override
	public int eliminarCategoria(int idCategoria) {
		
		Categoria cate = buscarUnaCategoria(idCategoria);
		
		if (cate != null) {//se comprueba que la categoria exista y procedemos a eliminarla
			categoriaRepository.delete(cate);
			return 1;
			
		}else {
			return 0;
		}
		
	}

	
	
	/**
	 * Metodo que utilizaremos para sacar una lista con todas las 
	 * categorias que hay
	 * 
	 * @author Maria Isabel
	 */
	@Override
	public List<Categoria> mostrarTodasCategorias() {
		return categoriaRepository.findAll();
	}

}
