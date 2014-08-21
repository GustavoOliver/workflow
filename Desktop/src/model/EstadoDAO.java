package model;

import java.sql.SQLException;

import banco.BD;

public class EstadoDAO extends Estado {

	private BD bd;
	private String sql;
	
	public EstadoDAO() {
		bd = new BD();
	}
	
	

	public String gravar() {
		try{
			
			sql = "insert into Estado values (null,?)";
			bd.getConnection();
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setString(1, getDescricao());
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
			sql = "select * from Estado where codigo = ?";
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, getIdEstado());
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
	public String buscarEstado() {
		try{
			bd.getConnection();
			sql = "select descricao from Estado where idStatus= ?";
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, getIdEstado());
			bd.rs = bd.st.executeQuery();
			bd.rs.next();
			return bd.rs.getString("descricao");//coluna da tabela
		}
		catch(SQLException erro){
			
		}
		finally{
			bd.close();
		}
		return "";
	}

		
}