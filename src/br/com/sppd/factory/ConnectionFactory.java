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
			String url = "jdbc:mysql://us-cdbr-azure-east-c.cloudapp.net:3306/msqlsppd";
			String userName = "badf4160ede94a";
			String passWord = "4efd22b1";
			
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
