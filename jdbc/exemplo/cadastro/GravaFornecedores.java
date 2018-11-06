package br.senai.sp.informatica.jdbc.exemplo.cadastro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class GravaFornecedores {
	// Guarda a conexão com o Banco de Dados
	static Connection con;
	// Guarda a instrução de gravação SQL no Banco de Dados
	static PreparedStatement sql;
	
	public static void main(String[] args) throws SQLException {
		String nome = JOptionPane.showInputDialog("Informe o nome do Fornecedor");
		
		while(!nome.equals("fim")) {
			Fornecedor obj = new Fornecedor();
			obj.setNome(nome);
			obj.setEndereco(JOptionPane.showInputDialog("Informe o Endereço"));
			
			try {
				// Inclui no Banco de Dados
				gravarFornecedor(obj);
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Houve erro na Gravação dos Dados");
				ex.printStackTrace();
			}
			
			nome = JOptionPane.showInputDialog("Informe o nome do Fornecedor");
		}
		
		closeConnection();
	}

	private static void gravarFornecedor(Fornecedor obj) throws SQLException, ClassNotFoundException {
		// Executado somente na 1ª vez quando a declaração SQL não estiver criada
		if(sql == null) {
			// Cria (prepara) a instrução SQL
			sql = getConnection().prepareStatement(
					"INSERT INTO fornecedor (nome, endereco) VALUES (?,?)");
		}
		
		// Monta os arqumentos na instrução SQL preparada previamente
		sql.setString(1, obj.getNome());
		sql.setString(2, obj.getEndereco());
		// Executa a instrução SQL
		sql.executeUpdate();
	}

	private static Connection getConnection() throws ClassNotFoundException, SQLException {
		// Executado somente na 1ª vez quando a conexão ao Banco de Dados não estiver estabelecida
		if(con == null) {
			// Registra o Driver JDBC
			Class.forName("com.mysql.jdbc.Driver");
			// Conecta ao Banco de Dados
			con = DriverManager.getConnection("jdbc:mysql://localhost:3307/javaoo1803", "root", "root132");
		}
		return con;
	}

	private static void closeConnection() throws SQLException {
		if(con != null) {
			con.close();
		}
	}
}
