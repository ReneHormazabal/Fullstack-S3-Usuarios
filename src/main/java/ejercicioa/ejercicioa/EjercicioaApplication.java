package ejercicioa.ejercicioa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Considerar un microservicio donde se realicen registros de usuario con sus respectivos roles y 
// direcciones de despacho. Se deben realizar las respectivas validaciones de los datos ingresados
//  ya que serán manipulados para una futura aplicación de tienda online con despacho a domicilio. 
// También debe contener un módulo de inicio de sesión.

@SpringBootApplication
public class EjercicioaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EjercicioaApplication.class, args);
	}

}
