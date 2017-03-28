package br.com.sppd.dbms.bean;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * Classe responsável por representar o uma Viagem
 * 
 * @author Vitor Silva Delfino <vitor.delfino952@gmail.com>
 * @since 22 de mar de 2017
 *
 */

@XmlRootElement
public class Viagem {

	private int id;
	private Passageiro passageiro;
	private Cartao cartao;
	private String dataViagem;
	private Estacao origem;
	private Estacao destino;
	private int entrandoSaindo;
	private double valor;
	public Viagem() {

	}

	public Viagem(Passageiro passageiro, Cartao cartao, String dataViagem, Estacao origem,
			double saldoAnterior, double saldoAtual) {
		this.setPassageiro(passageiro);
		this.setCartao(cartao);
		this.setDataViagem(dataViagem);
		this.setOrigem(origem);
		this.setEntrandoSaindo(entrandoSaindo);
		
	}
	
	public Viagem(Passageiro passageiro, Cartao cartao, String dataViagem, Estacao origem, Estacao destino,
			double saldoAnterior, double saldoAtual, double valor) {
		this.setPassageiro(passageiro);
		this.setCartao(cartao);
		this.setDataViagem(dataViagem);
		this.setOrigem(origem);
		this.setDestino(destino);
		this.setValor(valor);
		
	}

	public Viagem(Passageiro passageiro, Cartao cartao, Estacao origem, Estacao destino,
			double saldoAnterior, double saldoAtual) {
		this.setPassageiro(passageiro);
		this.setCartao(cartao);
		this.setOrigem(origem);
		this.setDestino(destino);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Passageiro getPassageiro() {
		return passageiro;
	}

	public void setPassageiro(Passageiro passageiro) {
		this.passageiro = passageiro;
	}

	public Cartao getCartao() {
		return cartao;
	}

	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}

	public String getDataViagem() {
		return dataViagem;
	}

	public void setDataViagem(String dataViagem) {
		this.dataViagem = dataViagem;
	}

	public Estacao getOrigem() {
		return origem;
	}

	public void setOrigem(Estacao origem) {
		this.origem = origem;
	}

	public Estacao getDestino() {
		return destino;
	}

	public void setDestino(Estacao destino) {
		this.destino = destino;
	}

	public int getEntrandoSaindo() {
		return entrandoSaindo;
	}

	public void setEntrandoSaindo(int entrandoSaindo) {
		this.entrandoSaindo = entrandoSaindo;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

}
