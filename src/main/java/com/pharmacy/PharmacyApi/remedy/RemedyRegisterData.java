package com.pharmacy.PharmacyApi.remedy;

public record RemedyRegisterData(String nome, Via via, String lote, int quantidade, String validade, Laboratorio laboratorio) {

}
