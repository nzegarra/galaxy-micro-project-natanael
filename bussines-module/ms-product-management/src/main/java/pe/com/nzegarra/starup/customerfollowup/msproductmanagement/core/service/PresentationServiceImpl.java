package pe.com.nzegarra.starup.customerfollowup.msproductmanagement.core.service;

import java.util.List;

import pe.com.nzegarra.starup.customerfollowup.msproductmanagement.core.domain.Presentation;
import pe.com.nzegarra.starup.customerfollowup.msproductmanagement.infraestructure.PresentationRepository;


public class PresentationServiceImpl implements PresentationService{

	private PresentationRepository presentationRepository;
	
	public PresentationServiceImpl(PresentationRepository presentationRepository) {
		super();
		this.presentationRepository = presentationRepository;
	}

	@Override
	public Presentation save(Presentation presentation) {
		return presentationRepository.save(presentation);
	}

	@Override
	public List<Presentation> findAll() {
		return presentationRepository.findAll();
	}

}
