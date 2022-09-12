package pe.com.nzegarra.starup.customerfollowup.mscustomermanagement.infraestructure.domain.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="person")
public class PersonEntity {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqPerson")
	@SequenceGenerator(sequenceName = "SEQ_PERSON", allocationSize = 1, name = "seqPerson")
	//@GeneratedValue(strategy=GenerationType.SEQUENCE) 
	private Long id;
	
	@NotNull(message = "Nombre es requerido")
  	@Size(min = 3, max = 60, message = "El nombre.....")
	private String firstname;
	@NotNull(message = "Apellido es requerido")
  	@Size(min = 5, max = 60, message = "El nombre.....")
	private String lastname;
	@NotNull(message = "Documento es requerido")
  	@Size(min = 4, max = 20, message = "El nombre.....")
	private String document;
	@NotNull(message = "Sexo de la persona es requerido")
  	@Size(min = 1, max = 20, message = "El nombre.....")
  	@Column(name = "sex")
	private String sex;
  	@Size(min = 5, max = 120, message = "El nombre.....")
	private String email;
	private String address;
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date createdate;
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date modifieddate;
//	@NotNull(message = "Telefono de la persona es requerido")
	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<PhoneEntity> phones;
	
	public void addAllPhone(Set<PhoneEntity> phonesEntities) {
		phonesEntities.stream().forEach(phone -> {
			System.out.println("hola");
			phone.setPerson(this);
		});
		if(Objects.isNull(phones)) {
			phones = new HashSet<>();
		}
		phones.addAll(phonesEntities);
	}
	public void removeAlltPhone(Set<PhoneEntity> phones) {
		if(!Objects.isNull(phones)) {
			phones = new HashSet<>();
		}
		phones.stream().forEach(phone -> phone.setPerson(null));
	}
	
	public void addPhone(PhoneEntity phoneEntity) {
		if(phones == null) {
			phones = new HashSet<>();
		}
		phones.add(phoneEntity);
		phoneEntity.setPerson(this);
	}
	
	public void removePhone(PhoneEntity phoneEntity) {
		if(!Objects.isNull(phones)) {
			phones.remove(phoneEntity);
		}
		phoneEntity.setPerson(null);
	}
}
