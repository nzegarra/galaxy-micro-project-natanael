package pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.infraestructure.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.com.nzegarra.starup.customerfollowup.mstreatmentmanagement.infraestructure.domain.entity.TreatmentDetailEntity;


@Repository
public interface TreatmentDetailDao extends JpaRepository<TreatmentDetailEntity, Long>{

	List<TreatmentDetailEntity> findByTreatmentId(Long treatmentId);
}
