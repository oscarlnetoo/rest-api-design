package com.oscarneto.restapi.presentation.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.oscarneto.restapi.application.service.HotelService;
import com.oscarneto.restapi.common.utils.Constants;
import com.oscarneto.restapi.domain.entity.Hotel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping(Constants.API_VERSION_V1 + "/hotels")
public class HotelControllerV1 {

    private final HotelService service;
    private final Jackson2ObjectMapperBuilder objectMapperBuilder;

    @GetMapping
    public List<String> getAll(@RequestParam(value = "fields", required = false) Set<String> fields) {
        List<Hotel> hotels = service.findAllWithFields(fields);

        if (fields != null && !fields.isEmpty()) {
            ObjectMapper customMapper = objectMapperBuilder.build();

            SimpleFilterProvider filterProvider = new SimpleFilterProvider()
                    .addFilter("HotelFilter", SimpleBeanPropertyFilter.filterOutAllExcept(fields));

            customMapper.setFilterProvider(filterProvider);
        }

        return hotels;
    }
}
