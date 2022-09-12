package pe.com.nzegarra.starup.customerfollowup.msproductmanagement.delivery.http;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import pe.com.nzegarra.starup.customerfollowup.msproductmanagement.core.domain.input.ProductCategoryRequest;
import pe.com.nzegarra.starup.customerfollowup.msproductmanagement.core.domain.output.GeneralResponse;
import pe.com.nzegarra.starup.customerfollowup.msproductmanagement.core.domain.output.MessageResponse;
import pe.com.nzegarra.starup.customerfollowup.msproductmanagement.core.domain.output.ProductCategoryResponse;
import pe.com.nzegarra.starup.customerfollowup.msproductmanagement.core.util.ProductConstants;
import pe.com.nzegarra.starup.customerfollowup.msproductmanagement.delivery.ProductCategoryController;

@Slf4j
@RestController
@RequestMapping(ProductConstants.API_PRODUCT_CATEGORY)
public class ProductCategoryRestController {

	private ProductCategoryController ProductCategoryController;

	public ProductCategoryRestController(ProductCategoryController ProductCategoryController) {
		this.ProductCategoryController = ProductCategoryController;
	}
	
	@PostMapping
	public ResponseEntity<GeneralResponse> save(@RequestBody ProductCategoryRequest productCategoryRequest){
		ProductCategoryResponse customerResponse = new ProductCategoryResponse();
//		try {
			customerResponse = ProductCategoryController.save(productCategoryRequest);
			return ResponseEntity.status(HttpStatus.CREATED).body(mapGeneralResponse(customerResponse));
//		}catch(Exception e) {
//			log.error(e.getMessage());
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(mapGeneralResponse(customerResponse));
//		}
	}
	
	
	@GetMapping
	public ResponseEntity<GeneralResponse> findAll(){
		List<ProductCategoryResponse> customerResponses = new ArrayList<>();
		
//		try {
			customerResponses = ProductCategoryController.findAll();
			return ResponseEntity.status(HttpStatus.OK).body(mapListProductCategoryResponse(customerResponses));
//		}catch(Exception e) {
//			log.error(e.getMessage());
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(mapListProductCategoryResponse(customerResponses));
//		}
	}
	
	
	private GeneralResponse mapGeneralResponse(ProductCategoryResponse customerResponse) {
		GeneralResponse response = null;
		try {
			response = GeneralResponse.builder()
					.response(MessageResponse.builder().code(ProductConstants.CODE_SUCCES).message(ProductConstants.MSG_SUCCES).build())
					.data(customerResponse)
					.build();
		}catch(Exception e) {
			log.error("Ocurrió un error" + e.getMessage());
			response = GeneralResponse.builder()
				.response(MessageResponse.builder().code(ProductConstants.CODE_ERROR).message(ProductConstants.MSG_ERROR).build())
				.build();
		}
		return response;
		
	}
	
	private GeneralResponse mapListProductCategoryResponse(List<ProductCategoryResponse> customerResponses) {
		GeneralResponse response = null;
		try {
			response = GeneralResponse.builder()
					.response(MessageResponse.builder().code(ProductConstants.CODE_SUCCES).message(ProductConstants.MSG_SUCCES).build())
					.data(customerResponses)
					.build();
		}catch(Exception e) {
			log.error("Ocurrió un error" + e.getMessage());
			response = GeneralResponse.builder()
				.response(MessageResponse.builder().code(ProductConstants.CODE_ERROR).message(ProductConstants.MSG_ERROR).build())
				.build();
		}
		return response;
		
	}
}
