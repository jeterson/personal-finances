package com.jmg.personal.finances.domain.core.valueobject;

import com.jmg.personal.finances.common.domain.valueobject.BaseId;

import java.util.UUID;

public class FinancialInstitutionId extends BaseId<UUID> {
    public FinancialInstitutionId(UUID value) {
        super(value);
    }
}
