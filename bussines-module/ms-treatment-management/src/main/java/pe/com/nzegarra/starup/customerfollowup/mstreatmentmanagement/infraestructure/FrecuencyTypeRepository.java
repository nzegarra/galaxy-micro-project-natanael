package pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.infraestructure;

import java.util.List;

import pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.core.domain.FrecuencyType;


public interface FrecuencyTypeRepository {

	public FrecuencyType save(FrecuencyType frecuencyType);
	public List<FrecuencyType> findAll();
	public FrecuencyType findByCode(String code);
}
