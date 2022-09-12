package pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.infraestructure.domain.entity;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "treatment")
public class TreatmentEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Size(min = 3, max = 3, message = "Ingrese un código de 3 dígitos")
	@Column(unique = true)
	private String code;
	@NotNull
	@Size(max = 50, message = "Ingrese un nombre de 50 dígitos")
	private String name;
	private String description;
	private String obervation;
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date createdate;
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date modifiedate;
	@Column(name = "user_id")
	@NotNull
	private Long userId;
	@Column(name = "client_id")
	@NotNull
	private Long clientId;
	
//	@OneToMany(mappedBy = "treatment", cascade = CascadeType.ALL, orphanRemoval = true)
//	private List<TreatmentDetailEntity> treatmentDetails;
	
//	public void addTreatmentDetail(TreatmentDetailEntity treatmentDetailEntity) {
//		if(treatmentDetails == null) {
//			treatmentDetails = new ArrayList<>();
//		}
//		treatmentDetails.add(treatmentDetailEntity);
//		treatmentDetailEntity.setTreatment(this);
//	}
//	
//	public void removeTreatmentDetail(TreatmentDetailEntity treatmentDetailEntity) {
//		if(treatmentDetails != null) {
//			treatmentDetails.remove(treatmentDetailEntity);
//		}
//		treatmentDetailEntity.setTreatment(null);
//	}
}
