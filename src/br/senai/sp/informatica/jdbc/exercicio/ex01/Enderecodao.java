package br.senai.sp.informatica.jdbc.exercicio.ex01;

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
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Estabelecer a conexão com o Bando de Dados
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaoo1803?useTimezone=true&serverTimezone=UTC", "root", "root132");
			
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
	public void incluir(Endereco obj) throws DaoException {
		try {
			incluir.setString(1, obj.getLogradouro());
			incluir.setString(2, obj.getNumero());
			incluir.setString(3, obj.getBairro());
			incluir.setString(4, obj.getCep());
			incluir.execute();
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new DaoException("Falha ao incluir um endereco");
		}
	}
	
	public void atualizar(Endereco obj) throws DaoException {
		try {
			atualizar.setString(1, obj.getLogradouro());
			atualizar.setString(2, obj.getNumero());
			atualizar.setString(3, obj.getBairro());
			atualizar.setString(4, obj.getCep());
			atualizar.execute();
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new DaoException("Falha ao atualizar um Fornecedor");
		}
	}
	
	public List<Endereco> consultar() throws DaoException {
		try {
			List<Endereco> lista = new ArrayList<>();
			
			ResultSet resultado = consultar.executeQuery();
			while(resultado.next()) {
				Endereco obj = new Endereco();
				obj.setIdendereco(resultado.getInt("idendereco"));
				obj.setLogradouro(resultado.getString("logradouro"));
				obj.setBairro(resultado.getString("bairro"));
				obj.setCep(resultado.getString("cep"));
				obj.setNumero(resultado.getString("numero"));
				
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







