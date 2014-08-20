package model;

import java.sql.SQLException;

import banco.BD;

public class ProcessoDAO extends Processo{
	
	private BD bd;
	private String sql;
	
	public ProcessoDAO() {
		bd = new BD();
	}
	
	public String gravar(){
		
		try {
			sql = "insert into processo values(?,?,?)";
			bd.getConnection();
			bd.st= bd.con.prepareStatement(sql);
			bd.st.setInt(1, getIdProcesso());
			bd.st.setInt(2, getIdFuncionario());
			bd.st.setString(3, getDescricao());
			int n = bd.st.executeUpdate();
			if(n==1){
				return "Processo cadastrado com sucesso!";
			}else{
				return "Falha ao cadastrar processo";
			}
			
		} catch (SQLException e) {
			return e.toString();
		} finally{
			bd.close();
		}
		
	}
	
	public String atualizar(){
		
		try{
			sql = "update processo set idProcesso=?,descricao=? where Funcionario_idFuncionario=?";
			bd.getConnection();
			bd.st= bd.con.prepareStatement(sql);
			bd.st.setInt(1, getIdProcesso());
			bd.st.setString(2, getDescricao());
			bd.st.setInt(3, getIdFuncionario());
			int n = bd.st.executeUpdate();
			if(n==1){
				return "Processo atualizado com sucesso!";
			}else{
				return "Falha ao atualizar processo!";
			}
			
			
		}catch(SQLException e){
			return e.toString();
		}finally{
			bd.close();
		}
		
	}
	

}
