package pe.com.nzegarra.starup.customerfollowup.msproductmanagement.delivery;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.json.JsonMapper;

import pe.com.nzegarra.starup.customerfollowup.msproductmanagement.core.domain.Product;
import pe.com.nzegarra.starup.customerfollowup.msproductmanagement.core.domain.input.ProductRequest;
import pe.com.nzegarra.starup.customerfollowup.msproductmanagement.core.domain.output.GeneralResponse;
import pe.com.nzegarra.starup.customerfollowup.msproductmanagement.core.domain.output.MessageResponse;
import pe.com.nzegarra.starup.customerfollowup.msproductmanagement.core.domain.output.ProductResponse;
import pe.com.nzegarra.starup.customerfollowup.msproductmanagement.core.service.ProductService;
import pe.com.nzegarra.starup.customerfollowup.msproductmanagement.core.util.ProductConstants;

public class ProductController {

	private ProductService productService;
	private JsonMapper jsonMapper;
	
	
	
	public ProductController(ProductService productService, JsonMapper jsonMapper) {
		this.productService = productService;
		this.jsonMapper = jsonMapper;
	}

	public ProductResponse save(ProductRequest request) {
		
		Product product = productService.save(mapperProduct(request));
		
		return mapperProductResponse(product);
	}
	
	public List<ProductResponse> findAll(){
		return  productService.findAll().stream().map(product -> mapperProductResponse(product)).collect(Collectors.toList());
	}
	
	public ProductResponse findById(Long id) {
		return mapperProductResponse(productService.findById(id));
	}
	
	public GeneralResponse deleteById(Long id) {
		productService.deleteById(id);
		return GeneralResponse
				.builder()
				.response(MessageResponse
						.builder()
						.code(ProductConstants.CODE_SUCCES)
						.message(String.format("Se ha eliminado el cliente %d", id))
						.build())
				.build();
	}
	
	private Product mapperProduct(ProductRequest productRequest) {
		return jsonMapper.convertValue(productRequest, Product.class);
	}
	
	private ProductResponse mapperProductResponse(Product product) {
		return jsonMapper.convertValue(product, ProductResponse.class);
	}

	
//	private <T> T mapperCustomerResponse(Object object, Class<T> className) {
//		return jsonMapper.convertValue(object, className);
//	}
}
