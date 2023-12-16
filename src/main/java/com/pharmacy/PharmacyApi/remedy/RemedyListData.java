package com.pharmacy.PharmacyApi.remedy;

import java.time.LocalDate;

public record RemedyListData(Long id, String nome, Via via, String lote, Laboratorio laboratorio, LocalDate validade) {

	public RemedyListData(Remedy remedy) {
		this(remedy.getId(), remedy.getNome(), remedy.getVia(), remedy.getLote(), remedy.getLaboratorio(),
				remedy.getValidade());
	}
}
