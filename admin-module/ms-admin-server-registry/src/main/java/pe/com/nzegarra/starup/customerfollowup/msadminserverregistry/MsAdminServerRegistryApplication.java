package pe.com.nzegarra.starup.customerfollowup.msadminserverregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class MsAdminServerRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsAdminServerRegistryApplication.class, args);
	}

}
