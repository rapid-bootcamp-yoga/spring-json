package com.springjson.repository;

import com.springjson.entity.CustomerRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRequestRepo extends JpaRepository<CustomerRequestEntity, Long> {
}
