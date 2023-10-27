package projetojava.grupo4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@EnableFeignClients
@SpringBootApplication
public class Grupo4Application {

	public static void main(String[] args) {
		SpringApplication.run(Grupo4Application.class, args);
	}

}
