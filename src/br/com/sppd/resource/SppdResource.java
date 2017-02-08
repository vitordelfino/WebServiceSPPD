package br.com.sppd.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.sppd.controller.EstacaoController;
import br.com.sppd.controller.LoginController;
import br.com.sppd.controller.PassageiroController;
import br.com.sppd.dbms.bean.Estacao;
import br.com.sppd.dbms.bean.LoginBean;
import br.com.sppd.dbms.bean.Passageiro;
import br.com.sppd.retorno.Retorno;

/**
 * 
 * Classe resposável por conter os metodos REST de acesso ao webservice
 * 
 * @author Vitor Silva Delfino <vitor.delfino952@gmail.com>
 * @since 2 de dez de 2016
 */

@Path("/sppd")
public class SppdResource {

	/**
	 * 
	 * Método resposável por fazer a chamada ao Controller
	 * 
	 * @author Vitor Silva Delfino <vitor.delfino952@gmail.com>
	 * @since 2 de dez de 2016
	 * @return List<Estacao>
	 */
	@GET
	@Path("/getListaEstacao")
	@Produces("application/json")
	public List<Estacao> getListaEstacao() {
		return new EstacaoController().getListaEstacao();
	}

	@POST
	@Path("/cadastraPassageiro/{nome}/{cpf}/{rg}/{logradouro}/{numero}/"
			+ "{complemento}/{cep}/{bairro}/{municipio}/{nascimento}/{deficiente}")
	@Consumes({ "application/json" })
	@Produces("application/json")
	public List<Retorno> cadastraPassageiro(@PathParam("nome") String nome, @PathParam("cpf") String cpf,
			@PathParam("rg") String rg, @PathParam("logradouro") String logradouro, @PathParam("numero") String numero,
			@PathParam("complemento") String complemento, @PathParam("cep") String cep,
			@PathParam("bairro") String bairro, @PathParam("municipio") String municipio,
			@PathParam("nascimento") String nascimento, @PathParam("deficiente") String deficiente) {
		nascimento = nascimento.substring(6, nascimento.length()) + "-" + nascimento.substring(3, 5) + "-"
				+ nascimento.substring(0, 2);
		Passageiro p = new Passageiro(1, nome, cpf, rg, logradouro, numero, complemento, cep, bairro, municipio,
				nascimento, Boolean.parseBoolean(deficiente));

		System.out.println(p.toString());
		List<Retorno> list = new PassageiroController().cadastraPassageiro(p);
		System.out.println(list.toString());
		return list;
	}

	@GET
	@Path("/logar/{usuario}/{senha}")
	@Produces("application/json")
	public List<LoginBean> logar(@PathParam("usuario") String usuario, @PathParam("senha") String senha) {
		return new LoginController().logar(usuario, senha);
	}
}
