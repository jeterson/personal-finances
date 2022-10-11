package com.jmg.personal.finances.domain.application.service.dto.account;

import lombok.AllArgsConstructor;
import lombok.Builder;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public class CreateAccountResponse extends BaseAccountResponse {
    public CreateAccountResponse(@NotNull UUID accountId, @NotNull String message) {
        super(accountId, message);
    }
}
