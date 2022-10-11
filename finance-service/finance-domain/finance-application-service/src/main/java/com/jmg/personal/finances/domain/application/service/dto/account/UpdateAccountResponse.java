package com.jmg.personal.finances.domain.application.service.dto.account;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public class UpdateAccountResponse extends BaseAccountResponse {
    public UpdateAccountResponse(@NotNull UUID accountId, @NotNull String message) {
        super(accountId, message);
    }
}
