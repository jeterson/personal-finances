package com.jmg.personal.finances.domain.application.service.mapper;

import com.jmg.personal.finances.common.domain.valueobject.Color;
import com.jmg.personal.finances.common.domain.valueobject.Money;
import com.jmg.personal.finances.domain.application.service.dto.account.*;
import com.jmg.personal.finances.domain.application.service.dto.financialinstitution.FinancialInstitutionResponse;
import com.jmg.personal.finances.domain.core.entity.Account;
import com.jmg.personal.finances.domain.core.entity.FinancialInstitution;
import com.jmg.personal.finances.domain.core.valueobject.FinancialInstitutionId;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AccountDataMapper {

    public Account createAccountCommandToAccount(CreateAccountCommand createAccountCommand){
        var financialInstitutionId = FinancialInstitution.builder().id(new FinancialInstitutionId(UUID.fromString(createAccountCommand.getFinancialInstitutionId()))).build();
        return Account.builder()
                .financialInstitution(financialInstitutionId)
                .type(createAccountCommand.getType())
                .color(Color.of(createAccountCommand.getColor()))
                .considerInBalance(createAccountCommand.isConsiderInBalance())
                .archived(false)
                .name(createAccountCommand.getName())
                .initialBalance(new Money(createAccountCommand.getInitialBalance()))
                .currentBalance(new Money(createAccountCommand.getInitialBalance()))
                .build();
    }
    public CreateAccountResponse accountToCreateAccountResponse(Account account, String message){
        return new CreateAccountResponse(account.getId().getValue(), message);
    }
    public UpdateAccountResponse accountToUpdateAccountResponse(Account account, String message) {
        return new UpdateAccountResponse(account.getId().getValue(), message);
    }
    public AccountResponse accountToAccountResponse(Account account) {
        return AccountResponse.builder()
                .archived(account.isArchived())
                .color(account.getColor().getColorHex())
                .id(account.getId().getValue())
                .considerInBalance(account.isConsiderInBalance())
                .currentBalance(account.getCurrentBalance().getAmount())
                .initialBalance(account.getInitialBalance().getAmount())
                .name(account.getName())
                .type(account.getType())
                .financialInstitution(FinancialInstitutionResponse.builder()
                        .icon(account.getFinancialInstitution().getIcon())
                        .name(account.getFinancialInstitution().getName())
                        .id(account.getFinancialInstitution().getId().getValue())
                        .build())
                .build();
    }
    public Account updateAccountCommandToAccount(UpdateAccountCommand updateAccountCommand) {
        var financialInstitutionId = FinancialInstitution.builder().id(new FinancialInstitutionId(UUID.fromString(updateAccountCommand.getFinancialInstitutionId()))).build();
        return Account.builder()
                .financialInstitution(financialInstitutionId)
                .type(updateAccountCommand.getType())
                .color(Color.of(updateAccountCommand.getColor()))
                .considerInBalance(updateAccountCommand.isConsiderInBalance())
                .archived(false)
                .name(updateAccountCommand.getName())
                .build();
    }

}
