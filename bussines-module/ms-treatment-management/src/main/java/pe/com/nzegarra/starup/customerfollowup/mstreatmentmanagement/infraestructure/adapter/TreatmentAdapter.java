package pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.infraestructure.adapter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.databind.json.JsonMapper;

import pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.core.domain.Treatment;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.infraestructure.TreatmentRepository;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.infraestructure.dao.TreatmentDao;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.infraestructure.domain.entity.TreatmentEntity;


public class TreatmentAdapter implements TreatmentRepository{

	private JsonMapper jsonMapper;
	private TreatmentDao treatmentDao;
	
	public TreatmentAdapter(JsonMapper jsonMapper, TreatmentDao treatmentDao) {
		this.jsonMapper = jsonMapper;
		this.treatmentDao = treatmentDao;
	}

	private TreatmentEntity mapperTreatmentEntity(Treatment treatment) {
		return jsonMapper.convertValue(treatment, TreatmentEntity.class);
	}
	
	private Treatment mapperTreatment(TreatmentEntity treatmentEntity) {
		return jsonMapper.convertValue(treatmentEntity, Treatment.class);
	}
	
	@Override
	public Treatment save(Treatment treatment) {
		TreatmentEntity productCategoryEntity = mapperTreatmentEntity(treatment);
				productCategoryEntity = treatmentDao.save(productCategoryEntity);
		return mapperTreatment(productCategoryEntity);
	}

	@Override
	public List<Treatment> findAll() {
		List<TreatmentEntity> treatmentEntities = treatmentDao.findAll();
		return treatmentEntities.stream().map(entity -> mapperTreatment(entity)).collect(Collectors.toList());
	}


	@Override
	public Treatment findById(Long id) {
		Optional<TreatmentEntity> optional = treatmentDao.findById(id);
		if(optional.isPresent()) {
			return mapperTreatment(optional.get());
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se ha encontrado el tratamiento con id" + id);
	}

	@Override
	public List<Treatment> findByUserIdAndClientId(Long userId, Long clientId) {
		List<TreatmentEntity> treatmentEntities = treatmentDao.findByUserIdAndClientId(userId, clientId);
		return treatmentEntities.stream().map(entity -> mapperTreatment(entity)).collect(Collectors.toList());
	}

	@Override
	public List<Treatment> findByUserId(Long userId) {
		List<TreatmentEntity> treatmentEntities = treatmentDao.findByUserId(userId);
		return treatmentEntities.stream().map(entity -> mapperTreatment(entity)).collect(Collectors.toList());
	}

	
	@Override
	public List<Treatment> findByClientId(Long clientId) {
		List<TreatmentEntity> treatmentEntities = treatmentDao.findByClientId(clientId);
		return treatmentEntities.stream().map(entity -> mapperTreatment(entity)).collect(Collectors.toList());
	}

}
