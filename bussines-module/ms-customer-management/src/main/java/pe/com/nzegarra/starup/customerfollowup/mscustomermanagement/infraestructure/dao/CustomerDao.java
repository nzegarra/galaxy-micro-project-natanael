package pe.com.nzegarra.starup.customerfollowup.mscustomermanagement.infraestructure.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.com.nzegarra.starup.customerfollowup.mscustomermanagement.infraestructure.domain.entity.CustomerEntity;

@Repository
public interface CustomerDao extends JpaRepository<CustomerEntity, Long>{

}
