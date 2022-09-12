package pe.com.nzegarra.starup.customerfollowup.mstreatmentquery.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import pe.com.nzegarra.starup.customerfollowup.mstreatmentquery.document.Treatment;

//@Repository
//public interface TreatmentRepository  extends ReactiveMongoRepository<Treatment, String>{
@Repository
public interface TreatmentRepository  extends MongoRepository<Treatment, String>{

	//List<Orden> getAllActivos();
	
}
