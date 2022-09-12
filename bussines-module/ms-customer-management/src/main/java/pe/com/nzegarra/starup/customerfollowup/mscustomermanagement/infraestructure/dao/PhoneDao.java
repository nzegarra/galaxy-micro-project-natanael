package pe.com.nzegarra.starup.customerfollowup.mscustomermanagement.infraestructure.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.com.nzegarra.starup.customerfollowup.mscustomermanagement.infraestructure.domain.entity.PhoneEntity;

public interface PhoneDao extends JpaRepository<PhoneEntity, Long>{

}
