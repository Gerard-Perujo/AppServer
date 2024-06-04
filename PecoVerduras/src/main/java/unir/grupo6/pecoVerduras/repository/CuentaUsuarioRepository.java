package unir.grupo6.pecoVerduras.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import unir.grupo6.pecoVerduras.modeloEntity.CuentaUsuario;


/**
 * Creo la clase CuentaUsuarioRepository que coge todos los metodos que tiene JPA
 * de esta manera esta clase se encargara de hacer todas las operaciones
 * necesarias con sus metodos propios
 * 
 * @author Gerard Perujo
 *
 */
public interface CuentaUsuarioRepository extends JpaRepository<CuentaUsuario, Integer>{
	
	
	/**
	 * Creo un metodo pasandole una query para buscar las cuentas pasandole el usuario
	 * segun el estado de la cuenta
	 * 
	 * @author Gerard Perujo
	 * 
	 * @param usuario usuario del cual queremos sacar las cuentas
	 * 
	 * @param estado parametro que hace referencia al estado que se encuentra la cuenta usuario
	 * 
	 * @return nos devuelve una lista con todas las cuentas que tiene el usuario segun el estado que 
	 * le pasemos
	 */
	@Query
	("select c from CuentaUsuario c where c.usuario.username = ?1 AND c.estado = ?2")
	List<CuentaUsuario> findCuentaPorUsuarioEstado(String usuario, String estado);

	
	/**
	 * Creo un metodo pasandole una query para buscar las cuen
	 * 
	 * @author Maria Isabel
	 * 
	 * @param usuario usuario del cual queremos sacar las cuentas
	 * 
	 * @param estado parametro que hace referencia al estado que se encuentra la cuenta usuario
	 * 
	 * @return nos devuelve una lista con todas las cuentas que tiene el usuario segun el estado que 
	 * le pasemos
	 */
	@Query
	("select u from CuentaUsuario u where u.usuario.username = ?1 AND u.estado = ?2")
	public List<CuentaUsuario> findCreditCardCuentaUsuario (String usuario, String estado); 
	
	
	/**
	 * Creo un metodo pasandole una query para sacar todas las cuentas que tiene el usuario
	 * pasandole el usuario
	 * 
	 * @param usuario usuario del cual queremos sacar las cuentas
	 * 
	 * @return nos devuelve la lista de todas las cuentas que tiene el usuario que pasemos
	 */
	@Query
	("select u from CuentaUsuario u where u.usuario.username = ?1") 
	public List<CuentaUsuario> findDatosCreditCardUsuario (String usuario); 
}
