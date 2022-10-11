package com.jmg.personal.finances.domain.application.service.dto.account;

import com.jmg.personal.finances.common.domain.valueobject.AccountType;
import com.jmg.personal.finances.domain.application.service.dto.financialinstitution.FinancialInstitutionResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class AccountResponse {
    private final UUID id;
    private final String name;
    private final String color;
    private final AccountType type;
    private final boolean considerInBalance;
    private final BigDecimal initialBalance;
    private final BigDecimal currentBalance;
    private final boolean archived;
    private FinancialInstitutionResponse financialInstitution;
}
