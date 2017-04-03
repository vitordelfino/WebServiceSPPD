package br.com.sppd.dijkstra;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.sppd.factory.ConnectionFactory;

/**
 * 
 * Classe respons�vel por preencher arquivo com as conex�es entre esta��es
 * @author Vitor Silva Delfino <vitor.delfino952@gmail.com>
 * @since 29 de mar de 2017
 *
 */
public class PreencheArquivo {
	
	public void preencher() throws IOException{
		Connection c = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String query = "select e1.nome, e2.nome, gf.distancia from grafoDasEstacoes gf, estacao e1, estacao e2"+
						" where gf.codEstacao = e1.codEstacao and gf.codEstacaoProx = e2.codEstacao";
		
		File f = new File("Grafo.txt");
		BufferedWriter bw = new BufferedWriter(new FileWriter(f));
		
		
		try{
			
			c = new ConnectionFactory().getConnection();
			pst = c.prepareStatement(query);			
			rs = pst.executeQuery();	
			String auxUltimo = "";
			while(rs.next()){
				if(!auxUltimo.equals("")){
					if(!rs.getString(1).equals(auxUltimo))
						bw.append(auxUltimo+"\n");
				}
				bw.append(rs.getString(1)+","+rs.getString(2)+"/"+rs.getInt(3)+"\n");
				bw.append(rs.getString(2)+","+rs.getString(1)+"/"+rs.getInt(3)+"\n");
				auxUltimo = rs.getString(2);
				
				
			}
			bw.append(auxUltimo);
			
			
			
		}catch(SQLException sql){
			System.out.println("********** ERRO DE CONEXAO **********");
			sql.printStackTrace();
		}catch(Exception sql){
			System.out.println("********** ERRO DE CONEXAO **********");
			sql.printStackTrace();
		}finally{
			try {
				rs.close();
				pst.close();
				c.close();
				bw.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}
