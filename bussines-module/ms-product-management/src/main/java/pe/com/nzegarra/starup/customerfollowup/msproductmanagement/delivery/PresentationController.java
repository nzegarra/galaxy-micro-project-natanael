package pe.com.nzegarra.starup.customerfollowup.msproductmanagement.delivery;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.json.JsonMapper;

import pe.com.nzegarra.starup.customerfollowup.msproductmanagement.core.domain.Presentation;
import pe.com.nzegarra.starup.customerfollowup.msproductmanagement.core.domain.input.PresentationRequest;
import pe.com.nzegarra.starup.customerfollowup.msproductmanagement.core.domain.output.PresentationResponse;
import pe.com.nzegarra.starup.customerfollowup.msproductmanagement.core.service.PresentationService;

public class PresentationController {

	private PresentationService presentationService;
	private JsonMapper jsonMapper;
	
	
	
	public PresentationController(PresentationService presentationService, JsonMapper jsonMapper) {
		this.presentationService = presentationService;
		this.jsonMapper = jsonMapper;
	}

	public PresentationResponse save(PresentationRequest request) {
		
		Presentation presentation = presentationService.save(mapperPresentation(request));
		
		return mapperPresentationResponse(presentation);
	}
	
	public List<PresentationResponse> findAll(){
		return  presentationService.findAll().stream().map(presentation -> mapperPresentationResponse(presentation)).collect(Collectors.toList());
	}
	
	
	private Presentation mapperPresentation(PresentationRequest presentationRequest) {
		return jsonMapper.convertValue(presentationRequest, Presentation.class);
	}
	
	private PresentationResponse mapperPresentationResponse(Presentation presentation) {
		return jsonMapper.convertValue(presentation, PresentationResponse.class);
	}

	
//	private <T> T mapperCustomerResponse(Object object, Class<T> className) {
//		return jsonMapper.convertValue(object, className);
//	}
}
