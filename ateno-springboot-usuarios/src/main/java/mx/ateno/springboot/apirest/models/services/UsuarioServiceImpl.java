package mx.ateno.springboot.apirest.models.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mx.ateno.springboot.apirest.models.dao.IUsuarioDao;
import mx.ateno.springboot.apirest.models.entity.Usuario;
@Service														// registramos esta clase como servicio en el contexto de spring
public class UsuarioServiceImpl implements IUsuarioService{ 	// implementamos los métodos de la interfaz servicio
	
	@Autowired													// inyectamos 
	private	IUsuarioDao usuarioDao;								// la interfaz UsuarioDao, que implementa el crud hacia la base de datos

	@Override
	public List<Usuario> findAll() {
		return (List<Usuario>) usuarioDao.findAll();			// devolvemos toda la lista de los usuarios
	}

	@Override
	public Usuario save(Usuario usuario) {
		return usuarioDao.save(usuario);						// creamos un nuevo registro
	}
	
	public Usuario findById(Long id) {
		return usuarioDao.findById(id).orElse(null);			// buscamos por id
	}
}
