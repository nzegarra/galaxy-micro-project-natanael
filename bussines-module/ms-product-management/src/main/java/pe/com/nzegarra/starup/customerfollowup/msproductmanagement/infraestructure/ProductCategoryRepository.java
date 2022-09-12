package pe.com.nzegarra.starup.customerfollowup.msproductmanagement.infraestructure;

import java.util.List;

import pe.com.nzegarra.starup.customerfollowup.msproductmanagement.core.domain.ProductCategory;

public interface ProductCategoryRepository {

	public ProductCategory save(ProductCategory productCategory);
	public List<ProductCategory> findAll();
}
