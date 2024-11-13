package com.oscarneto.restapi.domain.repository;

import com.oscarneto.restapi.domain.entity.Hotel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends MongoRepository<Hotel, String> {

}
