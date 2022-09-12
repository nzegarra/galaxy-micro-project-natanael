package pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;

import pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.core.service.FrecuencyTypeService;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.core.service.FrecuencyTypeServiceImpl;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.core.service.TreatmentDetailService;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.core.service.TreatmentDetailServiceImpl;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.core.service.TreatmentService;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.core.service.TreatmentServiceImpl;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.delivery.FrecuencyTypeController;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.delivery.TreatmentController;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.delivery.TreatmentDetailController;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.infraestructure.FrecuencyTypeRepository;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.infraestructure.TreatmentDetailRepository;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.infraestructure.TreatmentRepository;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.infraestructure.adapter.FrecuencyTypeAdapter;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.infraestructure.adapter.TreatmentAdapter;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.infraestructure.adapter.TreatmentDetailAdapter;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.infraestructure.dao.FrecuencyTypeDao;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.infraestructure.dao.TreatmentDao;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.infraestructure.dao.TreatmentDetailDao;

@Configuration
@EnableAutoConfiguration
public class SpringConfig {

	@Autowired
	private TreatmentDao treatmentDao;
	
	@Autowired
	private FrecuencyTypeDao frecuencyTypeDao;
	
	@Autowired
	private TreatmentDetailDao treatmentDetailDao;
	
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
	public FrecuencyTypeRepository frecuencyTypeRepository() {
		return new FrecuencyTypeAdapter(jsonMapper(), frecuencyTypeDao);
	}
	
	@Bean
	public TreatmentDetailRepository treatmentDetailRepository() {
		return new TreatmentDetailAdapter(jsonMapper(), treatmentDetailDao, treatmentDao, frecuencyTypeDao);
	}
	
	@Bean
	public TreatmentService treatmentService() {
		return new TreatmentServiceImpl(treatmentRepository());
	}
	
	@Bean
	public FrecuencyTypeService frecuencyTypeService() {
		return new FrecuencyTypeServiceImpl(frecuencyTypeRepository());
	}
	
	@Bean
	public TreatmentDetailService treatmentDetailService() {
		return new TreatmentDetailServiceImpl(treatmentDetailRepository());
	}
	
	@Bean
	public FrecuencyTypeController frecuencyTypeController() {
		return new FrecuencyTypeController(frecuencyTypeService(), jsonMapper());
	}
	
	@Bean
	public TreatmentController treatmentController() {
		return new TreatmentController(treatmentService(), jsonMapper());
	}
	
	@Bean
	public TreatmentDetailController treatmentDetailController() {
		return new TreatmentDetailController(treatmentDetailService(), jsonMapper());
	}
}
