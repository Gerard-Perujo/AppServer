package unir.grupo6.pecoVerduras.modeloEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Me creo la clase Direccion donde relaciono la tabla a la que hace referencia esta clase en la BBDD y 
 * luego tambien relaciono cada variable con su columna de la tabla de la BBDD en caso de que 
 * el nombre en la BBDD fuera diferente que el de la variable.
 * para generar los constructores, getters, and setters utulizo el lombok 
 * 
 * @author Gerard Perujo
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="DIRECCION_USUARIO")//es el nombre de la tabla a la que hace referencia en la BBDD
public class Direccion {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_DIRECCION")// es el nombre de la columna a la que hace referencia en la BBDD
	private int idDireccion;
	private String calle;
	private String numero;
	private String piso;
	private String puerta;
	private String poblacion;
	private String provincia;
	private String pais;
	private String vivienda;
	private String estado;
	@ManyToOne
	@JoinColumn(name="USERNAME")// es el nombre de la columna a la que hace referencia en la BBDD
	private Usuario usuario;

}
