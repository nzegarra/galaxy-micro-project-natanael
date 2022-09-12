package pe.com.nzegarra.starup.customerfollowup.mscustomermanagement.core.domain.output;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.com.nzegarra.starup.customerfollowup.mscustomermanagement.core.domain.Phone;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponse {

	private Long id;
	private String firstname;
	private String lastname;
	private String document;
	private String sex;
	private String email;
	private String address;
	private List<Phone> phones;
	
}
