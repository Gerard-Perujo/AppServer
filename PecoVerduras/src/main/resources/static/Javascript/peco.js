window.onload = function(){

	if (document.querySelector(".comentariosNum")){
	let texto = contadorComent(".comentariosNum")
	let numeros = document.createTextNode(texto)
	numComentarios.appendChild(numeros)
	}
	
	if (document.querySelector(".direccionesNum")){
	let texto = contadorComent(".direccionesNum")
	let numeros = document.createTextNode(texto)
	numDirecciones.appendChild(numeros)
	}
	
	if (document.querySelector(".pedidosNum")){
	let texto = contadorComent(".pedidosNum")
	let numeros = document.createTextNode(texto)
	numPedidos.appendChild(numeros)
	}
	
	if (document.querySelector(".creditcardNum")){
	let texto = contadorComent(".creditcardNum")
	let numeros = document.createTextNode(texto)
	numcreditcard.appendChild(numeros)
	}
	
	
  // puntero del cursor
  const cursor = document.querySelector(".cursor")

  document.addEventListener("mousemove", (e) =>{
    let x = e.pageX;
    let y = e.pageY;
  
    cursor.style.top = y + "px";
    cursor.style.left = x + "px";
  });



  // cagramos el loader de carga de pagina
 $('#cargarLoad').fadeOut();


  // cargamos las diferentes funciones de javascript
	if(document.getElementById("pulsar1")){
		pulsar1.onmouseover = alturaContenedorPHeader;
 		pulsar1.onmouseout = salirAlturaContenedorPHeader;  
	}
	
	if(document.getElementById("pulsar2")){
		 pulsar2.onmouseover = alturaContenedorPHeader;
  		pulsar2.onmouseout = salirAlturaContenedorPHeader;  
	}
  	if(document.getElementById("pulsar3")){
		 pulsar3.onmouseover = alturaContenedorPHeader;
  		pulsar3.onmouseout = salirAlturaContenedorPHeader; 
	}
 	
 	if(document.getElementById("pulsar4")){
		pulsar4.onmouseover = alturaContenedorPHeader;
  		pulsar4.onmouseout = salirAlturaContenedorPHeader; 
	}
   
   if(document.getElementById("btnMovil")){
	btnMovil.onclick = abrirMenuMovil;
   }
   
   if(document.getElementById("btnCerrarMovil")){
	btnCerrarMovil.onclick = cerrarMenuMovil;
   }
  		
  		
  
  if(document.getElementById("cerrarContacto")){
	cerrarContacto.onclick = cerrarMensaje
  }
  
 	
 	quitarLogoDescuento()

  cargarImagenHeader()
  
  abrirMensaje();
  
	if(document.getElementById("imagenTargetaAgregar")){
		cargarImagenTargeta()
	}
	
	
	if(document.getElementById("imagenDetalleAgregar")){
		cargarImagenDetalle()
	}
		

}



	//Slider comentarios Gerard en la pagina Home
	$(document).ready(function(){
		if(document.querySelector(".tarjetaComentario")){
				$('.tarjetaComentario').slick({
  					infinite: true,
  					slidesToShow: 3,
  					slidesToScroll: 3,
  					responsive: [
    				{
						breakpoint: 1024,
      					settings: {
        					slidesToShow: 2,
        					slidesToScroll: 2,
        					infinite: true,
        					dots: true
							}
						},
						{
      						breakpoint: 850,
      							settings: {
        						slidesToShow: 1,
        						slidesToScroll: 1,
        						infinite: true,
        						dots: true
      					}}]
				});
			}
		})
		
		




function alturaContenedorPHeader(){
    console.log("dentrofuncion")
    let contenedor = document.querySelector(".gerardNavegadorPequeño")
    contenedor.style.height = "85px"
}

function salirAlturaContenedorPHeader(){
    console.log("dentrofuncion")
    let contenedor = document.querySelector(".gerardNavegadorPequeño")
    contenedor.style.height = "61px"
}


function abrirMenuMovil(){
  console.log("dentro de abrir menu")
  let menu = document.querySelector(".gerardMenuMobilActivo")
  let bloqueo = document.querySelector("body")
  let fondo = document.getElementById("fondoNegro")

  menu.style.opacity = "1"
  menu.style.visibility = "visible"
  menu.style.left = "0"
  bloqueo.style.overflow = "hidden"
  fondo.style.content= "''"
  fondo.style.width = "100%";
  fondo.style.height= "2000px"
  fondo.style.position = "fixed"
  fondo.style.backgroundColor = "rgba(0, 0, 0, 0.5)"
  fondo.style.zIndex = "1"
}




function cerrarMenuMovil(){
  let menu = document.querySelector(".gerardMenuMobilActivo")
  let bloqueo = document.querySelector("body")
  let fondo = document.getElementById("fondoNegro")

  menu.style.opacity = "0"
  menu.style.visibility = "hidden"
  menu.style.left = "-205px"
  bloqueo.style.overflow = "unset"

  fondo.style.backgroundColor = "transparent"
  fondo.style.zIndex = "-1"
}


function cargarImagenHeader(){
  let contenedor = document.getElementById("imagenHome")
  console.log("dentro cargar imagen")

  if(contenedor != null){
    let header1 = document.querySelector(".FondoHeader2")
    
    header1.style.display= "block"

    console.log("dentro primera imagen")

  }else{
	if(document.querySelector(".FondoHeader1")){
		 let header1 = document.querySelector(".FondoHeader1")
    
    	header1.style.display= "block";
    
    	console.log("dentro del else")
	}
   
  }
}


function abrirMensaje(){
	console.log("dentro funcion mensaje")
	
	if(document.querySelector(".MensajeEnviado")){
		let mostrar =document.querySelector(".MensajeEnviado")
		
		mostrar.style.opacity = "1";
		mostrar.style.visibility = "visible";
		mostrar.style.bottom = "0";
	}
	

}





function cerrarMensaje(){
	console.log("dentro funcion mensaje")
	let mostrar = document.querySelector(".MensajeEnviado")
	
	mostrar.style.opacity = "0";
	mostrar.style.visibility = "hidden";
	mostrar.style.bottom = "-400px";

}

/* */

/* ¿ES NECESARIO CREAR EL METODO REPETIDAMENTE PARA CADA TARJETA?*/
	function contadorComent(clase){
		let cantidad = document.querySelectorAll(clase); 
			return cantidad.length; 
	}
	
	function contadorDirect(clase){
		let cantidad = document.querySelectorAll(clase); 
			return cantidad.length; 
	}
	
		function contadorDirect(clase){
		let cantidad = document.querySelectorAll(clase); 
			return cantidad.length; 
	}
		function contadorDirect(clase){
		let cantidad = document.querySelectorAll(clase); 
			return cantidad.length; 
	}
	


function quitarLogoDescuento(){

	if(document.querySelector(".imagenDescuento")){
		console.log("dentro funcion quitar descuento")
		let contenedorDescuento = document.querySelectorAll(".imagenDescuento")
		
		contenedorDescuento.forEach(function(contenedor){
			let valor = contenedor.querySelectorAll(".logoDescuendo")
		
			valor.forEach(function(campo){
				console.log("dentro del bucle")
				console.log(campo.innerText)
				if(campo.innerText !== "s"){
					console.log("dentro del display")
					contenedor.style.display = "none";
					}
				
				
				});
			
				
			});
			
	
	}
}

function cargarImagenTargeta(){
	const imagendefecto = "/css/imagenes/Varias/imagenvacio.png"
	
	const archivo = document.getElementById("cargarImagenTargeta");
	const img = document.getElementById("imagenTargetaAgregar");
	archivo.addEventListener('change', e =>{
		if(e.target.files[0]){
			const leer = new FileReader();
			leer.onload = function(e){
				img.src = e.target.result;
			}
			leer.readAsDataURL(e.target.files[0])
		}else{
			img.src = imagendefecto;
		}
	})
}



function cargarImagenDetalle(){
	const imagendefecto = "/css/imagenes/Varias/imagenvacio.png"
	
	const archivo = document.getElementById("cargarImagenDetalle");
	const img = document.getElementById("imagenDetalleAgregar");
	archivo.addEventListener('change', e =>{
		if(e.target.files[0]){
			const leer = new FileReader();
			leer.onload = function(e){
				img.src = e.target.result;
			}
			leer.readAsDataURL(e.target.files[0])
		}else{
			img.src = imagendefecto;
		}
	})
}





