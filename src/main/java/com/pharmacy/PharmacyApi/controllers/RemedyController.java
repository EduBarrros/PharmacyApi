package com.pharmacy.PharmacyApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pharmacy.PharmacyApi.remedy.Remedy;
import com.pharmacy.PharmacyApi.remedy.RemedyListData;
import com.pharmacy.PharmacyApi.remedy.RemedyRegisterData;
import com.pharmacy.PharmacyApi.remedy.RemedyRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/remedy")
public class RemedyController {

	@Autowired
	private RemedyRepository repository;

	@PostMapping
	@Transactional
	public void createRemedy(@RequestBody @Valid RemedyRegisterData data) {
		repository.save(new Remedy(data));
	}
	
	@GetMapping
	public List<RemedyListData> listRemedy(){
		return repository.findAll().stream().map(RemedyListData::new).toList();
	}

}
