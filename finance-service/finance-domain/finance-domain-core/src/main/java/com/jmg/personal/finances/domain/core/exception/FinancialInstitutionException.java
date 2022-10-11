package com.jmg.personal.finances.domain.core.exception;

import com.jmg.personal.finances.common.domain.exception.DomainException;

public class FinancialInstitutionException extends DomainException {
    public FinancialInstitutionException(String message) {
        super(message);
    }

    public FinancialInstitutionException(String message, Throwable cause) {
        super(message, cause);
    }
}
