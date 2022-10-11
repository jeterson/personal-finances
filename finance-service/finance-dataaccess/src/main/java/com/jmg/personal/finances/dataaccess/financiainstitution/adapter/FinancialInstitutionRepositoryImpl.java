package com.jmg.personal.finances.dataaccess.financiainstitution.adapter;

import com.jmg.personal.finances.dataaccess.financiainstitution.mapper.FinancialInstitutionDataAccessMapper;
import com.jmg.personal.finances.dataaccess.financiainstitution.repository.FinancialInstitutionJpaRepository;
import com.jmg.personal.finances.domain.application.service.ports.output.repository.FinancialInstitutionRepository;
import com.jmg.personal.finances.domain.core.entity.FinancialInstitution;
import com.jmg.personal.finances.domain.core.valueobject.FinancialInstitutionId;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class FinancialInstitutionRepositoryImpl implements FinancialInstitutionRepository {
    private final FinancialInstitutionJpaRepository financialInstitutionJpaRepository;
    private final FinancialInstitutionDataAccessMapper financialInstitutionDataAccessMapper;

    public FinancialInstitutionRepositoryImpl(FinancialInstitutionJpaRepository financialInstitutionJpaRepository,
                                              FinancialInstitutionDataAccessMapper financialInstitutionDataAccessMapper) {
        this.financialInstitutionJpaRepository = financialInstitutionJpaRepository;

        this.financialInstitutionDataAccessMapper = financialInstitutionDataAccessMapper;
    }

    @Override
    public FinancialInstitution save(FinancialInstitution financialInstitution) {
        var entity = financialInstitutionDataAccessMapper.toFinancialInstitutionEntity(financialInstitution);
        entity = financialInstitutionJpaRepository.save(entity);
        return financialInstitutionDataAccessMapper.toFinancialInstitution(entity);
    }

    @Override
    public List<FinancialInstitution> findAll() {
       return financialInstitutionJpaRepository.findAll()
               .stream()
               .map(financialInstitutionDataAccessMapper::toFinancialInstitution)
               .collect(Collectors.toList());
    }

    @Override
    public Optional<FinancialInstitution> findById(FinancialInstitutionId financialInstitutionId) {
        return financialInstitutionJpaRepository.findById(financialInstitutionId.getValue())
                .map(financialInstitutionDataAccessMapper::toFinancialInstitution);
    }
}
