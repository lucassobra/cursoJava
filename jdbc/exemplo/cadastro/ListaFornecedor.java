package br.senai.sp.informatica.jdbc.exemplo.cadastro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class ListaFornecedor {
	public static void main(String[] args) {
		Connection con;
		
		List<Fornecedor> lista = new ArrayList<>();
		
		try {
			// Registrar o Driver JDBC
			Class.forName("com.mysql.jdbc.Driver");
			
			// Conectar ao Banco de Dados     
			con = DriverManager.getConnection("jdbc:mysql://localhost:3307/javaoo1803", 
					"root", "root132");
		
			// Preparar uma consulta SQL
			PreparedStatement sql = con.prepareStatement("SELECT * FROM fornecedor");
		
			// Percore o resultado SQL para construir o objeto Fornecedor 
			// e adicionar esta na lista
			ResultSet resultado = sql.executeQuery();
			while(resultado.next()) {
				Fornecedor obj = new Fornecedor();
				obj.setIdfornecedor(resultado.getInt("idfornecedor"));
				obj.setNome(resultado.getString("nome"));
				obj.setEndereco(resultado.getString("endereco"));
				lista.add(obj);
			}
		
			// Fecha a conexão ao Banco de Dados
			con.close();
			
			String msg = "Cadastro de Fornecedores\n\n";
			for (Fornecedor obj : lista) {
				msg += obj + "\n";
			}
			JOptionPane.showMessageDialog(null, msg);
		} catch (ClassNotFoundException ex) {
			JOptionPane.showMessageDialog(null, "Driver JDBC não encontrado");
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Problemas ao conectar ao Banco de Dados");
			ex.printStackTrace();
		}
		
	}
}
