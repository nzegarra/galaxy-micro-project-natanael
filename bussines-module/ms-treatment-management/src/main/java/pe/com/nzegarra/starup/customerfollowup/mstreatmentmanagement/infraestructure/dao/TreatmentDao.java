package pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.infraestructure.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.infraestructure.domain.entity.TreatmentEntity;


@Repository
public interface TreatmentDao extends JpaRepository<TreatmentEntity, Long>{

	List<TreatmentEntity>  findByUserIdAndClientId(Long userId, Long clientId);
	List<TreatmentEntity>  findByUserId(Long userId);
	List<TreatmentEntity> findByClientId(Long clientId);
}
