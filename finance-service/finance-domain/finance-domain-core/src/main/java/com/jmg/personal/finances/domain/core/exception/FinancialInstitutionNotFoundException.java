package com.jmg.personal.finances.domain.core.exception;

import com.jmg.personal.finances.common.domain.exception.DomainException;

public class FinancialInstitutionNotFoundException extends DomainException {
    public FinancialInstitutionNotFoundException(String message) {
        super(message);
    }

    public FinancialInstitutionNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
