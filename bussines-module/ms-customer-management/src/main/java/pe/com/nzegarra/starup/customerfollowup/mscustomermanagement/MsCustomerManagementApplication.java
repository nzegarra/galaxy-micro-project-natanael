package pe.com.nzegarra.starup.customerfollowup.mscustomermanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
//@EntityScan("pe.com.nzegarra.starup.customerfollowup.commons.domain.entity")
public class MsCustomerManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsCustomerManagementApplication.class, args);
	}

}
