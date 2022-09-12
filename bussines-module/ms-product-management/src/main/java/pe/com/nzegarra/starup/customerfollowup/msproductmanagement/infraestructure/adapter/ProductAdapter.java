package pe.com.nzegarra.starup.customerfollowup.msproductmanagement.infraestructure.adapter;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.databind.json.JsonMapper;

import pe.com.nzegarra.starup.customerfollowup.msproductmanagement.core.domain.Product;
import pe.com.nzegarra.starup.customerfollowup.msproductmanagement.infraestructure.ProductRepository;
import pe.com.nzegarra.starup.customerfollowup.msproductmanagement.infraestructure.dao.PresentationDao;
import pe.com.nzegarra.starup.customerfollowup.msproductmanagement.infraestructure.dao.ProductCategoryDao;
import pe.com.nzegarra.starup.customerfollowup.msproductmanagement.infraestructure.dao.ProductDao;
import pe.com.nzegarra.starup.customerfollowup.msproductmanagement.infraestructure.domain.entity.PresentationEntity;
import pe.com.nzegarra.starup.customerfollowup.msproductmanagement.infraestructure.domain.entity.ProductCategoryEntity;
import pe.com.nzegarra.starup.customerfollowup.msproductmanagement.infraestructure.domain.entity.ProductEntity;

public class ProductAdapter implements ProductRepository{

	private JsonMapper jsonMapper;
	private ProductDao productDao;
	private ProductCategoryDao productCategoryDao;
	private PresentationDao presentationDao;
	
	
	public ProductAdapter(JsonMapper jsonMapper, ProductDao productDao, ProductCategoryDao productCategoryDao,
			PresentationDao presentationDao) {
		this.jsonMapper = jsonMapper;
		this.productDao = productDao;
		this.productCategoryDao = productCategoryDao;
		this.presentationDao = presentationDao;
	}

	private ProductEntity mapperProductEntity(Product product, ProductCategoryEntity productCategoryEntity, PresentationEntity presentationEntity) {
		return ProductEntity
				.builder()
				.name(product.getName())
				.description(product.getDescription())
				.price(product.getPrice())
				.productCategory(productCategoryEntity)
				.presentation(presentationEntity)
				.build();
	}
	
	private Product mapperProduct(ProductEntity productEntity) {
		return Product.builder()
				.name(productEntity.getName())
				.description(productEntity.getDescription())
				.price(productEntity.getPrice())
				.productCategoryCode(productEntity.getProductCategory().getCode())
				.presentationCode(productEntity.getPresentation().getCode())
				.build();
	}
	
	@Override
	public Product save(Product product) {
		ProductCategoryEntity productCategoryEntity = productCategoryDao.findByCode(product.getProductCategoryCode());
		if(Objects.isNull(productCategoryEntity)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se ha encontrado la categoría con código " + product.getProductCategoryCode());
		}
		PresentationEntity presentationEntity = presentationDao.findByCode(product.getPresentationCode());
		if(Objects.isNull(presentationEntity)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se ha encontrado la presentación con código " + product.getPresentationCode());
		}
		ProductEntity productEntity = mapperProductEntity(product, productCategoryEntity, presentationEntity);
		
		productEntity = productDao.save(productEntity);
		
		return mapperProduct(productEntity);
	}

	@Override
	public List<Product> findAll() {
		List<ProductEntity> productEntities = productDao.findAll();
		return productEntities.stream().map(entity -> mapperProduct(entity)).collect(Collectors.toList());
	}

	@Override
	public Product findById(Long id) {
		Optional<ProductEntity> optional = productDao.findById(id);
		if(optional.isPresent()) {
			return mapperProduct(optional.get());
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se ha encontrado el producto con id" + id);
	}

	@Override
	public void deleteById(Long id) {
		productDao.deleteById(id);
		
	}

}
