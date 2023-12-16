package com.pharmacy.PharmacyApi.remedy;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RemedyRepository extends JpaRepository<Remedy, Long> {

	List<Remedy> findAllByAtivoTrue();

}
