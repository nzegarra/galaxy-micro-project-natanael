package pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.infraestructure;

import java.util.List;

import pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.core.domain.TreatmentDetail;


public interface TreatmentDetailRepository {

	public TreatmentDetail save(TreatmentDetail treatmentDetail);
	public List<TreatmentDetail> findAll();
	public TreatmentDetail findById(Long id);
	public List<TreatmentDetail> findByTreatmentId(Long treatmentId);
}
