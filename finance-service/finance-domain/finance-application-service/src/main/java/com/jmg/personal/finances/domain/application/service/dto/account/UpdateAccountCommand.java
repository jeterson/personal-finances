package com.jmg.personal.finances.domain.application.service.dto.account;

import com.jmg.personal.finances.common.domain.valueobject.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Builder
@AllArgsConstructor
public class UpdateAccountCommand {

    @NotNull
    private final String financialInstitutionId;
    @NotNull
    private final String color;
    @NotNull
    private final String name;
    @NotNull
    private final AccountType type;
    @NotNull
    private final boolean considerInBalance;
}
