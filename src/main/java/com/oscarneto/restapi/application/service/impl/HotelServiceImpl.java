package com.oscarneto.restapi.application.service.impl;

import com.oscarneto.restapi.application.service.HotelService;
import com.oscarneto.restapi.domain.entity.Hotel;
import com.oscarneto.restapi.domain.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {

    private final HotelRepository repository;
    private final MongoTemplate mongoTemplate;

    @Override
    public List<Hotel> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Hotel> findAllWithFields(Set<String> fields) {
        Query query = new Query();

        if (!CollectionUtils.isEmpty(fields)) {
            fields.forEach(query.fields()::include);
        }

        return mongoTemplate.find(query, Hotel.class);
    }

    @Override
    public Page<Hotel> findAllWithFields(Set<String> fields, int page, int size) {
        Query query = new Query();

        if (!CollectionUtils.isEmpty(fields)) {
            fields.forEach(query.fields()::include);
        }

        long totalElements = mongoTemplate.count(query, Hotel.class);

        Pageable pageable = PageRequest.of(page, size);
        query.with(pageable);

        return new PageImpl<>(mongoTemplate.find(query, Hotel.class), pageable, totalElements);
    }
}
