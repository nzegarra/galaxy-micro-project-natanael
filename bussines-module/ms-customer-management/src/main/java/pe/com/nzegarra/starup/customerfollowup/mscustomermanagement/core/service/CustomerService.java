package pe.com.nzegarra.starup.customerfollowup.mscustomermanagement.core.service;

import java.util.List;

import pe.com.nzegarra.starup.customerfollowup.mscustomermanagement.core.domain.Customer;

public interface CustomerService {

	Customer saveCustomer(Customer customer) ;
	public List<Customer> findAll();
	public Customer findById(Long id);
	public void deleteById(Long id);
}
