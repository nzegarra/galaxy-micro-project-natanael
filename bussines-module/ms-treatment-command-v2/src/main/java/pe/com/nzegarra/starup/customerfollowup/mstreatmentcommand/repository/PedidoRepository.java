package pe.com.nzegarra.starup.customerfollowup.mstreatmentcommand.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import pe.com.nzegarra.starup.customerfollowup.mstreatmentcommand.document.Orden;

@Repository
public interface PedidoRepository  extends ReactiveMongoRepository<Orden, String>{

	
}
