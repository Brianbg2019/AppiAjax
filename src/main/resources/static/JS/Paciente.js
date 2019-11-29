
$(document).ready(inicio);

function inicio(){
	Datos();
}

function Datos(){
	$.ajax({
		url: "/paciente/all",
		method:"Get",
		success:function(response){
			$("#pdatos").html("");
			response.forEach(i=>{
				$("#pdatos").append(""
				  +"<tr>"
				  	+"<td>"+ i.id + "</td>"
				  	+"<td>"+ i.nombre + "</td>"
				  	+"<td>"+ i.direccion + "</td>"
				  	+"<td><button class='btn btn-outline-warning'>Editar</button>" +
				  			"<button class='btn btn-outline-danger ml-2'>Eliminar</button></td>"
				  	
				  +"<tr>"
				  );
			});
		},
		error:function(response){
			alert("Error en la peticion" + response); 
		}
	});
}