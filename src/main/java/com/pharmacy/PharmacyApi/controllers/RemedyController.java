package com.pharmacy.PharmacyApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.pharmacy.PharmacyApi.remedy.Remedy;
import com.pharmacy.PharmacyApi.remedy.RemedyDetails;
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
	public ResponseEntity<RemedyDetails> createRemedy(@RequestBody @Valid RemedyRegisterData data, UriComponentsBuilder uriBuilder) {
		var remedy = new Remedy(data);
		
		repository.save(remedy);
		
		var uri = uriBuilder.path("/remedy/{id}").buildAndExpand(remedy.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new RemedyDetails(remedy));
	}

	@GetMapping
	public ResponseEntity<List<RemedyListData>> listRemedy() {
		var list = repository.findAllByAtivoTrue().stream().map(RemedyListData::new).toList();
		
		return ResponseEntity.ok(list);
	}

	@PutMapping
	@Transactional
	public ResponseEntity<RemedyDetails> updateRemedy(@RequestBody @Valid RemedyUpdateData data) {
		var remedy = repository.getReferenceById(data.id());
		remedy.updateRemedy(data);
		
		return ResponseEntity.ok(new RemedyDetails(remedy));
	}
	
	@PutMapping("/enable/{id}")
	@Transactional
	public ResponseEntity<String> enableRemedy(@PathVariable Long id) {
		var remedy = repository.getReferenceById(id);
		remedy.ativar();
		
		return ResponseEntity.ok("Remédio ativado com sucesso!");
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<Void> deleteRemedy(@PathVariable Long id){
		repository.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/disable/{id}")
	@Transactional
	public ResponseEntity<Void> disableRemedy(@PathVariable Long id){
		var remedy = repository.getReferenceById(id);
		remedy.inativar();
		
		return ResponseEntity.noContent().build();
	}
	
}
