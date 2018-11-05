package Exercicios;

public class ProdutosAlimenticios extends TodoProduto {

	private String dataDeValidade;
	private String dataDeProducao;

	public String getDataDeValidade() {
		return dataDeValidade;
	}

	public void setDataDeValidade(String dataDeValidade) {
		this.dataDeValidade = dataDeValidade;
	}

	public String getDataDeProducao() {
		return dataDeProducao;
	}

	public void setDataDeProducao(String dataDeProducao) {
		this.dataDeProducao = dataDeProducao;
	}

	@Override
	public String toString() {
		return super.toString() + " Data de Validade: " + dataDeValidade + " Data de Producao: " + dataDeProducao;
	}


}
