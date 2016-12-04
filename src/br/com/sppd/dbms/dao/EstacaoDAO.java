/**
 * 
 */
package br.com.sppd.dbms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.EscapeTokenizer;

import br.com.sppd.dbms.bean.Estacao;
import br.com.sppd.factory.ConnectionFactory;

/**
 * Classe resposável por realizar métodos de consulta ao BD relacionado a Estações
 * @author Vitor Silva Delfino <vitor.delfino952@gmail.com>
 * @since 2 de dez de 2016
 */
public class EstacaoDAO {
	
	/**
	 * 
	 * Método resposável por acessar o Banco e retornar todas as Estacoes cadastradas
	 * @author Vitor Silva Delfino <vitor.delfino952@gmail.com>
	 * @since 2 de dez de 2016
	 * @return List<Estacao>
	 */
	public List<Estacao> getListaEstacao(){
		Connection c = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String query = "select * from estacao";
		List<Estacao> estacao = new ArrayList<Estacao>();
		
		try{
			c = new ConnectionFactory().getConnection();
			pst = c.prepareStatement(query);
			rs = pst.executeQuery();
			
			while(rs.next()){
				estacao.add(new Estacao(rs.getInt(1), rs.getInt(2), rs.getString(3)));
			}
			return estacao;
		}catch(SQLException sql){
			System.out.println("********** ERRO DE CONEXAO **********");
			sql.printStackTrace();
			return estacao;
		}catch(Exception sql){
			System.out.println("********** ERRO DE CONEXAO **********");
			sql.printStackTrace();
			return estacao;
		}finally{
			try {
				rs.close();
				pst.close();
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}