package com.jmg.personal.finances.domain.application.service.ports.output.repository;

import com.jmg.personal.finances.domain.core.entity.Account;
import com.jmg.personal.finances.domain.core.valueobject.AccountId;

import java.util.List;
import java.util.Optional;

public interface AccountRepository {

    Account save(Account account);
    Optional<Account> findById(AccountId id);

    List<Account> findAll();
}
