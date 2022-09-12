package pe.com.nzegarra.starup.customerfollowup.mstreatmentcommand.infraestructure.adapter;



import com.fasterxml.jackson.databind.json.JsonMapper;

import pe.com.nzegarra.starup.customerfollowup.mstreatmentcommand.core.domain.Treatment;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentcommand.infraestructure.TreatmentRepository;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentcommand.infraestructure.dao.TreatmentDao;
import pe.com.nzegarra.starup.customerfollowup.mstreatmentcommand.infraestructure.domain.entity.TreatmentDocument;
import reactor.core.publisher.Mono;


public class TreatmentAdapter implements TreatmentRepository{

	private JsonMapper jsonMapper;
	private TreatmentDao treatmentDao;
	
	public TreatmentAdapter(JsonMapper jsonMapper, TreatmentDao treatmentDao) {
		this.jsonMapper = jsonMapper;
		this.treatmentDao = treatmentDao;
	}

	private TreatmentDocument mapperTreatmentEntity(Treatment treatment) {
		return jsonMapper.convertValue(treatment, TreatmentDocument.class);
	}
	
	private Treatment mapperTreatment(TreatmentDocument treatmentDocument) {
		return jsonMapper.convertValue(treatmentDocument, Treatment.class);
	}
	
	@Override
	public Treatment save(Treatment treatment) {
		TreatmentDocument treatmentDocument = mapperTreatmentEntity(treatment);
		Mono<TreatmentDocument> treatMono = treatmentDao.save(treatmentDocument);
//		TreatmentDocument treatMono = treatmentDao.save(treatmentDocument);
		return mapperTreatment(treatMono.block());
//		return mapperTreatment(treatMono);
	}


}
