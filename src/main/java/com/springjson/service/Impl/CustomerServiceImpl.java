package com.springjson.service.Impl;

import com.springjson.model.CustomerModel;
import com.springjson.model.CustomerRequestModel;
import com.springjson.model.CustomerResponse;
import com.springjson.repository.AddressRepo;
import com.springjson.repository.CustomerRepo;
import com.springjson.repository.CustomerRequestRepo;
import com.springjson.repository.SchoolsRepo;
import com.springjson.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
    private AddressRepo addressRepo;
    private SchoolsRepo schoolsRepo;
    private CustomerRepo customerRepo;
    private CustomerRequestRepo customerRequestRepo;

    @Autowired
    public CustomerServiceImpl(AddressRepo addressRepo, SchoolsRepo schoolsRepo,
                               CustomerRepo customerRepo, CustomerRequestRepo customerRequestRepo) {
        this.addressRepo = addressRepo;
        this.schoolsRepo = schoolsRepo;
        this.customerRepo = customerRepo;
        this.customerRequestRepo = customerRequestRepo;
    }

    @Override
    public List<CustomerModel> getAll() {
        return null;
    }

    @Override
    public CustomerResponse saveAll(CustomerRequestModel requestModel) {
        if(requestModel.getCustomers().isEmpty()) {
            return new CustomerResponse()
        }
        return null;
    }

    @Override
    public Optional<CustomerModel> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<CustomerModel> save(CustomerModel model) {
        return Optional.empty();
    }

    @Override
    public Optional<CustomerModel> update(Long id, CustomerModel model) {
        return Optional.empty();
    }

    @Override
    public Optional<CustomerModel> delete(Long id) {
        return Optional.empty();
    }

//    @Override
//    public Optional<CustomerModel> save(CustomerModel model){
//        if(model == null || model.addDetailList().isEmpty()) {
//            return Optional.empty();
//        }
//
//    }
}
