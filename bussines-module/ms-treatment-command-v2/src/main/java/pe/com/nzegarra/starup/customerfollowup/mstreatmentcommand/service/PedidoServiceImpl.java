package pe.com.nzegarra.starup.customerfollowup.mstreatmentcommand.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.nzegarra.starup.customerfollowup.mstreatmentcommand.document.Orden;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentcommand.repository.PedidoRepository;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentcommand.service.exception.ServiceException;
import reactor.core.publisher.Mono;

@Service
public class PedidoServiceImpl implements PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Override
	public Mono<Orden> save(Orden orden) throws ServiceException {
		try {
			return pedidoRepository.save(orden);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

}
