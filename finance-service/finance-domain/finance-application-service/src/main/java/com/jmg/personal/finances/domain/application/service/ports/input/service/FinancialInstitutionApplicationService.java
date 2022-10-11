package com.jmg.personal.finances.domain.application.service.ports.input.service;

import com.jmg.personal.finances.domain.application.service.dto.financialinstitution.FinancialInstitutionResponse;
import com.jmg.personal.finances.domain.core.entity.FinancialInstitution;
import com.jmg.personal.finances.domain.core.valueobject.FinancialInstitutionId;

import java.util.List;

public interface FinancialInstitutionApplicationService {

    FinancialInstitution save(FinancialInstitution financialInstitution);
    List<FinancialInstitutionResponse> findAll();
    FinancialInstitution findById(FinancialInstitutionId financialInstitutionId);
}
