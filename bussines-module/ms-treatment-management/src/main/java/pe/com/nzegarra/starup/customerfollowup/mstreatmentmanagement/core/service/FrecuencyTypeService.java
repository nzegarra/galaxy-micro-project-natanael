package pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.core.service;

import java.util.List;

import pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.core.domain.FrecuencyType;


public interface FrecuencyTypeService {

	FrecuencyType save(FrecuencyType frecuencyType);
	List<FrecuencyType> findAll();
	FrecuencyType findByCode(String code);
}
