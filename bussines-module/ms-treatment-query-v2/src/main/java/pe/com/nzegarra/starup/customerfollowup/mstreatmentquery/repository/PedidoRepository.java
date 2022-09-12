package pe.com.nzegarra.starup.customerfollowup.mstreatmentquery.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import pe.com.nzegarra.starup.customerfollowup.mstreatmentquery.document.Orden;

@Repository
public interface PedidoRepository  extends ReactiveMongoRepository<Orden, String>{

	//List<Orden> getAllActivos();
	
}
