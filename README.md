# WebServiceSPPD
Este é um projeto de conclusão de curso da Fatec de Carapicuíba.
Este projeto tem por objetivo viabilizar a integração do Aplicativo mobile SPPD (https://github.com/vitordelfino/Android-SPPD) com o Banco de dados MySQL.

# Funcionalidades

Interação com bd, retornando dados em JSON e um simulador de rotas da cptm e metro utilizando <b><i>"Dijkstra"</i></b>

# Dijkstra

Foi implementado um algoritmo com base no mapa da CPTM, onde informado "origem" e "destino", é retornado uma lista com o menor número de estações que deverá ser percorrido.

<b>OBS: </b> Para implementação desta funcionalidade, foi utilizado como base o código encontrado neste repositório: https://github.com/franzejr/Dijkstra-Algorithm-Java-GUI 

![alt tag](http://spressosp.com.br/wp-content/uploads/2016/04/metro_2020.gif)


<b> Modo de uso: </b> <br>
<t>url: http://host:8080/WebServiceSPPD/sppd/dijkstra/encontrarMenorCaminho/ <b><i>(não disponível on-line)</font></i></b><br></t>
<br><b>Json request:</b>

	{
	"origem": "CARAPICUIBA",	
 	"destino": "BARUERI"
	}
 
 <b>Json response:</b><br> 
 
	{
	 "estacao":
	 [
	  {
	   "codEstacao": "0",
	   "linha": "8",
	   "nomeEstacao": "CARAPICUIBA"
	  },
	  {
	   "codEstacao": "0",
	   "linha": "8",
	   "nomeEstacao": "SANTA TEREZINHA"
	  },
	  {
	   "codEstacao": "0",
	   "linha": "8",
	   "nomeEstacao": "ANTONIO JOÃO"
	  },
	  {
	   "codEstacao": "0",
	   "linha": "8",
	   "nomeEstacao": "BARUERI"
	  }
	 ]
	}

