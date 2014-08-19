package model;

import java.sql.SQLException;

import banco.BD;

public class OsDAO extends Os {

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
			bd.st.setInt(1, getIdOS());
			int n = bd.st.executeUpdate();
			if(n==1){
				return "Os excluída com sucesso!";
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
			
		
			sql = "insert into os values (?,?,?,?,?,?,?,?)";
			bd.getConnection();
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1,getIdOS());
			bd.st.setInt(2,getIdProcesso());
			bd.st.setInt(3,getIdFuncionario());
			bd.st.setInt(4,getIdCliente());
			bd.st.setInt(5,getIdMaquina());
			bd.st.setString(6,getDateOs());
			bd.st.setInt(7,getIdEtapa());
			bd.st.setString(8,getDate());
					
			int n = bd.st.executeUpdate();
			if(n==1){
				System.out.println("OK");
				return "OS cadastrada com sucesso!";
			}
			else{
				System.out.println("Falha");
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
			sql = "select * from os where codigo = ?";
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, getIdOS());
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
	

		
}