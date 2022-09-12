package pe.com.nzegarra.starup.customerfollowup.mscustomermanagement.infraestructure;

import java.util.List;

import pe.com.nzegarra.starup.customerfollowup.mscustomermanagement.core.domain.Customer;
import pe.com.nzegarra.starup.customerfollowup.mscustomermanagement.core.domain.output.GeneralResponse;

public interface CustomerRepository {

	public Customer saveCustomer(Customer customer);
	public List<Customer> findAll();
	public Customer findById(Long id);
	public void deleteById(Long id);
}
