package unir.grupo6.pecoVerduras.modeloDao;

import java.util.List;

import unir.grupo6.pecoVerduras.modeloEntity.Empresa;


/**
 *  Interface de Empresa donde tendremos nuestros metodos que utilizaremos para
 * sacar la informacion
 * 
 * @author Maria Isabel
 *
 */
public interface EmpresaDao {
	
	Empresa buscarUnaEmpresa(int idEmpresa);
	Empresa modificarEmpresa(Empresa empresa);
	Empresa insertarEmpresa(Empresa empresa);
	int eliminarEmpresa(int idEmpresa);
	List<Empresa> mostrarTodasEmpresas();

}
