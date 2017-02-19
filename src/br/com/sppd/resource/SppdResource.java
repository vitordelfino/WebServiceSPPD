package br.com.sppd.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.json.JSONException;
import org.json.JSONObject;

import br.com.sppd.controller.CartaoController;
import br.com.sppd.controller.EstacaoController;
import br.com.sppd.controller.LoginController;
import br.com.sppd.controller.PassageiroController;
import br.com.sppd.dbms.bean.Cartao;
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

	
	/*
	 * REQUISICOES REFERENTE MANIPULACAO DE PASSAGEIRO/USUARIO
	 */
	@POST
	@Path("passageiro/cadastraPassageiro/{nome}/{cpf}/{rg}/{logradouro}/{numero}/"
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
		cpf = cpf.replace(".", "");
		cpf = cpf.replaceAll("-", "");
		Passageiro p = new Passageiro(1, nome, cpf, rg, logradouro, numero, complemento, cep, bairro, municipio,
				nascimento, Boolean.parseBoolean(deficiente));

		System.out.println(p.toString());
		List<Retorno> list = new PassageiroController().cadastraPassageiro(p);
		System.out.println(list.toString());
		return list;
	}
	
	
	
	/*
	 * REQUISICAO REFERENTE A LOGIN
	 */
	@GET
	@Path("login/logar/{usuario}/{senha}")
	@Produces("application/json")
	public List<LoginBean> logar(@PathParam("usuario") String usuario, @PathParam("senha") String senha) {
		return new LoginController().logar(usuario, senha);
	}

	@POST
	@Path("/login/alterarSenha/{cpf}/{novaSenha}")
	@Consumes({ "application/json" })
	@Produces("application/json")
	public Retorno alterarSenha(@PathParam("cpf") String cpf,
				@PathParam("novaSenha") String novaSenha){
		return new LoginController().alterarSenha(cpf, novaSenha);
	}
	@POST
	@Path("/login/alterarSenha/{cpf}/{senhaAtual}/{novaSenha}")
	@Consumes({ "application/json" })
	@Produces("application/json")
	public Retorno alterarSenha(@PathParam("cpf") String cpf,
				@PathParam("senhaAtual") String senhaAtual,
				@PathParam("novaSenha") String novaSenha){
		return new LoginController().alterarSenha(cpf,senhaAtual, novaSenha);
	}
	
	
	/*
	 * REQUISICOES REFERENTE A MANIPULAÇÃO DE CARTÕES
	 */	
	@GET
	@Path("/cartao/getCartoes/{codPassageiro}")
	@Produces("application/json")
	public List<Cartao> getCartoes(@PathParam("codPassageiro") int codPassageiro) {
		System.out.println("Buscando Cartões");
		List<Cartao> cartoes = new CartaoController().getCartoes(codPassageiro);
		System.out.println("Retorno = " + cartoes.toString());
		return cartoes;
	}

	@POST
	@Path("/cartao/efetuarRecarga/{codCartao}/{codPassageiro}")
	@Consumes({ "application/json" })
	@Produces("application/json")
	public Retorno efetuarRecarga(@PathParam("codCartao") int codCartao, @PathParam("codPassageiro") int codPassageiro,
			JSONObject inputJson) throws NumberFormatException, JSONException {

		System.out.println("Tentando efetuar recarga");
		System.out.println(inputJson);
		Cartao cartao = new Cartao(codCartao, codPassageiro);

		Double valor = Double.parseDouble(inputJson.get("valor").toString());

		Retorno retorno = new CartaoController().efetuarRecarga(cartao, valor);
		System.out.println(retorno);
		return retorno;
	}

	@POST
	@Path("/cartao/ativarCartao/{codCartao}/{codPassageiro}")
	@Consumes({ "application/json" })
	@Produces("application/json")
	public Retorno ativarCartao(@PathParam("codCartao") int codCartao, 
			@PathParam("codPassageiro") int codPassageiro) {

		System.out.println("Iniciando **ativar cartao**");
		Cartao cartao = new Cartao(codCartao, codPassageiro);
		Retorno retorno = new CartaoController().ativarCartao(cartao);
		System.out.println("retorno: " + retorno.toString());
		return retorno;

	}
}
