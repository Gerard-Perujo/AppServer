package unir.grupo6.pecoVerduras.modeloDao;

import java.util.List;

import unir.grupo6.pecoVerduras.modeloEntity.Perfil;


/**
 *  Interface de Perfil donde tendremos nuestros metodos que utilizaremos para
 * sacar la informacion
 * 
 * @author Gerard Perujo
 *
 */
public interface PerfilDao {
	
	Perfil buscarUnPerfil(int idPerfil);
	Perfil modificarPerfil(Perfil perfil);
	Perfil insertarPerfil(Perfil perfil);
	int eliminarPerfil(int idPerfil);
	List<Perfil> mostrarTodosPerfil();

}
