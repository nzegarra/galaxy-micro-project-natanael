package pe.com.nzegarra.starup.customerfollowup.mstreatmentquery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.nzegarra.starup.customerfollowup.mstreatmentquery.document.Orden;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentquery.repository.PedidoRepository;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentquery.service.exception.ServiceException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PedidoServiceImpl implements PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;
	/*
	public PedidoServiceImpl(PedidoRepository pedidoRepository) {
		this.pedidoRepository=pedidoRepository;
	}*/
	
	@Override
	public Flux<Orden> findLike(Orden orden) throws ServiceException {
		try {
			return this.pedidoRepository.findAll();
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public Mono<Orden> findById(Orden orden) throws ServiceException {
		try {
			return pedidoRepository.findById(orden.getId());
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

}
