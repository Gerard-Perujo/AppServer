package unir.grupo6.pecoVerduras.configuration;

import javax.sql.DataSource;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;
/**
 * Clase para controlar todos los filtros y permisos de acceso de los usuarios dependiendo
 * del perfil tendran acceso a diferentes puntos de acceso
 * 
 * @author Gerard Perujo
 *
 */
@EnableWebSecurity
@Configuration
public class DataUserConfiguration {

	@Bean
	public UserDetailsManager usersCustom(DataSource dataSource) {

	JdbcUserDetailsManager users = 	new JdbcUserDetailsManager(dataSource); 
	users.setUsersByUsernameQuery("select username,password,estado from Usuarios u where username=?"); 
	users.setAuthoritiesByUsernameQuery("select u.username,p.nombre from Usuario_Perfiles up " +
	 "inner join usuarios u on u.username = up.username " +
			"inner join perfiles p on p.id_perfil = up.id_perfil " +
			"where u.username = ?");

	return users;

	}  
	
	/**
	 * Bean donde vamos a controlar los accesos a las diferentes rutas de nuestra aplicación dando permisos a 
	 * los diferentes roles que tenemos
	 */
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http
		.csrf(csrf -> csrf.disable());
		// Los recursos estáticos no requieren autenticación es donde vamos a guardar todas las imagenes y el css
		//de la pagina
		http.authorizeHttpRequests(authorize -> authorize
			.requestMatchers("/static/**","/css/**", "/imagenes/**", "/Javascript/**", "/archivos/**").permitAll()
			// Las vistas públicas no requieren autenticación
			.requestMatchers("/signup","/","/login", "/logout", "/NormaEnvio", "/politica", "/terminos").permitAll()
			.requestMatchers("/contacto", "/quienesSomos", "/promociones").permitAll()

			.requestMatchers("/frutas","/verduras","/productos", "/error/**").permitAll()

			.requestMatchers("/tienda").permitAll()
			.requestMatchers("/productos/verUno/**").permitAll()

			// Todas las demás URLs de la Aplicación requieren autenticación
			// Asignar permisos a URLs por ROLES

			.requestMatchers("/carro/**", "/usuario/**", "/misDatosPersonales/**", "/misDatosPersonalesEditarMiPerfil/**", "/misPedidos/**","/pedido/**", "/cancelarDireccion/**").hasAnyAuthority("ROLE_CLIENTEVIP","ROLE_FAMILIA","ROLE_CLIENTE","ROLE_ADMINISTRADOR") 
			.requestMatchers("/misProductosFavoritos/**", "/misDirecciones/**", "/misDireccionesEditar/**", "/misMetodosDePago/**", "/hacerPremium/**", "/hacerVip/**").hasAnyAuthority("ROLE_CLIENTEVIP","ROLE_FAMILIA","ROLE_CLIENTE","ROLE_ADMINISTRADOR") 
			.requestMatchers("/misMetodosDePagoAdd/**","/pecoClub/**", "/misComentarios/**", "/tramitar/**", "/utilizarPuntos/**","/MisComentarioVacio/**").hasAnyAuthority("ROLE_CLIENTEVIP","ROLE_FAMILIA","ROLE_CLIENTE","ROLE_ADMINISTRADOR")

			.requestMatchers("/Cancelar/**", "/promocionar/**", "/agregar/**").hasAnyAuthority("ROLE_ADMINISTRADOR")
			.requestMatchers("/modificar/**", "/activar/**", "/gestion/**", "/Desactivar/**").hasAnyAuthority("ROLE_ADMINISTRADOR")
			
			.anyRequest().authenticated());
		// El formulario de Login no requiere autenticacion
		http.formLogin(form -> form.loginPage("/login")//esta es la ruta que nos mostrara nuestro formulario
								.defaultSuccessUrl("/cargarUsuario").permitAll())// esta es la ruta que procesara el login de nuestro formulario
		.logout(logout -> logout.logoutSuccessUrl("/cerrar").permitAll());//esta es la ruta que mostrara una vez cerremos la session
		return http.build();
	}
}