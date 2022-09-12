package pe.com.nzegarra.starup.customerfollowup.msadminuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MsAdminUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsAdminUserApplication.class, args);
	}

}
