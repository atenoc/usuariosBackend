package mx.ateno.springboot.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import mx.ateno.springboot.apirest.models.entity.Usuario;

// extendemos de la interfaz de CrudRepository
public interface IUsuarioDao extends CrudRepository<Usuario, Long>{

}
