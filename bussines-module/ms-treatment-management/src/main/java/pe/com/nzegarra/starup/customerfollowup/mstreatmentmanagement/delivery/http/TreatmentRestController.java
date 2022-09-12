package pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.delivery.http;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.core.domain.input.TreatmentRequest;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.core.domain.output.GeneralResponse;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.core.domain.output.MessageResponse;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.core.domain.output.TreatmentDetailResponse;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.core.domain.output.TreatmentResponse;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.core.util.TreatmentConstants;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.delivery.TreatmentController;

@Slf4j
@RestController
@RequestMapping(TreatmentConstants.API_TREATMENT)
public class TreatmentRestController {

	private TreatmentController treatmentController;

	public TreatmentRestController(TreatmentController treatmentController) {
		this.treatmentController = treatmentController;
	}
	
	@PostMapping
	public ResponseEntity<GeneralResponse> save(@RequestBody TreatmentRequest treatmentRequest){
		TreatmentResponse customerResponse = new TreatmentResponse();
//		try {
			customerResponse = treatmentController.save(treatmentRequest);
			return ResponseEntity.status(HttpStatus.CREATED).body(mapGeneralResponse(customerResponse));
//		}catch(Exception e) {
//			log.error(e.getMessage());
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(mapGeneralResponse(customerResponse));
//		}
	}
	
	
	@GetMapping
	public ResponseEntity<GeneralResponse> findAll(){
		List<TreatmentResponse> customerResponses = new ArrayList<>();
		
//		try {
			customerResponses = treatmentController.findAll();
			return ResponseEntity.status(HttpStatus.OK).body(mapListTreatmentResponse(customerResponses));
//		}catch(Exception e) {
//			log.error(e.getMessage());
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(mapListProductCategoryResponse(customerResponses));
//		}
	}
	
	@GetMapping("/{Id}")
	public ResponseEntity<GeneralResponse> findById(@PathVariable("Id") final Long id){
		TreatmentResponse treatmentResponse = new TreatmentResponse();
		
//		try {
		treatmentResponse = treatmentController.findById(id);
			return ResponseEntity.status(HttpStatus.OK).body(mapGeneralResponse(treatmentResponse));
//		}catch(Exception e) {
//			log.error(e.getMessage());
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(mapGeneralResponse(customerResponse));
//		}
	}
	
	@GetMapping("/findByUserIdClientId")
	public ResponseEntity<GeneralResponse> findByUserIdAndClientId(@RequestParam(name = "userId", required = false, defaultValue = "") String userId, @RequestParam(name = "clientId", required = false, defaultValue = "") String clientId){
		List<TreatmentResponse> customerResponses = new ArrayList<>();
		
//		try {
			customerResponses = treatmentController.findByUserIdAndClientId(userId, clientId);
			return ResponseEntity.status(HttpStatus.OK).body(mapListTreatmentResponse(customerResponses));
//		}catch(Exception e) {
//			log.error(e.getMessage());
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(mapListProductCategoryResponse(customerResponses));
//		}
	}

	
	private GeneralResponse mapGeneralResponse(TreatmentResponse treatmentResponse) {
		GeneralResponse response = null;
		try {
			response = GeneralResponse.builder()
					.response(MessageResponse.builder().code(TreatmentConstants.CODE_SUCCES).message(TreatmentConstants.MSG_SUCCES).build())
					.data(treatmentResponse)
					.build();
		}catch(Exception e) {
			log.error("Ocurrió un error" + e.getMessage());
			response = GeneralResponse.builder()
				.response(MessageResponse.builder().code(TreatmentConstants.CODE_ERROR).message(TreatmentConstants.MSG_ERROR).build())
				.build();
		}
		return response;
		
	}
	
	private GeneralResponse mapListTreatmentResponse(List<TreatmentResponse> treatmentResponses) {
		GeneralResponse response = null;
		try {
			response = GeneralResponse.builder()
					.response(MessageResponse.builder().code(TreatmentConstants.CODE_SUCCES).message(TreatmentConstants.MSG_SUCCES).build())
					.data(treatmentResponses)
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
