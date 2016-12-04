package br.com.sppd.controller;

import java.util.List;

import br.com.sppd.dbms.bean.LoginBean;
import br.com.sppd.dbms.dao.Login;

public class LoginController {

	public List<LoginBean> logar(String usuario, String senha){
		return new Login().logar(usuario, senha); 
	}
}
