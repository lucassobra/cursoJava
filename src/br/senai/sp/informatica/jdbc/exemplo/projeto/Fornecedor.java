package br.senai.sp.informatica.jdbc.exemplo.projeto;

import lombok.Data;

@Data
public class Fornecedor {
	private Integer idfornecedor;
	private String nome;
	private String endereco;
	
	@Override
	public String toString() {
		return "Nome: " + nome + " Endereço: " + endereco;
	}
}
