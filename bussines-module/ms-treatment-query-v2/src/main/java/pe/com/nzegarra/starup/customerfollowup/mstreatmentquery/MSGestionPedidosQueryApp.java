package pe.com.nzegarra.starup.customerfollowup.mstreatmentquery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@RefreshScope
@SpringBootApplication
@EnableCaching
public class MSGestionPedidosQueryApp {

	public static void main(String[] args) {
		SpringApplication.run(MSGestionPedidosQueryApp.class, args);
	}

}
