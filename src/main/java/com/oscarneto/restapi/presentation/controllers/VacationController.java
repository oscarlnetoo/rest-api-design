package com.oscarneto.restapi.presentation.controllers;

import com.oscarneto.restapi.application.services.VacationService;
import com.oscarneto.restapi.domain.entities.Vacation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vacations")
public class VacationController {

    private final VacationService service;

    @GetMapping
    public List<Vacation> getAll() {
        return service.findAll();
    }
}
