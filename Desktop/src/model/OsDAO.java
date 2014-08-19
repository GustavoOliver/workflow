package model;

import java.sql.SQLException;

import banco.BD;

public class OsDAO extends Os implements DAO{

	private BD bd;
	private String sql;
	
	public OsDAO() {
		bd = new BD();
	}
	
	public String excluir() {
		try{
			bd.getConnection();
			sql = "delete from os where codigo = ?";
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setString(1, getCodigo());
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
			int p1=1;int p2=2;
			if(localizar()){//se encontrar
				sql = "update os set nome=? where codigo=?";
			}
			else{
				sql = "insert into os values (?,?)";
				p1=2; p2=1; //inverte a ordem dos par�metros
			}
			bd.getConnection();
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setString(p1, getNome());
			bd.st.setString(p2, getCodigo());
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
			sql = "select * from os where codigo = ?";
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
	 * retorna o nome do time a partir do c�digo
	 * 
	 */
	public String buscarNome() {
		try{
			bd.getConnection();
			sql = "select nome from os where codigo = ?";
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