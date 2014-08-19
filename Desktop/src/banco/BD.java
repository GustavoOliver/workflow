package banco;

import java.sql.*;

public class BD {
	public Connection con = null; //conecta ao banco
	public PreparedStatement st = null; //Executa SQL
	public ResultSet rs = null; //recebe resultado SQL
	
	private final String DRIVER = "com.mysql.jdbc.Driver";
	private final String DATABASENAME = "workflow";
	private final String URL = "jdbc:mysql://localhost:3306/"+
											DATABASENAME;
	private final String LOGIN = "root";
	private final String SENHA = "12345";
	
	/**
	 * Realiza a conexão ao banco de dados
	 * @return: true em caso de sucesso, ou false caso contrário
	 */
	public boolean getConnection(){
		
		try{
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL,LOGIN,SENHA);
			System.out.println("Conectou...");
			return true;
		}
		catch(ClassNotFoundException erro){
			System.out.println("Driver não encontrado! ");
			return false;
		}
		catch(SQLException erro){
			System.out.println("Erro " + erro.toString());
			return false;
		}		
	}
	
	/**
	 * Encerra a conexão ao banco de dados
	 */
	public void close(){  
		try{
			if(rs!=null){
				rs.close();  //encerra o rs
			}
		}
		catch(SQLException erro){}
		try{
			if(st!=null){
				st.close(); //encerra o st
			}
		}
		catch(SQLException erro){}
		try{
			if(con!=null){
				con.close(); //encerra a conexão
				System.out.println("Desconectou...");
			}
		}
		catch(SQLException erro){}
	}
	public static void main(String[] args) {
		BD bd = new BD();
		bd.getConnection();
		bd.close();
	}
}
