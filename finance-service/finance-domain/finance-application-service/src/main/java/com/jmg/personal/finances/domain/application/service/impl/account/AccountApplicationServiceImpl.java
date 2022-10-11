package com.jmg.personal.finances.domain.application.service.impl.account;

import com.jmg.personal.finances.common.domain.valueobject.Money;
import com.jmg.personal.finances.domain.application.service.dto.account.*;
import com.jmg.personal.finances.domain.application.service.mapper.AccountDataMapper;
import com.jmg.personal.finances.domain.application.service.ports.input.service.AccountApplicationService;
import com.jmg.personal.finances.domain.application.service.ports.output.repository.AccountRepository;
import com.jmg.personal.finances.domain.core.entity.Account;
import com.jmg.personal.finances.domain.core.exception.AccountDomainException;
import com.jmg.personal.finances.domain.core.valueobject.AccountId;
import com.jmg.personal.finances.domain.core.valueobject.ReadjustmentType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Validated
@Service
public class AccountApplicationServiceImpl implements AccountApplicationService {

    private final AccountRepository accountRepository;
    private final AccountDataMapper accountDataMapper;

    public AccountApplicationServiceImpl(AccountRepository accountRepository, AccountDataMapper accountDataMapper) {
        this.accountRepository = accountRepository;
        this.accountDataMapper = accountDataMapper;
    }

    @Override
    public CreateAccountResponse create(CreateAccountCommand createAccountCommand) {
        var account = accountDataMapper.createAccountCommandToAccount(createAccountCommand);
        account.initializeAccount();
        var accountSaved = accountRepository.save(account);
        return accountDataMapper.accountToCreateAccountResponse(accountSaved, "Account Created");
    }

    @Override
    public UpdateAccountResponse update(UpdateAccountCommand updateAccountCommand) {
        var account = accountDataMapper.updateAccountCommandToAccount(updateAccountCommand);
        var accountSaved = accountRepository.save(account);
        return accountDataMapper.accountToUpdateAccountResponse(accountSaved, "Account Updated");
    }

    @Override
    public ArchiveAccountResponse archive(AccountId accountId) {
        var account = accountRepository.findById(accountId);
        if(account.isEmpty()) {
            log.error("Account with id {} not found", accountId.getValue());
            throw new AccountDomainException(String.format("Can't archive nonexistent account"));
        }
        account.get().setArchived(true);
        accountRepository.save(account.get());
        log.info("Account {} was archived", accountId.getValue());
        return new ArchiveAccountResponse(accountId.getValue(), "Account was Archived");
    }

    @Override
    public AccountResponse findById(AccountId id) {
        var account = accountRepository.findById(id);
        if(account.isEmpty()){
            log.info("Account with id {} not found", id.getValue());
            throw new AccountDomainException("Account not found");
        }
        return accountDataMapper.accountToAccountResponse(account.get());

    }

    @Override
    public void readjustBalance(ReadjustmentAccountBalanceCommand readjustmentAccountBalanceCommand) {
        var account = accountRepository.findById(new AccountId(readjustmentAccountBalanceCommand.getAccountId()));
        if (account.isEmpty()) {
            log.error("Account with id {} not found", readjustmentAccountBalanceCommand.getAccountId());
            throw new AccountDomainException(String.format("Can't archive nonexistent account"));
        }
        if (readjustmentAccountBalanceCommand.getReadjustmentType() == ReadjustmentType.INITIAL_BALANCE) {
            log.info("Readjustment by initial balance");
            account.get().readjustInitialBalance(new Money(readjustmentAccountBalanceCommand.getBalance()));
            accountRepository.save(account.get());
        } else {
            log.info("Readjustment by transaction");
            //TODO
        }


    }

    @Override
    public List<AccountResponse> findAll() {
        List<Account> list = accountRepository.findAll();
        return list.stream().map(accountDataMapper::accountToAccountResponse).collect(Collectors.toList());
    }
}
