package pe.com.nzegarra.starup.customerfollowup.msproductmanagement.core.service;

import java.util.List;

import pe.com.nzegarra.starup.customerfollowup.msproductmanagement.core.domain.Product;
import pe.com.nzegarra.starup.customerfollowup.msproductmanagement.infraestructure.ProductRepository;


public class ProductServiceImpl implements ProductService{

	private ProductRepository productRepository;
	
	public ProductServiceImpl(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}

	@Override
	public Product save(Product product) {
		return productRepository.save(product);
	}

	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	public Product findById(Long id) {
		return productRepository.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		productRepository.deleteById(id);
	}
}
