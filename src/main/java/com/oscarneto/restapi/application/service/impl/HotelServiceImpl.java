package com.oscarneto.restapi.application.service.impl;

import com.oscarneto.restapi.application.service.HotelService;
import com.oscarneto.restapi.domain.entity.Hotel;
import com.oscarneto.restapi.domain.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {

    private final HotelRepository repository;

    @Override
    public List<Hotel> findAll() {
        return repository.findAll();
    }
}
