package com.jmg.personal.finances.domain.core.entity;

import com.jmg.personal.finances.common.domain.entity.BaseEntity;
import com.jmg.personal.finances.common.domain.valueobject.AccountType;
import com.jmg.personal.finances.common.domain.valueobject.Color;
import com.jmg.personal.finances.common.domain.valueobject.Money;
import com.jmg.personal.finances.domain.core.exception.AccountDomainException;
import com.jmg.personal.finances.domain.core.valueobject.AccountId;

import java.util.UUID;

public class Account extends BaseEntity<AccountId> {

    private Money initialBalance;
    private final Money currentBalance;

    private  FinancialInstitution financialInstitution;
    private AccountType type;
    private Color color;
    private boolean considerInBalance;
    private boolean archived;
    private String name;


    public Color getColor() {
        return color;
    }

    public AccountType getType() {
        return type;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public String getName() {
        return name;
    }

    public void readjustInitialBalance(Money newValue) {
        if(!newValue.isGreaterThanZero())
            throw new AccountDomainException("Readjust value to initialBalance can't be less than zero");

        initialBalance = newValue;
    }
    public  void initializeAccount() {
        super.setId(new AccountId(UUID.randomUUID()));
    }

    public FinancialInstitution getFinancialInstitution() {
        return financialInstitution;
    }

    public Money getCurrentBalance() {
        return currentBalance;
    }

    public Money getInitialBalance() {
        return initialBalance;
    }

    public boolean isConsiderInBalance() {
        return considerInBalance;
    }

    private Account(Builder builder) {
        super.setId(builder.id);
        initialBalance = builder.initialBalance;
        currentBalance = builder.currentBalance;
        financialInstitution = builder.financialInstitution;
        type = builder.type;
        color = builder.color;
        considerInBalance = builder.considerInBalance;
        archived = builder.archived;
        name = builder.name;
    }

    public static Builder builder() {
        return new Builder();
    }


    public static final class Builder {
        private String name;
        private boolean archived;
        private AccountId id;
        private Money initialBalance;
        private Money currentBalance;
        private FinancialInstitution financialInstitution;
        private AccountType type;
        private Color color;
        private boolean considerInBalance;

        private Builder() {
        }

        public Builder id(AccountId val) {
            id = val;
            return this;
        }
        public Builder name(String val) {
            name = val;
            return this;
        }
        public Builder archived(boolean val) {
            archived = val;
            return this;
        }

        public Builder initialBalance(Money val) {
            initialBalance = val;
            return this;
        }

        public Builder currentBalance(Money val) {
            currentBalance = val;
            return this;
        }

        public Builder financialInstitution(FinancialInstitution val) {
            financialInstitution = val;
            return this;
        }

        public Builder type(AccountType val) {
            type = val;
            return this;
        }

        public Builder color(Color val) {
            color = val;
            return this;
        }

        public Builder considerInBalance(boolean val) {
            considerInBalance = val;
            return this;
        }

        public Account build() {
            return new Account(this);
        }
    }
}
