package pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.core.service;

import java.util.List;

import pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.core.domain.Treatment;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.infraestructure.TreatmentRepository;



public class TreatmentServiceImpl implements TreatmentService{

	private TreatmentRepository treatmentRepository;
	
	public TreatmentServiceImpl(TreatmentRepository treatmentRepository) {
		super();
		this.treatmentRepository = treatmentRepository;
	}

	@Override
	public Treatment save(Treatment treatment) {
		return treatmentRepository.save(treatment);
	}

	@Override
	public List<Treatment> findAll() {
		return treatmentRepository.findAll();
	}

	@Override
	public Treatment findById(Long id) {
		return treatmentRepository.findById(id);
	}
	
	@Override
	public List<Treatment> findByUserIdAndClientId(String userId, String clientId) {
		if(userId.isEmpty() && clientId.isEmpty()) {
			return findAll();
		}else if(userId.isEmpty()) {
			return treatmentRepository.findByClientId(Long.valueOf(clientId));
		}else if(clientId.isEmpty()) {
			return treatmentRepository.findByUserId(Long.valueOf(userId));
		}
		return treatmentRepository.findByUserIdAndClientId(Long.valueOf(userId), Long.valueOf(clientId));
	}

//	@Override
//	public List<Treatment> findByClientId(Long clientId) {
//		return treatmentRepository.findByClientId(clientId);
//	}
}
