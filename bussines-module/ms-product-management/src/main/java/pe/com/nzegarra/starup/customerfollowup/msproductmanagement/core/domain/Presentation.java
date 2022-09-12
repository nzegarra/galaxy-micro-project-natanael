package pe.com.nzegarra.starup.customerfollowup.msproductmanagement.core.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Presentation {

	private String code;
	private String name;
	
}
