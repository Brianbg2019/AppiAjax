
$(document).ready(inicio);

function inicio(){
	Datos();
}

function Datos(){
	$.ajax({
		url: "/especialidad/all",
		method:"Get",
		success:function(response){
			$("#edatos").html("");
			response.forEach(i=>{
				$("#edatos").append(""
				  +"<tr>"
				  	+"<td>"+ i.id + "</td>"
				  	+"<td>"+ i.especialidad + "</td>"
				  	+"<td><button class='btn btn-outline-warning'>Editar</button></td>"
				  	+"<td><button class='btn btn-outline-danger ml-2'>Eliminar</button></td>"
				  	
				  +"<tr>"
				  );
			});
		},
		error:function(response){
			alert("Error en la peticion" + response); 
		}
	});
}