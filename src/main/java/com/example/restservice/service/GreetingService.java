package com.example.restservice.service;

import com.example.restservice.entity.Greeting;
import com.example.restservice.repository.IGreetingDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

  @Autowired
  private IGreetingDAO dao;

  public Greeting create(Greeting greeting) {
    return dao.save(greeting);
  }

}
