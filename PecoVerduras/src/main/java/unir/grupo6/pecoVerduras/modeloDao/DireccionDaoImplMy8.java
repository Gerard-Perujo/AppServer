package unir.grupo6.pecoVerduras.modeloDao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import unir.grupo6.pecoVerduras.modeloEntity.Direccion;
import unir.grupo6.pecoVerduras.modeloEntity.Usuario;
import unir.grupo6.pecoVerduras.repository.DireccionRepository;


/**
 * Clase que implementa la interface DireccionRepository para poder utilizar sus metodos
 * 
 * @author Noelia Villahermosa
 *
 */
@Repository
public class DireccionDaoImplMy8 implements DireccionDao{

	
	/**
	 * Importamos la clase DireccionRepository para poder utilizar los metodos de JPA
	 */
	@Autowired
	private DireccionRepository direccionRepository;
	
	
	/**
	 * Metodo que utilizaremos para buscar una direccion pasandole su id
	 * 
	 *  @author Noelia Villahermosa
	 *  
	 */
	@Override
	public Direccion buscarUnaDireccion(int idDireccion) {
		
		return direccionRepository.findById(idDireccion).orElse(null);
	}

	
	/**
	 * Metodo que utilizaremos para modificar una direccion pasandole todo
	 * el objeto
	 * 
	 *  @author Noelia Villahermosa
	 */
	@Override
	public Direccion modificarDireccion(Direccion direccion) {
		try {
			if(buscarUnaDireccion(direccion.getIdDireccion()) != null) {//en caso de que no sea nulo procederemos a modificar la direccion
				return direccionRepository.save(direccion);
			}else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	/**
	 * Metodo que utilizaremos para agregar una direccion pasandole
	 * todo el objeto
	 * 
	 *  @author Noelia Villahermosa
	 *  
	 */
	@Override
	public Direccion insertarDireccion(Direccion direccion) {
		try {
			if(buscarUnaDireccion(direccion.getIdDireccion()) == null) {//en caso de que sea nulo procederemos a modificar la direccion
				return direccionRepository.save(direccion);
			}else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	/**
	 * Metodo que utilizaremos para eliminar una direccion
	 * pasandole su id
	 * 
	 *  @author Noelia Villahermosa
	 *  
	 */
	@Override
	public int eliminarDireccion(int idDireccion) {
		Direccion direc = buscarUnaDireccion(idDireccion);
		
		if(direc != null) {//se comprueba que la direccion exista y procedemos a eliminarla
			direccionRepository.delete(direc);
			return 1;
		}else {
			return 0;
		}
		
	}

	
	/**
	 * Metodo que utilizremos para sacar una lista de todas las direcciones
	 * 
	 *  @author Noelia Villahermosa
	 *  
	 */
	@Override
	public List<Direccion> mostarTodasDireccion() {
		
		return direccionRepository.findAll();
	}

	
	/**
	 * Metodo que utilizaremos para sacar una lista de todas las direcciones que 
	 * tiene el usuario que pasemos segun su estado
	 * 
	 *  @author Noelia Villahermosa
	 *  
	 */
	@Override
	public List<Direccion> mostrarDireccionUsuario(Usuario usuario, String estado) {
		String user = usuario.getUsername(); 
		return direccionRepository.findDireccionesUsuario(user, estado);
	}
	
	

}
