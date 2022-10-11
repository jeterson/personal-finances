package com.jmg.personal.finances.service.application.rest.account;

import com.jmg.personal.finances.domain.application.service.dto.account.AccountResponse;
import com.jmg.personal.finances.domain.application.service.dto.account.CreateAccountCommand;
import com.jmg.personal.finances.domain.application.service.dto.account.CreateAccountResponse;
import com.jmg.personal.finances.domain.application.service.ports.input.service.AccountApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/accounts", produces = "application/vnd.api.v1+json")
public class AccountController {

    private final AccountApplicationService accountApplicationService;

    public AccountController(AccountApplicationService accountApplicationService) {
        this.accountApplicationService = accountApplicationService;
    }

    @PostMapping
    public ResponseEntity<CreateAccountResponse> createAccount(@RequestBody CreateAccountCommand createAccountCommand) {
        log.info("Creating account");
        var response = accountApplicationService.create(createAccountCommand);
        log.info("Account created with id {}", response.getAccountId());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @GetMapping
    public ResponseEntity<List<AccountResponse>> findAll() {
        var list = accountApplicationService.findAll();
        return ResponseEntity.ok(list);
    }
}
