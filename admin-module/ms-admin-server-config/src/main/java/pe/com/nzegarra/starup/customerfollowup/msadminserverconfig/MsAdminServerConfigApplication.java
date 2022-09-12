package pe.com.nzegarra.starup.customerfollowup.msadminserverconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class MsAdminServerConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsAdminServerConfigApplication.class, args);
	}

}
