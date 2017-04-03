package br.com.sppd.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import br.com.sppd.dbms.bean.Estacao;
import br.com.sppd.dbms.dao.EstacaoDAO;
import br.com.sppd.dijkstra.Dijkstra;
import br.com.sppd.dijkstra.Grafo;
import br.com.sppd.dijkstra.LerDoArquivo;
import br.com.sppd.dijkstra.Vertice;

/**
 * 
 * Classe responsável por ser o controller Resource e Dijkstra
 * @author Vitor Silva Delfino <vitor.delfino952@gmail.com>
 * @since 30 de mar de 2017
 *
 */
public class DijkstraController {

	public List<Estacao> encontrarMenorCaminhoDijkstra(String origem, String destino){
		Grafo grafo = new Grafo();
		grafo.setVertices(LerDoArquivo.lerGrafo("C:\\Workspace\\Eclipse\\WebServiceSPPD\\Grafo.txt"));
		Vertice v1 = new Vertice();
		Vertice v2 = new Vertice();
		v1 = grafo.encontrarVertice(origem);
		v2 = grafo.encontrarVertice(destino);
		
		List<Vertice> lv = new Dijkstra().encontrarMenorCaminhoDijkstra(grafo, v1, v2);
		
		for(Vertice v : lv){
			v.getDistancia();
		}
		List<Estacao> estacoes = new ArrayList<Estacao>();
		lv.forEach(v -> {
			String nomeEstacao = v.getDescricao();
			estacoes.add(new EstacaoDAO().getEstacao(nomeEstacao));
		});
		
		
		return estacoes;
	}
}
