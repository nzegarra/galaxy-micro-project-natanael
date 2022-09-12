package pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.infraestructure;

import java.util.List;

import pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.core.domain.Treatment;


public interface TreatmentRepository {

	public Treatment save(Treatment treatment);
	public List<Treatment> findAll();
	public Treatment findById(Long id);
	public List<Treatment> findByUserIdAndClientId(Long userId, Long clientId);
	public List<Treatment> findByUserId(Long userId);
	public List<Treatment> findByClientId(Long clientId);
}
