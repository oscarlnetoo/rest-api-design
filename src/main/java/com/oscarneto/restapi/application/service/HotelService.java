package com.oscarneto.restapi.application.service;

import com.oscarneto.restapi.domain.entity.Hotel;

import java.util.List;
import java.util.Set;

public interface HotelService {
    List<Hotel> findAll();
    List<Hotel> findAllWithFields(Set<String> fields);
}
