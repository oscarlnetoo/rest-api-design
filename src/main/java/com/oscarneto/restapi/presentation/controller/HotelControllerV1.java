package com.oscarneto.restapi.presentation.controller;

import com.oscarneto.restapi.application.service.HotelService;
import com.oscarneto.restapi.common.utils.Constants;
import com.oscarneto.restapi.domain.entity.Hotel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(Constants.API_VERSION_V1 + "/hotels")
public class HotelControllerV1 {

    private final HotelService service;

    @GetMapping
    public List<Hotel> getAll() {
        return service.findAll();
    }
}
