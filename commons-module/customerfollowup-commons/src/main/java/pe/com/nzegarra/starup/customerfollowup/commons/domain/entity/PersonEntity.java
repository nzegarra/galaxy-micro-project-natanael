package pe.com.nzegarra.starup.customerfollowup.commons.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
@Table(name="PERSON")
public class PersonEntity {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqPerson")
	@SequenceGenerator(sequenceName = "SEQ_PERSON", allocationSize = 1, name = "seqPerson")
	private Long id;
	
	@NotNull(message = "Nombre es requerido")
  	@Size(min = 3, max = 60, message = "El nombre.....")
	private String firstname;
	@NotNull(message = "Apellido es requerido")
  	@Size(min = 5, max = 60, message = "El nombre.....")
	private String lastname;
  	@Size(min = 4, max = 20, message = "El nombre.....")
	private String document;
	@NotNull(message = "Sexo de la persona es requerido")
  	@Size(min = 1, max = 20, message = "El nombre.....")
  	@Column(name = "sex")
	private String sex;
  	@Size(min = 5, max = 120, message = "El nombre.....")
	private String email;
	private String address;
	private PhoneEntity phone;
}
