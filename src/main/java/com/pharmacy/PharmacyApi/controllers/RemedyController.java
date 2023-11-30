package com.pharmacy.PharmacyApi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pharmacy.PharmacyApi.remedy.Remedy;
import com.pharmacy.PharmacyApi.remedy.RemedyRegisterData;
import com.pharmacy.PharmacyApi.remedy.RemedyRepository;

@RestController
@RequestMapping("/remedy")
public class RemedyController {
	
	@Autowired
	private RemedyRepository repository; 
	
	
	@PostMapping
	public void createRemedy(@RequestBody RemedyRegisterData data) {
		
		repository.save(new Remedy(data));
		
	}
	
}
