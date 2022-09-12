package pe.com.nzegarra.starup.customerfollowup.mscustomermanagement.infraestructure.domain.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
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
@Table(name="phone")
public class PhoneEntity {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqPhone")
	@SequenceGenerator(sequenceName = "SEQ_PHONE", allocationSize = 1, name = "seqPhone")
	//@GeneratedValue(strategy=GenerationType.SEQUENCE) 
	private Long id;
	@NotNull
	@Column(name = "phone")
	private String phone;
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date createdate;
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date modifieddate;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "person_id", nullable = false)
	private PersonEntity person;
}
