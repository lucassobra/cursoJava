package br.senai.sp.informatica.jdbc.exemplo.projeto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* Data Access Object
// um padrão de desenvolvimento de projetos utilizado
// para concentrar o acesso a um determinado mecanismo
// que forneça dados para uma aplicação
*/
public class Enderecodao {
	private Connection con;
	private PreparedStatement incluir;
	private PreparedStatement atualizar;
	private PreparedStatement consultar;
	private PreparedStatement remover;
	
	public Enderecodao() throws DaoException {
		try {
			// Registrar o Driver JDBC
			Class.forName("com.mysql.jdbc.Driver");
	
			// Estabelecer a conexão com o Bando de Dados
			con = DriverManager.getConnection("jdbc:mysql://localhost:3307/javaoo1803", 
					"root", "root132");
			
			// Preparar os SQLs para a utilização posterior
			incluir = con.prepareStatement(
					"insert into endereco (numero, logradouro, bairro, cep) values (?,?,?,?)");
			
			atualizar = con.prepareStatement(
					"update endereco set logradouro=?, numero=?, bairro=?, cep=? where idendereco=?");
			
			consultar = con.prepareStatement("select * from endereco");
			
			remover = con.prepareStatement("delete endereco where idendereco=?");
		} catch (ClassNotFoundException ex) {
			throw new DaoException("O Driver JDBC não foi encontrato");
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new DaoException("Houve problema na conexão com o Banco de Dados");
		}
	}
	
	// construção das rotinas que farão a gestão dos dados
	public void incluir(endereco obj) throws DaoException {
		try {
			incluir.setString(1, obj.getNome());
			incluir.setString(2, obj.getEndereco());
			incluir.execute();
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new DaoException("Falha ao incluir um endereco");
		}
	}
	
	public void atualizar(endereco obj) throws DaoException {
		try {
			atualizar.setString(1, obj.getNome());
			atualizar.setString(2, obj.getEndereco());
			atualizar.setInt(3, obj.getendereco());
			atualizar.execute();
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new DaoException("Falha ao atualizar um Fornecedor");
		}
	}
	
	public List<endereco> consultar() throws DaoException {
		try {
			List<endereco> lista = new ArrayList<>();
			
			ResultSet resultado = consultar.executeQuery();
			while(resultado.next()) {
				endereco obj = new endereco();
				obj.setIdfornecedor(resultado.getInt("idendereco"));
				obj.setNome(resultado.getString("nome"));
				obj.setEndereco(resultado.getString("endereco"));
				
				lista.add(obj);
			}
			
			return lista;
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new DaoException("Houve falha ao listar os endereco");
		}
	}
	
	public void remover(int id) throws DaoException {
		try {
			remover.setInt(1, id);
			remover.execute();
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new DaoException("Falha ao remover o Fornecedor");
		}
	}
	
	public void fecharConexao() {
		try {
			if(con != null) {
				con.close();
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}







