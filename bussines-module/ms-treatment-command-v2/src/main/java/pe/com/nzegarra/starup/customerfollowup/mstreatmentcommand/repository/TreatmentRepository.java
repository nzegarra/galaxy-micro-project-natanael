package pe.com.nzegarra.starup.customerfollowup.mstreatmentcommand.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import pe.com.nzegarra.starup.customerfollowup.mstreatmentcommand.document.Orden;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentcommand.document.Treatment;

@Repository
public interface TreatmentRepository  extends ReactiveMongoRepository<Treatment, String>{

	
}
