package pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.core.domain.output;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GeneralResponse {

	private MessageResponse response;
	private Object data;
}
