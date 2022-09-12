package pe.com.nzegarra.starup.customerfollowup.msadmingatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MsAdminGatewayServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsAdminGatewayServerApplication.class, args);
	}

}
