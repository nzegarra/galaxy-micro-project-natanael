package pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.infraestructure.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.infraestructure.domain.entity.FrecuencyTypeEntity;


@Repository
public interface FrecuencyTypeDao extends JpaRepository<FrecuencyTypeEntity, Long>{

	FrecuencyTypeEntity findByCode(String code);
}
