package com.springjson.service.Impl;

import com.springjson.entity.CustomerEntity;
import com.springjson.model.CustomerModel;
import com.springjson.repository.CustomerRepo;
import javafx.beans.value.ObservableBooleanValue;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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

    private List<CustomerEntity> customerEntityList;

    @BeforeEach
    void setUp() {
        log.info("Setup Run ... ");
        customerEntityList = Arrays.asList(
                new CustomerEntity(1L, "Yoga", "pria"),
                new CustomerEntity(2L, "Yoga Julian", "pria"),
                new CustomerEntity(3L, "Prasutiyo", "pria"),
                new CustomerEntity(4L, "Yoga Prasutiyo", "pria")
        );
    }

    @AfterEach
    void tearDown() {
        log.info("Setup Clear...");
    }

    @Test
    void getAll() {
        // Mocking adalah permisalan, simulasi case untuk di test
        // ketika ada request repo.findAll, maka kembalikan list kosong
        when(this.customerRepo.).thenReturn(Collections.emptyList());
        List<CustomerModel> result = service.getAll();
        assertNotNull(result);
        assertEquals(0, result.size());

        // mock atau ngecek
        when(this.customerRepo.findAll()).thenReturn(customerEntityList);
        result = service.getAll();
        assertNotNull(result);
        assertEquals(4, result.size());
        assertEquals(2L, result.get(1).getId());
        assertEquals("Yoga Julian", result.get(1).getFullName());
        assertEquals("pria", result.get(1).getGender());


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