package pe.com.nzegarra.starup.customerfollowup.mstreatment.document;


import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Treatment implements Serializable {

	private static final long serialVersionUID = 1L;

	private String code;
	private String name;
	private String description;
	private String obervation;
//	private String createdate;
//	private String modifiedate;
	private Long userId;
	private Long clientId;

}
