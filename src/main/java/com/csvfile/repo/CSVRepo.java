package com.csvfile.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csvfile.entity.CSVEntity;

public interface CSVRepo extends JpaRepository<CSVEntity, Integer>{

}
