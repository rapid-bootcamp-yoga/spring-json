package com.springjson.service;

import com.springjson.model.CustomerModel;
import com.springjson.model.CustomerRequestModel;
import com.springjson.model.CustomerResponse;

import java.util.List;
import java.util.Optional;


public interface CustomerService {

    List<CustomerModel> getAll();
    CustomerResponse saveAll(CustomerRequestModel requestModel);
    Optional<CustomerModel> getById(Long id);
    Optional<CustomerModel> save(CustomerModel model);
    Optional<CustomerModel> update(Long id, CustomerModel model);
    Optional<CustomerModel> delete(Long id);
}
