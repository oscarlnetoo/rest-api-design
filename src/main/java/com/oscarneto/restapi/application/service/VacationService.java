package com.oscarneto.restapi.application.service;

import com.oscarneto.restapi.domain.entity.Vacation;

import java.util.List;

public interface VacationService {
    List<Vacation> findAll();

    Vacation findById(String id);
}
