package com.pharmacy.PharmacyApi.remedy;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;

public record RemedyUpdateData(

		@NotNull Long id,

		String nome,

		Via via,

		String lote,

		Laboratorio laboratorio,

		LocalDate validade) {

}
