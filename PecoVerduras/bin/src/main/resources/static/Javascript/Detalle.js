//Para que en la descripcion cada linea solo tenga una frase.
document.addEventListener("DOMContentLoaded", function() {
    const descripcion = document.querySelector('.Descripcion');
    if (descripcion) {
        descripcion.innerHTML = descripcion.innerText.replace(/\. /g, '.<br>');
    }
});

//Slider comentarios Maribel en ver un producto
$(document).ready(function(){
		if(document.querySelector(".contenedorComentarios")){
				$('.ContenedorTarjetas').slick({
  					infinite: true,
  					slidesToShow: 2,
  					slidesToScroll: 2,
  					responsive: [
    				{
						breakpoint: 1265,
      					settings: {
        					slidesToShow: 1,
        					slidesToScroll: 1,
        					infinite: true,
        					dots: true
							}
						}]
				});
			}
		}) 