package com.oscarneto.restapi.application.service;

import com.oscarneto.restapi.domain.entity.Hotel;

import java.util.List;

public interface HotelService {
    List<Hotel> findAll();
}
