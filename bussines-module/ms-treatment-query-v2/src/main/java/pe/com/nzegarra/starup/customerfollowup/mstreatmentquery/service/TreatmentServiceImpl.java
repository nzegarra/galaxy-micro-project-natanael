package pe.com.nzegarra.starup.customerfollowup.mstreatmentquery.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentquery.document.Treatment;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentquery.repository.TreatmentRepository;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentquery.service.exception.ServiceException;

@Slf4j
@Service
@CacheConfig(cacheNames = "treatment")
public class TreatmentServiceImpl implements TreatmentService<Treatment> {

	@Autowired
	private TreatmentRepository treatmentRepository;
	/*
	public PedidoServiceImpl(PedidoRepository pedidoRepository) {
		this.pedidoRepository=pedidoRepository;
	}*/
	
	@Override
	@Cacheable
	public Iterable<Treatment> findLike(Treatment orden) throws ServiceException {
		try {
			log.info("consume de mongo db");
			return treatmentRepository.findAll();
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	@Override
	@Cacheable
	public Treatment findById(Treatment orden) throws ServiceException {
		try {
			Optional<Treatment> optional = treatmentRepository.findById(orden.getId());
			if(optional.isPresent()) {
				return optional.get();
			}else {
				return new Treatment();
			}
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

}
