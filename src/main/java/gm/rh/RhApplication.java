package gm.rh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RhApplication {

	public static void main(String[] args) {System.out.println("🚀 Iniciando backend en Railway...");
		String port = System.getenv("PORT");
		if (port != null) {
			System.setProperty("server.port", port);
			System.out.println("✅ Puerto seteado desde env: " + port);
		} else {
			System.out.println("⚠️ No se encontró variable PORT, usando 8080 por defecto");
		}
		SpringApplication.run(RhApplication.class, args);
		System.out.println("✅ Backend iniciado correctamente.");
	}

}
