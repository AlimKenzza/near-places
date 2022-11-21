package com.example.mongotest.repository;

import com.example.mongotest.model.Zagreb;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClientRepository extends MongoRepository<Zagreb, Long> {
}
