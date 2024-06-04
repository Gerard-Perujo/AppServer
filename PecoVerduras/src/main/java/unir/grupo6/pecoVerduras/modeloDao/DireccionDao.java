package unir.grupo6.pecoVerduras.modeloDao;

import java.util.List;

import unir.grupo6.pecoVerduras.modeloEntity.Direccion;
import unir.grupo6.pecoVerduras.modeloEntity.Usuario;


/**
 *  Interface de Direccion donde tendremos nuestros metodos que utilizaremos para
 * sacar la informacion
 * 
 * @author Noelia Villahermosa
 *
 */
public interface DireccionDao {
	
	Direccion buscarUnaDireccion(int idDireccion);
	Direccion modificarDireccion(Direccion direccion);
	Direccion insertarDireccion (Direccion direccion);
	int eliminarDireccion (int idDireccion);
	List<Direccion> mostarTodasDireccion();
	
	List<Direccion> mostrarDireccionUsuario(Usuario usuario, String estado);
}
