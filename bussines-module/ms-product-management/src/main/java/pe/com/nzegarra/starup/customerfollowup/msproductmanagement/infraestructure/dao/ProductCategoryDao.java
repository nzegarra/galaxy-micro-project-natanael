package pe.com.nzegarra.starup.customerfollowup.msproductmanagement.infraestructure.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.com.nzegarra.starup.customerfollowup.msproductmanagement.infraestructure.domain.entity.ProductCategoryEntity;

@Repository
public interface ProductCategoryDao extends JpaRepository<ProductCategoryEntity, Long>{

	ProductCategoryEntity findByCode(String code);
}
