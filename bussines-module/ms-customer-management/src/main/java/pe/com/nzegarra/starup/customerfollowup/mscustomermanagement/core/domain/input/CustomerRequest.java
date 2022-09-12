package pe.com.nzegarra.starup.customerfollowup.mscustomermanagement.core.domain.input;

import java.util.List;
import java.util.Set;

import lombok.Data;
import pe.com.nzegarra.starup.customerfollowup.mscustomermanagement.core.domain.Phone;

@Data
public class CustomerRequest {

	private String firstname;
	private String lastname;
	private String document;
	private String sex;
	private String email;
	private String address;
	private Set<Phone> phones;
	
}
