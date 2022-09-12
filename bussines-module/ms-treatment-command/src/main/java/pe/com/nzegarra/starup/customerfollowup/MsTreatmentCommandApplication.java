package pe.com.nzegarra.starup.customerfollowup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableEurekaClient
@RefreshScope
//@EnableReactiveMongoRepositories
public class MsTreatmentCommandApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsTreatmentCommandApplication.class, args);
	}

}
