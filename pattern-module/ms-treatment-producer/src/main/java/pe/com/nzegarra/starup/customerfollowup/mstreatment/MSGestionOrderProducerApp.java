package pe.com.nzegarra.starup.customerfollowup.mstreatment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@RefreshScope
@SpringBootApplication
public class MSGestionOrderProducerApp {

	public static void main(String[] args) {
		SpringApplication.run(MSGestionOrderProducerApp.class, args);
	}

}
