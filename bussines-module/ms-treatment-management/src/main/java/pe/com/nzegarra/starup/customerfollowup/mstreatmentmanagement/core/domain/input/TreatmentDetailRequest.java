package pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.core.domain.input;

import java.util.Date;

import lombok.Data;

@Data
public class TreatmentDetailRequest {

	private String description;
	private String observation;
	private Long frecuency;
	private Date startTime;
	private Date prevTime;
	private Integer total;
	private Integer used;
	private Long frecuencyTypeId;
	private Long productId;
	private Long treatmentId;
	
	
}
