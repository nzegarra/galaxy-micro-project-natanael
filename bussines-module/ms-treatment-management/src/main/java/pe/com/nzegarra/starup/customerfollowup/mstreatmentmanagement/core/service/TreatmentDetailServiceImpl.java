package pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.core.service;

import java.util.List;

import pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.core.domain.TreatmentDetail;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.infraestructure.TreatmentDetailRepository;



public class TreatmentDetailServiceImpl implements TreatmentDetailService{

	private TreatmentDetailRepository treatmentDetailRepository;
	
	public TreatmentDetailServiceImpl(TreatmentDetailRepository treatmentDetailRepository) {
		this.treatmentDetailRepository = treatmentDetailRepository;
	}

	@Override
	public TreatmentDetail save(TreatmentDetail treatmentDetail) {
		return treatmentDetailRepository.save(treatmentDetail);
	}

	@Override
	public List<TreatmentDetail> findAll() {
		return treatmentDetailRepository.findAll();
	}

	@Override
	public TreatmentDetail findById(Long id) {
		return treatmentDetailRepository.findById(id);
	}

	@Override
	public List<TreatmentDetail> findByTreatmentId(Long treatmentId) {
		return treatmentDetailRepository.findByTreatmentId(treatmentId);
	}

	
}
