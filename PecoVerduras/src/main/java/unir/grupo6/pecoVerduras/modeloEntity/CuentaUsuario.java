package unir.grupo6.pecoVerduras.modeloEntity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Me creo la clase Cuenta Usuario donde relaciono la tabla a la que hace referencia esta clase en la BBDD y 
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
@Table(name="CUENTA_USUARIO")//es el nombre de la tabla a la que hace referencia en la BBDD
public class CuentaUsuario {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_CUENTA")// es el nombre de la columna a la que hace referencia en la BBDD
	private int idCuenta;
	private String nombre;
	private String apellido;
	@Column(name="NUMERO_TARGETA")// es el nombre de la columna a la que hace referencia en la BBDD
	private String numeroTarjeta;
	@Temporal(TemporalType.DATE)//anoto la fecha con el tipo temporal para poder recoger los datos de la BBDD
	private Date caducidad;
	private String cvc;
	private double saldo;
	private String estado;
	@ManyToOne
	@JoinColumn(name="USERNAME")// es el nombre de la columna a la que hace referencia en la BBDD
	private Usuario usuario;
	
}
