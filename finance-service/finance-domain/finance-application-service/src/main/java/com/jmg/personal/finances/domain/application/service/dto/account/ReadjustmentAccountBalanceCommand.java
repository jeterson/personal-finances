package com.jmg.personal.finances.domain.application.service.dto.account;

import com.jmg.personal.finances.domain.core.valueobject.ReadjustmentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class ReadjustmentAccountBalanceCommand {

    @NotNull
    private final BigDecimal balance;
    @NotNull
    private final ReadjustmentType readjustmentType;
    @NotNull
    private UUID accountId;

}
