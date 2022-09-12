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
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.core.domain.input.TreatmentDetailRequest;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.core.domain.output.GeneralResponse;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.core.domain.output.MessageResponse;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.core.domain.output.TreatmentDetailResponse;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.core.util.TreatmentConstants;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.delivery.TreatmentDetailController;

@Slf4j
@RestController
@RequestMapping(TreatmentConstants.API_TREATMENTDETAIL)
public class TreatmentDetailRestController {

	private TreatmentDetailController treatmentDetailController;

	public TreatmentDetailRestController(TreatmentDetailController treatmentDetailController) {
		this.treatmentDetailController = treatmentDetailController;
	}
	
	@PostMapping
	public ResponseEntity<GeneralResponse> save(@RequestBody TreatmentDetailRequest treatmentDetailRequest){
		TreatmentDetailResponse customerResponse = new TreatmentDetailResponse();
//		try {
			customerResponse = treatmentDetailController.save(treatmentDetailRequest);
			return ResponseEntity.status(HttpStatus.CREATED).body(mapGeneralResponse(customerResponse));
//		}catch(Exception e) {
//			log.error(e.getMessage());
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(mapGeneralResponse(customerResponse));
//		}
	}
	
	@GetMapping
	public ResponseEntity<GeneralResponse> findAll(){
		List<TreatmentDetailResponse> treatmentDetailResponses = new ArrayList<>();
		
//		try {
		treatmentDetailResponses = treatmentDetailController.findAll();
			return ResponseEntity.status(HttpStatus.OK).body(mapListTreatmentDetailResponse(treatmentDetailResponses));
//		}catch(Exception e) {
//			log.error(e.getMessage());
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(mapListProductResponse(productResponses));
//		}
	}
	
	@GetMapping("/{Id}")
	public ResponseEntity<GeneralResponse> findById(@PathVariable("Id") final Long id){
		TreatmentDetailResponse treatmentDetailResponse = new TreatmentDetailResponse();
		
//		try {
		treatmentDetailResponse = treatmentDetailController.findById(id);
			return ResponseEntity.status(HttpStatus.OK).body(mapGeneralResponse(treatmentDetailResponse));
//		}catch(Exception e) {
//			log.error(e.getMessage());
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(mapGeneralResponse(customerResponse));
//		}
	}
	
	@GetMapping("/treatment/{Id}")
	public ResponseEntity<GeneralResponse> findByTreatmentId(@PathVariable("Id") final Long id){
		List<TreatmentDetailResponse> treatmentDetailResponses = new ArrayList<>();
		treatmentDetailResponses = treatmentDetailController.findByTreatmentId(id);
			return ResponseEntity.status(HttpStatus.OK).body(mapListTreatmentDetailResponse(treatmentDetailResponses));
	}
	
	private GeneralResponse mapGeneralResponse(TreatmentDetailResponse treatmentDetailResponse) {
		GeneralResponse response = null;
		try {
			response = GeneralResponse.builder()
					.response(MessageResponse.builder().code(TreatmentConstants.CODE_SUCCES).message(TreatmentConstants.MSG_SUCCES).build())
					.data(treatmentDetailResponse)
					.build();
		}catch(Exception e) {
			log.error("Ocurrió un error" + e.getMessage());
			response = GeneralResponse.builder()
				.response(MessageResponse.builder().code(TreatmentConstants.CODE_ERROR).message(TreatmentConstants.MSG_ERROR).build())
				.build();
		}
		return response;
		
	}
	
	private GeneralResponse mapListTreatmentDetailResponse(List<TreatmentDetailResponse> treatmentDetailResponses) {
		GeneralResponse response = null;
		try {
			response = GeneralResponse.builder()
					.response(MessageResponse.builder().code(TreatmentConstants.CODE_SUCCES).message(TreatmentConstants.MSG_SUCCES).build())
					.data(treatmentDetailResponses)
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
