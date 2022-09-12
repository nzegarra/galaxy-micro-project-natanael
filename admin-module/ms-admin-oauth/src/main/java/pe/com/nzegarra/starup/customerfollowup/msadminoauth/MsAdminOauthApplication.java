package pe.com.nzegarra.starup.customerfollowup.msadminoauth;

import java.util.Arrays;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableEurekaClient
//@EnableFeignClients
public class MsAdminOauthApplication implements CommandLineRunner{

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(MsAdminOauthApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String strPass = "123";
		for (int i = 0; i < 4; i++) {
			System.out.println(passwordEncoder.encode(strPass));
		}
	}

}
