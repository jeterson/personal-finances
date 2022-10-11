package com.jmg.personal.finances.dataaccess.account.adapter;

import com.jmg.personal.finances.dataaccess.account.mapper.AccountDataAccessMapper;
import com.jmg.personal.finances.dataaccess.account.repository.AccountJpaRepository;
import com.jmg.personal.finances.domain.application.service.ports.output.repository.AccountRepository;
import com.jmg.personal.finances.domain.core.entity.Account;
import com.jmg.personal.finances.domain.core.valueobject.AccountId;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class AccountRepositoryImpl implements AccountRepository {

    private final AccountJpaRepository accountJpaRepository;
    private final AccountDataAccessMapper accountDataAccessMapper;

    public AccountRepositoryImpl(AccountJpaRepository accountJpaRepository, AccountDataAccessMapper accountDataAccessMapper) {
        this.accountJpaRepository = accountJpaRepository;
        this.accountDataAccessMapper = accountDataAccessMapper;
    }

    @Override
    public Account save(Account account) {
        var accountEntity = accountDataAccessMapper.toAccountEntity(account);
        accountEntity = accountJpaRepository.save(accountEntity);
        return accountDataAccessMapper.toAccount(accountEntity);

    }

    @Override
    public Optional<Account> findById(AccountId id) {
        return accountJpaRepository.findById(id.getValue()).map(accountDataAccessMapper::toAccount);
    }

    @Override
    public List<Account> findAll() {
        return accountJpaRepository.findAll()
                .stream()
                .map(accountDataAccessMapper::toAccount)
                .collect(Collectors.toList());
    }
}
