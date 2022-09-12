package pe.com.nzegarra.starup.customerfollowup.mscustomermanagement.core.service;

import java.util.List;

import pe.com.nzegarra.starup.customerfollowup.mscustomermanagement.core.domain.Customer;
import pe.com.nzegarra.starup.customerfollowup.mscustomermanagement.infraestructure.CustomerRepository;

public class CustomerServiceImpl implements CustomerService{

	private CustomerRepository customerRepository;
	
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		return customerRepository.saveCustomer(customer);
	}

	@Override
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

	@Override
	public Customer findById(Long id) {
		return customerRepository.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		customerRepository.deleteById(id);
	}
}
