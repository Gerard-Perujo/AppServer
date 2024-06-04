package unir.grupo6.pecoVerduras.controller;




import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import unir.grupo6.pecoVerduras.modeloDao.CategoriaDao;
import unir.grupo6.pecoVerduras.modeloDao.ComentarioDao;
import unir.grupo6.pecoVerduras.modeloDao.CuentaEmpresaDao;
import unir.grupo6.pecoVerduras.modeloDao.CuentaUsuarioDao;
import unir.grupo6.pecoVerduras.modeloDao.DireccionDao;
import unir.grupo6.pecoVerduras.modeloDao.EmpresaDao;
import unir.grupo6.pecoVerduras.modeloDao.PedidoDao;
import unir.grupo6.pecoVerduras.modeloDao.PerfilDao;
import unir.grupo6.pecoVerduras.modeloDao.ProductoDao;
import unir.grupo6.pecoVerduras.modeloDao.ProductoPedidoDao;
import unir.grupo6.pecoVerduras.modeloDao.ProveedorDao;
import unir.grupo6.pecoVerduras.modeloDao.UsuarioDao;
import unir.grupo6.pecoVerduras.modeloEntity.Categoria;
import unir.grupo6.pecoVerduras.modeloEntity.Comentario;
import unir.grupo6.pecoVerduras.modeloEntity.CuentaEmpresa;
import unir.grupo6.pecoVerduras.modeloEntity.CuentaUsuario;
import unir.grupo6.pecoVerduras.modeloEntity.Direccion;
import unir.grupo6.pecoVerduras.modeloEntity.Empresa;
import unir.grupo6.pecoVerduras.modeloEntity.Pedido;
import unir.grupo6.pecoVerduras.modeloEntity.Perfil;
import unir.grupo6.pecoVerduras.modeloEntity.Producto;
import unir.grupo6.pecoVerduras.modeloEntity.ProductoPedido;
import unir.grupo6.pecoVerduras.modeloEntity.Usuario;



/**
 * Controlador que nos llevara toda la gestion de nuestras paginas iniciales, neutras, y tramites de nuestra 
 * aplicación web
 * 
 * @author Gerard Perujo
 */
@Controller
public class HomeController {
	
	 
	/**
	* Importamos la clase EmpresaDao para poder acceder a todos los metodos que tiene
	*/
	@Autowired
	private EmpresaDao empresaDao;
	
	
	/**
	* Importamos la clase UsuarioDao para poder acceder a todos los metodos que tiene
	*/
	@Autowired
	private UsuarioDao usudao;
	
	
	/**
	* Importamos la clase PerfilDao para poder acceder a todos los metodos que tiene
	*/
	@Autowired
	private PerfilDao perfidao;
	
	
	/**
	* Importamos la clase ProductoDao para poder acceder a todos los metodos que tiene
	*/
	@Autowired
	private ProductoDao produdao;
	
	
	/**
	* Importamos la clase CoemtarioDao para poder acceder a todos los metodos que tiene
	*/
	@Autowired
	private ComentarioDao comendao;
	
	
	/**
	* Importamos la clase PedidoDao para poder acceder a todos los metodos que tiene
	*/
	@Autowired
	private PedidoDao pedidao;
	
	
	/**
	* Importamos la clase DireccionDao para poder acceder a todos los metodos que tiene
	*/
	@Autowired
	private DireccionDao direcdao;
	
	
	/**
	* Importamos la clase CuentaUsuarioDao para poder acceder a todos los metodos que tiene
	*/
	@Autowired
	private CuentaUsuarioDao cuenUsudao;
	
	
	/**
	* Importamos la clase CuentaEmpresaDao para poder acceder a todos los metodos que tiene
	* 
	*/
	@Autowired
	private CuentaEmpresaDao cuenEmprdao;
	
	
	/**
	* Importamos la clase ProductoPedidoDao para poder acceder a todos los metodos que tiene
	*/
	@Autowired
	private ProductoPedidoDao produPedidao;
	
	
	/**
	* Importamos la clase CategoriaDao para poder acceder a todos los metodos que tiene
	*/
	@Autowired
	private CategoriaDao catedao;
	
	
	/**
	* Importamos la clase ProveedorDao para poder acceder a todos los metodos que tiene
	*/
	@Autowired
	private ProveedorDao provedao;
	

	
	
	/**
	 * Metodo que utilizamos para cargar nuestra pagina Home o index
	 * 
	 * @author Gerard Perujo
	 * 
	 * @param model parametro que utilizamos para agregar atributos o sacar mensajes en las vistas
	 * 
	 * @param aut parametro de authentication donde se guardan todos los parametros de autentificacion del usuario
	 * 
	 * @return nos deuvelve la vista Index que es nuestra pagina home
	 */
	@GetMapping("/")
	public String mostrarHome(Model model, Authentication aut) {
		
		Empresa emprea = empresaDao.buscarUnaEmpresa(1);//busco la empresa en la BBDD para sacar todos los datos de la empresa
		model.addAttribute("empresa", emprea);//agrego la empresa en un atributo para poder mostrar los datos en la vista
		
		List<Comentario> comen = comendao.mostrarTodosComentario();//busco todos los comentarios que hay en la BBDD para mostrarlos
		model.addAttribute("comentario", comen);// agrego los comentarios en un atributo para poder mostrarlos en la vista
		
		return "Index";
	}
	
	/**
	 * Metodo que utilizamos para cargar nuestra pagina Normas de envio
	 * 
	 * @author Gerard Perujo
	 * 
	 * @param model parametro que utilizamos para agregar atributos o sacar mensajes en las vistas
	 * 
	 * @param session parametro que utilizamos para recoger el usuario que esta en session
	 * 
	 * @return  nos va devolver la vista normas de envio
	 */
	@GetMapping("/NormaEnvio")
	public String mostrarNormaEnvio(Model model, HttpSession session) {
		
		Empresa emprea = empresaDao.buscarUnaEmpresa(1);//busco la empresa en la BBDD para sacar todos los datos de la empresa
		model.addAttribute("empresa", emprea);//agrego la empresa en un atributo para poder mostrar los datos en la vista
		
		return "NormasEnvio";
	}
	
	
	/**
	 * Metodo que utilizaremos para cargar nuestra pagina de politica
	 * 
	 * @author Gerard Perujo
	 * 
	 * @param model parametro que utilizamos para recoger el usuario que esta en session
	 * 
	 * @return nos va devolver la vista privacidad
	 */
	@GetMapping("/politica")
	public String mostrarPoliticaPrivacidad(Model model) {
		
		Empresa emprea = empresaDao.buscarUnaEmpresa(1);//busco la empresa en la BBDD para sacar todos los datos de la empresa
		model.addAttribute("empresa", emprea);//agrego la empresa en un atributo para poder mostrar los datos en la vista
		
		return "Privacidad";
	}
	
	
	/**
	 * Metodo que utilizaremos para cargar nuestra pagina de terminos
	 * 
	 * @author Gerard Perujo
	 * 
	 * @param model parametro que utilizamos para recoger el usuario que esta en session
	 * 
	 * @return nos va a devolver la vista de terminoscondiciones
	 */
	@GetMapping("/terminos")
	public String mostrarTerminosCondiciones(Model model) {
		
		Empresa emprea = empresaDao.buscarUnaEmpresa(1);//busco la empresa en la BBDD para sacar todos los datos de la empresa
		model.addAttribute("empresa", emprea);//agrego la empresa en un atributo para poder mostrar los datos en la vista
		
		return "TerminosCondiciones";
	}
	
	
	/**
	 * Metodo que utilizaremos para mostrar la vista contacto
	 * 
	 * @author Gerard Perujo
	 * 
	 * @param model parametro que utilizamos para recoger el usuario que esta en session
	 * 
	 * @return nos va devolver la vista Contacto
	 */
	@GetMapping("/contacto")
	public String mostrarContacto(Model model) {
		
		Empresa emprea = empresaDao.buscarUnaEmpresa(1);//busco la empresa en la BBDD para sacar todos los datos de la empresa
		model.addAttribute("empresa", emprea);//agrego la empresa en un atributo para poder mostrar los datos en la vista
		
		return "Contacto";
	}
	
	
	/**
	 * Metodo que utilizaremos para recoger los datos de nuestro formulario de contacto, este metodo
	 * no esta terminado falta imprementar la recogida de datos y envio de datos al mail de la empresa
	 * 
	 * @author Gerard Perujo
	 *  
	 * @param model parametro que utilizamos para recoger el usuario que esta en session
	 * 
	 * @return nos devuelve la vista mensaje
	 */
	@PostMapping("/contacto")
	public String contactoEnviado (Model model) {
		
		Empresa emprea = empresaDao.buscarUnaEmpresa(1);//busco la empresa en la BBDD para sacar todos los datos de la empresa
		model.addAttribute("empresa", emprea);//agrego la empresa en un atributo para poder mostrar los datos en la vista
		
		return "Mensaje";
	}
	
	
	/**
	 * Metodo que utilizaremos para cargar la vista quienes somos
	 * 
	 * @author Gerard Perujo
	 * 
	 * @param model parametro que utilizamos para recoger el usuario que esta en session
	 * 
	 * @return nos devuelve la pagina de quienes somos
	 */
	@GetMapping("/quienesSomos")
	public String mostrarQuienesSomos(Model model) {
		
		Empresa emprea = empresaDao.buscarUnaEmpresa(1);//busco la empresa en la BBDD para sacar todos los datos de la empresa
		model.addAttribute("empresa", emprea);//agrego la empresa en un atributo para poder mostrar los datos en la vista
		
		return "Nosotros";
	}
	
	
	/**
	 * Metodo que utilizaremos para cargar la vista de login
	 * 
	 * @author Gerard Perujo
	 * 
	 * @return nos va devolver la vista login con un formulario para poder entrar si eres usuario registrado
	 */
	@GetMapping("/login")
		public String mostrarLogin() {
		
			return "Login";
		}
	
	
	/**
	 * Metodo que utilizaremos para comprovar los datos del usuario por si esta registrado en la 
	 * aplicacion o no
	 * 
	 * @author Gerard Perujo
	 * 
	 * @param aut parametro del authentication que usaremos para comprobar el usuario con la BBDD
	 * 
	 * @param model parametro que utilizamos para recoger el usuario que esta en session
	 * 
	 * @param session parametro para poder agregar un atributo en session y poder acceder a el mientras la
	 * session este abierta
	 * 
	 * @return en caso de que estas registrado nos va a devolver a la pagina home, si no estas registrado
	 * nos va a devolver un mensaje de error
	 */
	@GetMapping("/cargarUsuario")
	public String procesarLogin(Authentication aut, Model model, HttpSession session) {
		
		Usuario usuario = usudao.buscarUnUsuario(aut.getName());//compruebo si el usuario esta registrado recogiendo el nombre y comprobando en la BBDD
		session.setAttribute("usuario", usuario);//agrego el usuario que se ha encontrado en un atributo session
		
		Date data = new Date();
		
		/*
		 * cuando se inicia session creo un pedido nuevo en el cual ira agregado los producto que 
		 * el usuario quiera comprar
		 */
		Pedido pedi = new Pedido();//creo un pedido nuevo
		pedi.setEmpresa(empresaDao.buscarUnaEmpresa(1));//busco la empresa en la BBDD y la agrego en el pedido
		pedi.setEstado("a");//pongo es estado Activo en el pedido
		pedi.setFechaPedido(data);//le paso la fecha del dia que se crea el pedido
		pedi.setTotal(0.00);//le pongo el total del pedido a 0
		pedi.setUsuario(usuario);//le agrego el usuario que se ha logeado al pedido
		
		pedidao.insertarPedido(pedi);//inserto el pedido que se ha creado a la BBDD

	
		return "forward:/";
	}
	
	
	/**
	 * Metodo que usaremos para mostrar la pagina de registro
	 * 
	 * @author Gerard Perujo
	 * 
	 * @return nos devuelve a la vista de registro
	 */
	@GetMapping("/signup")
	public String mostrarRegistro() {
		
		return "Registro";
	}
	
	
	
	/**
	 * Metodo que nos va a recoger los datos que enviamos desde la pagina registro para agregarlo en la 
	 * BBDD
	 * 
	 * @author Gerard Perujo
	 * 
	 * @param usuario estan los datos del usuario que nos envian desde la pagina registro
	 * 
	 * @param ratt parametro que utilizamos para recoger el usuario que esta en session
	 * 
	 * @return si el registro ha sido exitoso nos va a devolver a la vista login en caso de que no lo
	 * sea nos va ha devolver a la vista registro para que volvamos a realizar el registro
	 */
	@PostMapping("/signup")
	public String hacerRegistro(Usuario usuario, RedirectAttributes ratt) {
		
		Date fecha = new Date();//creo una fecha
		
		int enabled = 1;//pongo un 1 que indica que el usuario esta activado
		Perfil perfil = new Perfil();//creo un perfil
		perfil = perfidao.buscarUnPerfil(2);//busco el perfil 2 que es role_cliente
		usuario.setEstado(enabled);//agrego el estado al usuario
		usuario.setMisPuntos(0.00);//agrego los puntos que tiene el usuario 0
		usuario.setFechaRegistro(fecha);//agrego la fecha de creacion del usuario
		String pass = usuario.getPassword();//agrego la password que nos envian desde el formulario registro
		usuario.setPassword("{noop}"+pass);//agrego el noop delante de la password porque no esta encryptada
		usuario.addPerfil(perfil);//agrego el perfil al usuario
		
		/**
		 * hago una comprovacion en caso de que el usuario sea nulo agregaremos el usuario
		 * si existe devolveremos un mensaje diciendo que el usuario ya existe
		 */
		if(usudao.insertarUsuario(usuario) != null) {
			return "redirect:/login";
		}else {
			ratt.addFlashAttribute("mensaje", "Usuario Introducido ya existe");
			return "redirect:/signup";
		}
	}
	
	
	
	/**
	 * Metodo que usaremos para cerrar la session del usuario
	 * 
	 * @author Gerard Perujo
	 * 
	 * @param session parametro para poder agregar un atributo en session y poder acceder a el mientras la
	 * session este abierta
	 * 
	 * @param model parametro que utilizamos para recoger el usuario que esta en session
	 * 
	 * @return una vez cerrada la session nos va a devolver a la vista del home o index
	 */
	@GetMapping("/cerrar")
	public String cerrarSession(HttpSession session, Model model) {
		
		Usuario user = (Usuario) session.getAttribute("usuario");//recogo el usuario que esta dentro del atributo session
		Pedido pedio = pedidao.buscarPedidoPorUsuarioEstado(user, "a");// busco el pedido que esta activo del usuario
		
		List<ProductoPedido> prodpedi = produPedidao.mostrarProductosPorPedido(pedio);//recogo todos los productos que tiene ese pedido
		
		/*
		 * si el pedido es diferente a nulo realizo los cambios al pedido
		 */
		if(pedio != null) {
			//recorro todos los productos que tiene ese pedido
			for(ProductoPedido producto : prodpedi) {
				int cantidad = producto.getCantidad();//recogo la cantidad de elementos que ha agregado al carro del ese producto
				Producto prod = producto.getProducto();//recogo el objeto producto 
				int cantTienda = prod.getCantidadMaxima();//recogo la cantidad de elementos que tiene la tienda de ese producto
				int cantTotal = cantTienda + cantidad;//le sumo la cantidad de elementos que tenia en la cesta a la cantidad de la tienda
				prod.setCantidadMaxima(cantTotal);//agrego esa cantidad al producto
				produdao.modificarProducto(prod);//modifico el producto con la nueva cantidad en tienda
				produPedidao.eliminarProductosPorPedido(pedio);//elimino el producto del carro porque significa que el cliente se va sin comprar nada
				
			}
			pedidao.eliminarPedido(pedio.getIdPedido());//elimino el pedido porque no se ha comprado nada
		}
		

		
		session.removeAttribute("usuario");//remuevo el usuario de la session
		session.invalidate();
		model.addAttribute("mensajelogout", "La Session se ha Cerrado Correctamente");
		
		return "forward:/";
	}
	
	
	/**
	 * Metodo que usaremos para cargar la pagina promociones
	 * 
	 * @author Gerard Perujo
	 * 
	 * @param model parametro que utilizamos para recoger el usuario que esta en session
	 * 
	 * @param tipoCategoria parametro que recogemos del filtro para poder filtrar nuestros productos
	 * 
	 * @return nos va a devolver la vista promociones con todas las promociones que tenemos en nuestra aplicacion
	 * web
	 */
	@GetMapping("/promociones")
	public String mostrarPromociones(Model model, @RequestParam(name = "tipo", required = false)String tipoCategoria){
		
		
		Categoria categoria = new Categoria();
		/**
		 * en caso de que la categoria sea nula la ponemos en blanco
		 */
		if(tipoCategoria == null) {
			tipoCategoria = " ";//pongo la categoria en blanco
			categoria.setNombre(tipoCategoria);//agrego la categoria en el nombre de la categoria
		}else {
			categoria.setNombre(tipoCategoria);//agrego el nombre de la categoria que nos pasan por parametro
		}
		
		
		/**
		 * si el nombre de la categoria es blanco mostraremos todas las promociones que esten activas sino
		 * mostraremos las promociones por nombre que nos han pasado por parametro
		 */
		if(categoria.getNombre() == " ") {
			List<Producto> promocion = produdao.mostrarPromocionesPorEstadp("s", "a");//busco todas las promociones que esten activas
			model.addAttribute("producto", promocion);//agrego las promociones a un atributo para mostrarlas en la vista
		}else {
			List<Producto> promocion = produdao.mostrarProductoPorCategoriaEstado(categoria, "a" , "s");//busco todas las promociones que esten activas y con el parametro que nos pasan
			model.addAttribute("producto", promocion);//agrego las promociones a un atributo para mostrarlas en la vista
		}
		
		
		
		Empresa emprea = empresaDao.buscarUnaEmpresa(1);//busco la empresa en la BBDD para sacar todos los datos de la empresa
		model.addAttribute("empresa", emprea);//agrego la empresa en un atributo para poder mostrar los datos en la vista
	
	
		return "Promociones";
	}
	
	
	/**
	 * Metodo que usaremos para Cancelar una promocion
	 * 
	 * @author Gerard Perujo
	 * 
	 * @param idProducto parametro que nos entra con la id del producto
	 * 
	 * @param model parametro que utilizamos para recoger el usuario que esta en session
	 * 
	 * @return quita el estado promocion del producto y nos devuelve a la pagina de 
	 * gestion de productos
	 */
	@GetMapping("/Cancelar/Promocion/{id}")
	public String cancelarPromocion(@PathVariable("id") int idProducto, Model model) {
		
		Producto promocion = produdao.buscarUnProducto(idProducto);//busco el producto pasando la id que nos entra por parametros
		
		/*
		 * en caso de que el prducto no sea nulo
		 * procedo a modificar el estado del producto
		 */
		if(promocion != null) {
			promocion.setPromocion("n");//pongo el estado pormocion a No
			promocion.setDescuento(0.0);//pongo el precio del descuento en 0
			produdao.modificarProducto(promocion);//modifico el producto 
			
			model.addAttribute("mensaje", "El producto ya no es una promocion");
		}else {
			model.addAttribute("mensajeError", "No se ha podido cancelar la promocion");
		}
		
		
		return "forward:/gestion/producto";
	}
	
	
	/**
	 * Metodo que nos mostrara la pagina de tramitar
	 * 
	 * @author Gerard Perujo
	 * 
	 * @param idPedido id del pedido que nos entra por parametros
	 * 
	 * @param session parametro para poder agregar un atributo en session y poder acceder a el mientras la
	 * session este abierta
	 * 
	 * @param model parametro que utilizamos para recoger el usuario que esta en session
	 * 
	 * @return nos devuelve la vista tramitar compra con toda la informacion de nuestro pedido
	 */
	@GetMapping("/tramitar/{id}")
	public String finalizarPedido(@PathVariable("id") int idPedido, HttpSession session, Model model) {
		
		
		Usuario user = (Usuario) session.getAttribute("usuario");//recogo el usuario que tenemos en session
	
		Pedido pedio = pedidao.buscarUnPedido(idPedido);//busco el pedido con la id que nos entra por parametros		
		
		List<Direccion> direc = direcdao.mostrarDireccionUsuario(user,"a");//saco una lista de todas las direcciones que estan activas del usuario
		
		/**
		 * recorro los campos de todas las direcciones para 
		 * comprovar los campos nulos y que no me de error la vista
		 */
		for(Direccion direccion : direc) {
			if(direccion.getCalle() == null) {//en caso de que sea nulo le agrego un campo
				direccion.setCalle("no calle");
				
				direcdao.modificarDireccion(direccion);//modifico la direccion
			}
			if(direccion.getNumero() == null) {//en caso de que sea nulo le agrego un campo
				direccion.setNumero("No Numero");
				
				direcdao.modificarDireccion(direccion);//modifico la direccion
			}
			if(direccion.getPiso() == null) {//en caso de que sea nulo le agrego un campo
				direccion.setPiso("No piso");
				
				direcdao.modificarDireccion(direccion);//modifico la direccion
			}
			
			if(direccion.getPuerta() == null) {//en caso de que sea nulo le agrego un campo
				direccion.setPuerta("No puerta");
				
				direcdao.modificarDireccion(direccion);//modifico la direccion
			}
		}
		
		model.addAttribute("direccion", direc);//agrego las direcciones en un atributo para mostrarlas en la vista
		
		
		
		Empresa emprea = empresaDao.buscarUnaEmpresa(1);//busco la empresa en la BBDD para sacar todos los datos de la empresa
		model.addAttribute("empresa", emprea);//agrego la empresa en un atributo para poder mostrar los datos en la vista
		
		List<CuentaUsuario> cuentusu = cuenUsudao.mostrarCuentasUsuarioEstado(user, "a");//busco todas las cuentas que tiene el usuario que esten activas
		
		
		/**
		 * recorro los campos de todas las direcciones para 
		 * comprovar los campos nulos y que no me de error la vista
		 */
		for(CuentaUsuario cue : cuentusu) {
			if(cue.getNumeroTarjeta() == null) {//en caso de que sea nulo le agrego un campo
				cue.setNumeroTarjeta("no hay tarjeta");
				cuenUsudao.modificarCuenta(cue);//modifico la cuenta
			}
		}
		
		model.addAttribute("cuentas", cuentusu);//agrego las cuentas en un atributo para mostrarlas en la vista
		
		
		List<ProductoPedido> lista = produPedidao.mostrarProductosPorPedido(pedio);//busco todos los productos que tiene el pedido
		model.addAttribute("productos", lista);//agrego los productos en un atributo para mostrarlo en la vista
		
		Double total = 0.00;//creo un atributo total
		Double suma = 0.00;//creo un atributo suma
		
		/**
		 * recorro todos los productos del pedido para sumar todos los importes
		 */
		for(ProductoPedido prod : lista) {
			suma += prod.getPrecioProducto();
		}
		
		
		
		String rol = " ";//creo el atributo rol
		
		Authentication aut = SecurityContextHolder.getContext().getAuthentication();
		
		/**
		 * recorro el authentication para coger los roles
		 */
		for(GrantedAuthority roles : aut.getAuthorities()) {
			 rol = roles.getAuthority();
		}
		
			/**
			 * en caso dde que el usuario sea cliente y la suma de todos los productos sea
			 * inferior a 59.90 se le sumara 6.90 de gastos de envio
			 * si es superior no se le sumaran los gastos de envio
			 */
			if(rol.equals("ROLE_CLIENTE")){
				if(suma <= 59.90) {
					total = suma + 6.90;
					total = Math.round(total * 100.0) / 100.0;
					pedio.setTotal(total);
				}else {
					total = suma;
					total = Math.round(total * 100.0) / 100.0;
					pedio.setTotal(total);
				}
			}
			
			/**
			 * en caso de que el usuario sea rol familia no tiene gastos de envio
			 * y se le aplicara un descuento del 30% al total de la compra
			 */
			if(rol.equals("ROLE_FAMILIA")) {
				total = suma-(suma*0.3);
				total = Math.round(total * 100.0) / 100.0;
				pedio.setTotal(total);
			}
			
			/**
			 * en caso de que el usuario sea administrador no tendra gastos de envio
			 */
			if(rol.equals("ROLE_ADMINISTRADOR")) {
				total = suma;
				total = Math.round(total * 100.0) / 100.0;
				pedio.setTotal(total);
			}
			
			
			/**
			 * en caso de que el usuario sea administrador no tendra gastos de envio
			 */
			if(rol.equals("ROLE_CLIENTEVIP")) {
				total = suma;
				total = Math.round(total * 100.0) / 100.0;
				pedio.setTotal(total);
			}
	
		
		model.addAttribute("pedido", pedio);//agrego el pedido en un atributo para mostrarlo en la vista
		
		
		return "TramitarCompra";
	}
	
	
	
	
	/**
	 * Metodo que utilizaremos al utilizar los puntos que tiene acumuado el usuario al realizar
	 * compras que se van a descontar en el total del pedido
	 * 
	 *  @author Gerard Perujo
	 *  
	 * @param idPedido id del producto que nos entra por parametro
	 * 
	 * @param model parametro que utilizamos para recoger el usuario que esta en session
	 * 
	 * @param session parametro para poder agregar un atributo en session y poder acceder a el mientras la
	 * session este abierta
	 * 
	 * @return una vez realizada la operacion de los puntos nos devueve a la vista tramitar compra
	 */
	@GetMapping("/utilizarPuntos/{id}")
	public String tramitarPedidoConPuntos(@PathVariable("id") int idPedido, Model model, HttpSession session) {
		
		Usuario user = (Usuario) session.getAttribute("usuario");//cogo el usuario que esta dentro del atributo session
		
		Pedido pedio = pedidao.buscarUnPedido(idPedido);//busco el pedido con la id que nos entra por parametro
		
		
		List<Direccion> direc = direcdao.mostrarDireccionUsuario(user,"a");//busco todas las direcciones que tiene el usuario y que esten activas
		
		
		/**
		 * recorro los campos de todas las direcciones para 
		 * comprovar los campos nulos y que no me de error la vista
		 */
		for(Direccion direccion : direc) {
			if(direccion.getCalle() == null) {//en caso de que sea nulo le agrego un campo
				direccion.setCalle("no calle");
				
				direcdao.modificarDireccion(direccion);//modifico la direccion
			}
			if(direccion.getNumero() == null) {//en caso de que sea nulo le agrego un campo
				direccion.setNumero("No Numero");
				
				direcdao.modificarDireccion(direccion);//modifico la direccion
			}
			if(direccion.getPiso() == null) {//en caso de que sea nulo le agrego un campo
				direccion.setPiso("No piso");
				
				direcdao.modificarDireccion(direccion);//modifico la direccion
			}
			
			if(direccion.getPuerta() == null) {//en caso de que sea nulo le agrego un campo
				direccion.setPuerta("No puerta");
				
				direcdao.modificarDireccion(direccion);//modifico la direccion
			}
		}
		
		model.addAttribute("direccion", direc);//agrego las direcciones en un atributo para mostrarlo en las vistas
		
		
		
		Empresa emprea = empresaDao.buscarUnaEmpresa(1);//busco la empresa en la BBDD para sacar todos los datos de la empresa
		model.addAttribute("empresa", emprea);//agrego la empresa en un atributo para poder mostrar los datos en la vista
		
		List<CuentaUsuario> cuentusu = cuenUsudao.mostrarCuentasUsuarioEstado(user, "a");//busco todas las cuentas del usuario que esten activas
		
		
		/**
		 * recorro los campos de todas las direcciones para 
		 * comprovar los campos nulos y que no me de error la vista
		 */
		for(CuentaUsuario cue : cuentusu) {
			if(cue.getNumeroTarjeta() == null) {//en caso de que sea nulo le agrego un campo
				cue.setNumeroTarjeta("no hay tarjeta");
				cuenUsudao.modificarCuenta(cue);//modifico la direccion
			}
		}
		
		model.addAttribute("cuentas", cuentusu);//agrego las direcciones en un atributo para mostrarlo en las vistas
		
		
		List<ProductoPedido> lista = produPedidao.mostrarProductosPorPedido(pedio);//busco todos los productos que tiene el pedido
		model.addAttribute("productos", lista);//agrego los productos en un atributo para mostrarlo en la vista
		
		Double total = 0.00;// creo un atributo total
		Double suma = 0.00;//creo un atributo suma
		
		
		/**
		 * recorro todos los productos del pedido para sumar todos los importes
		 */
		for(ProductoPedido prod : lista) {
			suma += prod.getPrecioProducto();
		}
		
		String rol = " ";//creo el atributo rol
		
		
		Authentication aut = SecurityContextHolder.getContext().getAuthentication();
		
		
		/**
		 * recorro el authentication para coger los roles
		 */
		for(GrantedAuthority roles : aut.getAuthorities()) {
			 rol = roles.getAuthority();
		}
		
		Double puntos = user.getMisPuntos();//recogo los puntos que tiene el usuario
		
		/**
		 * en caso dde que el usuario sea cliente, los puntos sea superior a 0
		 * se realiazara la suma de los pedidos utilizando los puntos que tenga acumulados
		 * la suma de todos los productos sea
		 * inferior a 59.90 se le sumara 6.90 de gastos de envio
		 * si es superior no se le sumaran los gastos de envio
		 */
			if(rol.equals("ROLE_CLIENTE")){
				if(puntos > 0.00) {
					if(suma <= 59.90) {
						total = (suma + 6.90)-(puntos*0.01);//multiplico los puntos por 0.01 para convertirlos en importe
						total = Math.round(total * 100.0) / 100.0;
						user.setMisPuntos(0.00);//pongo el contador de los puntos a 0 una vez utilizados
						usudao.modificarUsuario(user);
						pedio.setTotal(total);
					}else {
						total = suma-(puntos*0.01);//multiplico los puntos por 0.01 para convertirlos en importe
						total = Math.round(total * 100.0) / 100.0;
						user.setMisPuntos(0.00);//pongo el contador de los puntos a 0 una vez utilizados
						usudao.modificarUsuario(user);
						pedio.setTotal(total);
					}
				}else {//si los puntos no son superior a 0 hace la suma sin los puntos
					if(suma <= 59.90) {
						total = suma + 6.90;
						total = Math.round(total * 100.0) / 100.0;
						pedio.setTotal(total);
					}else {
						total = suma;
						total = Math.round(total * 100.0) / 100.0;
						pedio.setTotal(total);
					}
				}
				
			}
			
			
			/**
			 * en caso de que el usuario sea rol familia y los puntos sean superior a 0
			 * se realizara el descuento de puntos no tiene gastos de envio
			 * y se le aplicara un descuento del 30% al total de la compra
			 */
			if(rol.equals("ROLE_FAMILIA")) {
				if(puntos > 0.00) {
					total = (suma -(suma*0.3))-(puntos*0.01);//multiplico los puntos por 0.01 para convertirlos en importe
					total = Math.round(total * 100.0) / 100.0;
					user.setMisPuntos(0.00);//pongo el contador de los puntos a 0 una vez utilizados
					usudao.modificarUsuario(user);
					pedio.setTotal(total);
				}else {//si los puntos no son superior a 0 hace la suma sin los puntos
					total = suma-(suma*0.3);
					total = Math.round(total * 100.0) / 100.0;
					pedio.setTotal(total);
				}
				
			}
			
			
			/**
			 * en caso de que el usuario sea administrador y los puntos sean superior a 0
			 * se realizara el descuento de puntos y no tendra gastos de envio
			 */
			if(rol.equals("ROLE_ADMINISTRADOR")) {
				if(puntos > 0.00) {
					total = suma -(puntos*0.01);//multiplico los puntos por 0.01 para convertirlos en importe
					total = Math.round(total * 100.0) / 100.0;
					user.setMisPuntos(0.00);//pongo el contador de los puntos a 0 una vez utilizados
					usudao.modificarUsuario(user);
					pedio.setTotal(total);
				}else {//si los puntos no son superior a 0 hace la suma sin los puntos
					total = suma;
					total = Math.round(total * 100.0) / 100.0;
					pedio.setTotal(total);
				}
				
			}
			
			
			/**
			 * en caso de que el usuario sea cliente vip y los puntos sean superior a 0
			 * se realizara el descuento de puntos
			 * y no tendra gastos de envio
			 */
			if(rol.equals("ROLE_CLIENTEVIP")) {
				if(puntos > 0.00) {
					total = suma - (puntos*0.01);//multiplico los puntos por 0.01 para convertirlos en importe
					total = Math.round(total * 100.0) / 100.0;
					user.setMisPuntos(0.00);//pongo el contador de los puntos a 0 una vez utilizados
					usudao.modificarUsuario(user);
					pedio.setTotal(total);
				}else {//si los puntos no son superior a 0 hace la suma sin los puntos
					total = suma;
					total = Math.round(total * 100.0) / 100.0;
					pedio.setTotal(total);
				}
				
			}
	
		
		model.addAttribute("pedido", pedio);//agrego el pedido en un atributo para mostrarlo en la vista
		
		
		return "TramitarCompra";
	}
	
	
	/**
	 * Metodo que utilizaremos para cancelar un producto de nuetra lista de producto antes de tramitar
	 * el pedido
	 * 
	 * @author Gerard Perujo
	 * 
	 * @param idCompra id del producto del carro que nos llega por parametros
	 * 
	 * @param model parametro que utilizamos para recoger el usuario que esta en session
	 * 
	 * @param session parametro para poder agregar un atributo en session y poder acceder a el mientras la
	 * session este abierta
	 * 
	 * @return nos devuelve la vista tramitar compra una vez se ha cancelado el producto
	 */
	@GetMapping("/CancelarProductoCompra/{id}")
	public String cancelarProductoEnTramitar(@PathVariable("id") int idCompra, Model model, HttpSession session){
		
		/**
		 * Busco el producto que quiero eliminar del carro de la cuenta pasandole su id
		 */
		ProductoPedido producu = produPedidao.buscarUnProdPedi(idCompra);

		
		/**
		 * En caso de que exista lo eliminamos del carro de la compra
		 */
		if(producu != null) {
			int cantidad = producu.getCantidad();//recogo la cantidad de elementos que tiene ese producto
			Producto prod = producu.getProducto();//recogo el producto entero
			int cantTienda = prod.getCantidadMaxima();//recogo la cantidad de elementos que tiene la tienda de ese producto
			int cantTotal = cantTienda + cantidad;//le sumo la cantidad de elementos de ese producto a la cantidad que hay en tienda
			prod.setCantidadMaxima(cantTotal);
			produdao.modificarProducto(prod);//modifico el producto
			produPedidao.eliminarProdPedi(idCompra);//elimino el producto del carro
		}
		
		
		int idPedido = producu.getPedido().getIdPedido();//cogo la id del pedido
		
		Usuario user = (Usuario) session.getAttribute("usuario");//cogo el usuario con el atributo session 
		
		Pedido pedio = pedidao.buscarUnPedido(idPedido);//busco el pedido pasandole el id pedido que hemos recogido de un producto
		
		
		List<Direccion> direc = direcdao.mostrarDireccionUsuario(user,"a");//saco todas las direcciones del usuario que esten activas
		
		for(Direccion direccion : direc) {
			if(direccion.getCalle() == null) {
				direccion.setCalle("no calle");
				
				direcdao.modificarDireccion(direccion);
			}
			if(direccion.getNumero() == null) {
				direccion.setNumero("No Numero");
				
				direcdao.modificarDireccion(direccion);
			}
			if(direccion.getPiso() == null) {
				direccion.setPiso("No piso");
				
				direcdao.modificarDireccion(direccion);
			}
			
			if(direccion.getPuerta() == null) {
				direccion.setPuerta("No puerta");
				
				direcdao.modificarDireccion(direccion);
			}
		}
		
		model.addAttribute("direccion", direc);//agrego las direcciones en un atributo para mostrarlo en la vista
		
		
		
		Empresa emprea = empresaDao.buscarUnaEmpresa(1);//busco los datos de la empresa en la BBDD
		model.addAttribute("empresa", emprea);//agrego la empresa en un atributo para mostrarlo en la vista
		
		List<CuentaUsuario> cuentusu = cuenUsudao.mostrarCuentasUsuarioEstado(user, "a");//busco todas las cuentas del usuario que esten activas
		
		for(CuentaUsuario cue : cuentusu) {
			if(cue.getNumeroTarjeta() == null) {
				cue.setNumeroTarjeta("no hay tarjeta");
				cuenUsudao.modificarCuenta(cue);
			}
		}
		
		model.addAttribute("cuentas", cuentusu);//agrego las cuentas en un atributo para mostrarlas en la vista
		
		List<ProductoPedido> lista = produPedidao.mostrarProductosPorPedido(pedio);//busco todos los productos que estan en el carro de ese pedido
		model.addAttribute("productos", lista);//agrego los productos en un atributo para mostrarlo en una vista
		
		Double total = 0.00;
		Double suma = 0.00;
		
		for(ProductoPedido prod : lista) {
			suma += prod.getPrecioProducto();
		}
		
		String rol = " ";
		
		Authentication aut = SecurityContextHolder.getContext().getAuthentication();
		
		for(GrantedAuthority roles : aut.getAuthorities()) {
			 rol = roles.getAuthority();
		}
	
				if(rol.equals("ROLE_CLIENTE")){
					if(suma <= 59.90) {
						total = suma + 6.90;
						total = Math.round(total * 100.0) / 100.0;
						pedio.setTotal(total);
					}else {
						total = suma;
						total = Math.round(total * 100.0) / 100.0;
						pedio.setTotal(total);
					}
				}
				
				if(rol.equals("ROLE_FAMILIA")) {
					total = suma-(suma*0.3);
					total = Math.round(total * 100.0) / 100.0;
					pedio.setTotal(total);
				}
				
				if(rol.equals("ROLE_ADMINISTRADOR")) {
					total = suma;
					total = Math.round(total * 100.0) / 100.0;
					pedio.setTotal(total);
				}
				
				if(rol.equals("ROLE_CLIENTEVIP")) {
					total = suma;
					total = Math.round(total * 100.0) / 100.0;
					pedio.setTotal(total);
				}
		
	
			model.addAttribute("pedido", pedio);
		
		return "TramitarCompra";
	}
	
	
	/**
	 * @author Gerard Perujo
	 * 
	 * @param idPedido
	 * 
	 * @param model parametro que utilizamos para recoger el usuario que esta en session
	 * 
	 * @param session parametro para poder agregar un atributo en session y poder acceder a el mientras la
	 * session este abierta
	 * 
	 * @param request parametro que usamos para recoger los datos strings del formulario
	 * 
	 * @param idCuentaUsusario id de la cuenta usuario que nos llega por parametro
	 * 
	 * @param ratt parametro que utilizamos para recoger el usuario que esta en session
	 * 
	 * @return una vez realizado el pedido nos devuelve al mensaje de pedido realizado
	 */
	@PostMapping("/tramitar/{id}")
	public String realizarPedido(@PathVariable("id") int idPedido, Model model, HttpSession session, HttpServletRequest request,
			@RequestParam("numeroTarjeta") int idCuentaUsusario, RedirectAttributes ratt) {
		
		Usuario user = (Usuario) session.getAttribute("usuario");//cogo el usuario que esta dentro del atributo session
		
		CuentaEmpresa cuentaEmpresa = cuenEmprdao.buscarUnaCuenta(1);//busco la cuenta del la empresa
		CuentaUsuario cuentaUsuario = cuenUsudao.buscarUnaCuenta(idCuentaUsusario);//busco la cuenta del usuario que me pasan por parametro
		
		
		
		Empresa emprea = empresaDao.buscarUnaEmpresa(1);//busco los datos de la empresa en la BBDD
		model.addAttribute("empresa", emprea);//agrego la empresa en un atributo para mostrarla en la vista
		
		
		Pedido pedio = pedidao.buscarUnPedido(idPedido);//busco el pedido con la id que me envian por parametros
		
		List<ProductoPedido> lista = produPedidao.mostrarProductosPorPedido(pedio);//busco todos los productos que tiene ese pedido
		model.addAttribute("productos", lista);//agrego los productos en un atributo para poder mostrarlo en la vista
		
		Double total = 0.00;
		Double suma = 0.00;
		
		for(ProductoPedido prod : lista) {
			suma += prod.getPrecioProducto();
		}
		
		String rol = " ";
		
		Authentication aut = SecurityContextHolder.getContext().getAuthentication();
		
		for(GrantedAuthority roles : aut.getAuthorities()) {
			 rol = roles.getAuthority();
		}
	
				if(rol.equals("ROLE_CLIENTE")){
					if(suma <= 59.90) {
						total = suma + 6.90;
						total = Math.round(total * 100.0) / 100.0;
						pedio.setTotal(total);
					}else {
						total = suma;
						total = Math.round(total * 100.0) / 100.0;
						pedio.setTotal(total);
					}
				}
				
				if(rol.equals("ROLE_FAMILIA")) {
					total = suma-(suma*0.3);
					total = Math.round(total * 100.0) / 100.0;
					pedio.setTotal(total);
				}
				
				if(rol.equals("ROLE_ADMINISTRADOR")) {
					total = suma;
					total = Math.round(total * 100.0) / 100.0;
					pedio.setTotal(total);
				}
				
				if(rol.equals("ROLE_CLIENTEVIP")) {
					total = suma;
					total = Math.round(total * 100.0) / 100.0;
					pedio.setTotal(total);
				}
		
				
		/**
		 * Hago una simulacion del gasto entre usuario y empresa ya que aun no se como
		 * implementar pagos bancarios por eso hemos puesto un campo saldo para simular las 
		 * compras		
		 */
		Double dineroEmpresa = cuentaEmpresa.getSaldo() + pedio.getTotal();//le sumo el coste del pedido a la cuenta empresa
		Double dineroEmpresaRound = Math.round(dineroEmpresa * 100.0) / 100.0;
		Double dineroUsuario = cuentaUsuario.getSaldo() - pedio.getTotal();//le resto el coste del pedido en la cuenta del usuario
		Double dineroUsuarioRound = Math.round(dineroUsuario * 100.0) / 100.0;
		
		cuentaEmpresa.setSaldo(dineroEmpresaRound);
		cuentaUsuario.setSaldo(dineroUsuarioRound);
		
		cuenEmprdao.modificarCuentaEmpresa(cuentaEmpresa);//modifico la cuenta de la empresa con el nuevo saldo
		cuenUsudao.modificarCuenta(cuentaUsuario);//modifico la cuenta del usuario con el nuevo saldo
		
		
		/**
		 * saco los puntos que gana el usuario al realizar una compra
		 * dividendo el total de la compra entre 4 es una cantidad que 
		 * lo hablamos en grupo porque sale un importe que no
		 * aporta perdidas a la empresa
		 */
		Double puntos = total/4;//dividimos el importe del pedido entre 4
		Double puntosActuales = user.getMisPuntos();//cogo los puntos actuales del usario
		Double puntosTotales = puntosActuales + puntos;//le sumo los puntos obtenidos de la nueva compra
		Double puntosRound = Math.round(puntosTotales * 100.0) / 100.0;
		
		
		/**
		 * en caso de que el usuario no haya rellenado los campos que hacen falta
		 * para realizar el envio en su perfil dentro de su area personal los recogo aqui
		 * y los agrego en la BBDD para tenerlos guardados para el siguiente pedido
		 */
		user.setNombre(request.getParameter("nombre"));
		user.setPrimerApellido(request.getParameter("primerApellido"));
		user.setSegundoApellido(request.getParameter("segundoApellido"));
		user.setEmail(request.getParameter("email"));
		user.setTelefono(request.getParameter("telefono"));
		user.setMisPuntos(puntosRound);
		
		usudao.modificarUsuario(user);//una vez recogido todos los datos modifico el usuario
		
		
		
		
		/**
		 * una vez realizado el pedido cambiados el estado del pedido a desactivado pasandole
		 * los puntos que ha obtenido el usuario en este pedido y el importe total
		 * del pedido		
		 */
		pedio.setEstado("d");
		pedio.setTotal(total);
		pedio.setPuntosConsegidos(puntos);
		pedidao.modificarPedido(pedio);
		
		
		/**
		 * Al cambiar el estado del pedido que hemos termiando de realizar a desactivado creo un nuevo
		 * pedido por si el usuario decide continuar comprando en caso que se le ovidara comprar algo
		 */
		Date data = new Date();
		Pedido pedi = new Pedido();
		pedi.setEmpresa(empresaDao.buscarUnaEmpresa(1));
		pedi.setEstado("a");
		pedi.setFechaPedido(data);
		pedi.setTotal(0.00);
		pedi.setUsuario(user);
		
		
		pedidao.insertarPedido(pedi);
		
		
		
		return "MensajePedido";
	}
	
	

	
	/**
	 * Metodo que utilizaremos para cambiar el estado de nuestro producto de desactivado
	 * a activado
	 * 
	 * @author Gerard Perujo
	 * 
	 * @param idProducto id del producto que nos entra por parametro
	 * ç
	 * @param model parametro que utilizamos para recoger el usuario que esta en session
	 * 
	 * @return nos devuelve la vista gestion de productos con el producto activado
	 */
	@GetMapping("/activar/producto/{id}")
	public String activarProductoDesactivado(@PathVariable("id") int idProducto, Model model) {
		
		Producto prod = produdao.buscarUnProducto(idProducto);//busco el producto con a id que nos entra por parametros
		
		
		/**
		 * en caso de que el producto no sea nulo
		 * cambio el estado del producto a Activado
		 * si todo ha salido bien saco un mensaje de de producto activado en caso
		 * contrario saco un mensaje de error
		 */
		if(prod != null) {
			prod.setEstado("a");
			produdao.modificarProducto(prod);
			model.addAttribute("mensaje", "El producto ha sido activado");
			
		}else {
			model.addAttribute("mensajeError", "El producto no ha podido ser activado");
		}
		
		return "forward:/gestion/producto";
	}
	
	
	
	/**
	 * Metodo que utilizaremos para mostar la pagina agregar un producto sin id Producto
	 * 
	 * @param model parametro que utilizamos para recoger el usuario que esta en session
	 * 
	 * @return nos devuelve la vista agregar un producto
	 */
	@GetMapping("/agregar/producto")
	public String mostrarAgregarrUnProducto( Model model) {
		
		
		Producto prod = new Producto();//creo un producto nuevo
		model.addAttribute("product", prod);//agrego ese producto nuevo en el atributo para poderlo mostrar en la vista
		
		Empresa emprea = empresaDao.buscarUnaEmpresa(1);//busco los datos de la empresa en la BBDD
		model.addAttribute("empresa", emprea);//agrego la empresa en un atributo para poderlo mostrar en las vistas
		
		return "agregarProducto";
		
	}
	
	

	/**
	 * Metodo que utilizaremos para mostrar la pagina agregar un Producto
	 * 
	 * @author Gerard Perujo
	 * 
	 * @param idProducto id del producto que nos entra por parametro
	 * 
	 * @param model parametro que utilizamos para recoger el usuario que esta en session
	 * 
	 * @return nos devuelve la vista de agregar un producto para poder agregar un nuevo producto
	 * a nuestra BBDD
	 */
	@GetMapping("/modificar/producto/{id}")
	public String mostrarModificarUnProducto(@PathVariable("id") int idProducto, Model model) {
		
		Producto prod = produdao.buscarUnProducto(idProducto);//busco el producto con la id que nos entra por parametros
		model.addAttribute("product", prod);//agrego el producto en un atributo para poderlo mostrar en la vista
		
		Empresa emprea = empresaDao.buscarUnaEmpresa(1);//busco los datos de la empresa en la BBDD
		model.addAttribute("empresa", emprea);//agrego la empresa en un atributo para poderlo mostrar en la vista
		
		return "agregarProducto";
		
	}
	
	
	
	
	/**
	 * Metodo que utilizaremos para agregar o modificar un producto existente
	 * 
	 * @author Gerard Perujo
	 * 
	 * @param prod es el producto que nos llega desde el formulario donde hemos creado nuestro producto o modificado
	 * 
	 * @param ratt parametro que utilizamos para recoger el usuario que esta en session
	 * 
	 * @param idProducto id del producto que nos llega desde parametros
	 * 
	 * @return nos va a devolver a la vista agregar una imagen para poder agregar una imagen a nuestro producto
	 * nuevo o modificar la que tiene
	 */
	@PostMapping("/agregar/producto/{id}")
	public String agregarUnProducto(Producto prod, RedirectAttributes ratt, @PathVariable("id") int idProducto) {
		
		Producto producto = new Producto();//creo un producto nuevo en caso de que no se modifique el producto
		
		Producto product = produdao.buscarUnProducto(idProducto);//busco el producto que nos entra por id desde los parametros

		/**
		 * En caso de que el producto exista hago una modificacion del producto
		 * con los datos que nos llegan del formulario
		 */
		if( product != null) {
			product.setNombre(prod.getNombre());
			product.setDescripcion(prod.getDescripcion());
			product.setEstado(prod.getEstado());
			product.setPromocion(prod.getPromocion());
			product.setDescuento(prod.getDescuento());
			product.setValoracion(prod.getValoracion());
			product.setCantidadMaxima(prod.getCantidadMaxima());
			product.setPrecioUnitario(prod.getPrecioUnitario());
			product.setCategoria(catedao.buscarUnaCategoria(prod.getCategoria().getIdCategoria()));
			product.setProveedor(provedao.buscarUnProveedor(prod.getProveedor().getIdProveedor()));
		
			
			produdao.modificarProducto(product);//modifico el producto con los datos que me han llegado del formulario
			
			ratt.addFlashAttribute("mensaje", "El producto ha sido Modificado");
			
		}else {// si el producto no existe creo un producto nuevo con los datos que nos llegan desde el formulario
			producto.setNombre(prod.getNombre());
			producto.setDescripcion(prod.getDescripcion());
			producto.setEstado(prod.getEstado());
			producto.setPromocion(prod.getPromocion());
			producto.setDescuento(prod.getDescuento());
			producto.setValoracion(prod.getValoracion());
			producto.setCantidadMaxima(prod.getCantidadMaxima());
			producto.setPrecioUnitario(prod.getPrecioUnitario());
			producto.setTipoProducto(prod.getTipoProducto());
			producto.setCategoria(catedao.buscarUnaCategoria(prod.getCategoria().getIdCategoria()));
			producto.setProveedor(provedao.buscarUnProveedor(prod.getProveedor().getIdProveedor()));
		
			
			produdao.insertarProducto(producto);//agrego el nuevo producto
			produdao.buscarUnProducto(producto.getIdProductos());//busco el nuevo producto que he agregado
			int numProducto = producto.getIdProductos();//cogo la id del producto
			
			ratt.addFlashAttribute("mensaje", "El Producto ha sido Agregado");
			
			return "redirect:/agregar/imagenProducto/"+ numProducto;//inserto la id del producto a la ruta porque me hace falta para mostar la vista imagen producto
			
			
		}
		
			
		
		return "redirect:/agregar/imagenProducto/{id}";//cuando es un producto modificado ya tiene la id propia del producto
	}
	
	
	/**
	 * Metodo que nos muestra la vista imagen producto
	 * 
	 * @author Gerard Perujo
	 * 
	 * @param model parametro que utilizamos para recoger el usuario que esta en session
	 * 
	 * @param idProducto la id del producto que nos entra por parametro
	 * 
	 * @return nos devuelve la vista imagenProducto donde se puede agregar una imagen a nuestro producto
	 */
	@GetMapping("/agregar/imagenProducto/{id}")
	public String msotrarAgregarImagenProducto(Model model, @PathVariable("id") int idProducto) {
		
		Producto prod = produdao.buscarUnProducto(idProducto);//busco el producto con la id que nos entra por parametro
		model.addAttribute("product", prod);//agrego el producto en un atributo para poderlo mostrar en la vista
		
		Empresa emprea = empresaDao.buscarUnaEmpresa(1);//busco los datos de la empresa en la BBDD
		model.addAttribute("empresa", emprea);//agrego la empresa en un atributo para poder mostrarlo en la vista
		
		return "imagenProducto";
	}
	

	/**
	 * Metodo que utlizaremos para mostrar la pagina de gestion de productos
	 * 
	 * @author Gerard Perujo
	 * 
	 * @param model parametro que utilizamos para recoger el usuario que esta en session
	 * 
	 * @return nos devuelve la vista gestion de productos
	 */
	@GetMapping("/gestion/producto")
	public String mostrarGestionProductos(Model model) {
		
		Empresa emprea = empresaDao.buscarUnaEmpresa(1);//busco los datos de la empresa en la BBDD
		model.addAttribute("empresa", emprea);//agrego la empresa en un atributo para mostrarlo en la vista
		
		List<Producto> prod = produdao.mostrarTodosProductos();//buscamos todos los productos que tenemos en la BBDD
		model.addAttribute("productos", prod);//agrego los productos en un atributo para mostrarlo en la vista
		
		return "gestionProductos";
	}
	
	
}





