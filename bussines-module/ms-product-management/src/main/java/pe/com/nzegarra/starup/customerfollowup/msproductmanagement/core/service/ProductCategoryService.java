package pe.com.nzegarra.starup.customerfollowup.msproductmanagement.core.service;

import java.util.List;

import pe.com.nzegarra.starup.customerfollowup.msproductmanagement.core.domain.ProductCategory;

public interface ProductCategoryService {

	ProductCategory save(ProductCategory productCategory);
	List<ProductCategory> findAll();
	
}
