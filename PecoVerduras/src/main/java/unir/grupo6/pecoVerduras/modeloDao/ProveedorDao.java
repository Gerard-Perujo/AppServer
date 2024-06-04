package unir.grupo6.pecoVerduras.modeloDao;

import java.util.List;

import unir.grupo6.pecoVerduras.modeloEntity.Proveedor;


/**
 *  Interface de Evento donde tendremos nuestros metodos que utilizaremos para
 * sacar la informacion
 * 
 * @author Maria Isabel
 *
 */
public interface ProveedorDao {

	Proveedor buscarUnProveedor(int idProveedor);
	Proveedor modificarProveedor(Proveedor proveedor);
	Proveedor insertarProveedor(Proveedor proveedor);
	int eliminarPorveedor(int idProveedor);
	List<Proveedor> mostrarTodosProveedores();
}
