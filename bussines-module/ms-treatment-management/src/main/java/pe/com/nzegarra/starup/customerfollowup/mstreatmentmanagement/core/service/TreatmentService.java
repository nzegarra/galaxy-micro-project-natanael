package pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.core.service;

import java.util.List;

import pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.core.domain.Treatment;


public interface TreatmentService {

	Treatment save(Treatment treatment);
	List<Treatment> findAll();
	Treatment findById(Long id);
	List<Treatment> findByUserIdAndClientId(String userId, String clientId);
//	List<Treatment> findByClientId(Long clientId);
	
}
