package pe.com.nzegarra.starup.customerfollowup.mscustomermanagement.infraestructure.adapter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.databind.json.JsonMapper;

import pe.com.nzegarra.starup.customerfollowup.mscustomermanagement.core.domain.Customer;
import pe.com.nzegarra.starup.customerfollowup.mscustomermanagement.core.domain.Phone;
import pe.com.nzegarra.starup.customerfollowup.mscustomermanagement.infraestructure.CustomerRepository;
import pe.com.nzegarra.starup.customerfollowup.mscustomermanagement.infraestructure.dao.CustomerDao;
import pe.com.nzegarra.starup.customerfollowup.mscustomermanagement.infraestructure.dao.PersonDao;
import pe.com.nzegarra.starup.customerfollowup.mscustomermanagement.infraestructure.dao.PhoneDao;
import pe.com.nzegarra.starup.customerfollowup.mscustomermanagement.infraestructure.domain.entity.CustomerEntity;
import pe.com.nzegarra.starup.customerfollowup.mscustomermanagement.infraestructure.domain.entity.PersonEntity;
import pe.com.nzegarra.starup.customerfollowup.mscustomermanagement.infraestructure.domain.entity.PhoneEntity;

public class CustomerAdapter implements CustomerRepository{

	private JsonMapper jsonMapper;
	private CustomerDao customerDao;
	private PersonDao personDao;
	private PhoneDao phoneDao;

	
	
	public CustomerAdapter(JsonMapper jsonMapper, CustomerDao customerDao, PersonDao personDao, PhoneDao phoneDao) {
		this.jsonMapper = jsonMapper;
		this.customerDao = customerDao;
		this.personDao = personDao;
		this.phoneDao = phoneDao;
	}

	private Customer mapperCustomer(CustomerEntity customerEntity) {
//		return jsonMapper.convertValue(customerEntity, Customer.class);
//		Set<Phone> phoneEntities = customerEntity.getPhones().stream().map(entity -> Phone.builder().phone(entity.getPhone()).build()).collect(Collectors.toSet());
		return Customer.builder().firstname(customerEntity.getFirstname())
			.lastname(customerEntity.getLastname())
			.document(customerEntity.getDocument())
			.sex(customerEntity.getSex())
			.email(customerEntity.getEmail())
			.address(customerEntity.getAddress())
//			.phones(phoneEntities)
			.build();
	}
	
	private Phone mapperPhone(PhoneEntity phoneEntity) {
		return Phone.builder().phone(phoneEntity.getPhone()).build();
	}
	
	private CustomerEntity mapperCustomerEntity(Customer customer) {
		return jsonMapper.convertValue(customer, CustomerEntity.class);
	}
	
	private CustomerEntity mapperPersonEntityToCustomerEntity(PersonEntity personEntity) {
		return jsonMapper.convertValue(personEntity, CustomerEntity.class);
	}
	
	private PersonEntity mapperCustomerEntityToPersonEntity(CustomerEntity customerEntity) {
		return jsonMapper.convertValue(customerEntity, CustomerEntity.class);
	}
	
	private PersonEntity mapperPersonEntity(Customer customer) {
//		return jsonMapper.readValue(customer, PersonEntity.class)
//		return jsonMapper.convertValue(customer, PersonEntity.class);
//		Set<PhoneEntity> phoneEntities = customer.getPhones().stream().map(cPhone -> PhoneEntity.builder().phone(cPhone.getPhone()).build()).collect(Collectors.toSet());
//		PersonEntity personEntity = PersonEntity.builder().firstname(customer.getFirstname())
		return PersonEntity.builder().firstname(customer.getFirstname())
			.lastname(customer.getLastname())
			.document(customer.getDocument())
			.sex(customer.getSex())
			.email(customer.getEmail())
			.address(customer.getAddress())
//			.phones(phoneEntities)
			.build();
//		personEntity.addAllPhone(phoneEntities);
//		return personEntity;
	}
	
	private PhoneEntity mapperPhoneEntity(Customer customer) {
		return jsonMapper.convertValue(customer, PhoneEntity.class);
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		PersonEntity personEntity = mapperPersonEntity(customer);
//		personEntity = personDao.save(personEntity);
//		CustomerEntity customerEntity = mapperCustomerEntity(customer);
		CustomerEntity customerEntity =  mapperPersonEntityToCustomerEntity(personEntity);
//		customerEntity.setId(personEntity.getId());
		customerEntity = customerDao.save(customerEntity);
		personEntity = mapperCustomerEntityToPersonEntity(customerEntity);
		
//		List<PhoneEntity> phoneEntities = new ArrayList<>();
		for(Phone phone : customer.getPhones()) {
			PhoneEntity phoneEntity = PhoneEntity.builder()
					.phone(phone.getPhone())
					.person(personEntity)
					.build();
//			phoneEntities.add(phoneDao.save(phoneEntity));
			phoneDao.save(phoneEntity);
		}
//		customerEntity.setPhones(phoneEntities.stream().collect(Collectors.toSet()));
		return mapperCustomer(customerEntity);
	}

	@Override
	public List<Customer> findAll() {
		List<CustomerEntity> customerEntities = customerDao.findAll();
		return customerEntities.stream().map(entity -> mapperCustomer(entity)).collect(Collectors.toList());
	}

	@Override
	public Customer findById(Long id) {
		Optional<CustomerEntity> optional = customerDao.findById(id);
		if(optional.isPresent()) {
			return mapperCustomer(optional.get());
		}
		
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se ha encontrado el cliente con id" + id);
	}
	
	@Override
	public void deleteById(Long id) {
		customerDao.deleteById(id);
	}
	
}
