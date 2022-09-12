package pe.com.nzegarra.starup.customerfollowup.msproductmanagement.infraestructure;

import java.util.List;

import pe.com.nzegarra.starup.customerfollowup.msproductmanagement.core.domain.Product;

public interface ProductRepository {

	public Product save(Product product);
	public List<Product> findAll();
	public Product findById(Long id);
	public void deleteById(Long id);
}
