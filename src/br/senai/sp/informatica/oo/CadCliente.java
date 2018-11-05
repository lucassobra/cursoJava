package br.senai.sp.informatica.oo;

import javax.swing.JOptionPane;

public class CadCliente {

	public static void main(String[] args) {
		int codigo = leInteiro("Informe o código do cliente");
		String nome = JOptionPane.showInputDialog("informe o nome");
		String cpf = JOptionPane.showInputDialog("informe o CPF");
		
		Cliente obj = new Cliente();
		obj.setCodigo(codigo);
		obj.setNome(nome);
		obj.setCpf(cpf);
		
		JOptionPane.showMessageDialog(null, obj);
	}

	public static int leInteiro(String mensagem) {
		String temp = JOptionPane.showInputDialog(mensagem);
		return Integer.parseInt(temp);
	}
	
	

}
