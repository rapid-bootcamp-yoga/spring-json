package com.springjson.service;

import com.springjson.model.CustomerRequestModel;
import com.springjson.repository.CustomerRequestRepo;

import java.util.Optional;


public interface CustomerRequestService {
    Optional<CustomerRequestRepo> save(CustomerRequestModel model);
}
