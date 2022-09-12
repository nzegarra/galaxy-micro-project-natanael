package pe.com.nzegarra.starup.customerfollowup.mscustomermanagement.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;

import pe.com.nzegarra.starup.customerfollowup.mscustomermanagement.core.service.CustomerService;
import pe.com.nzegarra.starup.customerfollowup.mscustomermanagement.core.service.CustomerServiceImpl;
import pe.com.nzegarra.starup.customerfollowup.mscustomermanagement.delivery.CustomerController;
import pe.com.nzegarra.starup.customerfollowup.mscustomermanagement.infraestructure.CustomerRepository;
import pe.com.nzegarra.starup.customerfollowup.mscustomermanagement.infraestructure.adapter.CustomerAdapter;
import pe.com.nzegarra.starup.customerfollowup.mscustomermanagement.infraestructure.dao.CustomerDao;
import pe.com.nzegarra.starup.customerfollowup.mscustomermanagement.infraestructure.dao.PersonDao;
import pe.com.nzegarra.starup.customerfollowup.mscustomermanagement.infraestructure.dao.PhoneDao;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"pe.com.nzegarra.starup.customerfollowup.mscustomermanagement.infraestructure"})
public class SpringConfig {

	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private PersonDao personDao;
	
	@Autowired
	private PhoneDao phoneDao;
	
	@Bean
	public JsonMapper jsonMapper() {
		return JsonMapper.builder().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).build();
		//return new JsonMapper();
	}
	
	@Bean
	public CustomerRepository customerRepository() {
		return new CustomerAdapter(jsonMapper(), customerDao, personDao, phoneDao);
	}
	
	@Bean
	public CustomerService customerService() {
		return new CustomerServiceImpl(customerRepository());
	}
	
	@Bean
	public CustomerController customerController() {
		return new CustomerController(customerService(), jsonMapper());
	}
}
