package pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.delivery;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.json.JsonMapper;

import pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.core.domain.Treatment;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.core.domain.input.TreatmentRequest;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.core.domain.output.TreatmentResponse;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.core.service.TreatmentService;

public class TreatmentController {

	private TreatmentService treatmentService;
	private JsonMapper jsonMapper;

	public TreatmentController(TreatmentService treatmentService, JsonMapper jsonMapper) {
		this.treatmentService = treatmentService;
		this.jsonMapper = jsonMapper;
	}

	public TreatmentResponse save(TreatmentRequest request) {

		Treatment treatment = treatmentService.save(mapperTreatment(request));

		return mapperTreatmentResponse(treatment);
	}

	public List<TreatmentResponse> findAll() {
		return treatmentService.findAll().stream().map(treatment -> mapperTreatmentResponse(treatment))
				.collect(Collectors.toList());
	}

	public TreatmentResponse findById(Long id) {
		Treatment treatment =  treatmentService.findById(id);
		return mapperTreatmentResponse(treatment);
	}
	public List<TreatmentResponse> findByUserIdAndClientId(String userId, String clientId){
		List<Treatment> treatments = treatmentService.findByUserIdAndClientId(userId, clientId);
		return treatments.stream().map(treatment -> mapperTreatmentResponse(treatment))
				.collect(Collectors.toList());
	}
//	public List<TreatmentResponse> findByClientId(Long clientId){
//		List<Treatment> treatments = treatmentService.findByClientId(clientId);
//		return treatments.stream().map(treatment -> mapperTreatmentResponse(treatment))
//				.collect(Collectors.toList());
//	}
	
	private Treatment mapperTreatment(TreatmentRequest request) {
		return jsonMapper.convertValue(request, Treatment.class);
	}

	private TreatmentResponse mapperTreatmentResponse(Treatment treatment) {
		return jsonMapper.convertValue(treatment, TreatmentResponse.class);
	}

//	private <T> T mapperCustomerResponse(Object object, Class<T> className) {
//		return jsonMapper.convertValue(object, className);
//	}
}
