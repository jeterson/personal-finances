package com.jmg.personal.finances.dataaccess.financiainstitution.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "financial_institution")
@Entity
public class FinancialInstitutionEntity {

    @Id
    @Column(name="id", columnDefinition = "uuid")
    private UUID id;
    private String name;
    private String icon;
}
