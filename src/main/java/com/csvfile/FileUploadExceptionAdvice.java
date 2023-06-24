package com.csvfile;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.csvfile.message.CSVMessage;

@RestControllerAdvice
public class FileUploadExceptionAdvice extends ResponseEntityExceptionHandler{
	  @SuppressWarnings("rawtypes")
	  @ExceptionHandler(MaxUploadSizeExceededException.class)
	    public ResponseEntity handleMaxSizeException(MaxUploadSizeExceededException exc) {
	      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new CSVMessage("File too large!",""));
	    }

}
