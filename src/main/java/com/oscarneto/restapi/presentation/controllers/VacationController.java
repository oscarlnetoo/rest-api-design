package com.oscarneto.restapi.presentation.controllers;

import com.oscarneto.restapi.application.services.VacationService;
import com.oscarneto.restapi.common.utils.Constants;
import com.oscarneto.restapi.domain.entities.Vacation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(Constants.API_VERSION_V1 + "/vacations")
public class VacationController {

    private final VacationService service;

    @GetMapping
    public List<Vacation> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Vacation getById(@PathVariable String id) {
        return service.findById(id);
    }
}
