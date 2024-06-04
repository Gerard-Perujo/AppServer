package unir.grupo6.pecoVerduras.modeloDao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import unir.grupo6.pecoVerduras.modeloEntity.CuentaEmpresa;
import unir.grupo6.pecoVerduras.repository.CuentaEmpresaRepository;



/**
 * Clase que implementa la interface CuentaEmpresa para poder utilizar sus metodos
 * 
 * @author Gerard Perujo
 *
 */
@Repository
public class CuentaEmpresaImplMy8 implements CuentaEmpresaDao{
	
	
	/**
	 * Importamos la clase CuentaEmpresaRepository para poder utilizar los metodos de JPA
	 */
	@Autowired
	private CuentaEmpresaRepository cuentaEmpresaRepository;

	
	/**
	 * Metodo que utilizaremos para buscar una cuenta de la empresa segun su id
	 * 
	 * @author Gerard Perujo
	 * 
	 */
	@Override
	public CuentaEmpresa buscarUnaCuenta(int idCuenta) {
		return cuentaEmpresaRepository.findById(idCuenta).orElse(null);
	}

	
	/**
	 * Metodo que utilizaremos para modificar una cuenta de empresa pasandole
	 * todo el objeto
	 * 
	 * @author Gerard Perujo
	 */
	@Override
	public CuentaEmpresa modificarCuentaEmpresa(CuentaEmpresa cuentaEmpresa) {
		try {
			if(buscarUnaCuenta(cuentaEmpresa.getIdEmpresa()) != null) {//en caso de que no sea nulo procederemos a modificar la cuenta Empresa
				return cuentaEmpresaRepository.save(cuentaEmpresa);
			}else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	/**
	 * Metodo que utilizatemos para agregar una cuenta de empresa pasandole todo
	 * el objeto
	 * 
	 * @author Gerard Perujo
	 * 
	 */
	@Override
	public CuentaEmpresa insertarCuentaEmpresa(CuentaEmpresa cuentaEmpresa) {
		try {
			if(buscarUnaCuenta(cuentaEmpresa.getIdEmpresa()) == null) {//en caso de que sea nulo procederemos a modificar la cuenta Empresa
				return cuentaEmpresaRepository.save(cuentaEmpresa);
			}else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	/**
	 * Metodo que utilizaremos para eliminar la cuenta de la empresa pasando el id
	 * 
	 * @author Gerard Perujo
	 * 
	 */
	@Override
	public int eliminarCuentaEmpresa(int idCuenta) {
		CuentaEmpresa cuenta = buscarUnaCuenta(idCuenta);
		
		if(cuenta != null) {
			cuentaEmpresaRepository.delete(cuenta);//se comprueba que la cuentaEmpresa exista y procedemos a eliminarla
			return 1;
		}else {
			return 0;
		}
		
	}

	
	/**
	 * Metodo que utilizaremos para mostrar todas las cuentas de la empresa
	 * 
	 * @author Maria Isabel
	 * 
	 */
	@Override
	public List<CuentaEmpresa> mostrarTodoCuentaEmpresa() {

		return cuentaEmpresaRepository.findAll();
	}

}
