package mx.ateno.springboot.apirest.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import mx.ateno.springboot.apirest.models.entity.Usuario;
import org.springframework.http.HttpStatus;

import mx.ateno.springboot.apirest.models.services.IUsuarioService;

@CrossOrigin (origins = {"http://localhost:4200"})      // origen del dominio que puede enviar y recibir datos (Angular)
@RestController											// definimos esta clase como un controlador de tipo rest
@RequestMapping("/api")									// definimos la ruta principal
public class UsuarioRestController {

	@Autowired											// inyectamos el servicio usuario
	private IUsuarioService usuarioservice;				
	
	@GetMapping("/usuarios")							// mapeamos la ruta para obtener los usuarios, tipo GET
	public List<Usuario> usuarios(){
		return usuarioservice.findAll();				// devolvemos la lista de todos los usuarios registrados
	}
	
	@PostMapping("/usuarios")							// mapeamos la ruta para agregar usuarios, tipo POST
	@ResponseStatus(HttpStatus.CREATED)					// definimos el estado a devolver
	public ResponseEntity<?> create(@RequestBody Usuario usuario) {			// definimos una entidad generica, y obtenemos el json con request boby
		
		Usuario usuarioNew = null;
		Map<String, Object> response = new HashMap<>();		// creamos un mapa, para asignar la respuesta 
		
		try {
			usuarioNew = usuarioservice.save(usuario);		// mediante el servicio inyectado realizamos la opreacion para crear el usuario 
		}catch (DataAccessException dae) {					// capturamos un posible error
			response.put("mensaje", "Error al insertar en la Base de Datos");
			response.put("error", dae.getMessage().concat(": ").concat(dae.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);  // retornamos la respuesta del error
		}
		
		// si no hay errores, devolvemos la respuesta de éxito
		
		response.put("mensaje", "El Usuario ha sido insertado con éxito");
		response.put("usuario", usuarioNew);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
}
