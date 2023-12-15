package com.pharmacy.PharmacyApi.remedy;

import java.time.LocalDate;

public record RemedyListData(String nome, Via via, String lote, Laboratorio laboratorio, LocalDate validade) {
	
	public RemedyListData(Remedy remedy) {
		this(remedy.getNome(), remedy.getVia(), remedy.getLote(), remedy.getLaboratorio(), remedy.getValidade());
	}
 }
