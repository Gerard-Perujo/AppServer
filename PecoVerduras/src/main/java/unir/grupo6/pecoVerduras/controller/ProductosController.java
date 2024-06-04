package unir.grupo6.pecoVerduras.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import unir.grupo6.pecoVerduras.modeloDao.EmpresaDao;
import unir.grupo6.pecoVerduras.modeloDao.PedidoDao;
import unir.grupo6.pecoVerduras.modeloDao.ProductoDao;
import unir.grupo6.pecoVerduras.modeloDao.ProductoFavoritoDao;
import unir.grupo6.pecoVerduras.modeloDao.ProductoPedidoDao;
import unir.grupo6.pecoVerduras.modeloDao.ProveedorDao;
import unir.grupo6.pecoVerduras.modeloDao.UsuarioDao;
import unir.grupo6.pecoVerduras.modeloEntity.Categoria;
import unir.grupo6.pecoVerduras.modeloEntity.Comentario;
import unir.grupo6.pecoVerduras.modeloEntity.Empresa;
import unir.grupo6.pecoVerduras.modeloEntity.Pedido;
import unir.grupo6.pecoVerduras.modeloEntity.Producto;
import unir.grupo6.pecoVerduras.modeloEntity.ProductoFavorito;
import unir.grupo6.pecoVerduras.modeloEntity.ProductoPedido;
import unir.grupo6.pecoVerduras.modeloEntity.Usuario;


/**
 * Controlador que nos llevara toda la gestion de nuestras paginas de los productos de nuestra  
 * aplicación web
 * 
 * @author Maria Isabel
 */
@Controller
public class ProductosController {

	
	/**
	* Importamos la clase EmpresaDao para poder acceder a todos los metodos que tiene
	*/
	@Autowired
	private EmpresaDao empresaDao;
	
	
	/**
	* Importamos la clase ProductoDao para poder acceder a todos los metodos que tiene
	*/
	@Autowired
	private ProductoDao productoDao;
	
	
	/**
	* Importamos la clase CategoriaDao para poder acceder a todos los metodos que tiene
	*/
	@Autowired
	private CategoriaDao categoriaDao;
	
	
	/**
	* Importamos la clase CoemtarioDao para poder acceder a todos los metodos que tiene
	*/
	@Autowired
	private ComentarioDao comentarioDao;
	
	
	/**
	* Importamos la clase PedidoDao para poder acceder a todos los metodos que tiene
	*/
	@Autowired
	private PedidoDao pedidoDao;
	
	
	/**
	* Importamos la clase ProductoPedidoDao para poder acceder a todos los metodos que tiene
	*/
	@Autowired
	private ProductoPedidoDao productoPedidoDao;
	
	
	/**
	* Importamos la clase ProductoFavoritoDao para poder acceder a todos los metodos que tiene
	*/
	@Autowired
	private ProductoFavoritoDao productoFavoritoDao;

	
	
	/**
	 *  Metodo que utilizaremos para mostrar la pagina Categorias donde se alojan todas las categorias de 
	 * productos que tenemos
	 * 
	 * @author Maria Isabel
	 * 
	 * @param model parametro que utilizamos para agregar atributos o sacar mensajes en las vistas
	 * 
	 * @return devuelve la vista categorias 
	 */
	@GetMapping("/tienda")
	public String mostrarTienda(Model model) {
		
	    Empresa empresa = empresaDao.buscarUnaEmpresa(1);//busco la empresa en la BBDD para sacar todos los datos de ella
	    model.addAttribute("empresa", empresa); //agrego la empresa en un atributo para sacar los datos en la vista
	    
	    return "Categorias";
	}

	
	
	/**
	 * Metodo que utilizaremos para mostrar la pagina frutas que es la pagina donde se alojan todas
	 * nuestras frutas
	 * 
	 * @author Maria Isabel
	 * 
	 * @param modelparametro que utilizamos para agregar atributos o sacar mensajes en las vistas
	 * 
	 * @param tipoCategoria paramentro que nos entra desde la url que recoge el tipo de categoria del filtro
	 * 
	 * @return devuelve la vista listafrutas donde se muestra todas las frutas que tenemos en caso de utilizar el
	 * filtro nos devolvera todas las frutas por el tipo que hayamos filtrado
	 */
	@GetMapping("/frutas")
	public String listadoFrutas(Model model, @RequestParam(name = "tipo", required = false)String tipoCategoria){

		Producto producto = new Producto();//creo un producto nuevo
		
		/**
		 * en el caso de que el parametro que nos entra tipocategoria sea nulo
		 * le pondremos un campo blanco y lo añadiremos al producto
		 * que hemos creado, si no es nulo agregaremos el tipoCategoria
		 * que nos entra por parametros
		 */
		if(tipoCategoria == null) {
			tipoCategoria = " ";
			producto.setTipoProducto(tipoCategoria);
		}else {
			producto.setTipoProducto(tipoCategoria);
		}
		
		
		/**
		 * si el tipo de producto es blanco sacaremos todos los productos que tengan la categoria 2 = fruta
		 * que esten activos y no sean promocion si no sacaremos todos esos productos que tengan el tipo
		 * producto que hemos pasado por parametro y que no sean de promocion
		 */
		if(producto.getTipoProducto() == " ") {
			Categoria cate = categoriaDao.buscarUnaCategoria(2);//paso la categoria 2 = fruta	
			List<Producto> fruta = productoDao.buscarTodosPorCategoriaYEstadoActivo(cate, "a", "n");//busco todos los productos de tipo fruta
			model.addAttribute("producto", fruta);//agrego todos los productos en un atributo para sacar los datos por las vistas	    
		}else {	
			List<Producto> product = productoDao.buscarProductoPorNombre(producto.getTipoProducto(), "n");//busco todos los productos segun el tipo de producto
		    model.addAttribute("producto", product);//agrego todos los producto en un atributo para poder sacar los datos en las vistas
		}
	
		Empresa emprea = empresaDao.buscarUnaEmpresa(1);//busco la empresa en la BBDD para sacar todos los datos de ella
		model.addAttribute("empresa", emprea);//agrego la empresa en un atributo para sacar los datos en la vista
		
		return "ListadoFrutas";
	}
	
	
		
	
	/**
	 * Metodo que utilizaremos para mostrar la pagina verduras que es la pagina donde se alojan todas
	 * nuestras verduras
	 * 
	 * @author Maria Isabel
	 * 
	 * @param model parametro que utilizamos para agregar atributos o sacar mensajes en las vistas
	 * 
	 * @param tipoCategoria paramentro que nos entra desde la url que recoge el tipo de categoria del filtro
	 * 
	 * @return devuelve la vista listaverduras donde se muestra todas las frutas que tenemos en caso de utilizar el
	 * filtro nos devolvera todas las verduras por el tipo que hayamos filtrado
	 */
	@GetMapping("/verduras")
	public String listarVerduras(Model model, @RequestParam(name = "tipo", required = false)String tipoCategoria){
			
		Producto producto = new Producto();//creo un producto nuevo
		
		/**
		 * en el caso de que el parametro que nos entra tipocategoria sea nulo
		 * le pondremos un campo blanco y lo añadiremos al producto
		 * que hemos creado, si no es nulo agregaremos el tipoCategoria
		 * que nos entra por parametros
		 */
		if(tipoCategoria == null) {
			tipoCategoria = " ";
			producto.setTipoProducto(tipoCategoria);
		}else {
			producto.setTipoProducto(tipoCategoria);
		}

		
		/**
		 * si el tipo de producto es blanco sacaremos todos los productos que tengan la categoria 1 = verduras
		 * que esten activos y no sean promocion si no sacaremos todos esos productos que tengan el tipo
		 * producto que hemos pasado por parametro y que no sean de promocion
		 */
		if(producto.getTipoProducto() == " ") {
			Categoria cate = categoriaDao.buscarUnaCategoria(1);//paso la categoria 1 = verdura		
			List<Producto> verdura = productoDao.buscarTodosPorCategoriaYEstadoActivo(cate, "a", "n");//busco todos los productos de tipo verdura
			model.addAttribute("producto", verdura);//agrego todos los productos en un atributo para sacar los datos por las vistas			    
		}else {	
			List<Producto> product = productoDao.buscarProductoPorNombre(producto.getTipoProducto(), "n");//busco todos los productos segun el tipo de producto
		    model.addAttribute("producto", product);//agrego todos los producto en un atributo para poder sacar los datos en las vistas
		}
	
		Empresa emprea = empresaDao.buscarUnaEmpresa(1);//busco la empresa en la BBDD para sacar todos los datos de ella
		model.addAttribute("empresa", emprea);//agrego la empresa en un atributo para sacar los datos en la vista
		return "ListadoVerduras";
	}
	
	
	
	
	/**
	 * Metodo que utilizaremos para mostrar la pagina productos varios que es la pagina donde se alojan todas
	 * nuestros productos
	 * 
	 * @author Maria Isabel
	 * 
	 * @param model parametro que utilizamos para agregar atributos o sacar mensajes en las vistas
	 * 
	 * @param tipoCategoria paramentro que nos entra desde la url que recoge el tipo de categoria del filtro
	 * 
	 * @return devuelve la vista productos varios donde se muestra todas las frutas que tenemos en caso de utilizar el
	 * filtro nos devolvera todos los productos varios por el tipo que hayamos filtrado
	 */
	@GetMapping("/productos")
	public String listarOtros(Model model, @RequestParam(name = "tipo", required = false)String tipoCategoria){
			
		Producto producto = new Producto();//creo un producto nuevo
		
		/**
		 * en el caso de que el parametro que nos entra tipocategoria sea nulo
		 * le pondremos un campo blanco y lo añadiremos al producto
		 * que hemos creado, si no es nulo agregaremos el tipoCategoria
		 * que nos entra por parametros
		 */
		if(tipoCategoria == null) {
			tipoCategoria = " ";
			producto.setTipoProducto(tipoCategoria);
		}else {
			producto.setTipoProducto(tipoCategoria);
		}

		
		/**
		 * si el tipo de producto es blanco sacaremos todos los productos que tengan la categoria 3 = productos varios
		 * que esten activos y no sean promocion si no sacaremos todos esos productos que tengan el tipo
		 * producto que hemos pasado por parametro y que no sean de promocion
		 */
		if(producto.getTipoProducto() == " ") {
			Categoria cate = categoriaDao.buscarUnaCategoria(3);//paso la categoria 3 = productosvarios	
			List<Producto> otro = productoDao.buscarTodosPorCategoriaYEstadoActivo(cate, "a", "n");//busco todos los productos de tipo productos
			model.addAttribute("producto", otro);//agrego todos los producto en un atributo para poder sacar los datos en las vistas			    
		}else {	
			List<Producto> product = productoDao.buscarProductoPorNombre(producto.getTipoProducto(), "n");//busco todos los productos segun el tipo de producto
		    model.addAttribute("producto", product);//agrego todos los producto en un atributo para poder sacar los datos en las vistas
		}
	
		Empresa emprea = empresaDao.buscarUnaEmpresa(1);//busco la empresa en la BBDD para sacar todos los datos de ella
		model.addAttribute("empresa", emprea);//agrego la empresa en un atributo para sacar los datos en la vista
		return "ListadoOtros";
	}
	
	

	
	/**
	 * Metodo que utilizaremos para cambiar el estado de nuestros productos a desactivado
	 * 
	 * @author Maria Isabel
	 * 
	 * @param idProducto id del producto que nos entra por parametro a traves de la url
	 *  
	 * @param model parametro que utilizamos para agregar atributos o sacar mensajes en las vistas
	 * 
	 * @return nos devuelve la vista gestion productos con el estado de nuestro producto desactivado
	 */
	@GetMapping("/Desactivar/producto/{id}")
	public String desactivarFruta(@PathVariable("id") int idProducto, Model model) {
		
		Producto producto = productoDao.buscarUnProducto(idProducto);//busco el producto pasando la id que nos entra por parametros
		
		
		/**
		 * si el producto no es nulo le cambiaremos el estado a "d" = desactivado
		 * modificaremos el producto y sacaremos un mensaje diciendo que la operacion
		 * a sido realizada, en caso de que sea nulo sacaremos un mensaje de error
		 */
		if(producto != null) {
			producto.setEstado("d");//cambio el estado del producto
			productoDao.modificarProducto(producto);//modifico el producto
			
			model.addAttribute("mensaje", "El producto ha sido Desactivadp");
		}else {
			model.addAttribute("mensajeError", "El producto no ha sido Desactivado");
		}
		
		
		Empresa emprea = empresaDao.buscarUnaEmpresa(1);//busco la empresa en la BBDD para sacar todos los datos de ella
		model.addAttribute("empresa", emprea);//agrego la empresa en un atributo para sacar los datos en la vista	
		
		return "forward:/gestion/producto";
	}
	
	
	
	
	/**
	 * Metodo que utilizaremos para cambiar el estado de nuestro producto a promocion
	 * 
	 * @author Maria Isabel
	 * 
	 * @param idProducto id del producto que nos entra por parametro a traves de la url
	 * 
	 * @param model parametro que utilizamos para agregar atributos o sacar mensajes en las vistas
	 * 
	 * @return nos devuelve la vista gestion/producto donde veremos el estado de nuestro producto en promocion
	 */
	@GetMapping("/promocionar/producto/{id}")
	public String promocionarUnaFruta (@PathVariable("id") int idProducto, Model model) {
		
		Producto prod = productoDao.buscarUnProducto(idProducto);//busco el producto con la id que nos entra por parametros
		
		/**
		 * en caso de que el producto no sea nulo cambiaremos el esado de promocion "s" = si
		 * modificaremos el producto y sacaremos un mensaje conforme la operacion se ha realizado
		 * correctamente, si es nulo sacaremos un mensaje de error
		 */
		if(prod != null) {
			prod.setPromocion("s");//cambio el estado del producto
			productoDao.modificarProducto(prod);//modifico el producto
			model.addAttribute("mensaje", "El producto ha sido Promocionado");
		}else {
			model.addAttribute("mensajeError", "El producto no ha sido Promocionado");
		}
		
		return "forward:/gestion/producto";
	}
	
	
	
	
	/**
	 * Metodo que utilizaremos para mostrar la pagina detalle donde se podra ver toda la informacion
	 * del producto seleccionado
	 * 
	 * @author Maria Isabel
	 * 
	 * @param id id del producto que nos entra por parametro por la url
	 * 
	 * @param model parametro que utilizamos para agregar atributos o sacar mensajes en las vistas
	 * 
	 * @return devuelve la vista detalle con toda la informacion del producto seleccionado
	 */
	@GetMapping("/productos/verUno/{id}")
	public String detalle(@PathVariable int id, Model model) {
		
	    Producto producto = productoDao.buscarUnProducto(id);//busco el producto con la id que nos entra por parametros
	    
	    
	    /**
	     * en caso de que el producto no sea nulo agregaremos el producto encontrado
	     * en un atributo para sacar todos los datos del producto en las vistas, si es
	     * nulo sacaremos un mensaje de error
	     */
	    if (producto != null) {
	        model.addAttribute("producto", producto);//agrego el producto en un atributo para sacar todos los datos en la vista
	    } else {
	        model.addAttribute("mensaje", "El producto no se ha encontrado");
	    }
	    
	    /**
	     * busco todos los comentarios que tiene ese producto y lo agrego en un
	     * atributo para poder sacar todos los datos de os comentarios en una vista
	     */
	    List<Comentario> comen = comentarioDao.buscarComentariosPorProductoYEstado(producto, "a");//busco todos los comentarios que esten activos del producto
	    model.addAttribute("comentarios", comen);//agrego los comentarios en un atributo para sacar todos los datos en la vista	    
	    
	    
	    Empresa emprea = empresaDao.buscarUnaEmpresa(1);//busco la empresa en la BBDD para sacar todos los datos de ella
		model.addAttribute("empresa", emprea);//agrego la empresa en un atributo para sacar los datos en la vista		
	   
		return "Detalle";
	}
	
	
	
	
	/**
	 * Metodo que utilizaremos para agregar el producto que queremos comprar en la cesta a nuestro pedido
	 * 
	 * @author Maria Isabel
	 * 
	 * @param idProductos id del producto que nos entra por parametro a traves de la url
	 * 
	 * @param ratt parametro que utilizamos para agregar atributos o sacar mensajes en las vistas
	 * 
	 * @param session parametro para poder agregar un atributo en session y poder acceder a el mientras la
	 * session este abierta
	 * 
	 * @param request parametro que usamos para recoger los datos strings del formulario
	 * 
	 * @param numeroSelect parametro que recogemos del formulario para la cantidad de productos que hemos seleccionado
	 * 
	 * @return despues de agregar el producto a la cesta nos devuelve a la vista tienda con un mensaje correcto o error
	 */
	 @PostMapping("/compra/{id}")
	    public String selectCompra(@PathVariable("id") int idProductos, RedirectAttributes ratt,
	            					HttpSession session, HttpServletRequest request, @RequestParam ("numero") int numeroSelect) {
	        
	        Usuario user = (Usuario) session.getAttribute("usuario");//saco el usuario que esta en session con el atributo session

	        Producto producto = productoDao.buscarUnProducto(idProductos);//busco el producto con la id que nos entra desde parametros

	        Pedido pedido = pedidoDao.buscarPedidoPorUsuarioEstado(user, "a");//busco el pedido que tenga activo el usuario
	        
	        String promocion = producto.getPromocion();//cogo el valor que tiene en promocion el producto para saber si el producto esta en promocion o no
	        
	        int tienda = producto.getCantidadMaxima();//cogo la cantidad maxima de productos que tiene la tienda
	        int prodDisponible = tienda - numeroSelect;//le resto la cantidad de productos que tiene la tienda con la cantidad que ha comprado el usuario
	        
	        Double precioUnidad = producto.getPrecioUnitario();//cogo el precio unitario que tiene el producto
	        int variableNumeroSelect = numeroSelect;//pongo la cantidad de productos que ha comprado el usuario en una variable
	        
	        Double precioTotal = precioUnidad * variableNumeroSelect;//multiplo la cantidad que ha comprado por el precio del producto para saber el precio total
	        
	        ProductoPedido productoPedido = new ProductoPedido();
	        
	        /**
	         * si la cantidad de productos que quedan en la tienda es igual o inferior a 0 cuando
	         * el ususario quiera agregarlos en la cesta sacara un mensaje de error diciendo que no
	         * hay suficientes productos en la tienda para realizar la compra, si no es el caso
	         * se procedera a agregar el producto en el carro de la compra
	         */
	        if(prodDisponible <= 0) {
	        	ratt.addFlashAttribute("mensajeError", "El producto no se puede comprar no hay stock");
	        }else {
	        	/**
	        	 * en el caso de que el producto sea promocion "s" = si se le aplicara el
	        	 * descuento que tiene el producto en el precio, si no es promocion no se le
	        	 * aplicara ningun descuento
	        	 */
	        	if(promocion.equals("s")){
		        	Double descuento = producto.getDescuento()*0.01;//multiplico el valor del descuento para sacar el tanto por ciento
		        	Double precioDescuento = precioTotal -(precioTotal*descuento);//hago la operacion aplicando el descuento en el producto
		        	productoPedido.setProducto(producto);//agrego el producto en el la compra
		 	        productoPedido.setPedido(pedido);//agrego el pedido en la compra
		 	        productoPedido.setPrecioProducto(precioDescuento);//agrego el precio con descuento en la compra
		 	        productoPedido.setCantidad(numeroSelect);//agrego la cantidad de productos que ha seleccionado en la compra
		 	        
		 	        producto.setCantidadMaxima(prodDisponible);//agrego la nueva cantidad de productos que quedan en la tienda
		 	        productoDao.modificarProducto(producto);//modifico el producto
		 	        productoPedidoDao.insertarProdPedi(productoPedido);//agrego la compra en el carro
		 	        
		        }else {
		        	productoPedido.setProducto(producto);//agrego el producto en la compra
		 	        productoPedido.setPedido(pedido);//agrego el pedido en la compra
		 	        productoPedido.setPrecioProducto(precioTotal);//agrego el precio total del producto en la compra
		 	        productoPedido.setCantidad(numeroSelect);//agrego la cantidad de productos que ha seleccionado en la compra
		 	        
		 	        producto.setCantidadMaxima(prodDisponible);//agrego la nueva cantidad de productos que quedan en la tienda
		 	        productoDao.modificarProducto(producto);//modifico el producto con la nueva cantidad
		 	        productoPedidoDao.insertarProdPedi(productoPedido);//agrego la compra en el carro
		 	        
		 	       ratt.addFlashAttribute("mensaje", "El producto se ha agregado a la cesta");
		        }
	        }
	        
	        
	       

	        Empresa empresa = empresaDao.buscarUnaEmpresa(1);//busco la empresa en la BBDD para sacar todos los datos de ella
	        ratt.addFlashAttribute("empresa", empresa);//agrego la empresa en un atributo para sacar los datos en la vista
	        
	        
	        return "redirect:/tienda";
	    }
	 
	 
	 

	/**
	 * Metodo que utilizaremos para agregar un producto a nuestra lista de productos favoritos
	 * 
	 * @author Maria Isabel
	 * 
	 * @param idProductos id del producto que nos entra por parametro a traves de la url
	 * 
	 * @param session parametro para poder agregar un atributo en session y poder acceder a el mientras la
	 * session este abierta
	 * 
	 * @param ratt parametro que utilizamos para agregar atributos o sacar mensajes en las vistas
	 * 
	 * @param request parametro que usamos para recoger los datos strings del formulario
	 * 
	 * @return una vez agregado el producto a nuestra lista de favoritos nos va a devolver a la vista
	 * de nuestros productos favoritos
	 */
	 @PostMapping("/anadir/{id}")
	 public String anadirFavorito(@PathVariable("id") int idProductos, 
	                             HttpSession session, RedirectAttributes ratt, HttpServletRequest request) {
		 
	     Usuario user = (Usuario) session.getAttribute("usuario");//saco el usuario que esta en session con el atributo session
	     
	     Producto producto = productoDao.buscarUnProducto(idProductos);//busco el producto con la id que nos entra por parametros
	     
	     ProductoFavorito yaFavorito = productoFavoritoDao.buscarProductoFavoritoPorUsuarioYProducto(user.getUsername(), idProductos);//busco en productos favoritos el producto
	     
	     
	     /**
	      * en caso de que el producto sea diferente a nulo sacara un mensaje de error
	      * diciendo que el producto ya lo tenemos añadido en favoritos, sino agregara el producto
	      * en nuestra lista de productos favoritos
	      */
	     if (yaFavorito != null) {
	    	 
	    	 ratt.addFlashAttribute("mensajeError", "El producto ya se encuentra como favorito");
	     }else {
	    	 ProductoFavorito productoFavorito = new ProductoFavorito();//creo un producto favorito
		     productoFavorito.setNombre(producto.getNombre());//agrego el nombre del producto
		     productoFavorito.setFoto(producto.getImagen());//agrego la imagen del producto
		     productoFavorito.setPrecio(producto.getPrecioUnitario());//agrego el precio del producto
		     productoFavorito.setValoracion(producto.getValoracion());//agrego la valoracion que le doy al producto
		     productoFavorito.setEstado("a");//pongo el estado del producto favorito en "a" = activado
		     productoFavorito.setProducto(producto);//agrego el producto 
		     productoFavorito.setUsuario(user);//agrego el usuario
		     
		     productoFavoritoDao.insertarFavorito(productoFavorito);//inserto el producto en productos favoritos
		     
		     ratt.addFlashAttribute("mensaje", "El producto se ha añadido como favorito");
		     }		     
	     	     	   
	     Empresa empresa = empresaDao.buscarUnaEmpresa(1);//busco la empresa en la BBDD para sacar todos los datos de ella
	     ratt.addFlashAttribute("empresa", empresa);//agrego la empresa en un atributo para sacar los datos en la vista

	     return "redirect:/misProductosFavoritos";
	     }
	 
	 
	 
		
		/**
		 * Metodo que utilizaremos para agregar un comentario del producto
		 * 
		 * @author Maria Isabel
		 * 
		 * @param idProductos id del producto que nos entra por parametros a traves de la url
		 * 
		 * @param session parametro para poder agregar un atributo en session y poder acceder a el mientras la
		 * session este abierta
		 * 
		 * @param ratt parametro que utilizamos para agregar atributos o sacar mensajes en las vistas
		 * 
		 * @param request parametro que usamos para recoger los datos strings del formulario
		 * 
		 * @return una vez agregado nuestro comentario del producto nos va a devolver a la vista detalle del
		 * producto con nuestro mensaje agregado
		 */
		@PostMapping ("/comentar/{id}")
	    public String comentar(@PathVariable("id") int idProductos, 
	    						HttpSession session, RedirectAttributes ratt, HttpServletRequest request) {	
			
			Usuario user = (Usuario) session.getAttribute("usuario");//saco el usuario de la session con el atributo session
			
			Producto producto = productoDao.buscarUnProducto(idProductos);//busco el producto con la id que nos entra por parametros

			Comentario comentario = new Comentario();//creo un nuevo comentario
	        comentario.setFecha(new Date());//agrego la fecha de hoy en el comentario
	        comentario.setEstado("a"); //agrego el estado "a" = activo en el comentario
	        comentario.setComentario(request.getParameter("comentario"));//recogo el comentario que se ha escrito en el formulario
	        comentario.setProducto(producto);//agrego el producto
	        comentario.setUsuario(user);//agrego el usuario
	        comentario.setValoracion(request.getParameter("valoracion"));//recogo la valoracion que se ha hecho en el formulario

	        comentarioDao.insertarComentario(comentario);//inserto el comentario en comentarios	        

	        return "redirect:/productos/verUno/{id}"; 
	    }
		
		
		
		
		/**
		 * Metodo que utilizaremos para mostrar la pagina carro con todos los productos que tenemos
		 * 
		 * @author Maria Isabel
		 * 
		 * @param model parametro que utilizamos para agregar atributos o sacar mensajes en las vistas
		 * 
		 * @param session parametro para poder agregar un atributo en session y poder acceder a el mientras la
		 * session este abierta
		 * 
		 * @return nos devuelve la vista carro con todos nuestros productos que queremos comprar, en caso de no
		 * tener productos nos mostrara una pagina vacia
		 */
		@GetMapping("/carro")
		 public String mostrarCarro (Model model, HttpSession session) {
			
			 Empresa empresa = empresaDao.buscarUnaEmpresa(1);//busco la empresa en la BBDD para sacar todos los datos de ella
		     model.addAttribute("empresa", empresa);//agrego la empresa en un atributo para sacar los datos en la vista
		     
			 Usuario user = (Usuario) session.getAttribute("usuario");//saco los datos de usuario del atributo session
			 
			 Pedido pedido = pedidoDao.buscarPedidoPorUsuarioEstado(user, "a");//busco el pedido del usuario que este "a" = activo
			 model.addAttribute("pedidos", pedido);//agrego el pedido en un atributo para sacar los datos en las vistas
			 
			 List <ProductoPedido> listaCarro = productoPedidoDao.mostrarProductosPorPedido(pedido);//busco todos los productos que tiene el pedido
			 model.addAttribute("listadoCarrito", listaCarro);//agrego los productos en un atributo para sacar los datos en la vista
			 
			 System.out.println(listaCarro);
			 /**
			  * en el caso de que el pedido no tenga productos sacara la vista carro vacio
			  * que contiene un mensaje de carro vacio, sino voy a sacar el carro con todos
			  * los productos que he agregado en el carro
			  */
			 if(productoPedidoDao.mostrarProductosPorPedido(pedido).isEmpty()) {
				 return "CarritoVacio";
				 
			 }else {
				 return "Carrito";
			 }
			 	  
		 }
		
		
		/**
		 * Metodo que utilizaremos para eliminar productos de nuestro carro
		 * 
		 * @author Maria Isabel
		 * 
		 * @param idCarro id del producto en el carro que nos entra por parametros a traves de la url
		 * 
		 * @param model parametro que utilizamos para agregar atributos o sacar mensajes en las vistas
		 * 
		 * @return nos devuelve a la vista del carro con nuestro producto eliminado del carro
		 * 
		 */
		@GetMapping("/cancelar/carrito/{id}")
		public String eliminarProductoCesta(@PathVariable("id") int idCarro, Model model) {
			
			ProductoPedido prodpedi = productoPedidoDao.buscarUnProdPedi(idCarro);//busco el producto que esta en la cesta utilizando el id que nos entra por parametros
			
			
			/**
			 * si el producto no es nulo procedere a eliminarlo del carro devolviendo
			 * la cantidad comprada a la tienda, si es nulo sacare un mensaje de error
			 */
			if(prodpedi != null) {
				int cantidad = prodpedi.getCantidad();//recogo la cantidad de productos que hay en el carro
				Producto prod = prodpedi.getProducto();//recogo el producto que es
				int cantTienda = prod.getCantidadMaxima();//recogo la cantidad de productos que hay en la tienda
				int cantTotal = cantTienda + cantidad;//le sumo la cantidad de productos que habia comprado el usuario
				prod.setCantidadMaxima(cantTotal);//agrego la nueva cantidad al producto
				productoDao.modificarProducto(prod);//modifico el producto
				productoPedidoDao.eliminarProdPedi(idCarro);//elimino el producto del carro
				
				model.addAttribute("mensaje", "El producto ha sido eliminado de la cesta");
			}else {
				model.addAttribute("mensajeError", "El producto no se ha podido eliminar de la cesta");
			}
			
			
			return "forward:/carro";
		}





}
