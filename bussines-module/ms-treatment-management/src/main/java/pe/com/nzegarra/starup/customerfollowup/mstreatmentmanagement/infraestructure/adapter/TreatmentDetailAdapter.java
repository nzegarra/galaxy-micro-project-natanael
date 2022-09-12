package pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.infraestructure.adapter;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.databind.json.JsonMapper;

import pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.core.domain.TreatmentDetail;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.infraestructure.TreatmentDetailRepository;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.infraestructure.dao.FrecuencyTypeDao;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.infraestructure.dao.TreatmentDao;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.infraestructure.dao.TreatmentDetailDao;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.infraestructure.domain.entity.TreatmentDetailEntity;


public class TreatmentDetailAdapter implements TreatmentDetailRepository{

	private JsonMapper jsonMapper;
	private TreatmentDetailDao treatmentDetailDao;
	private TreatmentDao treatmentDao;
	private FrecuencyTypeDao frecuencyTypeDao;
	
	
	public TreatmentDetailAdapter(JsonMapper jsonMapper, TreatmentDetailDao treatmentDetailDao, TreatmentDao treatmentDao,
			FrecuencyTypeDao frecuencyTypeDao) {
		this.jsonMapper = jsonMapper;
		this.treatmentDetailDao = treatmentDetailDao;
		this.treatmentDao = treatmentDao;
		this.frecuencyTypeDao = frecuencyTypeDao;
	}

	private TreatmentDetailEntity mapperTreatmentDetailEntity(TreatmentDetail treatmentDetail) {
		return TreatmentDetailEntity
				.builder()
				.description(treatmentDetail.getDescription())
				.observation(treatmentDetail.getObservation())
				.frecuency(treatmentDetail.getFrecuency())
				.total(treatmentDetail.getTotal())
				.startTime(new Date())
				.prevTime(new Date())
				.used(treatmentDetail.getUsed())
				.frecuencyTypeId(treatmentDetail.getFrecuencyTypeId())
				.productId(treatmentDetail.getProductId())
				.treatmentId(treatmentDetail.getTreatmentId())
				.build();
	}
	
	private TreatmentDetail mapperTreatmentDetail(TreatmentDetailEntity treatmentDetailEntity) {
		return jsonMapper.convertValue(treatmentDetailEntity, TreatmentDetail.class);
	}
	
	@Override
	public TreatmentDetail save(TreatmentDetail treatmentDetail) {
		TreatmentDetailEntity treatmentDetailEntity = mapperTreatmentDetailEntity(treatmentDetail);
		treatmentDetailEntity = treatmentDetailDao.save(treatmentDetailEntity);
		return mapperTreatmentDetail(treatmentDetailEntity);
	}

	@Override
	public List<TreatmentDetail> findAll() {
		List<TreatmentDetailEntity> treatmentDetailEntities = treatmentDetailDao.findAll();
		return treatmentDetailEntities.stream().map(entity -> (mapperTreatmentDetail(entity))).collect(Collectors.toList());
	}

	@Override
	public TreatmentDetail findById(Long id) {
		Optional<TreatmentDetailEntity> optional = treatmentDetailDao.findById(id);
		if(optional.isPresent()) {
			return mapperTreatmentDetail(optional.get());
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se ha encontrado el detalle de tratamiento con id" + id);
	}

	
	@Override
	public List<TreatmentDetail> findByTreatmentId(Long treatmentId) {
		List<TreatmentDetailEntity> treatmentDetailEntities = treatmentDetailDao.findByTreatmentId(treatmentId);
		return treatmentDetailEntities.stream().map(entity -> (mapperTreatmentDetail(entity))).collect(Collectors.toList());
	}

}
