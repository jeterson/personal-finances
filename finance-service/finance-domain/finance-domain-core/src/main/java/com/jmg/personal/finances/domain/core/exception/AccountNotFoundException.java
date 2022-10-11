package com.jmg.personal.finances.domain.core.exception;

import com.jmg.personal.finances.common.domain.exception.DomainException;

public class AccountNotFoundException extends DomainException {
    public AccountNotFoundException(String message) {
        super(message);
    }

    public AccountNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
