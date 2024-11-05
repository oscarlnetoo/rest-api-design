package com.oscarneto.restapi.domain.repository;

import com.oscarneto.restapi.domain.entity.Vacation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacationRepository extends MongoRepository<Vacation, String> {
}
