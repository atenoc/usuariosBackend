package mx.ateno.springboot.apirest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication												// inicializa la aplicación
@ComponentScan(basePackages= {"mx.ateno.springboot.apirest"})		// escanea todos los componentes en el paquete raiz y los paquetes que contenga
public class AtenoSpringbootUsuariosApplication{
	
	// método principal
	public static void main(String[] args) {
		SpringApplication.run(AtenoSpringbootUsuariosApplication.class, args);
	}

}
