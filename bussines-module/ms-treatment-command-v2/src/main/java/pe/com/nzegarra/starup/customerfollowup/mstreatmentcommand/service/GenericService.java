package pe.com.nzegarra.starup.customerfollowup.mstreatmentcommand.service;

import pe.com.nzegarra.starup.customerfollowup.mstreatmentcommand.service.exception.ServiceException;
import reactor.core.publisher.Mono;

public interface GenericService<T> {
	
	Mono<T> save(T t) throws ServiceException;

}
