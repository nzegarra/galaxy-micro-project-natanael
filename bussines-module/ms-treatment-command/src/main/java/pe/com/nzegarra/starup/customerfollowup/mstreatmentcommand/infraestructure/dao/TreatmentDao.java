package pe.com.nzegarra.starup.customerfollowup.mstreatmentcommand.infraestructure.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import pe.com.nzegarra.starup.customerfollowup.mstreatmentcommand.infraestructure.domain.entity.TreatmentDocument;


//@Repository
public interface TreatmentDao extends ReactiveMongoRepository<TreatmentDocument, String>{
//public interface TreatmentDao extends MongoRepository<TreatmentDocument, String>{
}
