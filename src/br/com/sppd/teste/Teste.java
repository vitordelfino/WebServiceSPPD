package br.com.sppd.teste;

import java.util.Date;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import br.com.sppd.dbms.bean.Estacao;
import br.com.sppd.dbms.bean.Passageiro;
import br.com.sppd.dbms.dao.EstacaoDAO;
import br.com.sppd.dbms.dao.Login;
import br.com.sppd.dbms.dao.PassageiroDAO;
import br.com.sppd.factory.ConnectionFactory;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		testaConexao();
		//testaGetEstacao();
		//testeCadastraPassageiro();
		
		/*JSONObject jo = new JSONObject();
		try {
			jo.put("valor", 10.00);
			System.out.println(jo);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		//logar();
	}


static void testaConexao(){
	/**
	*************** teste de conexao com banco ***************
	**/
	System.out.println("******** teste conexao com banco ******** ");
	ConnectionFactory c = new ConnectionFactory();
	c.getConnection();
}

static void testaGetEstacao(){
	EstacaoDAO e = new EstacaoDAO();
	List<Estacao> listEstacao = e.getListaEstacao();
	System.out.println(listEstacao.toString());
	
}

static void testeCadastraPassageiro(){
	Passageiro p = new Passageiro(1, "VITOR", "42780908890", "483718075"
			,"RUA JATOBÁ", "8","CASA 2", "06332340", "VILA VELOSO", "CARAPICUIBA", "1995-10-04", false);
	
	PassageiroDAO pDAO = new PassageiroDAO();
	System.out.println(pDAO.cadastraPassageiro(p));
}

static void logar(){
	Login l = new Login();
	System.out.println(l.logar("42780908890", "42780908890.").toString());
}
}