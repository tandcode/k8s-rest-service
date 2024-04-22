package com.example.restservice.repository;

import com.example.restservice.entity.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGreetingDAO extends JpaRepository<Greeting, Long> {
}
