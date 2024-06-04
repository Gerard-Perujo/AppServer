package unir.grupo6.pecoVerduras.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import unir.grupo6.pecoVerduras.modeloEntity.CuentaEmpresa;


/**
 * Creo la clase CuentaEmporesaRepository que coge todos los metodos que tiene JPA
 * de esta manera esta clase se encargara de hacer todas las operaciones
 * necesarias con sus metodos propios
 * 
 * @author Gerard Perujo
 *
 */
public interface CuentaEmpresaRepository extends JpaRepository<CuentaEmpresa, Integer>{

}
