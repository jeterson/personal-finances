package com.jmg.personal.finances.domain.core.valueobject;

import com.jmg.personal.finances.common.domain.valueobject.BaseId;

import java.util.UUID;

public class AccountId extends BaseId<UUID> {
    public AccountId(UUID value) {
        super(value);
    }
}
