package com.jmg.personal.finances.domain.application.service.impl.financialinstitution;

import com.jmg.personal.finances.domain.application.service.dto.financialinstitution.FinancialInstitutionResponse;
import com.jmg.personal.finances.domain.application.service.mapper.FinancialInstitutionDataMapper;
import com.jmg.personal.finances.domain.application.service.ports.input.service.FinancialInstitutionApplicationService;
import com.jmg.personal.finances.domain.application.service.ports.output.repository.FinancialInstitutionRepository;
import com.jmg.personal.finances.domain.core.entity.FinancialInstitution;
import com.jmg.personal.finances.domain.core.exception.FinancialInstitutionNotFoundException;
import com.jmg.personal.finances.domain.core.valueobject.FinancialInstitutionId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Validated
@Service
public class FinancialInstitutionServiceImpl implements FinancialInstitutionApplicationService {
    private final FinancialInstitutionRepository financialInstitutionRepository;
    private final FinancialInstitutionDataMapper financialInstitutionDataMapper;

    public FinancialInstitutionServiceImpl(FinancialInstitutionRepository financialInstitutionRepository,
                                           FinancialInstitutionDataMapper financialInstitutionDataMapper) {
        this.financialInstitutionRepository = financialInstitutionRepository;
        this.financialInstitutionDataMapper = financialInstitutionDataMapper;
    }

    @Override
    public FinancialInstitution save(FinancialInstitution financialInstitution) {
       return financialInstitutionRepository.save(financialInstitution);
    }

    @Override
    public List<FinancialInstitutionResponse> findAll() {
        return financialInstitutionRepository.findAll()
                .stream()
                .map(financialInstitutionDataMapper::toFinancialInstitutionResponse)
                .collect(Collectors.toList());
    }

    @Override
    public FinancialInstitution findById(FinancialInstitutionId financialInstitutionId) {
        var financialInstitution = financialInstitutionRepository.findById(financialInstitutionId);
        if(financialInstitution.isEmpty()) {
            log.warn("Financial institution with id {} not found", financialInstitutionId.getValue());
            throw new FinancialInstitutionNotFoundException("Financial institution not found");
        }
        return financialInstitution.get();
    }
}
