package com.oscarneto.restapi.presentation.controller;

import com.oscarneto.restapi.application.service.VacationService;
import com.oscarneto.restapi.common.utils.Constants;
import com.oscarneto.restapi.domain.entity.Vacation;
import com.oscarneto.restapi.presentation.dto.request.VacationCreateRequestDTO;
import com.oscarneto.restapi.presentation.mapper.VacationMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(Constants.API_VERSION_V1 + "/vacations")
public class VacationControllerV1 {

    private final VacationService service;
    private final VacationMapper mapper;

    @GetMapping
    public List<Vacation> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Vacation getById(@PathVariable String id) {
        return service.findById(id);
    }

    @PostMapping
    public Vacation create(@RequestBody @Valid VacationCreateRequestDTO vacation) {
        return service.create(mapper.toEntity(vacation));
    }
}
