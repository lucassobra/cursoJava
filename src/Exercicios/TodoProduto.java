package Exercicios;

public abstract class TodoProduto {
	
		private String codigoDoProduto;
		private String descricaoDoProduto;
		private String ValorDoProduro;
		
		public String getCodigoDoProduto() {
			return codigoDoProduto;
		}
		public void setCodigoDoProduto(String codigoDoProduto) {
			this.codigoDoProduto = codigoDoProduto;
		}
		public String getDescricaoDoProduto() {
			return descricaoDoProduto;
		}
		public void setDescricaoDoProduto(String descricaoDoProduto) {
			this.descricaoDoProduto = descricaoDoProduto;
		}
		public String getValorDoProduro() {
			return ValorDoProduro;
		}
		public void setValorDoProduro(String valorDoProduro) {
			ValorDoProduro = valorDoProduro;
		}
		
		@Override
		public String toString() {
			return "Codigo do Produto: " + codigoDoProduto + " Descricao: " + descricaoDoProduto
					+ " Valor do Produro: " + ValorDoProduro;
		}
		
}

