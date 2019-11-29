
$(document).ready(inicio);

function inicio(){
	Datos();
}

function Datos(){
	$.ajax({
		url: "/consulta/all",
		method:"Get",
		success:function(response){
			$("#cdatos").html("");
			response.forEach(i=>{
				$("#cdatos").append(""
				  +"<tr>"
				  	+"<td>"+ i.id + "</td>"
				  	+"<td>"+ i.fecha + "</td>"
				  	+"<td>"+ i.sintomas + "</td>"
				  	+"<td>"+ i.diagnostico + "</td>"
				  	+"<td>"+ i.idDoctor.nombre + "</td>"
				  	+"<td>"+ i.paciente.nombre + "</td>"
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