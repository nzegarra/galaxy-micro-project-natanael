package pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.infraestructure.adapter;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.json.JsonMapper;

import pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.core.domain.FrecuencyType;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.infraestructure.FrecuencyTypeRepository;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.infraestructure.dao.FrecuencyTypeDao;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.infraestructure.domain.entity.FrecuencyTypeEntity;


public class FrecuencyTypeAdapter implements FrecuencyTypeRepository{

	private JsonMapper jsonMapper;
	private FrecuencyTypeDao frecuencyTypeDao;
	
	public FrecuencyTypeAdapter(JsonMapper jsonMapper, FrecuencyTypeDao frecuencyTypeDao) {
		this.jsonMapper = jsonMapper;
		this.frecuencyTypeDao = frecuencyTypeDao;
	}

	private FrecuencyTypeEntity mapperFrecuencyTypeEntity(FrecuencyType frecuencyType) {
		return jsonMapper.convertValue(frecuencyType, FrecuencyTypeEntity.class);
	}
	
	private FrecuencyType mapperFrecuencyType(FrecuencyTypeEntity frecuencyTypeEntity) {
		return jsonMapper.convertValue(frecuencyTypeEntity, FrecuencyType.class);
	}
	
	@Override
	public FrecuencyType save(FrecuencyType frecuencyType) {
		FrecuencyTypeEntity frecuencyTypeEntity = mapperFrecuencyTypeEntity(frecuencyType);
		frecuencyTypeEntity = frecuencyTypeDao.save(frecuencyTypeEntity);
		return mapperFrecuencyType(frecuencyTypeEntity);
	}

	@Override
	public List<FrecuencyType> findAll() {
		List<FrecuencyTypeEntity> frecuencyTypeEntities = frecuencyTypeDao.findAll();
		return frecuencyTypeEntities.stream().map(entity -> mapperFrecuencyType(entity)).collect(Collectors.toList());
	}

	@Override
	public FrecuencyType findByCode(String code) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
