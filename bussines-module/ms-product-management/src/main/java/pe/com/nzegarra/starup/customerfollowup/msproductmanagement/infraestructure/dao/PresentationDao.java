package pe.com.nzegarra.starup.customerfollowup.msproductmanagement.infraestructure.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.com.nzegarra.starup.customerfollowup.msproductmanagement.infraestructure.domain.entity.PresentationEntity;

@Repository
public interface PresentationDao extends JpaRepository<PresentationEntity, Long>{

	PresentationEntity findByCode(String code);
}
