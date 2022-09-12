package pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.core.domain.output;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FrecuencyTypeResponse {

	private String code;
	private String name;
	
}
