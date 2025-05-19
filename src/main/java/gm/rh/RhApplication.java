package gm.rh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RhApplication {

	public static void main(String[] args) {System.out.println("🚀 Iniciando backend en Railway...");
		SpringApplication.run(RhApplication.class, args);
		System.out.println("Backend iniciado correctamente.");
	}

}
