package com.jmg.personal.finances.domain.application.service.mapper;

import com.jmg.personal.finances.domain.application.service.dto.financialinstitution.FinancialInstitutionResponse;
import com.jmg.personal.finances.domain.core.entity.FinancialInstitution;
import org.springframework.stereotype.Component;

@Component
public class FinancialInstitutionDataMapper {

    public FinancialInstitutionResponse toFinancialInstitutionResponse(FinancialInstitution financialInstitution) {
        return FinancialInstitutionResponse.builder()
                .id(financialInstitution.getId().getValue())
                .name(financialInstitution.getName())
                .icon(financialInstitution.getIcon())
                .build();
    }
}
