package unir.grupo6.pecoVerduras.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import jakarta.servlet.http.HttpSession;
import unir.grupo6.pecoVerduras.modeloDao.PerfilDao;
import unir.grupo6.pecoVerduras.modeloDao.ProductoDao;
import unir.grupo6.pecoVerduras.modeloDao.UsuarioDao;
import unir.grupo6.pecoVerduras.modeloEntity.Perfil;
import unir.grupo6.pecoVerduras.modeloEntity.Producto;
import unir.grupo6.pecoVerduras.modeloEntity.Usuario;


/**
 * Controlador que nos llevara toda las gestiones de subida de archivos a nuestro proyecto
 * 
 * @author Gerard Perujo
 */
@Controller
public class subidaArchivos {
	
	 // diferentes rutas donde se guardaran los archivos que se suban
	
    private static String ruta = ".//src//main//resources//static//archivos//";
    
    private static String rutaImagen = ".//src//main//resources//static//css//imagenes//Productos//";
    
    private static String rutaImagenDetalle = ".//src//main//resources//static//css//imagenes//Productos//";
    
    
    //rutas que se agregaran en la BBDD de donde se encuentran los archivos que se hayan subido
    private static String rutaBbddImagen = "/css/imagenes/Productos/";
    
    private static String rutaBbddImagenDetalle = "/css/imagenes/Productos/";
    
    
    /**
	 * Importamos la clase PerfilDao para poder acceder a todos los metodos que tiene
	 */
    @Autowired
    private PerfilDao perfidao;
    
    
    /**
	 * Importamos la clase UsuarioDao para poder acceder a todos los metodos que tiene
	 */
    @Autowired
    private UsuarioDao usudao;
    
    /**
	 * Importamos la clase ProductoDao para poder acceder a todos los metodos que tiene
	 */
    @Autowired
    private ProductoDao produdao;
    
    
    /**
     * Metodo que utilizaremos para agregar los archivos que nos suban desde pecoClub a nuestra aplicacion
     * 
     * @author Gerard Perujo
     * 
     * @param file parametro que utilizaremos para poder acceder al nombre del archivo que se esta subiendo, y su
     * tamaño
     * 
     * @param redirectAttributes parametro que utilizamos para agregar atributos o sacar mensajes en las vistas
     * 
     * @param session parametros que utilizaremos para agregar el usuario en la session y poder acceder
	 * a sus datos hasta que cerremos la session
     * 
     * @return nos devuelve a la vista pecoClub en caso de que el ususario sea rol cliente va a cambiarle el rol
     * a rol_familia y nos subira los archivos a nuestra aplicacion web, si el ususario no es rol cliente no se va
     * a cambiar el rol y tampoco se subiran archivos
     */
    @PostMapping("/pecoClub")
    public String handleFileUpload(@RequestParam("familia") MultipartFile file,
                                   RedirectAttributes redirectAttributes, HttpSession session) {
    	
    	Usuario user = (Usuario) session.getAttribute("usuario");//cogo el ususario que esta en session
    	Usuario usuario = usudao.buscarUnUsuario(user.getUsername());// recogo el nombre del usuario en una variable
    	
 
    	/*
    	 * en caso de que el archivo subido este vacio nos sacara un mensaje de error
    	 */
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("mensajeError", "No has cargado ningun Archivo");
            return "redirect:pecoClub";
        }
        
        
		String rol = " ";
        
        Authentication aut = SecurityContextHolder.getContext().getAuthentication();
        
        /**
         * recorro el authorities para poder coger el rol de nuestro usuario
         */
        for (GrantedAuthority roles : aut.getAuthorities()) {
             rol = roles.getAuthority();
        }
        
        
        Perfil perfi = new Perfil();
        
        /*
         * En caso de que el cliente tenga el rol cliente ejecutaremos el if
         */
        if (rol.equals("ROLE_CLIENTE")) {
        	
        	/*
        	 * recorro los perfiles comparando si el perfil del ususario es rol cliente, en caso 
        	 * afirmativo le cambio el perfil al 4 = role_familia
        	 */
            List<Perfil> perfiles = usuario.getPerfiles();
            for (Perfil perfil : perfiles) {
                if (perfil.getNombre().equals("ROLE_CLIENTE")) {
                   perfi = perfidao.buscarUnPerfil(4);
                   break;
                }
            }
            
            /*
             * hago una comprobacion por si el perfil estuviera nullo, en ese caso
             * sacariamos un mensaje de error sino procedo agregar el perfil al ususario
             */
            if(perfi != null) {
            	usuario.getPerfiles().clear();
            	usuario.addPerfil(perfi);
            	
            	
            	
            	/*
            	 * hago un try catch para la subida de archivo ya que estas acciones levantan execpciones
            	 */
                try {
                    // Guardar el archivo en el directorio especificado
                    byte[] bytes = file.getBytes(); // cogo el tamaño del archivo que nos entra
                    Path path = Paths.get(ruta + file.getOriginalFilename());// agrego el nombre del archivo a la ruta
                    String rutaBbdd = ruta + file.getOriginalFilename();// agrego la ruta en un string para subirlo a la BBDD
                    Files.write(path, bytes);// subo el archivo pasandole la ruta y el tamaño
                    usuario.setArchivoFamilia(rutaBbdd);// agrego la ruta al usuario donde se encuentra el archivo

                    redirectAttributes.addFlashAttribute("mensaje",
                            "El Archivo se ha cargado correctamente");

                } catch (IOException e) {
                    e.printStackTrace();
                    redirectAttributes.addFlashAttribute("mensaje",
                            "mensaje de error");
                }
            }
            
            /*
             * utilizo un modificar usuario para agregar la ruta donde se encuentra el archivo dentro de 
             * nuestr aplicacion
             */
            usudao.modificarUsuario(usuario); 
          
           
        }else {
            redirectAttributes.addFlashAttribute("mensajeError",
                    "No puedes ser Cliente Familia, porque no eres un Rol cliente");
        }

    
        /*
         * devuelvo la vista pecoClub una vez se ha realizado todo
         */
        return "redirect:/pecoClub";
    }
    
    /**
     * Metodo que usaremos para subir las imagenes de nuestros productos o modificar alguna imagen de un producto
     * ya existente
     * 
     * @author Gerard Perujo
     * 
     * @param idProducto hace referencia al id de nuestro producto que nos entra
     * 
     * @param ratt parametro que utilizamos para agregar atributos o sacar mensajes en las vistas
     * 
     * @param imagen hace referencia a la imagen de nuestras targetas que contiene el nombre del archivo
     * 
     * @param imagenDetalle hace referencia a la imagen de nuestras paginas detalle que contiene el nombre del archivo
     * 
     * @return nos devuelve la vista gestion/producto despues de subir las imagenes dentro de nuestra aplicacion, en
     * caso de que no se subieran nos devolvera un mensaje de error en nuestra vista
     */
    @PostMapping("/agregar/imagenproducto/{id}")
    public String subirImagenProducto(@PathVariable("id") int idProducto, RedirectAttributes ratt, 
    		@RequestParam("imagen")MultipartFile imagen, @RequestParam("imagenDetalle") MultipartFile imagenDetalle) {
    	
    	Producto prod = produdao.buscarUnProducto(idProducto);//busco el producto con la id que nos entra
    	
    	/**
    	 * hago un try catch ya que la subida de archivo siempre genera execpciones
    	 */
    	try {
            
    		/**
    		 * en caso de que el archivo que nos suban estuviera vacio no hago nada
    		 */
    		if (imagen.isEmpty()) {
    			
    		}else {
    		    byte[] bytesImagen = imagen.getBytes();//recogo el tamaño del archivo que nos suben
                Path pathImagen = Paths.get(rutaImagen + imagen.getOriginalFilename());//agrego el nombre del archivo a la ruta
                String imagenRuta = rutaBbddImagen + imagen.getOriginalFilename();//meto la ruta de nuestro archivo en un string
                Files.write(pathImagen, bytesImagen);//subo el archivo a nuestra aplicacion pasandole la ruta y el tamaño
                
                prod.setImagen(imagenRuta);// agrego el string con la ruta en nuestro producto para saber donde se encuentra
                produdao.modificarProducto(prod);//modifico el producto con la ruta de nuestro archivo
    		}
    		
    		/**
    		 * en caso de que el archivo imagendetalle estuviera vacio no hago nada
    		 */
            if(imagenDetalle.isEmpty()) {
            	
            }else {
            	 byte[] bytesImagenDetalle = imagenDetalle.getBytes();//recogo el tamaño del archivo que nos suben
                 Path pathImagenDetalle = Paths.get(rutaImagenDetalle + imagenDetalle.getOriginalFilename());//agrego el nombre del archivo a la ruta
                 String imagenRutaDetalle = rutaBbddImagenDetalle + imagenDetalle.getOriginalFilename();//meto la ruta de nuestro archivo en un string
                 Files.write(pathImagenDetalle, bytesImagenDetalle);//subo el archivo a nuestra aplicacion pasandole la ruta y el tamaño
                 
                 prod.setImagenDetalle(imagenRutaDetalle);// agrego el string con la ruta en nuestro producto para saber donde se encuentra
                 produdao.modificarProducto(prod);//modifico el producto con la ruta de nuestro archivo
            }
           
            /**
             * devuelvo un mensaje en caso de que todo haya salido correcto
             */
            ratt.addFlashAttribute("mensaje",
                    "El Archivo se ha cargado correctamente");

        } catch (IOException e) {
            e.printStackTrace();
            ratt.addFlashAttribute("mensajeError",
                    "No se ha podido agregar");
        }
    	
    	
    	/*
         * devuelvo la vista gestion/producto una vez se ha realizado todo
         */
    	return "redirect:/gestion/producto";
    }


}
