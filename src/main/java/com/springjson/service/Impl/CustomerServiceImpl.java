package com.springjson.service.Impl;

import com.springjson.entity.CustomerEntity;
import com.springjson.model.CustomerModel;
import com.springjson.model.CustomerRequestModel;
import com.springjson.model.CustomerResponse;
import com.springjson.repository.AddressRepo;
import com.springjson.repository.CustomerRepo;
import com.springjson.repository.SchoolsRepo;
import com.springjson.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepo customerRepo;

    @Autowired
    public CustomerServiceImpl(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Override
    public List<CustomerModel> getAll() {
        return this.customerRepo.findAll().stream().map(CustomerModel::new)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerResponse saveAll(CustomerRequestModel requestModel) {
        if(requestModel.getCustomers().isEmpty()) {
            return new CustomerResponse();
        }
        CustomerResponse responseCustomer = new CustomerResponse();
        int testSuccess = 0;
        int testFailed = 0;
        List<CustomerModel> customerModels = new ArrayList<>();
        for (CustomerModel model: requestModel.getCustomers()) {
            // call isi model
            Optional<CustomerModel> customerModel = this.save(model);

            //validasi
            if(customerModel.isPresent()){
                customerModels.add(model);
                testSuccess++;
            } else {
                testFailed++;
            }
        }
//        responseCustomer.setDataCust(customerModels);
//        responseCustomer.setSuccessSave(testSuccess);
//        responseCustomer.setFailedSave(testFailed);
//        return responseCustomer;

        return new CustomerResponse(customerModels, testSuccess, testFailed);


    }

    @Override
    public Optional<CustomerModel> getById(Long id) {
        if(id == 0) {
            return Optional.empty();
        }
        Optional<CustomerEntity> result = this.customerRepo.findById(id);
        return result.map(CustomerModel::new);
    }

    @Override
    public Optional<CustomerModel> save(CustomerModel model) {
        if(model == null) {
            return Optional.empty();
        }
        CustomerEntity entity = new CustomerEntity(model);
        try {
            this.customerRepo.save(entity);
            return Optional.of(new CustomerModel(entity));
        }catch (Exception error){
            log.error("Customer save gagal, error : {}", error.getMessage());
            return Optional.empty();
        }


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
