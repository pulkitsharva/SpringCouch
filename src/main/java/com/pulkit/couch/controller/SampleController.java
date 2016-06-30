package com.pulkit.couch.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pulkit.couch.dto.StudentDTO;

@RestController
@RequestMapping("/api/v1/student")
public class SampleController {

	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<StudentDTO> get(@PathVariable Integer id){
		
		StudentDTO student=new StudentDTO();
		return new ResponseEntity<StudentDTO>(student,HttpStatus.OK);
	}
}
