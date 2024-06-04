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
 * Me creo la clase Pedidos donde relaciono la tabla a la que hace referencia esta clase en la BBDD y 
 * luego tambien relaciono cada variable con su columna de la tabla de la BBDD en caso de que 
 * el nombre en la BBDD fuera diferente que el de la variable.
 * para generar los constructores, getters, and setters utulizo el lombok 
 * 
 * @author Gerard Perujo
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="PEDIDOS")//es el nombre de la tabla a la que hace referencia en la BBDD
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_PEDIDO")// es el nombre de la columna a la que hace referencia en la BBDD
	private int idPedido;
	@Temporal(TemporalType.DATE)//anoto la fecha con el tipo temporal para poder recoger los datos de la BBDD
	@Column(name="FECHA_PEDIDO")// es el nombre de la columna a la que hace referencia en la BBDD
	private Date fechaPedido;
	private double total;
	private String estado;
	@Column(name="PUNTOS_CONSEGIDOS")// es el nombre de la columna a la que hace referencia en la BBDD
	private Double puntosConsegidos;
	@ManyToOne
	@JoinColumn(name="ID_EMPRESA")// es el nombre de la columna a la que hace referencia en la BBDD
	private Empresa empresa;
	@ManyToOne
	@JoinColumn(name="USERNAME")// es el nombre de la columna a la que hace referencia en la BBDD
	private Usuario usuario;
}
