package pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.infraestructure.domain.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

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
@Table(name="treatment_detail")
public class TreatmentDetailEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private String description;
	private String observation;
	@NotNull
	private Long frecuency;
	@NotNull
	@Column(name = "start_time")
	private Date startTime;
	@NotNull
	@Column(name = "prev_time")
	private Date prevTime;
	@NotNull
	private Integer total;
	@NotNull
	private Integer used;
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date createdate;
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date modifiedate;
	@NotNull
	@Column(name = "frecuency_type_id")
	private Long frecuencyTypeId;
	@NotNull
	@Column(name = "product_id")
	private Long productId;
	@NotNull
	@Column(name = "treatment_id")
	private Long treatmentId;
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "treatment_id", nullable = false)
//	private TreatmentEntity treatment;
	
//	
//	@Override
//	public boolean equals(Object o) {
//		if (this == o) return true;
//        if (!(o instanceof TreatmentEntity )) return false;
//        return id != null && id.equals(((TreatmentEntity) o).getId());
//	}
//	
//	@Override
//    public int hashCode() {
//        return getClass().hashCode();
//    }
}
