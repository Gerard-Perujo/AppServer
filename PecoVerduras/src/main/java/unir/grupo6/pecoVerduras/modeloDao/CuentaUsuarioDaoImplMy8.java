package unir.grupo6.pecoVerduras.modeloDao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import unir.grupo6.pecoVerduras.modeloEntity.CuentaUsuario;
import unir.grupo6.pecoVerduras.modeloEntity.Usuario;
import unir.grupo6.pecoVerduras.repository.CuentaUsuarioRepository;


/**
 * Clase que implementa la interface CuentaUsuarioDao para poder utilizar sus metodos
 * 
 * @author Noelia Villahermosa
 *
 */
@Repository
public class CuentaUsuarioDaoImplMy8 implements CuentaUsuarioDao{

	
	/**
	 * Importamos la clase CuentaUsuarioRepository para poder utilizar los metodos de JPA
	 */
	@Autowired
	private CuentaUsuarioRepository cuentaUsuarioRepository;
	
	
	@Override
	public CuentaUsuario buscarUnaCuenta(int idCuenta) {
		
		return cuentaUsuarioRepository.findById(idCuenta).orElse(null);
	}

	@Override
	public CuentaUsuario modificarCuenta(CuentaUsuario cuentaUsuario) {
		try {
			if(buscarUnaCuenta(cuentaUsuario.getIdCuenta()) != null) {
				return cuentaUsuarioRepository.save(cuentaUsuario);
			}else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public CuentaUsuario insertarCuenta(CuentaUsuario cuentaUsuario) {
		try {
			if(buscarUnaCuenta(cuentaUsuario.getIdCuenta()) == null) {
				return cuentaUsuarioRepository.save(cuentaUsuario);
			}else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int eliminarCuenta(int idCuenta) {
		CuentaUsuario cuenta = buscarUnaCuenta(idCuenta);
		
		if(cuenta != null) {
			cuentaUsuarioRepository.delete(cuenta);
			return 1;
		}else {
			return 0;
		}
		
	}

	@Override
	public List<CuentaUsuario> mostarTodasCuentas() {
		
		return cuentaUsuarioRepository.findAll();
	}

	
	@Override
	public List<CuentaUsuario> mostrarCreditCardCuentaUsuario(Usuario usuario, String estado) {
		String user = usuario.getUsername();
		return cuentaUsuarioRepository.findCreditCardCuentaUsuario(user, estado);

	}
	
	
	@Override	
	public List<CuentaUsuario> mostrarCuentasUsuarioEstado(Usuario usuario, String estado) {
		
		String user = usuario.getUsername();
		
		return cuentaUsuarioRepository.findCuentaPorUsuarioEstado(user, estado);

	}

	@Override
	public List<CuentaUsuario> mostrarDatosCreditCardUsuario(String usuario) {
		// TODO Auto-generated method stub
		return cuentaUsuarioRepository.findDatosCreditCardUsuario(usuario);
	}

}
