package pe.com.nzegarra.starup.customerfollowup.msproductmanagement.core.domain.output;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductCategoryResponse {

	private String code;
	private String name;
}
