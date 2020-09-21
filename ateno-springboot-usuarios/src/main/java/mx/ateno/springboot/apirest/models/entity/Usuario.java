package mx.ateno.springboot.apirest.models.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// definimos la entidad, para crear la tabla en la base de datos definido en el archivo .properties

@Entity
@Table(name="usuarios")
public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 1L; 
	
	@Id														// definimos este campo como id
	@GeneratedValue(strategy = GenerationType.IDENTITY)		// proporcionamos la forma de creacion del id
	private Long id;
	
	@Column(nullable=false, length=30)						// el nombre no puede ser nulo y debe contener un tamaño de 30 caracteres
	private String nombre;
	
	@Column(length=30)
	private String apellido;
	
	@Column(length=5)
	private Long edad;
	
	@Column(length=20)
	private String sexo;
	
	@Column(nullable=false, unique=true, length=40) 		// el correo no puede ser nulo ni repetible
	private String correo;
	
	@Column(length=200)
	private String password;
	
	public Long getId() {									// asignamos getters y settes 
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Long getEdad() {
		return edad;
	}

	public void setEdad(Long edad) {
		this.edad = edad;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

