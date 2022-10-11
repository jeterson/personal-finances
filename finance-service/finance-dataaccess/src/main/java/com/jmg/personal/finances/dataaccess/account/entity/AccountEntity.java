package com.jmg.personal.finances.dataaccess.account.entity;

import com.jmg.personal.finances.common.domain.valueobject.AccountType;
import com.jmg.personal.finances.common.domain.valueobject.Color;
import com.jmg.personal.finances.dataaccess.financiainstitution.entity.FinancialInstitutionEntity;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "account")
@Entity
public class AccountEntity {
    @Id
    @Column(name = "id", columnDefinition = "uuid")
    private UUID id;

    @Enumerated(EnumType.STRING)
    private AccountType type;

    private boolean considerInBalance;
    private BigDecimal initialBalance;
    private BigDecimal currentBalance;

    @Enumerated(EnumType.STRING)
    private Color color;

    private String name;

    @ManyToOne
    @JoinColumn(name = "financial_institution_id")
    private FinancialInstitutionEntity financialInstitution;


}
