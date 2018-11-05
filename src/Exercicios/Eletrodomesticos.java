package Exercicios;

public class Eletrodomesticos extends TodoProduto {

	private String codigoFornecedor;
	private String nomeFornecedor;

	public String getCodigoFornecedor() {
		return codigoFornecedor;
	}

	public void setCodigoFornecedor(String codigoFornecedor) {
		this.codigoFornecedor = codigoFornecedor;
	}

	public String getNomeFornecedor() {
		return nomeFornecedor;
	}

	public void setNomeFornecedor(String nomeFornecedor) {
		this.nomeFornecedor = nomeFornecedor;
	}

	@Override
	public String toString() {
		return super.toString() + " Codigo Fornecedor: " + codigoFornecedor + " Nome Fornecedor: " + nomeFornecedor;
	}

}
