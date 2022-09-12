package pe.com.nzegarra.starup.customerfollowup.msproductmanagement.core.service;

import java.util.List;

import pe.com.nzegarra.starup.customerfollowup.msproductmanagement.core.domain.ProductCategory;
import pe.com.nzegarra.starup.customerfollowup.msproductmanagement.infraestructure.ProductCategoryRepository;


public class ProductCategoryServiceImpl implements ProductCategoryService{

	private ProductCategoryRepository productCategoryRepository;
	
	public ProductCategoryServiceImpl(ProductCategoryRepository productCategoryRepository) {
		super();
		this.productCategoryRepository = productCategoryRepository;
	}

	@Override
	public ProductCategory save(ProductCategory productCategory) {
		return productCategoryRepository.save(productCategory);
	}

	@Override
	public List<ProductCategory> findAll() {
		return productCategoryRepository.findAll();
	}

}
