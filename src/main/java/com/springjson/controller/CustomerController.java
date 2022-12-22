package com.springjson.controller;

import com.springjson.model.CustomerModel;
import com.springjson.model.CustomerRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @PostMapping
    public ResponseEntity<Object> saveCustomer(@RequestBody CustomerRequest request){
        return ResponseEntity.ok().body(request);
    }


}
