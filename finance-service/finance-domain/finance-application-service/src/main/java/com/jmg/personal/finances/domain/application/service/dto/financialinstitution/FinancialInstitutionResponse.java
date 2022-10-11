package com.jmg.personal.finances.domain.application.service.dto.financialinstitution;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.UUID;


@Getter
@Builder
@AllArgsConstructor
public class FinancialInstitutionResponse{

    @NotNull
    private final UUID id;
    @NotNull
    private final String name;
    @NotNull
    private final String icon;
}
