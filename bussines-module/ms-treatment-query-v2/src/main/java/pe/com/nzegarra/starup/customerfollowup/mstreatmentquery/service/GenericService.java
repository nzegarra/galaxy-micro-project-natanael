package pe.com.nzegarra.starup.customerfollowup.mstreatmentquery.service;

import pe.com.nzegarra.starup.customerfollowup.mstreatmentquery.service.exception.ServiceException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface GenericService<T> {
	
	Flux<T> findLike(T t) throws ServiceException;

	Mono<T> findById(T t) throws ServiceException;

}
