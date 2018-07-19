package springbootresapi.springbootapiservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
//@ComponentScan("springbootresapi.springbootapiservice.repos")
@Configuration
public class SpringbootApiServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApiServiceApplication.class, args);
	}
}
