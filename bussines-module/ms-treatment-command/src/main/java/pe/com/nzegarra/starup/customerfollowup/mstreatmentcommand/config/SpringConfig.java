package pe.com.nzegarra.starup.customerfollowup.mstreatmentcommand.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;

import pe.com.nzegarra.starup.customerfollowup.mstreatmentcommand.core.service.TreatmentService;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentcommand.core.service.TreatmentServiceImpl;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentcommand.delivery.TreatmentController;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentcommand.infraestructure.TreatmentRepository;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentcommand.infraestructure.adapter.TreatmentAdapter;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentcommand.infraestructure.dao.TreatmentDao;

@Configuration
@EnableAutoConfiguration
public class SpringConfig {

//	@Autowired
	private TreatmentDao treatmentDao;
	
	
	@Bean
	public JsonMapper jsonMapper() {
		return JsonMapper.builder().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).build();
		//return new JsonMapper();
	}
	
	@Bean
	public TreatmentRepository treatmentRepository() {
		return new TreatmentAdapter(jsonMapper(), treatmentDao);
	}
	
	
	@Bean
	public TreatmentService treatmentService() {
		return new TreatmentServiceImpl(treatmentRepository());
	}
	
	
	@Bean
	public TreatmentController treatmentController() {
		return new TreatmentController(treatmentService(), jsonMapper());
	}
	
}
