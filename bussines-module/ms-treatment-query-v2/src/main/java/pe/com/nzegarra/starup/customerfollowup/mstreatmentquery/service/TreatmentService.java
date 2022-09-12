package pe.com.nzegarra.starup.customerfollowup.mstreatmentquery.service;

import pe.com.nzegarra.starup.customerfollowup.mstreatmentquery.service.exception.ServiceException;

public interface TreatmentService<T>{

	Iterable<T> findLike(T t) throws ServiceException;

	T findById(T t) throws ServiceException;
	
}
