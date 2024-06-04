package unir.grupo6.pecoVerduras.modeloDao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import unir.grupo6.pecoVerduras.modeloEntity.Empresa;
import unir.grupo6.pecoVerduras.repository.EmpresaRepository;


/**
 * Clase que implementa la interface EmpresaDao para poder utilizar sus metodos
 * 
 * @author Maria Isabel
 *
 */
@Repository
public class EmpresaDaoImplMy8 implements EmpresaDao{

	
	/**
	 * Importamos la clase EmpresaRepository para poder utilizar los metodos de JPA
	 */
	@Autowired
	private EmpresaRepository empresaRepository;
	
	
	/**
	 * Metodo que usaremos para buscar una Empresa pasandole su id
	 * 
	 *  @author Maria Isabel
	 *  
	 */
	@Override
	public Empresa buscarUnaEmpresa(int idEmpresa) {
		
		return empresaRepository.findById(idEmpresa).orElse(null);
	}

	
	
	/**
	 * Metodo que utilizaremos para modificar una empresa pasandole
	 * todo el objeto
	 * 
	 *  @author Maria Isabel
	 *  
	 */
	@Override
	public Empresa modificarEmpresa(Empresa empresa) {
		try {
			if(buscarUnaEmpresa(empresa.getIdEmpresa()) != null) {//en caso de que no sea nulo procederemos a modificar la empresa
				return empresaRepository.save(empresa);
			}else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	/**
	 * Metodo que utilizaremos para agregar una empresa pasandole
	 * todo el objeto
	 * 
	 *  @author Maria Isabel
	 *  
	 */
	@Override
	public Empresa insertarEmpresa(Empresa empresa) {
		try {
			if(buscarUnaEmpresa(empresa.getIdEmpresa()) == null) {//en caso de que sea nulo procederemos agregar la empresa
				return empresaRepository.save(empresa);
						
			}else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	/**
	 * Metodo que usaremos para eliminar la empresa pasandole su id
	 * 
	 *  @author Maria Isabel
	 *  
	 */
	@Override
	public int eliminarEmpresa(int idEmpresa) {
		Empresa empresa = buscarUnaEmpresa(idEmpresa);
		
		if(empresa != null) {
			empresaRepository.delete(empresa);//se comprueba que la empresa no exista y procedemos a eliminarla
			return 1;
		}else {
			return 0;
		}
		
	}

	
	/**
	 * Metodo que usaremos para sacar una lista con todas las
	 * empresas
	 * 
	 *  @author Maria Isabel
	 *  
	 */
	@Override
	public List<Empresa> mostrarTodasEmpresas() {
		
		return empresaRepository.findAll();
	}

}
