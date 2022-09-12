package pe.com.nzegarra.starup.customerfollowup.msproductmanagement.core.domain.output;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GeneralResponse {

	private MessageResponse response;
	private Object data;
}
