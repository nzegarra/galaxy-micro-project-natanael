package pe.com.nzegarra.starup.customerfollowup.mscustomermanagement.infraestructure.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import pe.com.nzegarra.starup.customerfollowup.mscustomermanagement.core.domain.Phone;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="customer")
@PrimaryKeyJoinColumn(name = "person_id")
@SuperBuilder
public class CustomerEntity extends PersonEntity{

	@Column(name = "bonus_point")
	private Integer bonusPoint;
	
}
