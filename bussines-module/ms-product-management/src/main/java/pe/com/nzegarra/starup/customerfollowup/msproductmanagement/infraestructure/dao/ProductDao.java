package pe.com.nzegarra.starup.customerfollowup.msproductmanagement.infraestructure.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.com.nzegarra.starup.customerfollowup.msproductmanagement.infraestructure.domain.entity.ProductEntity;

@Repository
public interface ProductDao extends JpaRepository<ProductEntity, Long>{

}
