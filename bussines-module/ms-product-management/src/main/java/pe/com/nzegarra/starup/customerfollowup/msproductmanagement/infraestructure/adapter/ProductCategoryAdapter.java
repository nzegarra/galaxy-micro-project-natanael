package pe.com.nzegarra.starup.customerfollowup.msproductmanagement.infraestructure.adapter;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.json.JsonMapper;

import pe.com.nzegarra.starup.customerfollowup.msproductmanagement.core.domain.ProductCategory;
import pe.com.nzegarra.starup.customerfollowup.msproductmanagement.infraestructure.ProductCategoryRepository;
import pe.com.nzegarra.starup.customerfollowup.msproductmanagement.infraestructure.dao.ProductCategoryDao;
import pe.com.nzegarra.starup.customerfollowup.msproductmanagement.infraestructure.domain.entity.ProductCategoryEntity;

public class ProductCategoryAdapter implements ProductCategoryRepository{

	private JsonMapper jsonMapper;
	private ProductCategoryDao productCategoryDao;
	
	public ProductCategoryAdapter(JsonMapper jsonMapper, ProductCategoryDao productCategoryDao) {
		this.jsonMapper = jsonMapper;
		this.productCategoryDao = productCategoryDao;
	}

	private ProductCategoryEntity mapperProductCategoryEntity(ProductCategory productCategory) {
		return jsonMapper.convertValue(productCategory, ProductCategoryEntity.class);
	}
	
	private ProductCategory mapperProductCategory(ProductCategoryEntity productCategoryEntity) {
		return jsonMapper.convertValue(productCategoryEntity, ProductCategory.class);
	}
	
	@Override
	public ProductCategory save(ProductCategory productCategory) {
		ProductCategoryEntity productCategoryEntity = mapperProductCategoryEntity(productCategory);
				productCategoryEntity = productCategoryDao.save(productCategoryEntity);
		return mapperProductCategory(productCategoryEntity);
	}

	@Override
	public List<ProductCategory> findAll() {
		List<ProductCategoryEntity> productCategoryEntities = productCategoryDao.findAll();
		return productCategoryEntities.stream().map(entity -> mapperProductCategory(entity)).collect(Collectors.toList());
	}

}
