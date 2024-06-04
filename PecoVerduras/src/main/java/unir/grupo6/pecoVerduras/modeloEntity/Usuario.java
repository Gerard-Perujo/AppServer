package unir.grupo6.pecoVerduras.modeloEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;




/**
 * Me creo la clase Usuario donde relaciono la tabla a la que hace referencia esta clase en la BBDD y 
 * luego tambien relaciono cada variable con su columna de la tabla de la BBDD en caso de que 
 * el nombre en la BBDD fuera diferente que el de la variable.
 *
 * 
 * @author Gerard Perujo
 *
 */
@Entity
@Table(name="USUARIOS")//es el nombre de la tabla a la que hace referencia en la BBDD
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String username;
	private String password;
	private String nombre;
	@Column(name="PRIMER_APELLIDO")// es el nombre de la columna a la que hace referencia en la BBDD
	private String primerApellido;
	@Column(name="SEGUNDO_APELLIDO")// es el nombre de la columna a la que hace referencia en la BBDD
	private String segundoApellido;
	private String telefono;
	private String sexo;
	private String email;
	private String foto;
	private int estado;
	@Temporal(TemporalType.DATE)//anoto la fecha con el tipo temporal para poder recoger los datos de la BBDD
	@Column(name="FECHA_REGISTRO")// es el nombre de la columna a la que hace referencia en la BBDD
	private Date fechaRegistro;
	@Temporal(TemporalType.DATE)//anoto la fecha con el tipo temporal para poder recoger los datos de la BBDD
	@Column(name="FECHA_NACIMIENTO")// es el nombre de la columna a la que hace referencia en la BBDD
	private Date fechaNacimiento;
	@Column(name="MIS_PUNTOS")// es el nombre de la columna a la que hace referencia en la BBDD
	private Double misPuntos;
	@Column(name="ARCHIVO_FAMILIA")// es el nombre de la columna a la que hace referencia en la BBDD
	private String archivoFamilia;
	
	
	/**
	 * hago un join para relacionar el usuario con la tabla perfiles
	 * para que pueda acceder a su perfil
	 */
	@ManyToMany
	@JoinTable(
		name="USUARIO_PERFILES"
		, joinColumns={
			@JoinColumn (name="USERNAME")  
			}
		, inverseJoinColumns={
			@JoinColumn (name="ID_PERFIL")
		}
		)

	private List<Perfil> perfiles;

	public Usuario(){
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPrimerApellido() {
		return this.primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}
	
	public String getSegundoApellido() {
		return this.segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}
	
	
	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getFoto() {
		return this.foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	public String getArchivoFamilia() {
		return this.archivoFamilia;
	}

	public void setArchivoFamilia(String archivoFamilia) {
		this.archivoFamilia = archivoFamilia;
	}
	

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public double getMisPuntos() {
		return this.misPuntos;
	}

	public void setMisPuntos(double misPuntos) {
		this.misPuntos = misPuntos;
	}

	public int getEstado() {
		return this.estado;
	}

	public void setEstado(int enabled) {
		this.estado = enabled;
	}

	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	
	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Perfil> getPerfiles(){
	{
		
		
	}
		return this.perfiles;
	}

	public void setPerfiles(List<Perfil> perfiles) {
		this.perfiles = perfiles;
	}
	
	public void addPerfil(Perfil perfil) {
		if (perfiles == null)
			perfiles = new ArrayList<>();
		
		perfiles.add(perfil);
	}
	
	public void removePerfil(Perfil perfil) {
		if (perfiles == null)
			perfiles = new ArrayList<>();
		
		perfiles.remove(perfil);
	}
	
	public boolean obtenerPerfil(String nombrePerfil) {
		for(Perfil perfil : perfiles) {
			if(perfil.getNombre().equals(nombrePerfil)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(username, other.username);
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
