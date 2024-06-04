package unir.grupo6.pecoVerduras.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import unir.grupo6.pecoVerduras.modeloEntity.Categoria;


/**
 * Creo la clase Categoriarepository que coge todos los metodos que tiene JPA
 * de esta manera esta clase se encargara de hacer todas las operaciones
 * necesarias con sus metodos propios
 * 
 * @author Gerard Perujo
 *
 */
public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{

}
