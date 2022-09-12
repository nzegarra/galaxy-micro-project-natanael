package pe.com.nzegarra.starup.customerfollowup.msproductmanagement.core.service;

import java.util.List;

import pe.com.nzegarra.starup.customerfollowup.msproductmanagement.core.domain.Product;

public interface ProductService {

	Product save(Product customer) ;
	public List<Product> findAll();
	public Product findById(Long id);
	public void deleteById(Long id);
}
