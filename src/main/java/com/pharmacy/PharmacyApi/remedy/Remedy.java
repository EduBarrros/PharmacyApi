package com.pharmacy.PharmacyApi.remedy;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "Remedys")
@Entity(name = "remedy")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Remedy {

	public Remedy(RemedyRegisterData data) {
		this.nome = data.nome();
		this.via = data.via();
		this.lote = data.lote();
		this.quantidade = data.quantidade();
		this.validade = data.validade();
		this.laboratorio = data.laboratorio();
		this.ativo = true;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	@Enumerated(EnumType.STRING)
	private Via via;

	private String lote;

	private int quantidade;

	private LocalDate validade;

	@Enumerated(EnumType.STRING)
	private Laboratorio laboratorio;
	
	private Boolean ativo;

	public void updateRemedy(@Valid RemedyUpdateData data) {
		if (data.nome() != null) {
			this.nome = data.nome();
		}

		if (data.via() != null) {
			this.via = data.via();
		}

		if (data.lote() != null) {
			this.lote = data.lote();
		}

		if (data.laboratorio() != null) {
			this.laboratorio = data.laboratorio();
		}

		if (data.validade() != null) {
			this.validade = data.validade();
		}
		
		if (data.ativo() != null) {
			this.ativo = data.ativo();
		}
	}

	public void inativar() {
		this.ativo = false;
		
	}
}
