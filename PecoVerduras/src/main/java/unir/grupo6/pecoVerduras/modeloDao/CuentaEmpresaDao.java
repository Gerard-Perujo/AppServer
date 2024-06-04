package unir.grupo6.pecoVerduras.modeloDao;

import java.util.List;

import unir.grupo6.pecoVerduras.modeloEntity.CuentaEmpresa;



/**
 *  Interface de CuentaEmpresa donde tendremos nuestros metodos que utilizaremos para
 * sacar la informacion
 * 
 * @author Gerard Perujo
 *
 */
public interface CuentaEmpresaDao {
	
	CuentaEmpresa buscarUnaCuenta(int idCuenta);
	CuentaEmpresa modificarCuentaEmpresa(CuentaEmpresa cuentaEmpresa);
	CuentaEmpresa insertarCuentaEmpresa(CuentaEmpresa cuentaEmpresa);
	int eliminarCuentaEmpresa(int idCuenta);
	List<CuentaEmpresa> mostrarTodoCuentaEmpresa();

}
