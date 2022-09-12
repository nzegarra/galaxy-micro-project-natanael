package pe.com.nzegarra.starup.customerfollowup.mscustomermanagement.infraestructure.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.com.nzegarra.starup.customerfollowup.mscustomermanagement.infraestructure.domain.entity.PersonEntity;

public interface PersonDao extends JpaRepository<PersonEntity, Long>{

}
