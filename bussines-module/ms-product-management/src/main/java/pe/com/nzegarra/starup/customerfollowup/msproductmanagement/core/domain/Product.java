package pe.com.nzegarra.starup.customerfollowup.msproductmanagement.core.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {

	private String name;
	private String description;
	private Long price;
	private String productCategoryCode;
	private String presentationCode;
}
