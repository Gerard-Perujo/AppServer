package unir.grupo6.pecoVerduras.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;
import unir.grupo6.pecoVerduras.modeloDao.EmpresaDao;
import unir.grupo6.pecoVerduras.modeloEntity.Empresa;


/**
 * Controlador que nos va a gestionar la pagina de Error
 * 
 * @autor Gerard Perujo
 */
@ControllerAdvice
public class ErrorControler implements ErrorController{
	
	
	/**
	 * Importamos la clase EmpresaDao para poder acceder a todos los metodos que tiene
	 */
	@Autowired
	private EmpresaDao empresaDao;
	
		/**
		 * Metodo que nos va a devolver la vista de Error
		 * 
		 * @param model parametro que utilizamos para agregar atributos o sacar mensajes en las vistas
		 * 
		 * @return devuelve la vista de Error en caso de que el servicio solicitado no se haya encontrado
		 */
		@ExceptionHandler(NoHandlerFoundException.class)
	    public String handlerNoEncontrador(Model model) {
			
			Empresa emprea = empresaDao.buscarUnaEmpresa(1);//busco una empresa para sacar la información que nos hace falta en el footer
			model.addAttribute("empresa", emprea);
	     
	        return "Error";
	    }
		
		
		/**
		 * Metodo que nos va a devolver la vista error
		 * 
		 * @param model parametro que utilizamos para agregar atributos o sacar mensajes en las vistas
		 * 
		 * @return devuelve la vista Error en caso de que el servicio solicitado se haya levantado una exepcion
		 */
		@ExceptionHandler(Exception.class)
		public String handlerExepcion(Model model) {
			Empresa emprea = empresaDao.buscarUnaEmpresa(1);//busco una empresa para sacar la información que nos hace falta en el footer
			model.addAttribute("empresa", emprea);
	     
	        return "Error";
		}
	  
	
}
