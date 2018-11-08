package fileio;

import java.io.Serializable;

import lombok.Data;

@Data
public class Produto implements Serializable {
	private static final long serialVersionUID = -2336739401904823604L;
	
	private int codigo;
	private String nome;
	private String descricao;
	private double valor;
	private int quantidade;

	@Override
	public String toString() {
		return "codigo: " + codigo + " nome: " + nome + " descricao: "
				+ descricao + " valor: " + valor + " quantidade: " + quantidade;
	}

}
