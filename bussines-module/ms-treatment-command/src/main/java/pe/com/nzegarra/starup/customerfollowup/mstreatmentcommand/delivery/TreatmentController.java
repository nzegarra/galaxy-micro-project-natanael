package pe.com.nzegarra.starup.customerfollowup.mstreatmentcommand.delivery;

import com.fasterxml.jackson.databind.json.JsonMapper;

import pe.com.nzegarra.starup.customerfollowup.mstreatmentcommand.core.domain.Treatment;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentcommand.core.domain.input.TreatmentRequest;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentcommand.core.domain.output.TreatmentResponse;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentcommand.core.service.TreatmentService;

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
	
	private Treatment mapperTreatment(TreatmentRequest request) {
		return jsonMapper.convertValue(request, Treatment.class);
	}

	private TreatmentResponse mapperTreatmentResponse(Treatment treatment) {
		return jsonMapper.convertValue(treatment, TreatmentResponse.class);
	}

}
