package br.senai.sp.informatica.oo;

public class Cliente {
	public int getCodigo() {
		
		
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	private int codigo;
	private String nome;
	private String cpf;
	@Override
	public String toString() {
		return "Cliente Codigo: " + codigo + " Nome: " + nome + "CPF: " + cpf + "";
				 
	}

}
