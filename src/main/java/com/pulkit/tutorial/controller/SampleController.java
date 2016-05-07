package com.pulkit.tutorial.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/couch")
public class SampleController {

	@RequestMapping(value="/get",method=RequestMethod.GET)
	public String get(){
		String sample="this is hi from couch";
		return sample;
	}
}
