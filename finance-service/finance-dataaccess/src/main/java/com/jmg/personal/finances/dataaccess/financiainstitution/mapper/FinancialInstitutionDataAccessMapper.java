package com.jmg.personal.finances.dataaccess.financiainstitution.mapper;

import com.jmg.personal.finances.dataaccess.financiainstitution.entity.FinancialInstitutionEntity;
import com.jmg.personal.finances.domain.core.entity.FinancialInstitution;
import com.jmg.personal.finances.domain.core.valueobject.FinancialInstitutionId;
import org.springframework.stereotype.Component;

@Component
public class FinancialInstitutionDataAccessMapper {

    public FinancialInstitutionEntity toFinancialInstitutionEntity(FinancialInstitution financialInstitution){
        return FinancialInstitutionEntity
                .builder()
                .id(financialInstitution.getId().getValue())
                .name(financialInstitution.getName())
                .icon(financialInstitution.getIcon())
                .build();
    }
    public FinancialInstitution toFinancialInstitution(FinancialInstitutionEntity financialInstitutionEntity) {
        return FinancialInstitution
                .builder()
                .id(new FinancialInstitutionId(financialInstitutionEntity.getId()))
                .name(financialInstitutionEntity.getName())
                .icon(financialInstitutionEntity.getIcon())
                .build();
    }

}
