package pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.core.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TreatmentDetail {

	private String description;
	private String observation;
	private Long frecuency;
	private Date startTime;
	private Date prevTime;
	private Integer total;
	private Integer used;
	private Date createdate;
	private Date modifiedate;
	private Long frecuencyTypeId;
	private Long productId;
	private Long treatmentId;
}
