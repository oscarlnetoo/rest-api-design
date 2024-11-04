package com.oscarneto.restapi.application.services.impl;

import com.oscarneto.restapi.application.services.VacationService;
import com.oscarneto.restapi.common.exceptions.EntityNotFoundException;
import com.oscarneto.restapi.domain.entities.Vacation;
import com.oscarneto.restapi.domain.repositories.VacationRepository;
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
}
