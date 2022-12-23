package com.springjson.service.Impl;

import com.springjson.repository.CustomerRepo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;

import static javafx.beans.binding.Bindings.when;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {

    @InjectMocks
    @Autowired
    private CustomerServiceImpl service;

    @Mock
    private CustomerRepo customerRepo;

    @BeforeEach
    void setUp() {
        log.info("Setup Run ... ");
    }

    @AfterEach
    void tearDown() {
        log.info("Setup Clear...");
    }

    @Test
    void getAll() {
        // Mocking adalah permisalan, simulasi case untuk di test
        // ketika ada request repo.findAll, maka kembalikan list kosong
//      when(this.customerRepo.findAll().thenReturn(Collections.emptyList());

    }

    @Test
    void saveAll() {
    }

    @Test
    void getById() {
    }

    @Test
    void save() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}