package pe.com.nzegarra.starup.customerfollowup.mscustomermanagement.delivery;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.json.JsonMapper;

import pe.com.nzegarra.starup.customerfollowup.mscustomermanagement.core.domain.Customer;
import pe.com.nzegarra.starup.customerfollowup.mscustomermanagement.core.domain.input.CustomerRequest;
import pe.com.nzegarra.starup.customerfollowup.mscustomermanagement.core.domain.output.CustomerResponse;
import pe.com.nzegarra.starup.customerfollowup.mscustomermanagement.core.domain.output.GeneralResponse;
import pe.com.nzegarra.starup.customerfollowup.mscustomermanagement.core.domain.output.MessageResponse;
import pe.com.nzegarra.starup.customerfollowup.mscustomermanagement.core.service.CustomerService;
import pe.com.nzegarra.starup.customerfollowup.mscustomermanagement.core.util.CustomerConstants;

public class CustomerController {

	private CustomerService customerService;
	private JsonMapper jsonMapper;
	
	
	
	public CustomerController(CustomerService customerService, JsonMapper jsonMapper) {
		this.customerService = customerService;
		this.jsonMapper = jsonMapper;
	}

	public CustomerResponse save(CustomerRequest request) {
		
		Customer customer = customerService.saveCustomer(mapperCustomer(request));
		
		return mapperCustomerResponse(customer);
	}
	
	public List<CustomerResponse> findAll(){
		return  customerService.findAll().stream().map(cutomer -> mapperCustomerResponse(cutomer)).collect(Collectors.toList());
	}
	
	public CustomerResponse findById(Long id) {
		return mapperCustomerResponse(customerService.findById(id));
	}
	
	public GeneralResponse deleteById(Long id) {
		customerService.deleteById(id);
		return GeneralResponse
				.builder()
				.response(MessageResponse
						.builder()
						.code(CustomerConstants.CODE_SUCCES)
						.message(String.format("Se ha eliminado el cliente %d", id))
						.build())
				.build();
	}
	
	private Customer mapperCustomer(CustomerRequest customerRequest) {
		return jsonMapper.convertValue(customerRequest, Customer.class);
	}
	
	private CustomerResponse mapperCustomerResponse(Customer customer) {
		return jsonMapper.convertValue(customer, CustomerResponse.class);
	}

	
//	private <T> T mapperCustomerResponse(Object object, Class<T> className) {
//		return jsonMapper.convertValue(object, className);
//	}
}
