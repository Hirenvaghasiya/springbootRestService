package springbootresapi.springbootapiservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan("springbootresapi.springbootapiservice.repos")
public class SpringbootApiServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApiServiceApplication.class, args);
	}
}
