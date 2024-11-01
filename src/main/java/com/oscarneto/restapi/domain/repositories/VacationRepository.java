package com.oscarneto.restapi.domain.repositories;

import com.oscarneto.restapi.domain.entities.Vacation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacationRepository extends MongoRepository<Vacation, String> {
}
