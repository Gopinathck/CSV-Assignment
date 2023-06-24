package com.csvfile.controller;

import java.util.List;

//import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.csvfile.entity.CSVEntity;
import com.csvfile.helper.CSVHelper;
import com.csvfile.message.CSVMessage;
import com.csvfile.service.CSVService;

//import jakarta.annotation.Resource;

@CrossOrigin("*")
@RestController
public class CSVController {
	@Autowired
	  CSVService fileService;

	//upload file here
	  @PostMapping("/upload")
	  public ResponseEntity<CSVMessage> uploadFile(@RequestParam("file") MultipartFile file) {
	    String message = "";

	    if (CSVHelper.hasCSVFormat(file)) {
	      try {
	        fileService.save(file);

	        message = "Uploaded the file successfully: " + file.getOriginalFilename();
	        
	        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
	                .path("/api/csv/download/")
	                .path(file.getOriginalFilename())
	                .toUriString();

	        return ResponseEntity.status(HttpStatus.OK).body(new CSVMessage(message,fileDownloadUri));
	      } catch (Exception e) {
	        message = "Could not upload the file: " + file.getOriginalFilename() + "!";
	        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new CSVMessage(message,""));
	      }
	    }

	    message = "Please upload a csv file!";
	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new CSVMessage(message,""));
	  }

	  @GetMapping("/tutorials")
	  public ResponseEntity<List<CSVEntity>> getAllTutorials() {
	    try {
	      List<CSVEntity> tutorials = fileService.getAllTutorials();

	      if (tutorials.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }

	      return new ResponseEntity<>(tutorials, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	  //
	  @GetMapping("/download/{fileName:.+}")
	  public ResponseEntity<InputStreamResource> downloadFile(@PathVariable String fileName) {
	    InputStreamResource file = new InputStreamResource(fileService.load());

	    return ResponseEntity.ok()
	        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName)
	        .contentType(MediaType.parseMediaType("application/csv")).body(file);
	  }

}
