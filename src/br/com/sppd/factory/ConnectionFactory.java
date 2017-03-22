package br.com.sppd.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private Connection conexao(){
		Connection con = null;
		
		try{
			String driveName = "com.mysql.jdbc.Driver";
			Class.forName(driveName);		
			//"jdbc:mysql://localhost/SPPD";
			//"root";
			//"123456";
			String url = "jdbc:mysql://localhost/SPPD";
			String userName = "root";
			String passWord = "123456";
			
			con = DriverManager.getConnection(url,userName,passWord);
			
			if(con != null){
				System.out.println("Conectou...");
				return con;
			}else{
				return null;
			}	
			}catch(ClassNotFoundException e){
				e.printStackTrace();
				return null;
			}catch(SQLException e ){
				e.printStackTrace();
				return null;
			}		
	}
	
	public Connection getConnection(){
		ConnectionFactory c = new ConnectionFactory();
		return c.conexao();
	}
	
	public void closeConnection(Connection c){
		try {
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
