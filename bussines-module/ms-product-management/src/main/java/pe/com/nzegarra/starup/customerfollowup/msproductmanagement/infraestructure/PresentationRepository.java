package pe.com.nzegarra.starup.customerfollowup.msproductmanagement.infraestructure;

import java.util.List;

import pe.com.nzegarra.starup.customerfollowup.msproductmanagement.core.domain.Presentation;

public interface PresentationRepository {

	public Presentation save(Presentation presentation);
	public List<Presentation> findAll();
}
