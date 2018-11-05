package br.senai.sp.informatica.oo;

import java.util.ArrayList;
import java.util.List;

public class Produtos {
public int getCodigo() {
		
		
		return getCodigo();
	}
	
	
	
	private String nome;
	private String descricao;
	private String dataValidade;
	private Tipos tipo;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getDataValidade() {
		return dataValidade;
	}
	public void setDataValidade(String dataValidade) {
		this.dataValidade = dataValidade;
	}
	public Tipos getTipo() {
		return tipo;
	}
	public void setTipo(Tipos tipo) {
		this.tipo = tipo;
		
	}
	@Override
	public String toString() {
		return "Produtos [" + (nome != null ? "nome=" + nome + ", " : "")
				+ (descricao != null ? "descricao=" + descricao + ", " : "")
				+ (dataValidade != null ? "dataValidade=" + dataValidade + ", " : "")
				+ (tipo != null ? "tipo=" + tipo : "") + "]";
	}
	public void setCodigo(int c) {
		// TODO Auto-generated method stub
		
	}
	
	
		
	
	


}

