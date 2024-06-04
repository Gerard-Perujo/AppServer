package unir.grupo6.pecoVerduras.modeloDao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import unir.grupo6.pecoVerduras.modeloEntity.Perfil;
import unir.grupo6.pecoVerduras.repository.PerfilRepository;


/**
 * Clase que implementa la interface PerfilDao para poder utilizar sus metodos
 * 
 * @author Gerard Perujo
 *
 */
@Repository
public class PerfilDaoImplMy8 implements PerfilDao{
	
	
	/**
	 * Importamos la clase PerfilRepository para poder utilizar los metodos de JPA
	 */
	@Autowired
	private PerfilRepository perfilRepository;

	
	/**
	 * Metodo que usarems para sacar un perfil pasandole su id
	 * 
	 * @author Gerard Perujo
	 * 
	 */
	@Override
	public Perfil buscarUnPerfil(int idPerfil) {
		
		return perfilRepository.findById(idPerfil).orElse(null);
	}

	
	/**
	 * Metodo que usaremos para modificar un perfil pasandole
	 * el objeto entero
	 * 
	 * @author Gerard Perujo
	 * 
	 */
	@Override
	public Perfil modificarPerfil(Perfil perfil) {
		try {
			if(buscarUnPerfil(perfil.getIdPerfil()) != null) {//en caso de que no sea nulo procederemos a modificar el perfil
				return perfilRepository.save(perfil);
			}else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	/**
	 * Metodo que utilizaremos para agregar un perfil pasandole
	 * todo el objeto
	 * 
	 * @author Gerard Perujo
	 * 
	 */
	@Override
	public Perfil insertarPerfil(Perfil perfil) {
		try {
			if(buscarUnPerfil(perfil.getIdPerfil()) == null) {//en caso de que sea nulo procederemos agregar el perfil
				return perfilRepository.save(perfil);
			}else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	/**
	 * Metodo que utilizaremos para eliminar un perfil pasandole
	 * la id
	 * 
	 * @author Gerard Perujo
	 * 
	 */
	@Override
	public int eliminarPerfil(int idPerfil) {
		Perfil perfil = buscarUnPerfil(idPerfil);
		
		if(perfil != null) {//se comprueba que el perfil exista y procedemos a eliminarla
			perfilRepository.delete(perfil);
			return 1;
		}else {
			return 0;
		}
		
	}

	
	
	/**
	 * Metodo que utilizaremos para sacar una lista 
	 * de todos los perfiles
	 * 
	 * @author Gerard Perujo
	 * 
	 */
	@Override
	public List<Perfil> mostrarTodosPerfil() {
		
		return perfilRepository.findAll();
	}

}
