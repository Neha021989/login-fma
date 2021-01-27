package com.example.demo.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.client.Login;

@Repository
public interface LoginRepository extends ReactiveMongoRepository<Login, String> {

}
