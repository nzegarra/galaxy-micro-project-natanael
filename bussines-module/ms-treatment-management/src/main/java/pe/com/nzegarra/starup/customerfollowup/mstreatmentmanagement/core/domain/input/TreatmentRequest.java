package pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.core.domain.input;

import lombok.Data;

@Data
public class TreatmentRequest {

	private String code;
	private String name;
	private String description;
	private String obervation;
	private Long userId;
	private Long clientId;
}
