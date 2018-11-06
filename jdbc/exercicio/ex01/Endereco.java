package br.senai.sp.informatica.jdbc.exercicio.ex01;

import lombok.Data;

@Data
public class Endereco {
	private Integer idendereco;
	private String logradouro;
	private String numero;
	private String bairro;
	private String cep;

	@Override
	public String toString() {
		return logradouro + ", " + numero + " - " + bairro + " CEP: " + cep;
	}
}
