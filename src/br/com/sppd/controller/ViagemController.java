package br.com.sppd.controller;

import java.util.List;

import br.com.sppd.dbms.bean.Viagem;
import br.com.sppd.dbms.dao.ViagemDAO;

/**
 * 
 * Classe responsável por ser o controlador entre ViagemDAO e resource
 * @author Vitor Silva Delfino <vitor.delfino952@gmail.com>
 * @since 18 de abr de 2017
 *
 */
public class ViagemController {
	public List<Viagem> getHistoricoViagens(int codPassageiro){
		return new ViagemDAO().getHistoricoViagens(codPassageiro);
	}
}
