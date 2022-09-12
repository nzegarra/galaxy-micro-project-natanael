package pe.com.nzegarra.starup.customerfollowup.mstreatment.rest;

import static pe.com.nzegarra.starup.customerfollowup.mstreatment.rest.commons.Constants.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;
import pe.com.nzegarra.starup.customerfollowup.mstreatment.document.Treatment;
import pe.com.nzegarra.starup.customerfollowup.mstreatment.producer.TreatmentProducer;

@Slf4j
@RestController
@RequestMapping(API_TREATMENT_PRODUCER)
public class TreatmentRest {

	private TreatmentProducer ordenProducer;

	public TreatmentRest(TreatmentProducer ordenProducer) {

		this.ordenProducer = ordenProducer;
	}

	@PostMapping
	public ResponseEntity<?> send(@RequestBody Treatment orden) {

		try {
			ordenProducer.sendMessage(orden);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return ResponseEntity.internalServerError().build();
		}
		
	};

}
