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
 * Me creo la clase Productos donde relaciono la tabla a la que hace referencia esta clase en la BBDD y 
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
@Table(name="PRODUCTOS")//es el nombre de la tabla a la que hace referencia en la BBDD
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_PRODUCTO")// es el nombre de la columna a la que hace referencia en la BBDD
	private int idProductos;
	private String nombre;
	private String descripcion;
	private String imagen;
	@Column(name="IMAGEN_DETALLE")// es el nombre de la columna a la que hace referencia en la BBDD
	private String imagenDetalle;
	private String estado;
	private String promocion;
	private double descuento;
	private String valoracion;
	@Column(name="CANTIDAD_MAXIMA")// es el nombre de la columna a la que hace referencia en la BBDD
	private int cantidadMaxima;
	@Column(name="PRECIO_UNITARIO")// es el nombre de la columna a la que hace referencia en la BBDD
	private double precioUnitario;
	@Column(name="TIPO_PRODUCTO")// es el nombre de la columna a la que hace referencia en la BBDD
	private String tipoProducto;
	@ManyToOne
	@JoinColumn(name="ID_CATEGORIA")// es el nombre de la columna a la que hace referencia en la BBDD
	private Categoria categoria;
	@ManyToOne
	@JoinColumn(name="ID_PROVEEDOR")// es el nombre de la columna a la que hace referencia en la BBDD
	private Proveedor proveedor;
	
}
