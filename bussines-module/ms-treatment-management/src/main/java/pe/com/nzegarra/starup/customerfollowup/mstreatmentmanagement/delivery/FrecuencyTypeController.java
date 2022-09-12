package pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.delivery;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.json.JsonMapper;

import pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.core.domain.FrecuencyType;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.core.domain.input.FrecuencyTypeRequest;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.core.domain.output.FrecuencyTypeResponse;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.core.service.FrecuencyTypeService;


public class FrecuencyTypeController {

	private FrecuencyTypeService frecuencyTypeService;
	private JsonMapper jsonMapper;
	
	public FrecuencyTypeController(FrecuencyTypeService frecuencyTypeService, JsonMapper jsonMapper) {
		this.frecuencyTypeService = frecuencyTypeService;
		this.jsonMapper = jsonMapper;
	}

	public FrecuencyTypeResponse save(FrecuencyTypeRequest request) {
		
		FrecuencyType frecuencyType = frecuencyTypeService.save(mapperFrecuencyType(request));
		
		return mapperFrecuencyTypeResponse(frecuencyType);
	}
	
	public List<FrecuencyTypeResponse> findAll(){
		return  frecuencyTypeService.findAll().stream().map(type -> mapperFrecuencyTypeResponse(type)).collect(Collectors.toList());
	}
	
	
	private FrecuencyType mapperFrecuencyType(FrecuencyTypeRequest frecuencyTypeRequest) {
		return jsonMapper.convertValue(frecuencyTypeRequest, FrecuencyType.class);
	}
	
	private FrecuencyTypeResponse mapperFrecuencyTypeResponse(FrecuencyType frecuencyType) {
		return jsonMapper.convertValue(frecuencyType, FrecuencyTypeResponse.class);
	}

	
//	private <T> T mapperCustomerResponse(Object object, Class<T> className) {
//		return jsonMapper.convertValue(object, className);
//	}
}
