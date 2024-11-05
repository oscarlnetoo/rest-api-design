package com.oscarneto.restapi.application.service.impl;

import com.oscarneto.restapi.application.service.VacationService;
import com.oscarneto.restapi.domain.exception.EntityNotFoundException;
import com.oscarneto.restapi.domain.entity.Vacation;
import com.oscarneto.restapi.domain.repository.VacationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VacationServiceImpl implements VacationService {

    private final VacationRepository repository;

    @Override
    public List<Vacation> findAll() {
        return repository.findAll();
    }

    @Override
    public Vacation findById(String id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(Vacation.class));
    }

    @Override
    public Vacation create(Vacation vacation) {
        return repository.save(vacation);
    }
}
