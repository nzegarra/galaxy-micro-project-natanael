package pe.com.nzegarra.starup.customerfollowup.mstreatmentcommand.infraestructure.domain.entity;


import java.io.Serializable;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "Treatment")
public class TreatmentDocument implements Serializable{

	@Id
    private String id= UUID.randomUUID().toString();
	@Field("code")
	private String code;
	@Field("name")
	private String name;
	@Field("description")
	private String description;
	@Field("obervation")
	private String obervation;
	@Field("createdate")
	private String createdate;
	@Field("modifiedate")
	private String modifiedate;
	@Field("userId")
	private Long userId;
	@Field("clientId")
	private Long clientId;
	
}
