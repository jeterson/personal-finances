package com.jmg.personal.finances.dataaccess.financiainstitution.repository;

import com.jmg.personal.finances.dataaccess.financiainstitution.entity.FinancialInstitutionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FinancialInstitutionJpaRepository extends JpaRepository<FinancialInstitutionEntity, UUID> {
}
