package com.pharmacy.PharmacyApi.remedy;

import java.time.LocalDate;

public record RemedyDetails(

		Long id, String nome, Via via, String lote, int quantidade, LocalDate validade, Laboratorio laboratorio,
		Boolean ativo

) {

	public RemedyDetails(Remedy remedy) {
		this(remedy.getId(), remedy.getNome(), remedy.getVia(), remedy.getLote(), remedy.getQuantidade(),
				remedy.getValidade(), remedy.getLaboratorio(), remedy.getAtivo());
	}

}
