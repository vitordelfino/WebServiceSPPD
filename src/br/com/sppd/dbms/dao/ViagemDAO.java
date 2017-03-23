package br.com.sppd.dbms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.sppd.dbms.bean.Viagem;
import br.com.sppd.factory.ConnectionFactory;
import br.com.sppd.retorno.Retorno;

/**
 * 
 * Classe responsável por realizar métodos ao BD 
 * @author Vitor Silva Delfino <vitor.delfino952@gmail.com>
 * @since 22 de mar de 2017
 *
 */
public class ViagemDAO {
	
	public Retorno setNovaViagem(Viagem viagem){
		Connection c = null;
		PreparedStatement pst = null;
		String query = "insert into historicoViagem"+
						"(codPassageiro, codCartao, origem, saldoAtual)"+	
						"select ?,?,?, saldo from cartao where codCartao = ?";
		
		
		Retorno retorno = new Retorno();
		retorno.setRetorno(false);
		try{
			c = new ConnectionFactory().getConnection();
			pst = c.prepareStatement(query);
			pst.setInt(1, viagem.getPassageiro().getCodPassageiro());
			pst.setInt(2, viagem.getCartao().getCodCartao());
			pst.setInt(3, viagem.getOrigem().getCodEstacao());
			pst.setInt(4, viagem.getCartao().getCodCartao());
			
			System.out.println(query);
			
			pst.execute();
			retorno = new Retorno(true, "Sucess");
			
			return retorno;
		}catch(SQLException sql){
			System.out.println("********** ERRO DE CONEXAO **********");
			sql.printStackTrace();
			retorno.setStatus(sql.getMessage());
			return retorno;
			
		}catch(Exception sql){
			System.out.println("********** ERRO DE CONEXAO **********");
			sql.printStackTrace();
			retorno.setStatus(sql.getMessage());
			return retorno;
		}finally{
			try {
				pst.close();
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
