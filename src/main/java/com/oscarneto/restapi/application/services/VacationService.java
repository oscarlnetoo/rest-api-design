package com.oscarneto.restapi.application.services;

import com.oscarneto.restapi.domain.entities.Vacation;

import java.util.List;

public interface VacationService {
    List<Vacation> findAll();
}
