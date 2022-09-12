package pe.com.nzegarra.starup.customerfollowup.mstreatmentcommand.core.domain.output;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MessageResponse {

	private Integer code;
	private String message;
	private String messageError;
}
