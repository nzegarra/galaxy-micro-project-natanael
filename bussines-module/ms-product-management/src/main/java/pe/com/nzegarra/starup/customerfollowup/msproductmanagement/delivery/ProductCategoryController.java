package pe.com.nzegarra.starup.customerfollowup.msproductmanagement.delivery;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.json.JsonMapper;

import pe.com.nzegarra.starup.customerfollowup.msproductmanagement.core.domain.ProductCategory;
import pe.com.nzegarra.starup.customerfollowup.msproductmanagement.core.domain.input.ProductCategoryRequest;
import pe.com.nzegarra.starup.customerfollowup.msproductmanagement.core.domain.output.ProductCategoryResponse;
import pe.com.nzegarra.starup.customerfollowup.msproductmanagement.core.service.ProductCategoryService;

public class ProductCategoryController {

	private ProductCategoryService productCategoryService;
	private JsonMapper jsonMapper;
	
	
	
	public ProductCategoryController(ProductCategoryService productCategoryService, JsonMapper jsonMapper) {
		this.productCategoryService = productCategoryService;
		this.jsonMapper = jsonMapper;
	}

	public ProductCategoryResponse save(ProductCategoryRequest request) {
		
		ProductCategory productCategory = productCategoryService.save(mapperProductCategory(request));
		
		return mapperProductCategoryResponse(productCategory);
	}
	
	public List<ProductCategoryResponse> findAll(){
		return  productCategoryService.findAll().stream().map(category -> mapperProductCategoryResponse(category)).collect(Collectors.toList());
	}
	
	
	private ProductCategory mapperProductCategory(ProductCategoryRequest request) {
		return jsonMapper.convertValue(request, ProductCategory.class);
	}
	
	private ProductCategoryResponse mapperProductCategoryResponse(ProductCategory productCategory) {
		return jsonMapper.convertValue(productCategory, ProductCategoryResponse.class);
	}

	
//	private <T> T mapperCustomerResponse(Object object, Class<T> className) {
//		return jsonMapper.convertValue(object, className);
//	}
}
