package pe.com.nzegarra.starup.customerfollowup.commons.domain.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name="PHONE")
public class PhoneEntity {

	@Id
	@Column(name="id_phone")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqPhone")
	@SequenceGenerator(sequenceName = "SEQ_PHONE", allocationSize = 1, name = "seqPhone")
	private Long id;
	@NotNull
	@Column(name = "phone")
	private String phone;
	@NotNull
	@Column(name = "createdate")
	private Date createdate;
	@NotNull
	@Column(name = "modifieddate")
	private Date modifieddate;
	private Long personId;
}
