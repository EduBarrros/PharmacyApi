package com.pharmacy.PharmacyApi.remedy;

import java.time.LocalDate;

import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RemedyRegisterData(

		@NotBlank(message = "O nome não pode estar em branco!") String nome,

		@NotNull(message = "A via informada é inválida!") @Enumerated Via via,

		@NotBlank(message = "O lote não pode estar em branco!") String lote,

		int quantidade,

		@Future(message = "A data não pode ser retroativa!") LocalDate validade,

		@NotNull(message = "O laboratório informado é inválido!") @Enumerated Laboratorio laboratorio) {

}
