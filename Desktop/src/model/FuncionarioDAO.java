package model;

import java.sql.SQLException;

import banco.BD;

public class FuncionarioDAO extends Funcionario{

	private BD bd;
	private String sql;
	
	public FuncionarioDAO() {
		bd = new BD();
	}
	
	public String excluir() {
		try{
			bd.getConnection();
			sql = "delete from funcionario where idFuncionario = ?";
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, getIdFuncionario());
			int n = bd.st.executeUpdate();
			if(n==1){
				return "funcionário excluído com sucesso!";
			}
			else{
				return "Código não encontrado!";
			}
		}
		catch(SQLException erro){
		}
		finally{
			bd.close();
		}
		return "Falha na exclusão!";
		
	}

	public String gravar() {
		try{
			sql = "insert into funcionario values (?,?,?,?,?,?,?)";
			bd.getConnection();
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, getIdFuncionario());
			bd.st.setInt(2, getIdCargo());
			bd.st.setString(3, getNome());
			bd.st.setString(4, getSobrenome());
			bd.st.setString(5, getRg());
			bd.st.setString(6, getCpf());
			bd.st.setString(7, getEmail());
			bd.st.setString(8, getSenha());
			int n = bd.st.executeUpdate();
			if(n==1){
				return "Funcionário inserido com sucesso!";
			}
			else{
				return "Funcionário não inserido!";
			}
		}
		catch(SQLException erro){
			return erro.toString();
		}
		finally{
			bd.close();
		}
	}


	/**
	 * verifica se um determinado time existe no BD
	 * A busca é feita a partir do código do time
	 */
	public boolean localizar() {
		try{
			bd.getConnection();
			sql = "select * from funcionario where idFuncionario = ?";
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, getIdFuncionario());
			bd.rs = bd.st.executeQuery();
			return bd.rs.next();
		}
		catch(SQLException erro){
			
		}
		finally{
			bd.close();
		}
		return false;
	}

	
	/**
	 * retorna o nome do time a partir do código
	 * 
	 */
	public String buscarNome() {
		try{
			bd.getConnection();
			sql = "select nome from funcionario where idFuncionario = ?";
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, getIdFuncionario());
			bd.rs = bd.st.executeQuery();
			bd.rs.next();
			return bd.rs.getString("nome");//coluna da tabela
		}
		catch(SQLException erro){
			
		}
		finally{
			bd.close();
		}
		return "";
	}

		
}