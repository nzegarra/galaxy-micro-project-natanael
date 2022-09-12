package pe.com.nzegarra.starup.customerfollowup.msproductmanagement.core.domain.input;

import lombok.Data;

@Data
public class ProductRequest {

	private String name;
	private String description;
	private Long price;
	private String productCategoryCode;
	private String presentationCode;
}
