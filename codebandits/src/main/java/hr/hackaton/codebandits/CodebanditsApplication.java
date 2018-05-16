package hr.hackaton.codebandits;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("hr.hackaton.codebandits") //used to scan the specified package for repos
@EntityScan("hr.hackaton.codebandits") //used to pick up our JPA entities
@SpringBootApplication
public class CodebanditsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodebanditsApplication.class, args);
	}
}
