package pe.com.nzegarra.starup.customerfollowup.mscustomermanagement.core.domain;

import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder//Para Lombok de la versión 1.18 hacia adelante, herencia múltiple
public class Customer extends Person{

	private Integer bonusPoint;
}
