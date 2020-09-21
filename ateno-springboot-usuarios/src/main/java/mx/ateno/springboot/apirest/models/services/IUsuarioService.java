package mx.ateno.springboot.apirest.models.services;

import java.util.List;

import mx.ateno.springboot.apirest.models.entity.Usuario;

// definimos la interfaz Usuario para definir el patron a implementar en el servicio (métodos abstractos)
public interface IUsuarioService {

	public List<Usuario> findAll();
	public Usuario findById(Long id);
	public Usuario save(Usuario usuario);
}
