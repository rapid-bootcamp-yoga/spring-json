package com.springjson.repository;

import com.springjson.entity.SchoolsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolsRepo extends JpaRepository<SchoolsEntity, Long> {
}
