package model;

import java.sql.SQLException;

import banco.BD;

public class EstadoDAO extends Estado {

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
			bd.st.setInt(1, getIdEstado());
			int n = bd.st.executeUpdate();
			if(n==1){
				return "Time exclu�do com sucesso!";
			}
			else{
				return "C�digo n�o encontrado!";
			}
		}
		catch(SQLException erro){
		}
		finally{
			bd.close();
		}
		return "Falha na exclus�o!";
		
	}

	public String gravar() {
		try{
			
			sql = "insert into estado values (null,?)";
			bd.getConnection();
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setString(1, getDescricao());
			int n = bd.st.executeUpdate();
			if(n==1){
				return "opera��o realizada com sucesso!";
			}
			else{
				return "C�digo n�o encontrado!";
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
	 * A busca � feita a partir do c�digo do time
	 */
	public boolean localizar() {
		try{
			bd.getConnection();
			sql = "select * from estado where codigo = ?";
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
	 * retorna o nome do time a partir do c�digo
	 * 
	 */
	public String buscarEstado() {
		try{
			bd.getConnection();
			sql = "select descricao from estado where idStatus= ?";
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