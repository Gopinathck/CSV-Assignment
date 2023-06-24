package com.csvfile.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.csvfile.entity.CSVEntity;
import com.csvfile.helper.CSVHelper;
import com.csvfile.repo.CSVRepo;

@Service
public class CSVService {
	 @Autowired
	  CSVRepo repository;

	  public void save(MultipartFile file) {
	    try {
	      List<CSVEntity> tutorials = CSVHelper.csvToTutorials(file.getInputStream());
	      repository.saveAll(tutorials);
	    } catch (IOException e) {
	      throw new RuntimeException("fail to store csv data: " + e.getMessage());
	    }
	  }

	  public ByteArrayInputStream load() {
	    List<CSVEntity> tutorials = repository.findAll();

	    ByteArrayInputStream in = CSVHelper.tutorialsToCSV(tutorials);
	    return in;
	  }

	  public List<CSVEntity> getAllTutorials() {
	    return repository.findAll();
	  }

}
