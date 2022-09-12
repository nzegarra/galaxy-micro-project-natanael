package pe.com.nzegarra.starup.customerfollowup.msproductmanagement.core.service;

import java.util.List;

import pe.com.nzegarra.starup.customerfollowup.msproductmanagement.core.domain.Presentation;

public interface PresentationService {

	Presentation save(Presentation presentation);
	List<Presentation> findAll();
}
