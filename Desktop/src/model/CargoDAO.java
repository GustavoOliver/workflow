package model;

import java.sql.SQLException;

import banco.BD;

public class CargoDAO extends Cargo{

	private BD bd;
	private String sql;
	
	public CargoDAO() {
		bd = new BD();
	}
	
	public String excluir(int idCargo) {
		try{
			bd.getConnection();
			sql = "delete from cargo where idCargo = ?";
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, getIdCargo());
			int n = bd.st.executeUpdate();
			if(n==1){
				return "Cargo exclu�do com sucesso!";
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
			
			sql = "insert into cargo values (?,?,?)";
			bd.getConnection();
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, getIdCargo());
			bd.st.setString(2, getFuncao());
			bd.st.setString(3, getDescricao());
			
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
	public boolean localizar(int idCargo) {
		try{
			bd.getConnection();
			sql = "select * from cargo where idCargo = ?";
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, getIdCargo());
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
			sql = "select funcao from cargo where idCargo = ?";
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, getIdCargo());
			bd.rs = bd.st.executeQuery();
			bd.rs.next();
			return bd.rs.getString("funcao");//coluna da tabela
		}
		catch(SQLException erro){
			
		}
		finally{
			bd.close();
		}
		return "";
	}

		
}