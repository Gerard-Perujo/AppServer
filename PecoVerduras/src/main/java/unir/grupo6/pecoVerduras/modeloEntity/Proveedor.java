package unir.grupo6.pecoVerduras.modeloEntity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Me creo la clase Proveedor donde relaciono la tabla a la que hace referencia esta clase en la BBDD y 
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
@Table(name="PROVEEDOR")//es el nombre de la tabla a la que hace referencia en la BBDD
public class Proveedor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_PROVEEDOR")// es el nombre de la columna a la que hace referencia en la BBDD
	private int idProveedor;
	private String nombre;
	private String poblacion;
	private String calle;
	private int numero;
	private int cp;
	private String email;
	private int telefono;
	@Temporal(TemporalType.DATE)//anoto la fecha con el tipo temporal para poder recoger los datos de la BBDD
	@Column(name="FECHA_ALTA")// es el nombre de la columna a la que hace referencia en la BBDD
	private Date fechaAlta;
	private String estado;
}
