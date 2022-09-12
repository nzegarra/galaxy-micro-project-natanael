package pe.com.nzegarra.starup.customerfollowup.msproductmanagement.delivery.http;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import pe.com.nzegarra.starup.customerfollowup.msproductmanagement.core.domain.input.ProductRequest;
import pe.com.nzegarra.starup.customerfollowup.msproductmanagement.core.domain.output.GeneralResponse;
import pe.com.nzegarra.starup.customerfollowup.msproductmanagement.core.domain.output.MessageResponse;
import pe.com.nzegarra.starup.customerfollowup.msproductmanagement.core.domain.output.ProductResponse;
import pe.com.nzegarra.starup.customerfollowup.msproductmanagement.core.util.ProductConstants;
import pe.com.nzegarra.starup.customerfollowup.msproductmanagement.delivery.ProductController;

@Slf4j
@RestController
@RequestMapping(ProductConstants.API_PRODUCT)
public class ProductRestController {

	private ProductController productController;

	public ProductRestController(ProductController productController) {
		this.productController = productController;
	}
	
	@PostMapping
	public ResponseEntity<GeneralResponse> save(@RequestBody ProductRequest productRequest){
		ProductResponse customerResponse = new ProductResponse();
//		try {
			customerResponse = productController.save(productRequest);
			return ResponseEntity.status(HttpStatus.CREATED).body(mapGeneralResponse(customerResponse));
//		}catch(Exception e) {
//			log.error(e.getMessage());
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(mapGeneralResponse(customerResponse));
//		}
	}
	
	@DeleteMapping("/{Id}")
	public ResponseEntity<GeneralResponse> deleteById(@PathVariable("Id") final Long id){
//		try {
			GeneralResponse response = productController.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).body(response);
//		}catch(Exception e) {
//			log.error(e.getMessage());
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(mapGeneralResponse(customerResponse));
//		}
	}
	
	@GetMapping
	public ResponseEntity<GeneralResponse> findAll(){
		List<ProductResponse> productResponses = new ArrayList<>();
		
//		try {
			productResponses = productController.findAll();
			return ResponseEntity.status(HttpStatus.OK).body(mapListProductResponse(productResponses));
//		}catch(Exception e) {
//			log.error(e.getMessage());
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(mapListProductResponse(productResponses));
//		}
	}
	
	@GetMapping("/{Id}")
	public ResponseEntity<GeneralResponse> findById(@PathVariable("Id") final Long id){
		ProductResponse customerResponse = new ProductResponse();
		
//		try {
			customerResponse = productController.findById(id);
			return ResponseEntity.status(HttpStatus.OK).body(mapGeneralResponse(customerResponse));
//		}catch(Exception e) {
//			log.error(e.getMessage());
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(mapGeneralResponse(customerResponse));
//		}
	}
	
	private GeneralResponse mapGeneralResponse(ProductResponse customerResponse) {
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
	
	private GeneralResponse mapListProductResponse(List<ProductResponse> productResponses) {
		GeneralResponse response = null;
		try {
			response = GeneralResponse.builder()
					.response(MessageResponse.builder().code(ProductConstants.CODE_SUCCES).message(ProductConstants.MSG_SUCCES).build())
					.data(productResponses)
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
