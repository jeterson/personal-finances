package com.jmg.personal.finances.domain.application.service.ports.input.service;

import com.jmg.personal.finances.domain.application.service.dto.account.*;
import com.jmg.personal.finances.domain.core.entity.Account;
import com.jmg.personal.finances.domain.core.valueobject.AccountId;

import javax.validation.Valid;
import java.util.List;

public interface AccountApplicationService {

    CreateAccountResponse create(@Valid CreateAccountCommand createAccountCommand);
    UpdateAccountResponse update(@Valid UpdateAccountCommand updateAccountCommand);
    ArchiveAccountResponse archive(AccountId accountId);
    AccountResponse findById(AccountId id);
    void readjustBalance(@Valid ReadjustmentAccountBalanceCommand readjustmentAccountBalanceCommand);

    List<AccountResponse> findAll();
}
