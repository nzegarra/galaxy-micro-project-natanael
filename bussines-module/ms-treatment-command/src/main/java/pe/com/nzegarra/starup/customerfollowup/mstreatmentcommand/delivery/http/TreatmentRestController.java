package pe.com.nzegarra.starup.customerfollowup.mstreatmentcommand.delivery.http;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentcommand.core.domain.input.TreatmentRequest;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentcommand.core.domain.output.GeneralResponse;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentcommand.core.domain.output.MessageResponse;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentcommand.core.domain.output.TreatmentResponse;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentcommand.core.util.TreatmentConstants;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentcommand.delivery.TreatmentController;

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
			customerResponse = treatmentController.save(treatmentRequest);
			return ResponseEntity.status(HttpStatus.CREATED).body(mapGeneralResponse(customerResponse));
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
}
