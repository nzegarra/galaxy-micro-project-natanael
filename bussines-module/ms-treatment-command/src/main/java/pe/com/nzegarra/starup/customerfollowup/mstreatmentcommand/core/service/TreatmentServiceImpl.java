package pe.com.nzegarra.starup.customerfollowup.mstreatmentcommand.core.service;

import pe.com.nzegarra.starup.customerfollowup.mstreatmentcommand.core.domain.Treatment;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentcommand.infraestructure.TreatmentRepository;



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

}
