package br.senai.sp.informatica.oo;

import lombok.Data;

@Data
public class Cliente {
	
	private int codigo;
	private String nome;
	private String cpf;
	@Override
	public String toString() {
		return "Cliente Codigo: " + codigo + " Nome: " + nome + "CPF: " + cpf + "";
				 
	}

}
