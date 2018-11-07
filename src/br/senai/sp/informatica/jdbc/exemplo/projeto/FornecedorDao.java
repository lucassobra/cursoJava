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
public class FornecedorDao {
	private Connection con;
	private PreparedStatement incluir;
	private PreparedStatement atualizar;
	private PreparedStatement consultar;
	private PreparedStatement remover;
	
	public FornecedorDao() throws DaoException {
		try {
			// Registrar o Driver JDBC
			Class.forName("com.mysql.jdbc.Driver");
	
			// Estabelecer a conexão com o Bando de Dados
			con = DriverManager.getConnection("jdbc:mysql://localhost:3307/javaoo1803", 
					"root", "root132");
			
			// Preparar os SQLs para a utilização posterior
			incluir = con.prepareStatement(
					"insert into fornecedor (nome, endereco) values (?,?)");
			
			atualizar = con.prepareStatement(
					"update fornecedor set nome=?, endereco=? where idfornecedor=?");
			
			consultar = con.prepareStatement("select * from fornecedor");
			
			remover = con.prepareStatement("delete fornecedor where idfornecedor=?");
		} catch (ClassNotFoundException ex) {
			throw new DaoException("O Driver JDBC não foi encontrato");
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new DaoException("Houve problema na conexão com o Banco de Dados");
		}
	}
	
	// construção das rotinas que farão a gestão dos dados
	public void incluir(Fornecedor obj) throws DaoException {
		try {
			incluir.setString(1, obj.getNome());
			incluir.setString(2, obj.getEndereco());
			incluir.execute();
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new DaoException("Falha ao incluir um Fornecedor");
		}
	}
	
	public void atualizar(Fornecedor obj) throws DaoException {
		try {
			atualizar.setString(1, obj.getNome());
			atualizar.setString(2, obj.getEndereco());
			atualizar.setInt(3, obj.getIdfornecedor());
			atualizar.execute();
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new DaoException("Falha ao atualizar um Fornecedor");
		}
	}
	
	public List<Fornecedor> consultar() throws DaoException {
		try {
			List<Fornecedor> lista = new ArrayList<>();
			
			ResultSet resultado = consultar.executeQuery();
			while(resultado.next()) {
				Fornecedor obj = new Fornecedor();
				obj.setIdfornecedor(resultado.getInt("idfornecedor"));
				obj.setNome(resultado.getString("nome"));
				obj.setEndereco(resultado.getString("endereco"));
				
				lista.add(obj);
			}
			
			return lista;
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new DaoException("Houve falha ao listar os Fornecedores");
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







