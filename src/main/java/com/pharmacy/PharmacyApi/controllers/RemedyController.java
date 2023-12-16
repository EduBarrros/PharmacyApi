package com.pharmacy.PharmacyApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pharmacy.PharmacyApi.remedy.Remedy;
import com.pharmacy.PharmacyApi.remedy.RemedyListData;
import com.pharmacy.PharmacyApi.remedy.RemedyRegisterData;
import com.pharmacy.PharmacyApi.remedy.RemedyRepository;
import com.pharmacy.PharmacyApi.remedy.RemedyUpdateData;

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
	public List<RemedyListData> listRemedy() {
		return repository.findAllByAtivoTrue().stream().map(RemedyListData::new).toList();
	}

	@PutMapping
	@Transactional
	public void updateRemedy(@RequestBody @Valid RemedyUpdateData data) {
		var remedy = repository.getReferenceById(data.id());
		remedy.updateRemedy(data);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public void deleteRemedy(@PathVariable Long id){
		repository.deleteById(id);
	}
	
	@DeleteMapping("/disable/{id}")
	@Transactional
	public void logicDeleteRemedy(@PathVariable Long id){
		var remedy = repository.getReferenceById(id);
		remedy.inativar();
	}
	
}
