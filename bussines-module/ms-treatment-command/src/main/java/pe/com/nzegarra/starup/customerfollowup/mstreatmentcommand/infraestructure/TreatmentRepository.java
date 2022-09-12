package pe.com.nzegarra.starup.customerfollowup.mstreatmentcommand.infraestructure;

import pe.com.nzegarra.starup.customerfollowup.mstreatmentcommand.core.domain.Treatment;


public interface TreatmentRepository {

	public Treatment save(Treatment treatment);
}
