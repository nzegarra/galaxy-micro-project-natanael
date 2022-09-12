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
import pe.com.nzegarra.starup.customerfollowup.msproductmanagement.core.domain.input.PresentationRequest;
import pe.com.nzegarra.starup.customerfollowup.msproductmanagement.core.domain.output.GeneralResponse;
import pe.com.nzegarra.starup.customerfollowup.msproductmanagement.core.domain.output.MessageResponse;
import pe.com.nzegarra.starup.customerfollowup.msproductmanagement.core.domain.output.PresentationResponse;
import pe.com.nzegarra.starup.customerfollowup.msproductmanagement.core.util.ProductConstants;
import pe.com.nzegarra.starup.customerfollowup.msproductmanagement.delivery.PresentationController;

@Slf4j
@RestController
@RequestMapping(ProductConstants.API_PRESENTATION)
public class PresentationRestController {

	private PresentationController presentationController;

	public PresentationRestController(PresentationController presentationController) {
		this.presentationController = presentationController;
	}
	
	@PostMapping
	public ResponseEntity<GeneralResponse> save(@RequestBody PresentationRequest presentationRequest){
		PresentationResponse presentationResponse = new PresentationResponse();
//		try {
		presentationResponse = presentationController.save(presentationRequest);
			return ResponseEntity.status(HttpStatus.CREATED).body(mapGeneralResponse(presentationResponse));
//		}catch(Exception e) {
//			log.error(e.getMessage());
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(mapGeneralResponse(customerResponse));
//		}
	}
	
	@GetMapping
	public ResponseEntity<GeneralResponse> findAll(){
		List<PresentationResponse> presentationResponses = new ArrayList<>();
		
//		try {
		presentationResponses = presentationController.findAll();
			return ResponseEntity.status(HttpStatus.OK).body(mapListPresentationResponse(presentationResponses));
//		}catch(Exception e) {
//			log.error(e.getMessage());
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(mapListCustomerResponse(customerResponses));
//		}
	}
	
	
	private GeneralResponse mapGeneralResponse(PresentationResponse presentationResponse) {
		GeneralResponse response = null;
		try {
			response = GeneralResponse.builder()
					.response(MessageResponse.builder().code(ProductConstants.CODE_SUCCES).message(ProductConstants.MSG_SUCCES).build())
					.data(presentationResponse)
					.build();
		}catch(Exception e) {
			log.error("Ocurrió un error" + e.getMessage());
			response = GeneralResponse.builder()
				.response(MessageResponse.builder().code(ProductConstants.CODE_ERROR).message(ProductConstants.MSG_ERROR).build())
				.build();
		}
		return response;
		
	}
	
	private GeneralResponse mapListPresentationResponse(List<PresentationResponse> presentationResponses) {
		GeneralResponse response = null;
		try {
			response = GeneralResponse.builder()
					.response(MessageResponse.builder().code(ProductConstants.CODE_SUCCES).message(ProductConstants.MSG_SUCCES).build())
					.data(presentationResponses)
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
