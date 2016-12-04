package br.com.sppd.dbms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.sppd.dbms.bean.LoginBean;
import br.com.sppd.dbms.bean.Passageiro;
import br.com.sppd.factory.ConnectionFactory;

/**
 * 
 * Classe resposável por implementar login no sistema
 * @author Vitor Silva Delfino <vitor.delfino952@gmail.com>
 * @since 4 de dez de 2016
 */
public class Login {
	
	public List<LoginBean> logar(String usuario, String senha){
		Connection c = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "select count(*) from LOGIN l where l.username = ? and l.password = ?";
		String sql2 = "select * from passageiro p where p.cpf = ?";
		List<LoginBean> l = new ArrayList<>();
		try{
			c = new ConnectionFactory().getConnection();
			pst = c.prepareStatement(sql);
			pst.setString(1, usuario);
			pst.setString(2, senha);
			rs = pst.executeQuery();
			
			rs.next();
			if(rs.getInt(1) > 0){
				pst = c.prepareStatement(sql2);
				pst.setString(1, usuario);
				rs = pst.executeQuery();
				rs.next();
				Passageiro p = new Passageiro(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7),
						rs.getString(8),
						rs.getString(9),
						rs.getString(10),
						rs.getString(11),
						rs.getBoolean(12));
				l.add(new LoginBean(p,true, "Sucess"));
				return l;
			}else{
				l.add(new LoginBean(false, "Usuário ou Senha não encontrado"));
				return l;
			}
		}catch(SQLException e){
			l.add(new LoginBean(false, e.getMessage()));
			return l;
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
