package com.jmg.personal.finances.dataaccess.account.mapper;

import com.jmg.personal.finances.common.domain.valueobject.Money;
import com.jmg.personal.finances.dataaccess.account.entity.AccountEntity;
import com.jmg.personal.finances.dataaccess.financiainstitution.entity.FinancialInstitutionEntity;
import com.jmg.personal.finances.domain.core.entity.Account;
import com.jmg.personal.finances.domain.core.entity.FinancialInstitution;
import com.jmg.personal.finances.domain.core.valueobject.AccountId;
import com.jmg.personal.finances.domain.core.valueobject.FinancialInstitutionId;
import org.springframework.stereotype.Component;

@Component
public class AccountDataAccessMapper {

    public AccountEntity toAccountEntity(Account account) {
        AccountEntity accountEntity = AccountEntity
                .builder()
                .id(account.getId().getValue())
                .color(account.getColor())
                .type(account.getType())
                .name(account.getName())
                .currentBalance(account.getCurrentBalance().getAmount())
                .initialBalance(account.getInitialBalance().getAmount())
                .considerInBalance(account.isConsiderInBalance())
                .financialInstitution(FinancialInstitutionEntity
                        .builder().id(account.getFinancialInstitution().getId().getValue()).
                        build())
                .build();

        return accountEntity;
    }
    public Account toAccount(AccountEntity accountEntity) {
        return Account
                .builder()
                .color(accountEntity.getColor())
                .considerInBalance(accountEntity.isConsiderInBalance())
                .currentBalance(new Money(accountEntity.getCurrentBalance()))
                .initialBalance(new Money(accountEntity.getInitialBalance()))
                .id(new AccountId(accountEntity.getId()))
                .type(accountEntity.getType())
                .financialInstitution(toFinancialInstitution(accountEntity.getFinancialInstitution()))
                .build();
    }
    private FinancialInstitution toFinancialInstitution(FinancialInstitutionEntity financialInstitutionEntity) {
        return FinancialInstitution
                .builder()
                .icon(financialInstitutionEntity.getIcon())
                .name(financialInstitutionEntity.getName())
                .id(new FinancialInstitutionId(financialInstitutionEntity.getId()))
                .build();
    }
}
