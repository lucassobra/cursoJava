package fileio;

import java.util.List;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class ModelProduto extends AbstractTableModel {
	private List<Produto> lista;
	private String[] titulo = { "Cod.", "Nome", "Valor", "Qtd." }; 
	
	public ModelProduto(List<Produto> lista) {
		this.lista = lista;
	}

	public void adiciona(Produto prod) {
		lista.add(prod);
		fireTableDataChanged();
	}

	public void setLista(List<Produto> lista) {		
		this.lista = lista;
		fireTableDataChanged();
	}
	
	@Override
	public int getColumnCount() {
		return titulo.length;
	}

	@Override
	public int getRowCount() {
		return lista.size();
	}

	@Override
	public String getColumnName(int col) {
		return titulo[col];
	}

	@Override
	public Object getValueAt(int lin, int col) {
		Object valor = null;
		Produto prod = lista.get(lin);
		
		switch (col) {
		case 0:
			valor = prod.getCodigo();
			break;
		case 1:
			valor = prod.getNome();
			break;
		case 2:
			valor = prod.getValor();
			break;
		case 3:
			valor = prod.getQuantidade();
			break;
		}
		
		return valor;
	}
}
