package com.oscarneto.restapi.application.service;

import com.oscarneto.restapi.domain.entity.Hotel;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Set;

public interface HotelService {
    List<Hotel> findAll();

    List<Hotel> findAllWithFields(Set<String> fields);

    Page<Hotel> findAllWithFields(Set<String> fields, int page, int size);
}
