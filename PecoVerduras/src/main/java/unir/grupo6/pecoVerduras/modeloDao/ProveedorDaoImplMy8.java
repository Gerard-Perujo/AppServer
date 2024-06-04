package unir.grupo6.pecoVerduras.modeloDao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import unir.grupo6.pecoVerduras.modeloEntity.Proveedor;
import unir.grupo6.pecoVerduras.repository.ProveedorRepository;


/**
 * Clase que implementa la interface ProveedorDao para poder utilizar sus metodos
 * 
 * @author Maria Isabel
 *
 */
@Repository
public class ProveedorDaoImplMy8 implements ProveedorDao{
	
	
	/**
	 * Importamos la clase ProveedorRepository para poder utilizar los metodos de JPA
	 */
	@Autowired
	private ProveedorRepository proveedorRepository;

	
	/**
	 * Metodo que usaremos para buscar un proveedor pasando el 
	 * id
	 * 
	 * @author Maria Isabel
	 * 
	 */
	@Override
	public Proveedor buscarUnProveedor(int idProveedor) {
		
		return proveedorRepository.findById(idProveedor).orElse(null);
	}

	
	/**
	 * Metodo que usaremos para modificar un proveedor pasandole el
	 * objeto entero
	 * 
	 * @author Maria Isabel
	 * 
	 */
	@Override
	public Proveedor modificarProveedor(Proveedor proveedor) {
		try {
			if(buscarUnProveedor(proveedor.getIdProveedor()) != null) {//en caso de que no sea nulo procederemos a modificar el proveedor
				return proveedorRepository.save(proveedor);
			}else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	/**
	 * Metodo que usaremos para agregar un proveedor pasandole
	 * el objeto entero
	 * 
	 * @author Maria Isabel
	 * 
	 */
	@Override
	public Proveedor insertarProveedor(Proveedor proveedor) {
		try {
			if(buscarUnProveedor(proveedor.getIdProveedor()) == null) {//en caso de que sea nulo procederemos agregar el proveedor
				return proveedorRepository.save(proveedor);
			}else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	

	
	/**
	 * Metodo que usaremos para eliminar un proveedor pasandole su id
	 * 
	 * @author Maria Isabel
	 * 
	 */
	@Override
	public int eliminarPorveedor(int idProveedor) {
		Proveedor prove = buscarUnProveedor(idProveedor);
		
		if(prove != null) {//se comprueba que el proveedor exista y procedemos a eliminarla
			proveedorRepository.delete(prove);
			return 1;
		}else {
			return 0;
		}
		
	}

	
	/**
	 * Metodo que usaremos para sacar una lista de todos los proveedores
	 * 
	 * @author Maria Isabel
	 * 
	 */
	@Override
	public List<Proveedor> mostrarTodosProveedores() {
		
		return proveedorRepository.findAll();
	}

}
