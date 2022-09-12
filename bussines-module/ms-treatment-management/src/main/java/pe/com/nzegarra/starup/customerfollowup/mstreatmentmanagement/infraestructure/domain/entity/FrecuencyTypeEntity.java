package pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.infraestructure.domain.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "frecuency_type")
public class FrecuencyTypeEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Size(min = 3, max = 3, message = "Ingrese un código de 3 dígitos")
	@Column(unique = true)
	private String code;
	@NotNull
	@Size(max = 50, message = "Ingrese un código de 3 dígitos")
	private String name;
//	@OneToMany(mappedBy = "presentation", orphanRemoval =true )
//	private Set<Product> products;
	
}
