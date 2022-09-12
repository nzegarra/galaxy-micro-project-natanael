package pe.com.nzegarra.starup.customerfollowup.msproductmanagement.infraestructure.adapter;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.json.JsonMapper;

import pe.com.nzegarra.starup.customerfollowup.msproductmanagement.core.domain.Presentation;
import pe.com.nzegarra.starup.customerfollowup.msproductmanagement.infraestructure.PresentationRepository;
import pe.com.nzegarra.starup.customerfollowup.msproductmanagement.infraestructure.dao.PresentationDao;
import pe.com.nzegarra.starup.customerfollowup.msproductmanagement.infraestructure.domain.entity.PresentationEntity;

public class PresentationAdapter implements PresentationRepository{

	private JsonMapper jsonMapper;
	private PresentationDao presentationDao;
	
	public PresentationAdapter(JsonMapper jsonMapper, PresentationDao presentationDao) {
		this.jsonMapper = jsonMapper;
		this.presentationDao = presentationDao;
	}

	private PresentationEntity mapperPresentationEntity(Presentation presentation) {
		return jsonMapper.convertValue(presentation, PresentationEntity.class);
	}
	
	private Presentation mapperPresentation(PresentationEntity presentationEntity) {
		return jsonMapper.convertValue(presentationEntity, Presentation.class);
	}
	
	@Override
	public Presentation save(Presentation presentation) {
		PresentationEntity presentationEntity = mapperPresentationEntity(presentation);
		presentationEntity = presentationDao.save(presentationEntity);
		return mapperPresentation(presentationEntity);
	}

	@Override
	public List<Presentation> findAll() {
		List<PresentationEntity> presentationEntities = presentationDao.findAll();
		return presentationEntities.stream().map(entity -> mapperPresentation(entity)).collect(Collectors.toList());
	}
	
	
}
