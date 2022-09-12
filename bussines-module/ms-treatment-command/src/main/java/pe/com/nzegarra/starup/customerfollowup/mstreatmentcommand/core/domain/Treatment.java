package pe.com.nzegarra.starup.customerfollowup.mstreatmentcommand.core.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Treatment {

	private String code;
	private String name;
	private String description;
	private String obervation;
	private Date createdate;
	private Date modifiedate;
	private Long userId;
	private Long clientId;
	
}
