package mx.maleficarum.brewcontrol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("mx.maleficarum.brewcommon.entity")
@EnableJpaRepositories("mx.maleficarum.brewcontrol.repository")
public class BrewControlApplication {

	public static void main(String[] args) {
		SpringApplication.run(BrewControlApplication.class, args);
	}

}
