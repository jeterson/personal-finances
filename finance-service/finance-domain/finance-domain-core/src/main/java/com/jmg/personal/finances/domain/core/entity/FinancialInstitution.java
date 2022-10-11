package com.jmg.personal.finances.domain.core.entity;

import com.jmg.personal.finances.common.domain.entity.BaseEntity;
import com.jmg.personal.finances.domain.core.valueobject.FinancialInstitutionId;

public class FinancialInstitution extends BaseEntity<FinancialInstitutionId> {
    private final String name;
    private final String icon;

    public String getIcon() {
        return icon;
    }

    public String getName() {
        return name;
    }

    private FinancialInstitution(Builder builder) {
        super.setId(builder.id);
        name = builder.name;
        icon = builder.icon;
    }

    public static Builder builder() {
        return new Builder();
    }


    public static final class Builder {
        private FinancialInstitutionId id;
        private String name;
        private String icon;

        private Builder() {
        }

        public Builder id(FinancialInstitutionId val) {
            id = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder icon(String val) {
            icon = val;
            return this;
        }

        public FinancialInstitution build() {
            return new FinancialInstitution(this);
        }
    }
}
