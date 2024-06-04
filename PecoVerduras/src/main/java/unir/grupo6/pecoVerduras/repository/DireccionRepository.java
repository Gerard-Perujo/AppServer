package unir.grupo6.pecoVerduras.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import unir.grupo6.pecoVerduras.modeloEntity.Direccion;


/**
 * Creo la clase DireccionRepository que coge todos los metodos que tiene JPA
 * de esta manera esta clase se encargara de hacer todas las operaciones
 * necesarias con sus metodos propios
 * 
 * @author Gerard Perujo
 *
 */
public interface DireccionRepository extends JpaRepository<Direccion, Integer>{
	
	/**
	 * Creo un metodo pasando una query pasando el usuario y el estado para sacar 
	 * una lista de direcciones
	 * 
	 * @author Gerard Perujo
	 * 
	 * @param usuario usuario del cual queremos sacar las cuentas
	 * 
	 * @param estado parametro que hace referencia al estado que se encuentra la direccion
	 * 
	 * @return nos devuelve una lista con todas las direcciones del usuario que hemos pasado
	 * segun su estado
	 */
	@Query
	("select u from Direccion u where u.usuario.username = ?1 AND u.estado = ?2")
	 public List<Direccion> findDireccionesUsuario(String usuario, String estado); 
}
