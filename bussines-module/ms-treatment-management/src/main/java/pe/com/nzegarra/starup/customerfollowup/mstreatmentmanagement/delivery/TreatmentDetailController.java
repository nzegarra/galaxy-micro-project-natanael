package pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.delivery;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.json.JsonMapper;

import pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.core.domain.TreatmentDetail;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.core.domain.input.TreatmentDetailRequest;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.core.domain.output.TreatmentDetailResponse;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.core.service.TreatmentDetailService;


public class TreatmentDetailController {

	private TreatmentDetailService treatmentDetailService;
	private JsonMapper jsonMapper;
	
	
	
	public TreatmentDetailController(TreatmentDetailService treatmentDetailService, JsonMapper jsonMapper) {
		this.treatmentDetailService = treatmentDetailService;
		this.jsonMapper = jsonMapper;
	}

	public TreatmentDetailResponse save(TreatmentDetailRequest request) {
		
		TreatmentDetail treatmentDetail = treatmentDetailService.save(mapperTreatmentDetail(request));
		
		return mapperTreatmentDetailResponse(treatmentDetail);
	}
	
	public List<TreatmentDetailResponse> findAll(){
		return  treatmentDetailService.findAll().stream().map(detail -> mapperTreatmentDetailResponse(detail)).collect(Collectors.toList());
	}
	
	public TreatmentDetailResponse findById(Long id) {
		return mapperTreatmentDetailResponse(treatmentDetailService.findById(id));
	}
	
	public List<TreatmentDetailResponse> findByTreatmentId(Long treatmentId){
		return  treatmentDetailService.findByTreatmentId(treatmentId).stream().map(detail -> mapperTreatmentDetailResponse(detail)).collect(Collectors.toList());
	}
	
	private TreatmentDetail mapperTreatmentDetail(TreatmentDetailRequest treatmentDetailRequest) {
		return jsonMapper.convertValue(treatmentDetailRequest, TreatmentDetail.class);
	}
	
	private TreatmentDetailResponse mapperTreatmentDetailResponse(TreatmentDetail treatmentDetail) {
		return jsonMapper.convertValue(treatmentDetail, TreatmentDetailResponse.class);
	}

	
//	private <T> T mapperCustomerResponse(Object object, Class<T> className) {
//		return jsonMapper.convertValue(object, className);
//	}
}
