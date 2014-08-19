package model;

import java.sql.SQLException;

import banco.BD;

public class EstadoDAO extends Estado implements DAO{

	private BD bd;
	private String sql;
	
	public EstadoDAO() {
		bd = new BD();
	}
	
	public String excluir() {
		try{
			bd.getConnection();
			sql = "delete from estado where codigo = ?";
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setString(1, getCodigo());
			int n = bd.st.executeUpdate();
			if(n==1){
				return "Time excluído com sucesso!";
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
			int p1=1;int p2=2;
			if(localizar()){//se encontrar
				sql = "update estado set nome=? where codigo=?";
			}
			else{
				sql = "insert into estado values (?,?)";
				p1=2; p2=1; //inverte a ordem dos parâmetros
			}
			bd.getConnection();
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setString(p1, getNome());
			bd.st.setString(p2, getCodigo());
			int n = bd.st.executeUpdate();
			if(n==1){
				return "operação realizada com sucesso!";
			}
			else{
				return "Código não encontrado!";
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
			sql = "select * from estado where codigo = ?";
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setString(1, getCodigo());
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
			sql = "select nome from estado where codigo = ?";
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setString(1, getCodigo());
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