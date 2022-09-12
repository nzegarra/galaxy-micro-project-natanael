package pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.core.service;

import java.util.List;

import pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.core.domain.FrecuencyType;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.infraestructure.FrecuencyTypeRepository;



public class FrecuencyTypeServiceImpl implements FrecuencyTypeService{

	private FrecuencyTypeRepository frecuencyTypeRepository;
	
	public FrecuencyTypeServiceImpl(FrecuencyTypeRepository frecuencyTypeRepository) {
		this.frecuencyTypeRepository = frecuencyTypeRepository;
	}

	@Override
	public FrecuencyType save(FrecuencyType frecuencyType) {
		return frecuencyTypeRepository.save(frecuencyType);
	}

	@Override
	public List<FrecuencyType> findAll() {
		return frecuencyTypeRepository.findAll();
	}

	@Override
	public FrecuencyType findByCode(String code) {
		// TODO Auto-generated method stub
		return null;
	}

}
