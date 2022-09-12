package pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.core.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FrecuencyType {

	private String code;
	private String name;
}
