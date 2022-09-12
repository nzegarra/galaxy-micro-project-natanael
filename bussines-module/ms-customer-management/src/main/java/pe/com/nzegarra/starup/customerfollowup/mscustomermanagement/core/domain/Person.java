package pe.com.nzegarra.starup.customerfollowup.mscustomermanagement.core.domain;

import java.util.List;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Person {

	protected String document;
	protected String firstname;
	protected String lastname;
	protected String sex;
	protected String email;
	protected String address;
	
	protected Set<Phone> phones;
}
