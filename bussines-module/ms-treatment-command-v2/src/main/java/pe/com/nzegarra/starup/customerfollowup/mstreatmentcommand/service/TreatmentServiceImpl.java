package pe.com.nzegarra.starup.customerfollowup.mstreatmentcommand.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.nzegarra.starup.customerfollowup.mstreatmentcommand.document.Orden;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentcommand.document.Treatment;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentcommand.repository.PedidoRepository;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentcommand.repository.TreatmentRepository;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentcommand.service.exception.ServiceException;
import reactor.core.publisher.Mono;

@Service
public class TreatmentServiceImpl implements TreatmentService {

	@Autowired
	private TreatmentRepository pedidoRepository;

	@Override
	public Mono<Treatment> save(Treatment orden) throws ServiceException {
		try {
			return pedidoRepository.save(orden);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

}
