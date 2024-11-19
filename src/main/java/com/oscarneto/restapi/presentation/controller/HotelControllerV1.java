package com.oscarneto.restapi.presentation.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.oscarneto.restapi.application.service.HotelService;
import com.oscarneto.restapi.common.utils.Constants;
import com.oscarneto.restapi.domain.entity.Hotel;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping(Constants.API_VERSION_V1 + "/hotels")
public class HotelControllerV1 {

    private final HotelService service;
    private final ObjectMapper objectMapper;

    @GetMapping
    public Page<Hotel> getAll(@RequestParam(value = "fields", required = false) Set<String> fields,
                              @RequestParam(value = "page", defaultValue = "0") int page,
                              @RequestParam(value = "size", defaultValue = "5") int size) {
        Page<Hotel> hotels = service.findAllWithFields(fields, page, size);

        if (fields != null && !fields.isEmpty()) {
            // Configure the filter to include only the specified fields
            SimpleFilterProvider filterProvider = new SimpleFilterProvider()
                    .addFilter("HotelFilter", SimpleBeanPropertyFilter.filterOutAllExcept(fields));

            // Set the filter provider for the global ObjectMapper
            objectMapper.setFilterProvider(filterProvider);
        } else {
            // Reset filters to include all fields
            objectMapper.setFilterProvider(new SimpleFilterProvider().addFilter("HotelFilter", SimpleBeanPropertyFilter.serializeAll()));
        }

        return hotels;
    }
}
