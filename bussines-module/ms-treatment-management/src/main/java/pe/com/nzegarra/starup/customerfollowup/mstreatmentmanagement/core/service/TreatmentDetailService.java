package pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.core.service;

import java.util.List;

import pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.core.domain.TreatmentDetail;


public interface TreatmentDetailService {

	TreatmentDetail save(TreatmentDetail treatmentDetail) ;
	public List<TreatmentDetail> findAll();
	public TreatmentDetail findById(Long id);
	public List<TreatmentDetail> findByTreatmentId(Long treatmentId);
}
