package pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.delivery.http;

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
import pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.core.domain.input.FrecuencyTypeRequest;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.core.domain.output.FrecuencyTypeResponse;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.core.domain.output.GeneralResponse;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.core.domain.output.MessageResponse;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.core.util.TreatmentConstants;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.delivery.FrecuencyTypeController;

@Slf4j
@RestController
@RequestMapping(TreatmentConstants.API_FRECUENCYTYPE)
public class FrecuencyTypeRestController {

	private FrecuencyTypeController presentationController;

	public FrecuencyTypeRestController(FrecuencyTypeController presentationController) {
		this.presentationController = presentationController;
	}
	
	@PostMapping
	public ResponseEntity<GeneralResponse> save(@RequestBody FrecuencyTypeRequest presentationRequest){
		FrecuencyTypeResponse presentationResponse = new FrecuencyTypeResponse();
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
		List<FrecuencyTypeResponse> presentationResponses = new ArrayList<>();
		
//		try {
		presentationResponses = presentationController.findAll();
			return ResponseEntity.status(HttpStatus.OK).body(mapListPresentationResponse(presentationResponses));
//		}catch(Exception e) {
//			log.error(e.getMessage());
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(mapListCustomerResponse(customerResponses));
//		}
	}
	
	
	private GeneralResponse mapGeneralResponse(FrecuencyTypeResponse presentationResponse) {
		GeneralResponse response = null;
		try {
			response = GeneralResponse.builder()
					.response(MessageResponse.builder().code(TreatmentConstants.CODE_SUCCES).message(TreatmentConstants.MSG_SUCCES).build())
					.data(presentationResponse)
					.build();
		}catch(Exception e) {
			log.error("Ocurrió un error" + e.getMessage());
			response = GeneralResponse.builder()
				.response(MessageResponse.builder().code(TreatmentConstants.CODE_ERROR).message(TreatmentConstants.MSG_ERROR).build())
				.build();
		}
		return response;
		
	}
	
	private GeneralResponse mapListPresentationResponse(List<FrecuencyTypeResponse> presentationResponses) {
		GeneralResponse response = null;
		try {
			response = GeneralResponse.builder()
					.response(MessageResponse.builder().code(TreatmentConstants.CODE_SUCCES).message(TreatmentConstants.MSG_SUCCES).build())
					.data(presentationResponses)
					.build();
		}catch(Exception e) {
			log.error("Ocurrió un error" + e.getMessage());
			response = GeneralResponse.builder()
				.response(MessageResponse.builder().code(TreatmentConstants.CODE_ERROR).message(TreatmentConstants.MSG_ERROR).build())
				.build();
		}
		return response;
		
	}
}
