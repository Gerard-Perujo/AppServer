package unir.grupo6.pecoVerduras.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import unir.grupo6.pecoVerduras.modeloEntity.Proveedor;



/**
 * Creo la clase ProveedorRepository que coge todos los metodos que tiene JPA
 * de esta manera esta clase se encargara de hacer todas las operaciones
 * necesarias con sus metodos propios
 * 
 * @author Gerard Perujo
 *
 */
public interface ProveedorRepository extends JpaRepository<Proveedor, Integer>{

}
