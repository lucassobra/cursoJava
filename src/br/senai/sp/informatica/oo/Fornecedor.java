package br.senai.sp.informatica.oo;


public class Fornecedor {
	private int codigo;		
	private	String nome;
	private String endereco;
	
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
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	@Override
	public String toString() {
		return "Fornecedor [codigo=" + codigo + ", " + (nome != null ? "nome=" + nome + ", " : "")
				+ (endereco != null ? "endereco=" + endereco : "") + "]";
	}
	public void setEnd(String text) {
		// TODO Auto-generated method stub
		
	}
	
		
		
		
	
	
}
