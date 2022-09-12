package pe.com.nzegarra.starup.customerfollowup.msproductmanagement.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;

import pe.com.nzegarra.starup.customerfollowup.msproductmanagement.core.domain.Presentation;
import pe.com.nzegarra.starup.customerfollowup.msproductmanagement.core.service.PresentationService;
import pe.com.nzegarra.starup.customerfollowup.msproductmanagement.core.service.PresentationServiceImpl;
import pe.com.nzegarra.starup.customerfollowup.msproductmanagement.core.service.ProductCategoryService;
import pe.com.nzegarra.starup.customerfollowup.msproductmanagement.core.service.ProductCategoryServiceImpl;
import pe.com.nzegarra.starup.customerfollowup.msproductmanagement.core.service.ProductService;
import pe.com.nzegarra.starup.customerfollowup.msproductmanagement.core.service.ProductServiceImpl;
import pe.com.nzegarra.starup.customerfollowup.msproductmanagement.delivery.PresentationController;
import pe.com.nzegarra.starup.customerfollowup.msproductmanagement.delivery.ProductCategoryController;
import pe.com.nzegarra.starup.customerfollowup.msproductmanagement.delivery.ProductController;
import pe.com.nzegarra.starup.customerfollowup.msproductmanagement.infraestructure.PresentationRepository;
import pe.com.nzegarra.starup.customerfollowup.msproductmanagement.infraestructure.ProductCategoryRepository;
import pe.com.nzegarra.starup.customerfollowup.msproductmanagement.infraestructure.ProductRepository;
import pe.com.nzegarra.starup.customerfollowup.msproductmanagement.infraestructure.adapter.PresentationAdapter;
import pe.com.nzegarra.starup.customerfollowup.msproductmanagement.infraestructure.adapter.ProductAdapter;
import pe.com.nzegarra.starup.customerfollowup.msproductmanagement.infraestructure.adapter.ProductCategoryAdapter;
import pe.com.nzegarra.starup.customerfollowup.msproductmanagement.infraestructure.dao.PresentationDao;
import pe.com.nzegarra.starup.customerfollowup.msproductmanagement.infraestructure.dao.ProductCategoryDao;
import pe.com.nzegarra.starup.customerfollowup.msproductmanagement.infraestructure.dao.ProductDao;

@Configuration
@EnableAutoConfiguration
public class SpringConfig {

	@Autowired
	private ProductCategoryDao productCategoryDao;
	
	@Autowired
	private PresentationDao presentationDao;
	
	@Autowired
	private ProductDao productDao;
	
	@Bean
	public JsonMapper jsonMapper() {
		return JsonMapper.builder().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).build();
		//return new JsonMapper();
	}
	
	@Bean
	public ProductCategoryRepository productCategoryRepository() {
		return new ProductCategoryAdapter(jsonMapper(), productCategoryDao);
	}
	
	@Bean
	public PresentationRepository presentationRepository() {
		return new PresentationAdapter(jsonMapper(), presentationDao);
	}
	
	@Bean
	public ProductRepository productRepository() {
		return new ProductAdapter(jsonMapper(), productDao, productCategoryDao, presentationDao);
	}
	
	@Bean
	public ProductCategoryService productCategoryService() {
		return new ProductCategoryServiceImpl(productCategoryRepository());
	}
	
	@Bean
	public PresentationService presentationService() {
		return new PresentationServiceImpl(presentationRepository());
	}
	
	@Bean
	public ProductService productService() {
		return new ProductServiceImpl(productRepository());
	}
	
	@Bean
	public PresentationController presentationController() {
		return new PresentationController(presentationService(), jsonMapper());
	}
	
	@Bean
	public ProductCategoryController productCategoryController() {
		return new ProductCategoryController(productCategoryService(), jsonMapper());
	}
	
	@Bean
	public ProductController productController() {
		return new ProductController(productService(), jsonMapper());
	}
}
