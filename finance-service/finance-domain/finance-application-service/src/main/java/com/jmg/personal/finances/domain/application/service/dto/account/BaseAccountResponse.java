package com.jmg.personal.finances.domain.application.service.dto.account;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@AllArgsConstructor
public abstract class BaseAccountResponse {
    @NotNull
    private final UUID accountId;
    @NotNull
    private final String message;
}
