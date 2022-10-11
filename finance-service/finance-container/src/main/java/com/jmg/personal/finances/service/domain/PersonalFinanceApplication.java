package com.jmg.personal.finances.service.domain;

import com.jmg.personal.finances.common.domain.valueobject.AccountType;
import com.jmg.personal.finances.common.domain.valueobject.Money;
import com.jmg.personal.finances.domain.application.service.dto.account.CreateAccountCommand;
import com.jmg.personal.finances.domain.application.service.ports.input.service.AccountApplicationService;
import com.jmg.personal.finances.domain.application.service.ports.input.service.FinancialInstitutionApplicationService;
import com.jmg.personal.finances.domain.core.entity.Account;
import com.jmg.personal.finances.domain.core.entity.FinancialInstitution;
import com.jmg.personal.finances.domain.core.valueobject.FinancialInstitutionId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.math.BigDecimal;
import java.util.Random;
import java.util.UUID;

@EnableJpaRepositories(basePackages = {"com.jmg.personal.finances.dataaccess"})
@EntityScan(basePackages = {"com.jmg.personal.finances.dataaccess"})
@SpringBootApplication(scanBasePackages = "com.jmg.personal.finances")
public class PersonalFinanceApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(PersonalFinanceApplication.class, args);
    }

    @Autowired
    private FinancialInstitutionApplicationService financialInstitutionApplicationService;
    @Autowired
    private AccountApplicationService accountApplicationService;

    @Override
    public void run(String... args) throws Exception {
        var f1 = FinancialInstitution.builder()
                .id(new FinancialInstitutionId(UUID.randomUUID()))
                .icon("icon1")
                .name("Nubank")
                .build();
        financialInstitutionApplicationService.save(f1);

        var a1 = CreateAccountCommand.builder()
                .color("#FFF")
                .considerInBalance(true)
                .initialBalance(new BigDecimal(10.0))
                .type(AccountType.MONEY)
                .name("Carteira")
                .financialInstitutionId(f1.getId().getValue().toString())
                .build();
        accountApplicationService.create(a1);
    }
}
