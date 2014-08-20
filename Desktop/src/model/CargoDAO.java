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
				return "Cargo excluído com sucesso!";
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
			
			sql = "insert into cargo values (null,?,?)";
			bd.getConnection();
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setString(1, getFuncao());
			bd.st.setString(2, getDescricao());
			
			int n = bd.st.executeUpdate();
			if(n==1){
				return "Operação realizada com sucesso!";
				
			}
			else{
				return "Falha no cadastro!";
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
	 * verifica se um determinado cargo existe no BD
	 * A busca é feita a partir do código do cargo
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

	
	public String buscarCargo() {
		try{
			bd.getConnection();
			sql = "select Descricao from cargo where idCargo = ?";
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, getIdCargo());
			bd.rs = bd.st.executeQuery();
			bd.rs.next();
			return bd.rs.getString("Descricao");//coluna da tabela
		}
		catch(SQLException erro){
			
		}
		finally{
			bd.close();
		}
		return "";
	}
	
			
}