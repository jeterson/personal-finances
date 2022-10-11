package com.jmg.personal.finances.domain.application.service.ports.output.repository;

import com.jmg.personal.finances.domain.application.service.dto.financialinstitution.FinancialInstitutionResponse;
import com.jmg.personal.finances.domain.core.entity.FinancialInstitution;
import com.jmg.personal.finances.domain.core.valueobject.FinancialInstitutionId;

import java.util.List;
import java.util.Optional;

public interface FinancialInstitutionRepository {

    FinancialInstitution save(FinancialInstitution financialInstitution);
    List<FinancialInstitution> findAll();
    Optional<FinancialInstitution> findById(FinancialInstitutionId financialInstitutionId);
}
