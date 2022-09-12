package pe.com.nzegarra.starup.customerfollowup.mscustomermanagement.delivery.http;

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
import pe.com.nzegarra.starup.customerfollowup.mscustomermanagement.core.domain.input.CustomerRequest;
import pe.com.nzegarra.starup.customerfollowup.mscustomermanagement.core.domain.output.CustomerResponse;
import pe.com.nzegarra.starup.customerfollowup.mscustomermanagement.core.domain.output.GeneralResponse;
import pe.com.nzegarra.starup.customerfollowup.mscustomermanagement.core.domain.output.MessageResponse;
import pe.com.nzegarra.starup.customerfollowup.mscustomermanagement.core.util.CustomerConstants;
import pe.com.nzegarra.starup.customerfollowup.mscustomermanagement.delivery.CustomerController;

@Slf4j
@RestController
@RequestMapping(CustomerConstants.API_CUSTOMER)
public class CustomerRestController {

	private CustomerController customerController;

	public CustomerRestController(CustomerController customerController) {
		this.customerController = customerController;
	}
	
	@PostMapping
	public ResponseEntity<GeneralResponse> save(@RequestBody CustomerRequest customerRequest){
		CustomerResponse customerResponse = new CustomerResponse();
//		try {
			customerResponse = customerController.save(customerRequest);
			return ResponseEntity.status(HttpStatus.CREATED).body(mapGeneralResponse(customerResponse));
//		}catch(Exception e) {
//			log.error(e.getMessage());
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(mapGeneralResponse(customerResponse));
//		}
	}
	
	@DeleteMapping("/{Id}")
	public ResponseEntity<GeneralResponse> deleteById(@PathVariable("Id") final Long id){
//		try {
			GeneralResponse response = customerController.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).body(response);
//		}catch(Exception e) {
//			log.error(e.getMessage());
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(mapGeneralResponse(customerResponse));
//		}
	}
	
	@GetMapping
	public ResponseEntity<GeneralResponse> findAll(){
		List<CustomerResponse> customerResponses = new ArrayList<>();
		
//		try {
			customerResponses = customerController.findAll();
			return ResponseEntity.status(HttpStatus.OK).body(mapListCustomerResponse(customerResponses));
//		}catch(Exception e) {
//			log.error(e.getMessage());
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(mapListCustomerResponse(customerResponses));
//		}
	}
	
	@GetMapping("/{Id}")
	public ResponseEntity<GeneralResponse> findById(@PathVariable("Id") final Long id){
		CustomerResponse customerResponse = new CustomerResponse();
		
//		try {
			customerResponse = customerController.findById(id);
			return ResponseEntity.status(HttpStatus.OK).body(mapGeneralResponse(customerResponse));
//		}catch(Exception e) {
//			log.error(e.getMessage());
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(mapGeneralResponse(customerResponse));
//		}
	}
	
	private GeneralResponse mapGeneralResponse(CustomerResponse customerResponse) {
		GeneralResponse response = null;
		try {
			response = GeneralResponse.builder()
					.response(MessageResponse.builder().code(CustomerConstants.CODE_SUCCES).message(CustomerConstants.MSG_SUCCES).build())
					.data(customerResponse)
					.build();
		}catch(Exception e) {
			log.error("Ocurrió un error" + e.getMessage());
			response = GeneralResponse.builder()
				.response(MessageResponse.builder().code(CustomerConstants.CODE_ERROR).message(CustomerConstants.MSG_ERROR).build())
				.build();
		}
		return response;
		
	}
	
	private GeneralResponse mapListCustomerResponse(List<CustomerResponse> customerResponses) {
		GeneralResponse response = null;
		try {
			response = GeneralResponse.builder()
					.response(MessageResponse.builder().code(CustomerConstants.CODE_SUCCES).message(CustomerConstants.MSG_SUCCES).build())
					.data(customerResponses)
					.build();
		}catch(Exception e) {
			log.error("Ocurrió un error" + e.getMessage());
			response = GeneralResponse.builder()
				.response(MessageResponse.builder().code(CustomerConstants.CODE_ERROR).message(CustomerConstants.MSG_ERROR).build())
				.build();
		}
		return response;
		
	}
}
