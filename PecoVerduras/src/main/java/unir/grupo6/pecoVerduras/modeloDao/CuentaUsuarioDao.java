package unir.grupo6.pecoVerduras.modeloDao;

import java.util.List;

import unir.grupo6.pecoVerduras.modeloEntity.CuentaUsuario;
import unir.grupo6.pecoVerduras.modeloEntity.Usuario;



/**
 *  Interface de CuentaUsuario donde tendremos nuestros metodos que utilizaremos para
 * sacar la informacion
 * 
 * @author Noelia Villahermosa
 *
 */
public interface CuentaUsuarioDao {
	
	CuentaUsuario buscarUnaCuenta(int idCuenta);
	CuentaUsuario modificarCuenta(CuentaUsuario cuentaUsuario);
	CuentaUsuario insertarCuenta(CuentaUsuario cuentaUsuario);
	int eliminarCuenta(int idCuenta);
	List<CuentaUsuario> mostarTodasCuentas();
	

	List<CuentaUsuario> mostrarCreditCardCuentaUsuario(Usuario usuario, String estado); 
	List<CuentaUsuario> mostrarDatosCreditCardUsuario (String usuario); 

	List<CuentaUsuario> mostrarCuentasUsuarioEstado(Usuario usuario, String estado);


}
